# CH.8(2018. 05. 15)
----

## 9주차
- Spring MVC를 이용한 웹페이지 처리 (v)
- 페이징 처리(1, 2, 3 ... K) : 게시물 N개씩 보여주기 (X)
- 등록 기능 처리 (v)
- 조회 기능 처리 (v)
- 게시판 보드 생성 → 글쓰기 → Controller → Model(DB)

#### 1. 다운로드([링크](https://github.com/sigmadream/ks-springboot/blob/master/boards.zip))
    boards.zip → Download → 압축해제

#### 2. git hub 프로젝트 불러오기
    File → import → Maven → Existing Maven Projects
- Root Directory → Browse → board → Finish
- 테스트 : RunAs → Spring Boot App
- 실행 : localhost:8080

#### 3. Controller 생성
    board → src/main/java → kr.ac.ks → WebBoardController
~~~
@Controller
@RequestMapping("/boards/")
public class WebBoardController {

	@Autowired
	private WebBoardRepository repo;

	@GetMapping("/list") (1)
	public void list(){}

	@GetMapping("/register") (2)
	public void registerGET(){
	}

	@PostMapping("/register")
	public String registerPOST(@ModelAttribute("vo")WebBoard vo, RedirectAttributes rttr){
		repo.save(vo);
		rttr.addFlashAttribute("msg", "success");

		return "redirect:/boards/list";
	}


}
~~~
- Resources -> templates -> boards → list.HTML (1)
- register.html 호출 (2)

#### 4. register.html 작성
    src/main/resources → boards → register.html
- list.html 복사 → 붙여넣기 → content 삭제 → 코드작성
~~~
<html xmlns:th="http://www.thymeleaf.org"
	xmlns:layout="http://www.ultraq.net.nz/thymeleaf/layout"
	layout:decorate="~{/layout/webboard_layout}">

<div layout:fragment="content">
	<div class="panel-heading">Register Page</div>
	<div class="panel-body">

		<form th:action="@{register}" method="post">

			<div class="form-group">
				<label>Title</label> <input class="form-control" name="title" th:value="${vo.title}" />
				<p class="help-block">Title text here.</p>
			</div>

			<div class="form-group">
				<label>Content</label> <textarea class="form-control" rows="3" name="content" th:text="${vo.content}"></textarea>
			</div>

			<div class="form-group">
				<label>Writer</label> <input class="from-control" name="writer" th:value="${vo.writer}" />
			</div>

			<button type="submit" class="btn btn-default">Submit Button</button>
			<button type="reset" class="btn btn-primary">Reset Button</button>
		</form>

	</div>
</div>

<th:block layout:fragment="script">
</th:block>
~~~

#### 5. 화면수정
    src/main/resources → templates → webboard_layout
- 코드수정
~~~
<!doctype html>
<html xmlns:th="http://www.thymeleaf.org" xmlns:layout="http://www.ultraq.net.nz/thymeleaf/layout">

<head>
	<meta charset="utf-8">
	<meta http-equiv="x-ua-compatible" content="ie=edge">
	<title>WebBoards</title>
	<meta name="description" content="">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" th:href="@{/css/minty.css}">
</head>
<body>

	<div class="container">
		<div layout:fragment="content"></div>
	</div>

	<script th:src="@{/js/jquery-3.3.1.min.js}"></script>
	<script th:src="@{/js/bootstrap.min.js}"></script>

	<th:block layout:fragment="script"></th:block>

</body>
</html>
~~~

#### 6. 데이터입력
    [url] : http://localhost:8080/boards/register
- 입력 → submit

#### 7. 데이터베이스 확인
    [url] : http://localhost:8080/h2-console/
- JDBC URL : jdbc:h2:mem:testdb → connect
- TBL_WEBBOARDS → Run → 101 확인

---

## etc
- Web을 생성할 때
  1. Get 방식을 이용하여 form을 보여준다.
  2. Post를 호출하여 form에서 전달된 데이터를 DB에 넣는다.
  3. Post완료 시 완료 메시지를 출력하는 화면으로 되돌려 보낸다.(Post의 중복 호출 방지)
<br>
- Web에서 html을 등록할 때
  1. Controller 생성
<br>
- 템플릿 엔진의 역할(객체를 화면에 출력하고 입력을 객체로 반환)
  1. 객체 → 화면출력
  2. 화면조작
  3. HTML 입력 → 객체
<br>
- 정리(Get Post Get 단계)
  1. 모델 생성
  2. Get 만들고 화면 출력
  3. Post로 보내서 DB에 저장
  4. 가장 최신에 저장 된 것을 화면에 출력
