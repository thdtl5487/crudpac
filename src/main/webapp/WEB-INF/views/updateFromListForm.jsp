<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>게시글 등록</title>

<!-- https://getbootstrap.com/ CSS only -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">

<link rel="stylesheet" href="../css/main.css" >
<c:set var="data" value="${article.content}" />

</head>
<body>

	<div class="container">
		<div class="box-wrapper card shadow-sm">
			<form action="/article/updateFromListActive.do" method="post">
				<input id="input_box" type="hidden" name="id" value="${param.id}">
				<p>
					제목 : <br><input class="form-control" id="input_box" type="text" name="title" value="${param.title}"> <br>
				</p>
				
				<p>
					비디오 주소 : <br><input class="form-control" id="input_box" type="text", name="video" value="${param.video}"> <br>
				</p>
				<p>
					내용 : <br><textarea class="form-control" rows="5" cols="30" id="textarea_box" name="content">${param.content}</textarea> <br>
				</p>
				
				<div class="btn-footer-sexion">
					<input class="btn btn-primary" type="submit" value="게시글 등록">
					<button class="btn btn-danger" type="button" onclick="javascript:history.go(-1);">취소</button>
				</div>
			</form>
			
		</div>	
	</div>
	
	
	
<script type="text/javascript">

</script>
	
</body>
</html>