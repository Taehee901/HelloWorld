<%@page import="com.yedam.vo.BoardVO"%>
<%@page import="java.util.List"%>
<%@page import="com.yedam.service.BoardServiceImpl"%>
<%@page import="com.yedam.service.BoardService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!-- 지시자 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- front 컨트롤러 -->
	<jsp:forward page="boardList.do"></jsp:forward>
	<%
	//기능실행 액션태그jsp
	//주석문..
	// sample.jsp -> sample_jsp.java -> sample_jsp.class 실행.
	String str = "Hello,World";
	for(int i=0;i<10;i++){
	%>
	<h3>여기는 HTML영역입니다.</h3>
	<%
	}//end of for.
	//여기 자바 영역.
	BoardService svc = new BoardServiceImpl();
	List <BoardVO> list = svc.boardList(1);//1페이지본다는의미
	out.print("<ul>");
	//자바에서 html을 사용하려면<% 		
	for(BoardVO board : list){
	%>
	<!-- =는변수로사용가능 -->
	<li><%=board.getBoardNo() %>,<%=board.getTitle() %></li>
	<% 
	}
	out.print("</ul>");
	System.out.print(str);

	%>
</body>
</html>