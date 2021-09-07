<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp"%>

<div class="container">

	<form action="/join" method="POST">
			<input type="text" name="username" class="form-control"
				placeholder="Enter username" required="required" autofocus="autofocus" maxlength="20">
			<input type="password" name="password" class="form-control"
				placeholder="Enter password" required="required" maxlength="20">
			<input type="email" name="email" class="form-control"
				placeholder="Enter email" required="required" maxlength="40">
		<button type="submit" class="btn btn-primary">회원가입</button>
	</form>

</div>

<%@ include file="../layout/footer.jsp"%>

