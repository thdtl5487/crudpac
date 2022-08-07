<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>메인화면</title>

<!-- https://getbootstrap.com/ CSS only -->
<!-- <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous"> -->
<link rel="stylesheet" href="../css/bootstrap.min.css">

<!-- JSTL replace 함수로 개행 문자 줄바꿈 처리 적용 -->
<%
	pageContext.setAttribute("newLineChar", "\n");
%>

<link rel="stylesheet" href="../css/readForm.css">

<c:set var="data" value="${article.content}" />

</head>
<body>

	<div class="allContainer">
		<div class="container card shadow-sm" style="float: left;">
			<div class="box-wrapper">

				<!-- video 출력 박스 -->
				<div class="video_box">
					<iframe id="video"
						src="https://www.youtube.com/embed/${ARTICLE_ID.video}"
						title="YouTube video player" frameborder="0"
						allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture"
						allowfullscreen></iframe>
				</div>
				<!-- video 출력 박스 종료 -->

				<!-- 제목이 달리는 박스 영역 시작 -->
				<div class="title_box">
					<p>
					<h3 class="fw-light">${ARTICLE_ID.title}</h1>
						</p>
				</div>
				<!-- 제목이 달리는 박스 영역 종료 -->
				<!-- 설명 박스 시작 -->
				<div class="comment_box">
					<div id="content_box">${ARTICLE_ID.content}</div>
				</div>
				<!-- 설명 박스 종료 -->

				<!-- 버튼 폼 시작 -->
				<div class="form_btn"
					style="display: flex; justify-content: space-between;">
					<form action="/article/getList.do">
						<button class="btn btn-primary" id="btn_form_sex" type="submit">처음으로</button>
					</form>
					<form action="/article/updateFromList.do">
						<input type="hidden" name="id" value="${ARTICLE_ID.id}" /> <input
							type="hidden" name="title" value="${ARTICLE_ID.title}" /> <input
							type="hidden" name="content" value="${ARTICLE_ID.content}" /> <input
							type="hidden" name="video" value="${ARTICLE_ID.video}" /> <input
							class="btn btn-outline-secondary" id="btn_form_sex" type="submit"
							value="수정하기">
					</form>
					<form action="delete.do" method="post">
						<input type="hidden" name="id" value="${ARTICLE_ID.id}" /> <input
							type="hidden" name="title" value="${ARTICLE_ID.title}" /> <input
							type="hidden" name="content" value="${ARTICLE_ID.content}" /> <input
							type="hidden" name="video" value="${ARTICLE_ID.video}" /> <input
							class="btn btn-danger" id="btn_form_sex" type="submit"
							value="삭제하기">
					</form>
				</div>
				<!-- 버튼 폼 종료 -->


			</div>
			<!-- end box-wrapper -->
		</div>
		<!-- end container -->

		<!-- start reply container -->
		<div class="replyContainer" style="float: right">
			
			<div class="replyList">
				<div class="replyInsert">
					<form action="#">
						<div class="Input-reply">
							<input class="Input-reply-replyer" type="text" placeholder="닉네임" value="">
							<input class="Input-reply-pw" type="text" placeholder="비밀번호" value="">
							<input class="Input-reply-content" type="text" placeholder="내용" value="">
							<input type="button" value="댓글달기">
						</div>
					</form>
				</div>
			
				<ul class="replyArea">
					<!-- 각각의 코멘트 영역 시작 -->
					<li class="replyrenderer">
						<div class="replyer">
							<b>백팔연타 나기동</b>
						</div>
						<div class="replyContent">
							걍뒤지셈
						</div>
						<div class="replyButton">
							2022-08-07
							<button>답글 달기</button>
							<button>삭제</button>
						</div>
					</li>
					<!-- 각각의 코멘트 영역 시작 -->
					
					<!-- 복수코멘트 테스트용 영역 시작 -->
					<li class="replyrenderer">
						<div class="replyer">
							<b>백팔연타 나기동</b>
						</div>
						<div class="replyContent">
							걍뒤지셈
						</div>
						<div class="replyButton">
							2022-08-07
							<button>답글 달기</button>
							<button>삭제</button>
						</div>
					</li>
					<!-- 각각의 코멘트 영역 시작 -->
				</ul>
			</div>
		
		</div>
		<!-- end reply container -->
	</div>

	<script type="text/javascript">
		// 	$(document).ready(function() {
		// 		//최초 로드 시 iframe 높이값 비율에 맞게 세팅
		// 		var $videoIframe = document.getElementById('video');
		// 		var responsiveHeight = $videoIframe.offsetWidth * 0.5625;
		// 		$videoIframe.setAttribute('height', responsiveHeight);

		// 		//브라우저 리사이즈 시 iframe 높이값 비율에 맞게 세팅
		// 		window.addEventListener('resize', function(){
		// 		    responsiveHeight = $videoIframe.offsetWidth * 0.5625;
		// 		    $videoIframe.setAttribute('height', responsiveHeight);
		// 		});

		// 	});
	</script>
</body>
</html>