<%@page import="com.yedam.common.SearchDTO"%>
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
   //자바코드를제거한
     List<BoardVO> list = (List<BoardVO>) request.getAttribute("blist");
   	 PageDTO paging = (PageDTO) request.getAttribute("pageInfo");
   	 SearchDTO search = (SearchDTO) request.getAttribute("search");
    %>
    <p><%=paging %></p>
    <h3>게시글 목록</h3>
    
    <!-- 검색조건추가.--><!--openwith-visualstuidocode원본파일 div.row#row 아이디 클래스는 div.row-->
		<form action="boardList.do">
			<div class="row">
				<!--selected부트스트랩에서 row클래스만나면 전체넓이를계산,12/1,sm은 화면넓이의 픽셀(기계에맞는크기),전체넓이의 4를 차지하겠다는 의미 = 전체부분의 12/4 넓이 사용-->
				<div class="col-sm-4">
					<!--form에서는(?) 파라미터로넘어가는값-->
					<select name="searchCondition" class="form-control">
						<!--옵션테그 사용자선택가능ㅇ한값여기서는 삼항연산식은 if문못씀,변수값을출력할때-->
						<!-- boardControl쪽에 kw,sc같은 값의 초기값이 null이라 오류발생 -->
						<option value="">선택하세요</option>
						<option value="T"<%=search.getSearchCondition() != null && search.getSearchCondition().equals("T") ? "selected" : ""%>>제목</option>
						<option value="W"<%=search.getSearchCondition() != null && search.getSearchCondition().equals("W") ? "selected" : ""%>>작성자</option>
						<option value="TW"<%=search.getSearchCondition() != null && search.getSearchCondition().equals("TW") ? "selected" : ""%>>제목&작성자</option>
					</select>
				</div>
				<!--사용자 선택한 키워드,속성태그는 []-->
				<div class="col-sm-6">
				<!-- null이면 공백 아닐경우 값을보여줌 -->
					<input type="text" name="keyword" class="form-control" value="<%=search.getKeyword() == null ? "" : search.getKeyword()%>">
				</div>
				<!--검색버튼 input:submit,col가 데이터한건의 행을가르킴,전체분의 해당숫자만큼의크기를가짐-->
				<div class="col-sm-2">
				<!--  -->
					<input type="submit" value="검색" class="btn btn-primary">
				</div>
			</div>
		</form>

    
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
                <!-- <%=board.getBoardNo()%> 하나의값 줄바꿈도하나의 값으로 인식해서 (+++)이런식으로나와안됨,문자열을 하나로만든후 불러올수o-->
                <!-- 파라미터전달 searchCondition=T&keyword=Test&page=3 key:value형식값전달-->
                <td><a href="board.do?bno=<%=board.getBoardNo()%>&searchCondition=<%=search.getSearchCondition()%>&page=<%=paging.getCurrentPage()%>&keyword=<%=search.getKeyword()%>"><%=board.getBoardNo() %></a></td>
                <!--<td><a href="board.do?bno=<%=board.getBoardNo()%>&searchCondition=<%=search.getSearchCondition()%>&page=<%=paging.getCurrentPage()%>&keyword=<%=search.getKeyword()%>"><%=board.getBoardNo() %></a></td>-->
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
			<% if(p != paging.getCurrentPage()){ %>
			<!-- 현재페이지와같으닞아닌지체크 후 같으면 else문출력  <li class="page-item"><a class="page-link" href="boardList.do?page=<%=p%>"><%=p %></a></li> -->
		 <!-- 오타날확률,메소드호출또는 붙여넣게 -->
		  <li class="page-item"><a class="page-link" href="boardList.do?searchCondition=<%=search.getSearchCondition()%>&keyword=<%=search.getKeyword()%>&page=<%=p %>"><%=p %></a></li>
		  <!-- <li class="page-item"><a class="page-link" href="boardList.do?page=1">1</a></li>
		  <li class="page-item"><a class="page-link" href="boardList.do?page=2">2</a></li>
		  <li class="page-item"><a class="page-link" href="boardList.do?page=3">3</a></li> -->
		  <%}else{ %>
		  <li class="page-item active" aria-current="page">
		  	<span class="page-link"><%=p%></span>
		  </li>
		  <%} } %>
		  
		  
			
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