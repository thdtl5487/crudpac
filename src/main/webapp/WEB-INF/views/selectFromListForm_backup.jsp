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
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">

<!-- JSTL replace 함수로 개행 문자 줄바꿈 처리 적용 -->
<%
	pageContext.setAttribute("newLineChar", "\n");
%>
	
<link rel="stylesheet" href="../css/readForm.css">

<c:set var="data" value="${article.content}" />

</head>
<body>

	<div class="container">
		<div class="box-wrapper">
		

		<!-- video 출력 박스 -->
			<div class="video_box">
				<iframe id="video" src="https://www.youtube.com/embed/${ARTICLE_ID.video}" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
			</div>
		<!-- video 출력 박스 종료 -->
			
		<!-- 제목이 달리는 박스 영역 시작 -->			
			<div class="title_box">
		
				<p>
					아티클아이디 갖고왔는지 확인 : <p>${ARTICLE_ID.title}</p>
				</p>			
		
				<!-- JSTL replace 함수로 개행문자 줄바꿈 처리 적용 -->
			</div>
		<!-- 제목이 달리는 박스 영역 종료 -->			
		<!-- 설명 박스 시작 -->	
			<div class="comment_box">
			비디오 설명 : 
				<div id="content_box">${ARTICLE_ID.content}</div>
			</div>
		<!-- 설명 박스 종료 -->	
		
		<!-- 버튼 폼 시작 -->
		<div class="form_btn">
			<form action="/article/getList.do">
				<input type="submit" value="처음으로">
			</form>
			<form action="/article/updateFromList.do">
				<input type="hidden" name="id" value="${ARTICLE_ID.id}"/>
				<input type="hidden" name="title" value="${ARTICLE_ID.title}"/>
				<input type="hidden" name="content" value="${ARTICLE_ID.content}"/>
				<input type="hidden" name="video" value="${ARTICLE_ID.video}"/>
				<input type="submit" value="수정하기">
			</form>
			<form action="delete.do" method="post">
				<input type="hidden" name="id" value="${ARTICLE_ID.id}"/>
				<input type="hidden" name="title" value="${ARTICLE_ID.title}"/>
				<input type="hidden" name="content" value="${ARTICLE_ID.content}"/>
				<input type="hidden" name="video" value="${ARTICLE_ID.video}"/>
				<input type="submit" value="삭제하기">
			</form>
		</div>
		<!-- 버튼 폼 종료 -->
		
		
		</div> <!-- end box-wrapper -->
	</div> <!-- end container -->
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