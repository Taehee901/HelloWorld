<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- <!DOCTYPE html>
<html>
  https://mundol-colynn.tistory.com/147 
    https://getbootstrap.kr/ 
<head>

    <meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4Q6Gf2aSP4eDXB8Miphtr37CMZZQ5oXLH2yaXMJ2w8e2ZtHTl7GptT4jmndRuHDT" crossorigin="anonymous">

</head>
<body> 컨트롤로제어하는데지금은jsp파일여는,안보임-->
	<%
		String logId = (String)session.getAttribute("logId");
	%>
	<h3>글등록화면(addBoard.jsp)</h3>
    <!-- 요청방식지정,get:사용자입력값(header)url주소값다나옴,글자수제한 post:비번(body)영역에데이터들어가서버로전송함,url파라미터보이지않고전송글자제한없음,인코딩방식지정해줘야함 -->
  <form action="addBoard.do" method="post">
  <input type="hidden" class = "form-control"name="writer"value="<%=logId%>">
	<table class="table" >
		<tr>
		<th>제목</th>
		<td><input type="text" name="title"></td>
		</tr>
		<tr>
		<th>내용</th>
		<td><input type="text" name="content"></td>
		</tr>
		<tr>
		<!-- <th>작성자</th><td><input type="text" name="writer"></td> 사용자가입력한게아니라로그인으로변경 -->
		<th>작성자</th><td><%=logId %></td>
		</tr>
		<tr>
		  <td colspan="2" align="center">
		  	<input type="submit" value="등록" class="btn btn-outline-success">
		  	<input type="reset" value="취소"class="btn btn-outline-danger">
		  </td>
		</tr>
	</table>
</form>  

<!-- <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/js/bootstrap.bundle.min.js" integrity="sha384-j1CDi7MgGQ12Z7Qab0qlWQ/Qqz24Gc6BM0thvEMVjHnfYGF0rmFCozFSxQBxwHKO" crossorigin="anonymous"></script>
</body>
</html> -->