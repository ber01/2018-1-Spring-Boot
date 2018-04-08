# CH.4(2018. 04. 03)
----

## Index
1. 5주차
2. etc
----

### - 5주차 -
#### 1. MySQL 설치(http://sigmadream.tistory.com)
    brew install mysql

#### 2. MySQL Workbench 설치
    https://dev.mysql.com/downloads/workbench/
- User and Privileges
- Add Account
  - Login Name : jpa_user
  - password : jpa_user
- Administrative Roles(DBA : select)

#### 2. Postman 설치
    Chrome → 웹 스토어 → Postman

#### 3. STS 설정(개발환경 설정)
- 문자셋(UTF-8)
- 폰트(Font)
- 라인넘버(Line number)

#### 4. 프로젝트 생성
    New → Spring Starter Project
- Name : boot03
- Group, Package : com.kyunghwan
- Available : JPA, MySQL, H2, Thymeleaf, Web, Rest Repositories
- Test : Run As → Spring Boot App → localhost:8080
- Available Delete : pom.xml → Dependencies → h2 → remove → **save**

#### 5. 데이터베이스 연동(p84)
    src/main/resources/application.properties
~~~
spring.datasource.driver-class-name=com.mysql.jdbc.Driver
spring.datasource.url=jdbc:mysql://localhost:3306/jpa_ex?useSSL=false
spring.datasource.username=jpa_user
spring.datasource.password=jpa_user
~~~
- Test : Run As -> Spring Boot App
- Error! : Unknown database 'jpa_ex'

#### 6. 에러 해결 : jpa_ex 생성
- Workbench(SCHEMAS → Create Schema)
- Name : jpa_ex
- Default Collation : utf-8 default Collation

#### 7. 기본설정 코드 작성
~~~
spring.jpa.hibernate.ddl-auto=update
spring.jpa.generate-ddl=true
spring.jpa.show-sql=true
spring.jpa.database=mysql
spring.jpa.database-platform=org.hibernate.dialect.MySQL5InnoDBDialect
logging.level.org.org.hibernate=info
~~~

#### 8. Model 생성
    boot03 → src/main/java → new → Package → com.kyunghwan.models

#### 9. Board 클래스 생성
    com.kyunghwan.models → new → class
~~~
package com.kyunghwan.models;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
public class Board {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long bno;
	private String title;
	private String content;
	private String writer;

	@CreationTimestamp
	private Timestamp regdate;
	@UpdateTimestamp
	private Timestamp updatedat;
}
~~~

#### 10. getter/setter생성
    Sources → Generated Getter and Setter → Select All → OK

#### 11. toString 생성
    Sources → Generated toString() → Code style : Builder/Buffer → OK

#### 12. Repository 생성
    boot03 → src/main/java → new → Package → com.kyunghwan.repositories

#### 13. interface 생성
    com.kyunghwan.repositories → new → interface → BoardRepository
~~~
package com.kyunghwan.repositories;

import org.springframework.data.repository.CrudRepository;

import com.kyunghwan.models.Board;

public interface BoardRepository extends CrudRepository<Board, Long>{

}
~~~

#### 14. TEST 코드작성
    src/test/java → com.kyunghwan → Boot03ApplicationTests.java
~~~
package com.kyunghwan;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.kyunghwan.models.Board;
import com.kyunghwan.repositories.BoardRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Boot03ApplicationTests {

	@Autowired
	private BoardRepository repo;

	@Test
	public void contextLoads() {
	}

	@Test
	public void testInsert200() {
		for(int i = 1; i <= 200; i++) {
			Board board = new Board();
			board.setTitle("제목.." + i);
			board.setContent("내용..." + i + " 채우");
			board.setWriter("user0" + (i%10));
			repo.save(board); // insert 와 update를 대신수행한다.
		}
	}
}
~~~

#### 15. Test 실행
    boot03 → Run As → JUnit Test

#### 16. 실행결과 확인
    MySQL workbench → jpa_ex → Tables → board → Result Grid 클릭

#### etc
- Controller, Service, Model, Repository
1. localhost:8080 입력 → Controller가 입력받는다.
2. controller 가 service 에게 insert 한다.
3. model 이 show를 make 한다.
4. Repository는 DB와 직접 연결한다.
5. 자바 다형성의 대표적인 예 : jdbc
6. repository : database 를 대신한다(ORM), crud 를 빠르게 도와준다.
