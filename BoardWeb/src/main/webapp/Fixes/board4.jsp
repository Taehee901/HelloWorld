<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- datatable 라이브러리ajax object -->
<link href="//cdn.datatables.net/2.3.2/css/dataTables.dataTables.min.css" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.29.2/moment.min.js"></script>
<script src="//cdn.datatables.net/2.3.2/js/dataTables.min.js"></script>    
<h3>상세화면(board.jsp)</h3>
<form action="modifyBoard.do">
  <input type="hidden" name="bno" value="${board.boardNo }">
  <input type="hidden" name="page" value="${page }">
  <input type="hidden" name="searchCondition" value="${searchCondition }">
  <input type="hidden" name="keyword" value="${keyword }">
  <table class="table">
    <tr>
      <th>글번호</th>
      <td>${board.boardNo }</td>
      <th>조회수</th>
      <td>${board.readCnt }</td>
    </tr>
    <tr>
      <th>제목</th>
      <td colspan="3">${board.title }</td>
    </tr>
    <tr>
      <th>내용</th>
      <td colspan="3">
        <textarea cols="45" rows="3" class="form-control" readonly>${board.content }</textarea></td>
    </tr>
    <tr>
      <th>작성자</th>
      <td colspan="3">${board.writer }</td>
    </tr>
    <tr>
      <th>작성일시</th>
      <td colspan="3">${board.writeDate }</td>
    </tr>
    <tr>
      <td colspan="4" align="center">
        <input type="submit" value="수정" class="btn btn-warning">
        <button class="btn btn-danger" type="button">삭제</button>
      </td>
    </tr>
  </table>
</form>
<!-- 댓글관련 페이지 -->
<style>
  div.reply ul {
    list-style-type: none;
  }

  div.reply span {
    display: inline-block;
  }
</style>
<div class="container reply">
  <div class="header">
    <input class="col-sm-8" id="reply">
    <button class="col-sm-3 btn btn-primary" id="addReply">등록</button>
  </div>
  <!-- datatable 적용. -->
  <table id="example" class="display">
        <thead>
            <tr>
                <th>댓글번호</th>
                <th>내용</th>
                <th>작성자</th>
                <th>작성일자</th>
            </tr>
        </thead>
        <tfoot>
            <tr>
                <th>Name</th>
                <th>Position</th>
                <th>Office</th>
                <th>Extn.</th>
            </tr>
        </tfoot>
    </table>
</div>

<script>
  let bno = "${board.boardNo}";
  let logId = "${logId}";
  document.querySelector('button.btn-danger').addEventListener('click', function () {
    location.href = 'removeBoard.do?bno=' + bno;
  })
</script>

<script>
const table = new DataTable('#example', {
	    ajax: 'replyList.do?bno='+bno,//각페이지마다 번호다름
	    columns: [//tfoot name..컬럼이름데이터에들어감
	        { data: 'replyNo' },
	        { data: 'reply' },
	        { data: 'replyer' },
	        { data: 'replyDate' }
	    ],
	    lengthMenu: [5, 10, 15, -1]//건수지정
	  //0번째부터 정렬하는데 역순(컬럼과 지정방식)
	    //order: [[0, 'desc']]	
		  //order: [[]] 
});
	    function addNewRow() {
	    	//ajax
	    	let reply = document.querySelector('#reply').value;
	    	if(!reply || !logId){
	    		return;
	    	}
	    	fetch('addReply.do?bno='+bno+'&reply='+reply+'&replyer='+replyer)
	    	.then(data => data.json())
	    	.then(result =>{
	    		console.log(result);
		    	//화면추가.row
		        table.row
		            .add({replyNo : result.replyNo,
		            	  reply : result.reply,
		                  replyer :result.replyer,
		                  replyDate :result.replyDate 
		            })
		            .draw(false);//화면 
	    	})//success면 화면출력
	    	.catch(err => console.log(err))
	        //counter++;
	    }
	     
	    //const table = new DataTable('#example');
	    //let counter = 1;
	     
	    document.querySelector('#addReply').addEventListener('click', addNewRow);
	  
	  

</script>