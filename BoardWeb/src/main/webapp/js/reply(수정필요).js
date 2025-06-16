
/**
 * javascript는 js폴더밑
 * reply.js
 * 
 */
let page = 1;//page 선택.
console.log(bno);

//메소드라 함수호출필요
Date.prototype.format = function() {
	let yyyy = this.getFullYear();//2025-05-27 12:39:23(연도)
	let MM = this.getMonth() + 1;//월 0부터 시작
	let dd = this.getDate();
	let hh = this.getHours();
	let mm = this.getMinutes();
	let ss = this.getSeconds();
	//slice? 전체글자에서
	return yyyy + '-' + ('0' + MM).slice(-2) + '-' + ('0' + dd).slice(-2) + ' ' + ('0' + hh).slice(-2) + ':' + ('0' + mm).slice(-2); //+ ':' + ('0' + ss).slice(-2);
}
//글목록출력.//게시글번호
//최초보여주는곳
//page = 2;
function showReplyList(){
document.querySelector('#target').innerHTML = "";
svc.replyList({ bno, page } 
	, result => {
		//console.log(result);	
		let ul = document.querySelector('#target');
		let template = document.querySelector('#target li');//queryselectall전체를들고오는데 queryselector는 첫번째거 들고옴
		console.log(result);
		for (let reply of result) {
			template = makeTemplate(reply);
			/*let rdate = new Date(reply.replyDate).format();//그냥가지고오면문자열이라 객체타입으로 변환시킴,Date.format
			//onclick이벤트(속성안에 함수호출가능),2.반복문끝나는위치button선택해서 
			template = `
					<li data-rno=${reply.replyNo}>
								<span class="col-sm-2">${reply.replyNo}</span>
								<span class="col-sm-4">${reply.reply}</span>
								<span class="col-sm-2">${reply.replyer}</span>
								<span class="col-sm-2">${rdate}</span><!-- 3,title,Date -->
								<span class="col-sm-1"><button onclick="deleteReply(event)" class="btn btn-danger">삭제</button></span>
							</li>
			`;//줄바꿈편하게 해줌,event의 기준으로 상위요소*/

			//ul태그의 위치,afterbegin시작태그를기준으로 끝나는부분에 놓는게
			ul.insertAdjacentHTML("beforeend", template);
		}
		//댓글페이지.
		showPageList();//페이징을 목록마다호출해줘야 새로그려짐
		//showReplyList();
	}
	, function(err) {
		console.log(err);
	}
);
}

console.log(showReplyList);

//이벤트. 
//1.댓글 등록이벤트.
document.querySelector("#addReply").addEventListener('click', addReplyHandler);
//2.댓글링크이벤트등록. a tag,elem 내가선언한변수,elem=>a
//화면초기화
function pagingEvent(){
document.querySelectorAll('.footer nav a').forEach(function(elem,idx){//함수매개값으로 a태그만큼반복
	console.log(elem);//a tag
	elem.addEventListener('click',function(e){
		//document.querySelector('#target').innerHTML = "";//<ul>.....</ul>
		//page = e.target.innerHTML;//a태그의 <a data-page="n">1</a>data-page="${p}"
		//page = e.target.dataset.page;
		//svc.replyList({ bno, page }
			//, result => {
			//	//console.log(result);	
				//let ul = document.querySelector('#target');
				//let template = "";//document.querySelector('#target li');//queryselectall전체를들고오는데 queryselector는 첫번째거 들고옴
				//console.log(result);
				//5건씩 화면에 출력.
				//for (let reply of result) {
				//	template = makeTemplate(reply);
					//ul.insertAdjacentHTML("beforeend", template);

				//}
				//댓글페이지.
				page = e.target.dataset.page;
				showReplyList();//svc.replylist
		})
});//메소드
}//end of pagingEvent
//댓글등록이벤트핸들러.
function addReplyHandler(e) {
	//글번호,로그인,몇번글상세화면..
	let reply = document.querySelector('#reply').value;
	if (!logId || !reply) {
		alert('값을 확인하세요!');
		return;//함수를 종료,값반환
	}

	//댓글등록,속성과변수같아서그냥씀
	svc.addReply({ bno, reply, replyer: logId }
		, result => {
			let ul = document.querySelector('#target');
			//console.log(result);
			if (result.retCode == "Success") {
				let rval = result.retVal;//반환값에는 retCode,retVal있음
				//ul.insertAdjacentHTML("afterbegin", makeTemplate(rval));
				page = 1;//최신글,첫페이지로 지정
				showReplyList();//목록출력
				document.querySelector('#reply').value = "";//입력값 초기화
				console.log(rval);
				//let rdate = document.querySelector('#target li');//queryselectall전체를들고오는데 queryselector는 첫번째거 들고옴
				//ul태그의 위치,afterbegin시작태그를기준으로 제일먼저 놓는게
			}
			//let template = document.querySelector('#target li');//queryselectall전체를들고오는데 queryselector는 첫번째거 들고옴
			//for (let reply of result) {
				
				//let rdate = new Date(reply.replyDate).format();//그냥가지고오면문자열이라 객체타입으로 변환시킴,Date.format
				//onclick이벤트(속성안에 함수호출가능),2.반복문끝나는위치button선택해서 
				/*template = `
		  					<li data-rno=${rval.replyNo}>
		  			       	  	<span class="col-sm-2">${rval.replyNo}</span>
		  			       	  	<span class="col-sm-4">${rval.reply}</span>
		  			       	  	<span class="col-sm-2">${rval.replyer}</span>
		  			       	  	<span class="col-sm-2">${rdate}</span><!-- 3,title,Date -->
		  			       	  	<span class="col-sm-1"><button onclick="deleteReply(event)" class="btn btn-danger">삭제</button></span>
		  			       	  </li>
		  			`;//줄바꿈편하게 해줌,event의 기준으로 상위요소*/

				//ul태그의 위치,afterbegin시작태그를기준으로 끝나는부분에 놓는게

			}
		, err => console.log(err)

	)
}//end of addReplyHandler.

