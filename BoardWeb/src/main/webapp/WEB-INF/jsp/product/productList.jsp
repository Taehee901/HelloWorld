<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h3>product/productList.jsp</h3>

<!-- 자바스크립트연습,스크립트외부파일 -->
<!-- 실제<ul>등 태그들이 dom객체형태로변환된다 -->
<div id="show">
  <table class="table">
    <tr>
      <th>글번호</th>
      <td><input type="text" id="bno" class="form-control"></td>
    </tr>
    <tr>
      <th>글내용</th>
      <td><input type="text" id="reply" class="form-control"></td>
    </tr>
    <tr>
      <td colspan="2" align="center">
        <button id="addReply" class="btn btn-primary">등록</button></td>
    </tr>
  </table>
	<!-- <ul>
		<li>1, EvenHard,2000</li>
	</ul> -->
	<table class="table">
	  <thead>
	<!-- 웹브라우저가규칙따라요소만들어줌 -->
		<tr>
			<th>글번호</th>
			<th>댓글내용</th>
			<th>작성자</th>
			<th>삭제</th>
		</tr>
	  </thead>
	  <tbody></tbody>
	</table>
</div>
<!-- 선언필요,ajax.js인식x -->
<script>
	const logId = "${logId}";
</script>
<!--경로계산은url기준 -->
<!-- 경로정상,ajax파일console내용출력 <script src="js/ajax.js"></script>-->
 <!--  <script src="js/promise.js"></script>-->

<script src="js/service.js"></script>
<script src="js/ajax2.js"></script>