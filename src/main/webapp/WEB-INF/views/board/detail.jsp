<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp"%>

<div class="container">
	<!-- 내 글이면 (권한이 있으면 ) 수정과 삭제 버튼 보이게 if사용가능 -->
	<c:if test="${sessionScope.principal.id == boardEntity.user.id}">
		<a href="/board/${boardEntity.id}/updateForm" class="btn btn-warning">수정</a>
		<button class="btn btn-danger" onclick="deleteById(${boardEntity.id})">삭제</button>
	</c:if>


	<script>
		function deleteById(id){
			//비동기 함수 호출 -> 비동기를 잘 처리하는방법????
			let response = await fetch("http://l ocalhost:8080/board/"+id, {
				method: "delete"
			});
			
			//2.코드
			//json()함수는 json처럼 생긴 문자열을 자바스크립트 오브젝트로 변환해준다
			let parseResponse = await response.json();
			console.log(parseResponse);
			
			if(parseResponse.code == 1){
				alret("삭제 성공");
				location.href="/";
			}else{
				alret("삭제 실패");
				location.href="/";
			}
			
		}
	</script>

	<br /> <br />
	<div>
		<span>글 번호 : ${boardEntity.id}</span> 작성자 : <span><i>${boardEntity.user.username}</i></span>
	</div>
	<br />
	<div>
		<h3>${boardEntity.title}</h3>
	</div>
	<hr />
	<div>
		<div>${boardEntity.content}</div>
	</div>
	<hr />


  <div class="card">
      <form action="/board/${boardEntity.id}/comment" method="post">
         <div class="card-body" >
            <textarea name="content" id="reply-content" class="form-control" rows="1"></textarea>
         </div>
         <div class="card-footer">
            <button type="submit" id="btn-reply-save" class="btn btn-primary">등록</button>
         </div>
      </form>
   </div>
   <br />
   
   <div class="card">
      <div class="card-header"><b>댓글 리스트</b></div>
      <ul id="reply-box" class="list-group">
         <li id="reply-1" class="list-group-item d-flex justify-content-between">
         <c:forEach>
            <div>댓글입니다</div>
            <div class="d-flex">
               <div class="font-italic">작성자 : 홍길동 &nbsp;</div>
               <button class="badge">삭제</button>
            </div>
         
         </c:forEach>
         </li>
      </ul>
   </div>
   <br/>
</div>
<%@ include file="../layout/footer.jsp"%>