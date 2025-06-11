<%@page import="com.yedam.vo.BoardVO"%>
<%@page import="java.util.List"%>
<%@page import="com.yedam.common.SearchDTO"%>
<%@page import="com.yedam.service.BoardServiceImpl"%>
<%@page import="com.yedam.service.BoardService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!-- 태그라이브러리지시자-주소값 ,ctrl+space 안뜨면 라이브러리제대로실행x,prefix는 $표현식이라 주석이라도 에러남-->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!-- 숫자나 날짜관련 -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EL.jsp</title>
</head>
<body>
<!-- jsp 접두사 prefixc라는태그를 쓰겠다는의미>-->

<!--http://localhost:8080/BoardWeb/EL.jsp -->
<!-- webapp밑에있는거는 경로등록안해도바로실행가능,문자열 및 연산도가능,간단한표현식사용가능 -->
	<!-- 'Hello, World' 변환시점,init 서비스 진행-->
     <%
     	//한번요청하고 사용하면 사라짐,표현식사용편하게 attrubute값읽어올수o
     	request.setAttribute("msg", "Hello");
     //일정기간 서브상의 정보를 유지하기 위해 사용
     	session.setAttribute("errMsg", "ID,PW확인.");
     //어플리케이션 종료하기까지 계속살아있는객체,서블릿변경시점 생존기간이 긺
     	application.setAttribute("projectName", "BoardWeb");
     	String name = "hong";
     	System.out.print(name);
     	
     	BoardService svc = new BoardServiceImpl();
     	SearchDTO search = new SearchDTO();
     	search.setPage(1);
     	List<BoardVO> list = svc.boardList(search);
     	request.setAttribute("blist", list);
     %>
     <!-- ==  = eq, != = ne > = get, >= = ge -->
    ${ 10 - 5 == 10}
    <!-- attribute 정보를읽어옴,req~,session~상관x,msg공백x,!empty비어있는값이있는지물어봄 -->
   <p>${!empty msg }</p>
    <p>${errMsg }</p>
    <!-- session이 없을경우 어플리케이션 -->
    <p>${empty hello }</p>
    
    <!-- value attrubite값도됨,set은 변수 선언 및 출력 = String name = "hong",sysout.print(name)속성과 값으로 표현 ,name하면 문자열을 그냥 출력,값을 보고싶으면 $-->
    <c:set var="name" value="Hongkildong"></c:set>
    <c:out value="${name }"></c:out>
    
    
    <c:set var="age" value="20"></c:set>
    <c:if test="${age >= 20}">
    	<p>성인</p>
    </c:if>
    <!-- if..else -->
    <c:choose>
    	<c:when test="${!empty logId }">
    		<p>로그인상태</p>
    	</c:when>
    	<c:otherwise>
    		<p>로그아웃상태</p>
    	</c:otherwise>
    </c:choose>
    
       <c:if test="${empty logId }">
    		<p>로그아웃상태</p>
   	  </c:if>
        <c:if test="${!empty logId }">
    	<p>로그인상태</p>
    	</c:if> 
    
    <!-- 반복문 횟수 지정경우 var:변수명,begin:시작수지정,step:증감식-->
	<c:forEach var="i" begin="1" end="5" step="2">
		<span>i의 값은${i }</span>
	</c:forEach>
	
	<!-- 반복2 -->
	<table border="1">
	<c:forEach var="board" items="${blist }">
		<tr>
		<!-- 매소드말고 속성적어주면 알아서 속성이름 유추해서 호출 -->
		<!-- board.getBoardNo() -->
		  <td>${board.boardNo }</td>
		  <td>${board.title }</td> <!-- board.getTitle() -->
		  <td><c:out value="${board.writer }"></c:out></td>
		  <!-- 출력포맷지정할수o -->
		  <td><fmt:formatDate value="${board.writeDate }" pattern="yyyy-MM-dd HH:mm:ss"/></td>
		</tr>
	</c:forEach>
	</table>
	
</body>
</html>