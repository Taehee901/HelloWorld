<%@page import="com.yedam.vo.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- <!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
page 내장객체에 이름이있어서 pg로 변경
<body> -->
    <jsp:include page="../include/header.jsp"></jsp:include>
    <%
	 BoardVO board = (BoardVO) request.getAttribute("board");
     String pg = (String) request.getAttribute("page");
     String sc = (String) request.getAttribute("searchCondition");
     String kw = (String) request.getAttribute("keyword");
	 String logId = (String)session.getAttribute("logId");

    %>
    
    <!--꺽쇄에%값% 변수값읽어올때 -->
    <h3>상세화면(board.jsp)</h3>
    <form action="modifyForm.do">
    <input type="hidden" name="bno" value="<%=board.getBoardNo()%>">
    <input type="hidden" name="page" value="<%=pg%>">
    <input type="hidden" name="searchCondition" value="<%=sc%>">
    <input type="hidden" name="keyword" value="<%=kw%>">
    <table class="table">
        <tr>
            <th>글번호</th><td><%=board.getBoardNo()%></td>
            <th>조회수</th><td><%=board.getReadCnt()%></td>
        </tr>
        <tr>
            <th>제목</th><td colspan="3"><%=board.getTitle()%></td>
        </tr>
        <tr>
            <!-- readonly -->
            <th>내용</th><td colspan="3"><textarea col="45" rows="4" class="form-control"><%=board.getContent()%></textarea></td>
        </tr>
        <tr>
            <th>작성자</th><td colspan="3"><%=board.getWriter()%></td>
        </tr>
        <tr>
            <th>작성일시</th><td colspan="3"><%=board.getWriteDate()%></td>
        </tr>
        <!-- 문자 ==(x) .equlas ... 문자를숫자취급하니안되었다.. -->
       	<%if(logId.equals(board.getWriter())){ %>
         <tr>
            <td colspan="4" align="center">
                <input type="submit" value="수정"class="btn btn-warning">
                <!-- submit이면 input태그랑 같아서 modifyForm로 이동이 된다 -->
                <button class="btn btn-danger" type="button">삭제</button>
            </td>
        </tr>
        <%} else{ %>
        <tr>
            <td colspan="4" align="center">
                <input type="submit" value="수정"class="btn btn-warning"disabled>
                <!-- submit이면 input태그랑 같아서 modifyForm로 이동이 된다 -->
                <button class="btn btn-danger" type="button"disabled>삭제</button>
            </td>
        </tr>
        <%} %>
    </table>
    </form>
    <script>
        let bno = "<%=board.getBoardNo()%>";
        console.log(bno);
        document.querySelector('button.btn-danger').addEventListener('click',function(){
            location.href = 'removeBoard.do?bno='+bno;
        })
    </script>
<jsp:include page="../include/footer.jsp"></jsp:include>

<!--     
</body>
</html> -->