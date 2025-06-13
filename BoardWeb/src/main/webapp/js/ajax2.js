/**
 * ajax2.js
 */
console.log(svc.add(10,20));
//목록출력메소드

svc.replyList(213,//게시글번호
	function(result){
		console.log(result);
		result.forEach(function(item){			
			let tr = makeRow(item);
			document.querySelector('table:nth-of-type(2) tbody').appendChild(tr);
		});//댓글수만큼 tr 생성
	 },//성공콜백함수
	function(err){ 
		console.log(err);
	})//실패콜백함수
	

//삭제메소드.(=삭제함수,기능구현,service쪽에 click이벤트를 호출하려면 필요)
function deleteReplyFnc(e){
	let rno = e.target.parentElement.parentElement.dataset.rno;
	svc.removeReply(rno,
		function(result){
			if (result.retCode == 'Success') {
				alert('삭제성공');
				e.target.parentElement.parentElement.remove();
			} else {
				alert('삭제실패');
			}
		},
		function(err){
			console.log(err);//==err=>console.error(err)
		}
	)
}

//등록이벤트.
document.querySelector('#addReply').addEventListener('click',addReplyFnc);
function addReplyFnc(e){
const bno = document.querySelector('#bno').value;
const reply = document.querySelector('#reply').value;
//필수입력
if(!bno || !reply || !logId){
	alert('필수값 입력 !');
	return;
}	
//메소드호출,속성과 변수이름이 같으면 한번만 써도됨 key:value
svc.addReply({bno,reply,replyer:logId},
	function(result) {//변수이름
		if (result.retCode == 'Success') {
			alert('등록성공');
			let tr = makeRow(result.retVal);
			let target = document.querySelector('table:nth-of-type(2) tbody tr');//제일첫번째 tr에 
			document.querySelector('table:nth-of-type(2) tbody').insertBefore(tr, target);
		}
		else {
			alert('등록실패');
		}			
	},
	function(err){
		console.log(err);
	}
  );
}

