# CH.2(2018. 03. 20)

----

## Index
1. 스프링 부트 프로젝트 생성(반복1)
2. 코드작성
3. JPA
4. etc

----

### 1. 스프링 부트 프로젝트 생성(반복1)
- File -> new -> Spring Starter Project
![1번](./1.png)
- URL : 설정 x
- Name : unittest(소문자 작성)
- Type, Packaging, Java Version, Language : 설정 x
- Group : com.kyunghwan(자신의 이름으로 생성)
- Artifact, Version, Description : 설정 x
- Package : com.kyunghwan.unittest(Group.Name으로 생성)
- Next
![2번](./2.png)
- JPA, Rest Repositories : 체크(프로젝트 생성 시 특별한 말이 없으면 반드시 체크)
  - cf) 해당 Available이 없을 경우 검색하여 체크
- Finish
![3번](./3.png)

----

### 2. Hello World 출력하기
- src/main/java -> com.kyunghwan.boot02 -> Boot02Application.java
![4번](./4.png)
- com.kyunghwan.boot02 -> New -> package
![5번](./5.png)
- Source folder : 설정 x
- Name : com.kyunghwan.boot02.controllers 작성
![6번](./6.png)
- com.kyunghwan.boot02.controllers -> new -> class
![7번](./7.png)
- Name : HelloController
![8번](./8.png)
- Finish
![9번](./9.png)
- 코드작성
![10번](./10.png)
- 유닛 테스트(전체 부분 중에 해당 부분을 테스트)
- src/test/java -> com.kyunghwan.boot02 -> Boot02ApplicationTest.java
- 코드작성(get, content import, p42 참조)
![11번](./11.png)
- boot02 -> Run As -> JUnit Test
![12번](./12.png)
- 초록색 바가 생성될 경우 test 완료
![13번](./13.png)
- Hello World 출력하기
- boot02 -> Run As -> Spring Boot App
![14번](./14.png)
- URL : localhost:8080/hello
![15번](./15.png)

----

### 3. JPA
- JPA의 구현체인 Hibernate를 사용(Sprgin boot의 의존성에 맞는 버전 사용)
- ORM(Object-relational mapping)
- H2 : 인메모리 DB(서버를 종료시키면 데이터가 사라지는 DB)
- H2 설정을 위한 세팅 : https://gist.github.com/sigmadream/ -> SpringSnippets -> H2데이터 베이스 설정 복사
- boot2 -> src/main/resource/ -> application.properties 붙여넣기
![16번](./16.png)
- 재실행(Run as -> Spring boot app)
- URL : localhost:8080/h2
![17번](./17.png)
- JDBC URL : jdbc:h2:mem:test 입력 -> connection
![18번](./18.png)
![19번](./19.png)
- boot02 -> src/main/java -> com.kyunghwan.boot2 -> new -> pacakge -> com.kyunghwan.boot2.models  생성
![20번](./20.png)
![21번](./21.png)
- models -> new -> class -> Board
- p61, private 멤버 작성
![22번](./22.png)
- timestamp import(sql)
- 오른쪽 -> source -> Generate Getter and Setters
![23번](./23.png)
- 오른쪽 -> source -> Generate hashCode() and equals()
- 오른쪽 -> source -> Generate toString() -> Code style : String Builder/Buffer
----

### 4. etc.
- 2번. Hello World 출력 구문과 p42 유닛테스트 및 컨트롤러를 수정하여 작성하시오.
- 오버라이딩 목록
    - toString()
    - equal()
    - hash()
- Rest API(Representational State Transfer)
  - 웹(http) 설계의 우수성을 제대로 사용하기 위하여 아키텍처로써 REST를 발표하였다.
  - 시스템 아키텍처 : 시스템이 어떻게 작동하는지를 설명하는 프레임 워크
  - 웹 프레임워크 : 웹 페이지를 개발하는 과정에서 겪는 어려움을 줄이고자 만들어진 뼈대(DB연동, 세션관리 등)
- Rest 방식의 웹 서비스
  - 클라이언트 -> 서버(URL요청), 서버 -> 클라이언트(XML 데이터 반환)
  - 웹의 모든 리소스를 URI로 표현핟고 이를 구조적이고 유기적으로 연결
  - 일관된 method를 사용하여 리소스를 사용하는 방법
- @RestController
  - 기존의 컨트롤러 처럼 뷰를 만들어내는 것이 아닌 데이터 처리를 위한 컨트롤러를 생성한다.
- @GetMapping
  - Controller 내부에서 URI경로를 설정한다.
  - 해당 URI경로를 지정하면 지정된 경로로 접속하였을 때 해당하는 메서드의 반환값에 따라서 템플릿 파일을 불러온다.
- @WebMvcTest
  - MVC 테스트용 어노테이션
  - @SpringBootTest 어노테이션을 같이 사용할 수 없다.(서로가 MockMvc를 설정하기 때문에 충돌이 일어난다.)
- @Autowired
  - get/set 접근 메서드를 직접 구현하지 않고 내부에서 처리한다.
- MockMvc
  - client가 요청 내용을 controller에서 받아 처리하는 것과 같은 테스트를 진행할 수 있도록 한다.
- @Test
  - 테스트를 수행하는 메소드로 지정
  - JUnit은 각각의 테스트가 서로 영향을 주지 않고 독립적으로 실행하기 때문에 Test마다 객체를 생성하여 내부적으로 실행한다.
- perform()
  - 객체를 브라우저에서 서버를 URL을 호출하듯이 테스트를 진행할 수 있게 한다.
----
