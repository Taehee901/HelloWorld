<%@page import="com.yedam.common.PageDTO"%>
<%@page import="com.yedam.vo.BoardVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- <!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4Q6Gf2aSP4eDXB8Miphtr37CMZZQ5oXLH2yaXMJ2w8e2ZtHTl7GptT4jmndRuHDT" crossorigin="anonymous">
</head>
<body> -->
<jsp:include page="../include/header.jsp"></jsp:include>
    <!-- jsp의 내장객체 -->
    <!--Stirng msg = request.getAttribute("myName")Systme.out.println(msg)-->
   <!--import는 뒤에다가해야함-->
   <%
     List<BoardVO> list = (List<BoardVO>) request.getAttribute("blist");
   	 PageDTO paging = (PageDTO) request.getAttribute("pageInfo");
    %>
    <p><%=paging %></p>
    <h3>게시글 목록</h3>
<!--table.table,자보코드를 사용할수 있다<%%>-->
    <table class="table">
        <thead>
            <tr>
                <th>글번호</th>
                <th>제목</th>
                <th>작성자</th>
                <th>작성일시</th>
                <th>조회수</th>
            </tr>
        </thead>
        <tbody>
            <%for(BoardVO board : list) {%>
            <tr>
                <!-- <%=board.getBoardNo()%> -->
                <td><a href="board.do?bno=<%=board.getBoardNo()%>"><%=board.getBoardNo() %></a></td>
                <td><%=board.getTitle()%></td>
                <td><%=board.getWriter()%></td>
                <td><%=board.getWriteDate()%></td>
                <td><%=board.getReadCnt()%></td>
            </tr>
            <%} %>
        </tbody>
    </table>
    <!-- paging 시작 -->
    <nav aria-label="Page navigation example">
		<ul class="pagination justify-content-center">
		<!-- 이전페이지없을경우,이전페이지여부체크 -->
		<!-- 이전페이지 활성화. -->
		<%if (!paging.isPrev()){ %>
		<!-- 비활성화 -->
		  <li class="page-item disabled">
		    <a class="page-link">Previous</a>
		  </li>
		 <%}else{ %>
		  <li class="page-item">
		  <!-- 현재페이지에서 이전페이지를보여주면되니까 -1작은거 보여주면됨-->
		    <a class="page-link" href="boardList.do?page=<%=paging.getStart()-1%>">Previous</a>
		  </li>
		  <%} %>
		  
		  <!-- paging정보를 활용. -->
		  <%for(int p = paging.getStart();p<=paging.getEnd();p++) {%>
		  <li class="page-item"><a class="page-link" href="boardList.do?page=<%=p%>"><%=p %></a></li>
		  <!-- <li class="page-item"><a class="page-link" href="boardList.do?page=1">1</a></li>
		  <li class="page-item"><a class="page-link" href="boardList.do?page=2">2</a></li>
		  <li class="page-item"><a class="page-link" href="boardList.do?page=3">3</a></li> -->
		  <%} %>
		  
		<!-- 이후페이지 활성화. -->
		<%if (!paging.isNext()){ %>
		<!-- 비활성화 -->
		  <li class="page-item disabled">
		    <a class="page-link">Next</a>
		  </li>
		 <%}else{ %>
		  <li class="page-item">
		  <!-- 현재페이지에서 이전페이지를보여주면되니까 -1작은거 보여주면됨-->
		    <a class="page-link" href="boardList.do?page=<%=paging.getEnd()+1%>">Next</a>
		  </li>
		  <%} %>
		  
		  
		  
		  
		  
		  <!-- <li class="page-item">
		    <a class="page-link" href="#">Next</a>
		  </li> -->
		</ul>
	</nav>
<!-- paging 종료. -->    
    
    
    
	<jsp:include page="../include/footer.jsp"></jsp:include>
</body>
<!-- include: 외부파일 포함 -->
<!-- <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/js/bootstrap.bundle.min.js" integrity="sha384-j1CDi7MgGQ12Z7Qab0qlWQ/Qqz24Gc6BM0thvEMVjHnfYGF0rmFCozFSxQBxwHKO" crossorigin="anonymous"></script> -->
</html>