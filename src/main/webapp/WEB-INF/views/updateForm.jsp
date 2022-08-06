<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>게시글 수정</title>

<!-- https://getbootstrap.com/ CSS only -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
<link rel="stylesheet" href="../css/main.css">

<c:set var="data" value="${article.content}" />



</head>

<body>

	<div class="container">
		<div class="box-wrapper card shadow-sm">
			<form action="modify.do" method="post">
				<p>
					제목 : <br><input class="form-control" id="input_box" type="text" name="title" value="${article.title}">
				</p>
				
				<p>
					내용 : <br><textarea rows="5" cols="30" id="textarea_box" name="content">${article.content}</textarea>
				</p>
				
				<input type="submit" value="게시글 수정">
			</form>
			
				<button type="button" onclick="javascript:history.go(-1);">취소</button>
						
		</div>	
	</div>















</body>
</html>