<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp"%>

<div class="container">

	<form>
			<input type="text"  value="${sessionScope.principal.username}" class="form-control" readonly="readonly"
				placeholder="Enter username" required="required" autofocus="autofocus" maxlength="20">
			<input type="password" value="${sessionScope.principal.password}" class="form-control"
				placeholder="Enter password" required="required" maxlength="20">
			<input type="email" value="${sessionScope.principal.email}" class="form-control"
				placeholder="Enter email" required="required" maxlength="40">
		<button type="submit" class="btn btn-primary">회원수정</button>
	</form>

</div>

<%@ include file="../layout/footer.jsp"%>

