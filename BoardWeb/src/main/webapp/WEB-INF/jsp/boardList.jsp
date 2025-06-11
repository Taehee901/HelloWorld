<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri= "http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
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

		<!-- 변수에담긴값을가져왔지만 attrubte의 값을가져오면(읽어오면)됨$여기 ,자바코드 list <>이 있어야하고,$어튜르브트값씀,반목문은못쓰는단점을 액션태그는..커스텀태그 라이브러리를이용-->
    <!--  <p>${pageInfo }${blist }${search }</p>-->
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
						<option value="T" ${!empty search.searchCondition && search.searchCondition == 'T' ? 'selected' : '' }>제목</option>
						<option value="W"${!empty search.searchCondition && search.searchCondition == 'W' ? 'selected' : '' }>작성자</option>
						<option value="TW"${!empty search.searchCondition && search.searchCondition == 'TW' ? 'selected' : '' }>제목&작성자</option>
					</select>
				</div>
				<!--사용자 선택한 키워드,속성태그는 []-->
				<div class="col-sm-6">
				<!-- search.keyword null이면 공백 아닐경우 값을보여줌,getkeyword호출 == null ? = empty-->
					<input type="text" name="keyword" class="form-control" value="${empty search.keyword ? '':search.keyword }">
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
		<!-- for(BoardVO board : list)변수이름과 어튜르뷰트이름인 거 차이밖에 없음 -->
            <c:forEach var="board" items="${blist }">            
            <tr>
                <!-- 어튜르뷰트값.필드값(keyword) jlts전하나의값 줄바꿈도하나의 값으로 인식해서 (+++)이런식으로나와안됨,문자열을 하나로만든후 불러올수o-->
                <!-- 파라미터전달 searchCondition=T&keyword=Test&page=3 key:value형식값전달,#자릿수 #,###.##-->
                <td><a href="board.do?bno=${board.boardNo }&searchCondition=${search.searchCondition }&page=${pageInfo.currentPage }paging.getCurrentPage()%>&keyword=${search.keyword }">${board.boardNo }</a></td>
                <td>${board.title }</td>
                <td><c:out value="${board.writer }"/></td>
                <td><fmt:formatDate value="${board.writeDate }" pattern="yyyy-MM-dd"/></td>
                <td><fmt:formatNumber value="${board.readCnt }" pattern="#,###" /> </td>
            </tr>
            </c:forEach>
        </tbody>
    </table>
    <!-- paging 시작 -->
    <nav aria-label="Page navigation example">
		<ul class="pagination justify-content-center">
		<!-- 이전페이지없을경우,이전페이지여부체크 -->
		<!-- 이전페이지 활성화. choose when otherwise -->
		<!-- 자바코드랑 같이쓰는거에서 ->jstl if..else -->
		<c:choose>
			<c:when test="${!pageInfo.prev }">
			  <li class="page-item disabled">
			    <a class="page-link">Previous</a>
			  </li>
			<!-- 비활성화 태그명을 이용 -->
			</c:when>
			<c:otherwise>
			  <li class="page-item">
			  <!-- 현재페이지에서 이전페이지를보여주면되니까 -1작은거 보여주면됨-->
			    <a class="page-link" href="boardList.do?page=${pageInfo.start -1}">Previous</a>
			  </li>
			</c:otherwise>
		</c:choose>
		  <!-- paging정보를 활용. ne = != -->
		  <!--pageInfo.start(필드값) 페이징 가져온 첫값.start 변수는 var,시작값 begin,반복끝값,반복안적어주면 자동으로 1증가(기본값) -->
		  <c:forEach var="p" begin="${pageInfo.start }" end="${pageInfo.end }" step="1">
		  <c:choose>
		  	<c:when test="${p ne pageInfo.currentPage }">
		  			<!-- 현재페이지와같으닞아닌지체크 후 같으면 else문출력  <li class="page-item"><a class="page-link" href="boardList.do?page=</a></li> ,BoardControl어튜리브튜 = pageInfo-->
		 	 	<li class="page-item"><a class="page-link" href="boardList.do?searchCondition=${search.searchCondition }&keyword=${search.keyword }&page=${p }">${p }</a></li>
		  	</c:when>
		  	<c:otherwise>
		  		<li class="page-item active" aria-current="page">
				  <span class="page-link">${p }</span>
				</li>
		  	</c:otherwise>
		  </c:choose>
		  </c:forEach>
		  
			
		<!-- 이후페이지 활성화. pageDTO next라는 필드가 o -->
		<c:choose>
		<c:when test="${!pageInfo.next }">
		<!-- 비활성화 -->
		  <li class="page-item disabled">
		    <a class="page-link">Next</a>
		  </li>
		  </c:when>
		 <c:otherwise>
		  <li class="page-item">
		  <!-- 현재페이지에서 다음페이지를보여주면되니까 +1 보여주면됨-->
		    <a class="page-link" href="boardList.do?page=${pageInfo.end+1}">Next</a>
		  </li>
		  </c:otherwise>
		</c:choose>

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