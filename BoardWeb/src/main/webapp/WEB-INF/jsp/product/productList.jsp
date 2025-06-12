<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h3>product/productList.jsp</h3>

<!-- 자바스크립트연습,스크립트외부파일 -->
<!-- 실제<ul>등 태그들이 dom객체형태로변환된다 -->
<div id="show">
	<ul>
		<li>1, EvenHard,2000</li>
	</ul>
	<table class="table">
		<tr>
			<th>글번호</th>
			<th>댓글내용</th>
			<th>작성자</th>
			<th>삭제</th>
		</tr>
		

	</table>
</div>
<!--경로계산은url기준 -->
<!-- 경로정상,ajax파일console내용출력 -->
<script src="js/ajax.js"></script>