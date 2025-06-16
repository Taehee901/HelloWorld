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
    <!-- 댓글관련 페이지 -->
    <style>
      div.reply ul {
      	list-style-type:none;
      }
      div.reply span{
      	display:inline-block;
      }
    </style>
    <div class="container reply">
       <div class = "header">
         <input class="col-sm-8" id="reply">
         <button class="col-sm-3 btn btn-primary" id="addReply">등록</button>
       </div>
       <!-- 댓글목록 -->
       <div class="content">
       <!-- 타이틀 -->
       	<ul id="title">
       	  <li>
       	  	<span class="col-sm-2">글번호</span>
       	  	<span class="col-sm-4">글내용</span>
       	  	<span class="col-sm-2">작성자</span>
       	  	<span class="col-sm-2">작성일시</span><!-- 3,title -->
       	  	<span class="col-sm-1">삭제</span>
       	  </li>
       	</ul>
       	<!-- 목록 -->
       	<ul id="target"></ul>
       </div>
       <!-- 댓글 페이징.sm작게,lg크게-->
       <div class="footer">
       <nav aria-label="...">
		  <ul class="pagination pagination-sm">
		    <li class="page-item disabled">
		      <span class="page-link">Previous</span>
		    </li> <!-- 이전페이지의 여부 -->
		    
		    <li class="page-item"><a class="page-link" href="#">1</a></li>
		    <li class="page-item active" aria-current="page">
		      <span class="page-link">2</span>
		    </li>
		    <li class="page-item"><a class="page-link" href="#">3</a></li>
		    <li class="page-item">
		      <a class="page-link" href="#">Next</a>
		    </li><!-- 이후 페이지 --> 
		  </ul>
		</nav>
		<!-- 댓글페이징 end. -->
       </div>
    </div>
    <!-- 댓글관련 페이지 -->
    <script>
        let bno = "${board.boardNo }";
        let logId = "${logId}";//댓글작성자
        console.log(bno);
        document.querySelector('button.btn-danger').addEventListener('click',function(){
            location.href = 'removeBoard.do?bno='+bno;
        })
    </script>
    <script src="js/service.js"></script>
    <script src="js/reply.js"></script>
<!--     
</body>
</html> -->