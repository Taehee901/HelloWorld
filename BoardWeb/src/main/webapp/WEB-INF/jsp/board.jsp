<%@page import="com.yedam.vo.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!-- <!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
page 내장객체에 이름이있어서 pg로 변경
<body> -->
    <!--꺽쇄에%값% 변수값읽어올때 -->
    <h3>상세화면(board.jsp)</h3>
    <form action="modifyForm.do">
    <input type="hidden" name="bno" value="${board.boardNo }">
    <input type="hidden" name="page" value="${page }">
    <input type="hidden" name="searchCondition" value="${searchCondition }">
    <input type="hidden" name="keyword" value="${keyword }">
    <table class="table">
        <tr>
            <th>글번호</th><td>${board.boardNo }</td>
            <th>조회수</th><td>${board.readCnt }</td>
        </tr>
        <tr>
            <th>제목</th><td colspan="3">${board.title }</td>
        </tr>
        <tr>
            <!-- readonly -->
            <th>내용</th><td colspan="3"><textarea col="45" rows="4" class="form-control">${board.content }</textarea></td>
        </tr>
        <tr>
            <th>작성자</th><td colspan="3">${board.writer }</td>
        </tr>
        <tr>
            <th>작성일시</th><td colspan="3"><fmt:formatDate value="${board.writeDate}" pattern="yyyy-MM-dd"/> </td>
        </tr>
        <!-- 문자 ==(x) .equlas ... 문자를숫자취급하니안되었다.. -->
       	<c:choose>
       		<c:when test="${logId eq (board.writer ) }">
	       		<tr>
	           	  <td colspan="4" align="center">
	                <input type="submit" value="수정"class="btn btn-warning">
	                <!-- submit이면 input태그랑 같아서 modifyForm로 이동이 된다 -->
	                <button class="btn btn-danger" type="button">삭제</button>
	              </td>
	        	</tr>
       		</c:when>
       		<c:otherwise>
       			<tr>
	              <td colspan="4" align="center">
	                <input type="submit" value="수정"class="btn btn-warning"disabled>
	                <!-- submit이면 input태그랑 같아서 modifyForm로 이동이 된다 -->
	                <button class="btn btn-danger" type="button"disabled>삭제</button>
	             </td>
	           </tr>
       		</c:otherwise>
       	</c:choose>
    </table>
    </form>
    <script>
        let bno = "${board.boardNo }";
        console.log(bno);
        document.querySelector('button.btn-danger').addEventListener('click',function(){
            location.href = 'removeBoard.do?bno='+bno;
        })
    </script>

<!--     
</body>
</html> -->