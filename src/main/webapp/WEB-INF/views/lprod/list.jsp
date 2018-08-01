<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="../../favicon.ico">

<title>Jsp</title>

<script src="/js/jquery-1.12.4.js"></script>
<link href="/bootstrap/css/bootstrap.css" rel="stylesheet">		<!-- Bootstrap core CSS -->
<script src="/bootstrap/js/bootstrap.js"></script>				<!-- Custom styles for this template -->
<link href="/css/dashboard.css" rel="stylesheet">
<link href="/css/blog.css" rel="stylesheet">
</head>

<body>
	<!-- top.jsp -->
	<%@ include file="/WEB-INF/views/common/top.jsp"%>

	<div class="container-fluid">
		<div class="row">

			<!-- left.jsp -->
			<%@ include file="/WEB-INF/views/common/left.jsp"%>

			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				<div class="row">
					<div class="col-sm-8 blog-main">
						<h2 class="sub-header">상품 분류</h2>
						<div class="table-responsive">
							<h3>상품분류 전체 조회</h3>
							<table class="table table-striped">
								<tr>
									<th>상품 번호	</th>
									<th>상품 분류	</th>
									<th>상품 이름	</th>
								</tr>

								<!-- TODO: 상품분류 조회 부분 -->
								<c:forEach items="${pageList}" var="vo">
									<tr>
										<td>${vo.lprod_id}</td>
										<td>${vo.lprod_gu}</td>
										<td>${vo.lprod_nm}</td>
									</tr>
								</c:forEach>			
							</table>
						</div>

						<a class="btn btn-default pull-right">사용자 등록</a>

						<div class="text-center">
							<ul class="pagination">
							<!-- 페이지 처리 된 상품분류 리스트 -->
								<li>${pageResult}</li>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>