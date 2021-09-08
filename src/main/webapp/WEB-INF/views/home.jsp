<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="layout/header.jsp"%>

<br />
<div class="container">

	<c:forEach begin="0" end="2">

		<!-- 카드글 시작 -->
		<div class="card">
			<div class="card-body">
				<h4 class="card-title">Title 부분입니다.</h4>
				<a href="#" class="btn btn-primary">상세보기</a>
			</div>
		</div>
		<!-- 카드글 끝 -->
		<br />
	</c:forEach>
	
	
	<div class="d-flex justify-content-center">
		<ul class="pagination">
			<li class="page-item disabled"><a class="page-link" href="#">Previous</a></li>
			<li class="page-item"><a class="page-link" href="#">Next</a></li>
		</ul>
	</div>

</div>

<br />
<%@ include file="layout/footer.jsp"%>