//댓글페이징출력.
function showPageList(){
//document.querySelector('#target').innerHTML = "";//목록지우기
svc.replyCount(bno, //첫번째매개값
	result=>{
		//console.loe(result.totalCnt);//{"totalCnt":80}
		let totalCnt = result.totalCnt;
		let start,end;// 첫번째 ~ 마지막 페이지
		let prev,next;//이전,이후 페이지존재여부
		let realEnd = Math.ceil(totalCnt/5); //실제 마지막페이지는 건수를 기준으로 계산한 마지막 페이지.
		//자바스크립트는 소수점까지 계산가능
		//end 계산상에 의한 마지막 페이지
		end = Math.ceil(page/10) * 10;//현재소속된 기준으로 마지막페이지계산,ex)9일 경우 0.9->올림->1*10=10
		start = end - 9;
		end = end > realEnd ? realEnd : end;//false일 경우 계산한 페이지 들고옴	
		prev = start > 1;//? true,1일 아닐경우는 이전페이지존재
		next = end < realEnd;
		
		//기존페이징 clear
		document.querySelector('nav ul.pagination-sm').innerHTML="";//지우기
		//페이지목록 출력.
		let target = document.querySelector('nav ul.pagination-sm');
		let str;
		if(prev){
			 str = `<li class="page-item">
					  <a class="page-link" href="#" data-page="${start-1}">Previous</a>
					</li>`;
		}else{
			 str = `<li class="page-item disabled">
						<span class="page-link" href="#">Previous</span>
					</li>`;
		}
		
		
		target.insertAdjacentHTML('beforeend',str);//끝나는 위치 앞에 붙임
		//1~10 페이징.
		for(let p = start; p <= end;p++){
			if(p == page){
				str = `<li class="page-item active" aria-current="page">
						  <span class="page-link">${p}</span>
						</li>`;
				
			}else{
				str = `<li class="page-item"><a class="page-link" href="#"data-page="${p}">${p}</a></li>`;				
			}
			//pagingEvent
			target.insertAdjacentHTML('beforeend',str);//끝나는 위치 앞에 붙임
		}
		
		//이후페이지.
		if(next){
			str = `<li class="page-item">
					<a class="page-link" href="#" data-page="${end+1}">Next</a>
					</li>`;
		} else {
			str = `<li class="page-item disabled">
					<span class="page-link" href="#">Next</span>
				   </li>`;
		}
		target.insertAdjacentHTML('beforeend',str);
		//생성한 페이징
		pagingEvent();
	},
	err =>console.log(err)
);
}//end of showPageList
	


//댓글화면출력,reply 이유- 
function makeTemplate(reply = {}) {
		console.log("reply 값 확인", reply);
	let rdate = new Date(reply.replyDate).format();//그냥가지고오면문자열이라 객체타입으로 변환시킴,Date.format
	//onclick이벤트(속성안에 함수호출가능),2.반복문끝나는위치button선택해서 
	//3,title,Date -->
	template = `
		<li data-rno="${reply.replyNo}">
       	  	<span class="col-sm-1">${reply.replyNo}</span>
       	  	<span class="col-sm-5">${reply.reply}</span>
       	  	<span class="col-sm-1">${reply.replyer}</span>
       	  	<span class="col-sm-3">${rdate}</span>
       	  	<span class="col-sm-1"><button onclick="deleteReply(event)" class="btn btn-danger">삭제</button></span>
       	  </li>
		`;//줄바꿈편하게 해줌,event의 기준으로 상위요소
	return template;//<li>....</li>반환.
}

//화면에서 찾아서 삭제
//댓글삭제함수.현버튼 상위요소 remove
function deleteReply(e) {
	//getAttrube = 
	let rno = e.target.parentElement.parentElement.dataset.rno;
	svc.removeReply(rno //메소드
		, result => {
			if(logId == board.writer){
				if (result.retCode == "Success") {
				//e.target.parentElement.parentElement.remove();//화면삭제
				alert("처리성공!");
				showReplyList();
			} else {
				alert("처리실패!");
			}
		  }
		}
		, err => console.log(err)
	)
}//end of deleteReply.