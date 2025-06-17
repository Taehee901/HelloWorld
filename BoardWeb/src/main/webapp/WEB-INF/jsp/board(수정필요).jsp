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
    <button class="col-sm-3 btn btn-danger" id="delReply">삭제</button>
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
                <th>댓글번호</th>
                <th>내용</th>
                <th>작성자</th>
                <th>작성일자</th>
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
	  //tfoot name..컬럼이름데이터에들어감
	    ajax: 'replyList.do?bno='+bno,//각페이지마다 번호다름
	    columns: [
	        { data: 'replyNo' },
	        { data: 'reply' },
	        { data: 'replyer' },
	        { data: 'replyDate' }
	    ],
	    lengthMenu: [5, 10, 15, -1],//건수지정
	  //0번째부터 정렬하는데 역순(컬럼과 지정방식)
	    order: [[0, 'desc']]	
});
//선택작업
//화면에서 row 삭제하는 기능,jquery(라이브러리)문법기반으로만들어져서,처리속도느림-on=addEvent
table.on('click', 'tbody tr', (e) => {
    let classList = e.currentTarget.classList;//currentTarget이벤트발생시키는대상=tr배열처럼반환
 
    if (classList.contains('selected')) {//contains?classList선택tr
        classList.remove('selected');
    	console.log(classList);
    }
    else {//rows모든,foeach=each
        table.rows('.selected').nodes().each((row) => row.classList.remove('selected'));
        classList.add('selected');
    }
});

//이전선택된거사라지는기능-화면에서만
//document.querySelector('#delReply').addEventListener('click', async function () {
    //화면갱신.fetch await fetch();
    //let data = await fetch('?????');
    //if(!document.querySelector('tr.selected')){
    	//alert('댓글을 선택하세요');
    	//return;
    //}
    //삭제할 댓글번호.,동기방식
    //let rno = document.querySelector('tr.selected').children[0].innerHTML;
    //console.log(rno);
    //let data = await fetch('removeReply.do?rno='+rno);//프라미스라는 객체여야한다,await는 then.then.catch
    //let result = await data.json();//json->javascirpt->프라미스 객체로 반환
    //if(result.retCode == 'Success'){
    	//table.row('.selected').remove().draw(false);
   // }
//});
  
   // fetch('removeReply.do?rno=' + rno)
    //.then(data => data.json())
    //.then(result=>{
    	//let writer = result.retVal.replyer;
    	//console.log(writer);
    	//if(result.retCode == 'Success'){
        	//if(writer == logId){
      		  //table.row('.selected').remove().draw(false);
          	//}   		
    	//}
    	//}
    //.catch(err =>console.log(err))
    //})

function addNewRow() {
	//ajax
	let reply = document.querySelector('#reply').value;
	if(!reply || !logId){
		return;
	}
	//500에러
	fetch('addReply.do?bno='+bno+'&reply='+reply+'&replyer='+logId)
	.then(data => data.json())
	.then(result =>{
		console.log(result);
		let rvo = result.retVal;//result객체에 있는 retVal 
 	//화면추가.row
     table.row
         .add({replyNo : rvo.replyNo,
         	   reply : rvo.reply,
               replyer :rvo.replyer,
               replyDate :rvo.replyDate 
         })
         .draw(false);//화면 
	})//success면 화면출력
	.catch(err => console.log(err))
}
	 document.querySelector('#addReply').addEventListener('click', addNewRow);
</script>