<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp"%>

<div class="container">

	<form onsubmit="update(event, ${sessionScope.principal.id})">
			<input type="text"  value="${sessionScope.principal.username}" class="form-control" readonly="readonly"
				placeholder="Enter username" required="required" autofocus="autofocus" maxlength="20">
			<input type="email" id="email" value="${sessionScope.principal.email}" class="form-control"
				placeholder="Enter email" required="required" maxlength="40">
		<button type="submit" class="btn btn-primary">회원수정</button>
	</form>

</div>

<script>
async function update(event, id){ 
    event.preventDefault();
    let userUpdateDto = {
          email: document.querySelector("#email").value
    };
 
       console.log(boardUpdateDto);
       console.log(JSON.stringify(boardUpdateDto));
 
       
       let response = await fetch("http://localhost:8080/api/user/"+id, {
          method: "put",
          body: JSON.stringify(userUpdateDto),
          headers: {
             "Content-Type": "application/json; charset=utf-8"
          }
       });
       
       let parseResponse = await response.json(); 
       
       console.log(parseResponse);
       
       if(parseResponse.code == 1){
          alert("업데이트 성공");
          location.href="/";
       }else{
          alert("업데이트 실패" + parseResponse.msg);
       }
 }
</script>

<%@ include file="../layout/footer.jsp"%>

