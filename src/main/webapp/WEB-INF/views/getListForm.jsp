
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta
name="author"
content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
<meta name="generator" content="Hugo 0.88.1">
<title>게시글 전체 확인</title>
<!-- https://getbootstrap.com/ CSS only -->
<link rel="stylesheet" href="../css/main.css">
<c:set var="data" value="${article.content}"/>
<link rel="canonical" href="https://getbootstrap.com/docs/5.1/examples/album/">
<!-- Bootstrap core CSS -->
<link href="../../css/bootstrap.min.css" rel="stylesheet">

<style>
	.bd-placeholder-img {
		font-size: 1.125rem;
		text-anchor: middle;
		-webkit-user-select: none;
		-moz-user-select: none;
		user-select: none;
	}

	@media (min-width : 768px) {
		.bd-placeholder-img-lg {
			font-size: 3.5rem;
		}
	}
</style>
</head>
<body>
<main>
	<section class="py-5 text-center container" style="display: inline;">
		<div class="row py-lg-5">
			<div class="col-lg-6 col-md-8 mx-auto">
				<h1 class="fw-light">게시글 모아 보기</h1>
				<p class="lead text-muted">해당 영역에서는 DB에 있는 게시글들을 모아 볼 수 있습니다.</p>
				<p>
				
					<form action="write.do">
						<input type="submit" class="okbtn btn btn-primary" value="게시글 등록" /><br>
						<br>
					</form>
					
					
				</p>
			</div>
		</div>
	</section>

	<div class="album py-2 bg-light">
		<div class="container">
			<div class="row row-cols-1 row-cols-sm-2 row-cols-md-3 g-3">
				<c:forEach var="articleList" items="${ARTICLE_ID}" varStatus="status">
					<div class="col">
						<div class="card shadow-sm">
							<img
								class="bd-placeholder-img card-img-top"
								width="90%"
								height="225"
								aria-label="Placeholder: Thumbnail"
								alt="thumbnail"
								preserveAspectRatio="xMidYMid slice"
								focusable="false"	
								src="https://img.youtube.com/vi/<c:out value="
								${articleList.video}" />/mqdefault.jpg"="${articleList.video}" />
								<rect width="100%" height="100%" fill="#55595c"/>
								<form action="selectFromList.do" method="get">
									<input type="hidden" name="id" value="${articleList.id}"/>
									<input type="hidden" name="title" value="${articleList.title}"/>
									<input type="hidden" name="content" value="${articleList.content}"/>
									<input type="hidden" name="video" value="${articleList.video}"/>
									<div class="card-body">
										<p class="card-text">
											<c:out value="${articleList.title}"/>
											<div class="d-flex justify-content-between align-items-center">
												<div style="align-items: center; width: 100%;" class="btn-group">
													<button style="display: inline-block;" type="submit" class="btn btn-outline-secondary">View</button>
												</div>
											</div>
										</div>
									</form>
								</div>
						</div>
							</c:forEach>
					</div>
				</div>
			</div>

		</main>

		<footer class="text-muted py-5">
			<div class="container">
				<p class="float-end mb-1">
					<a href="#">Back to top</a>
				</p>
			</div>
		</footer>
		<script src="../../js/bootstrap.bundle.min.js"></script>
	</body>
</html>