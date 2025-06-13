/**
 *
 * promise.js
 *  
 */
//의미x(순서설명)
//let data = "";
//비동기방식 우선순위,순서와 상관없이
//setTimeout(function(){//3.
	//data = "Hello, World";
	//console.log(data);//2.
//},0);//1.실행함수,2.지연시간(100=0.1,0 즉시시작),즉시실행인데
//for(let i = 0;i<10000;i++){//0.001초 지연 1.
	
//}
//console.log(data);

/**
 * Promise 객체역할.
 * 비동기방식의 처리를 동기방식의 순서로 처리(then(1)end-then(2)..)
 *서버로부터데이터받아오는 함수 fetch() 
 * 
 * 
 * =>(화살표 함수)
 * 
 * 
 */

 /*function add1(num1,num2){
	return num1+num2;
 }
 
 //함수표현식,함수표현식줄이기위해 =>사용,function지우고 간단하게 표현
 const add2 = function add2(num1,num2){
	return num1 + num2;
 } 
 
 const add3 = (num1,num2) =>{
	return num1+num2;
 }*/
 //매개변수실행=>()
 //const add = (num1,num2) => num1+num2;
 
//비동기->순차적으로,fetch값을 then1처리된거 ->then2
 fetch('replyList.do?bno=213')//json문자스트림 = data
 .then(function(data){//자바스크립트는 함수를매개값으로받기가능
	//console.log(data);//Response결과(스트림형태),바이트값-replyList.do반환하는
	return data.json();//json -> object(jsp),프라미스값으로 반환 성공 then,실패 catch
 })
 //함수구현
 //코드필요하면 then 함수 정의해서 사용
 .then(function(result){ //data.json()
	//console.log(result);
	result.forEach(function(item){
		//console.log(item);
		
		let tr = makeRow(item);
		//tr을 tbody에 추가
		document.querySelector('table:nth-of-type(2) tbody').appendChild(tr);
	});//댓글수만큼 tr 생성
	
 })
 //에러날 경우는 catch에서 처리(어느위치든 상관없이),어느곳한곳이라도에러가있으면 cthchrnanstlfgod
 .catch(function(err){
	console.log(err);
 })//목록출력.
 
 //=>함수,
 //삭제 함수
 function deleteReplyFnc(e){
	if(!confirm("삭제하겠습니까?")){
		return;
	}
	//removeReply?rno=23
	let rno = e.target.parentElement.parentElement.dataset.rno;
	/*fetch('removeReply.do?rno='+ rno)//url오류
	.then(function(json){
		return json.json();
	})
	.then(function(data){
		//console.log(data);
		if(data.retCode == 'Success'){
			alert('삭제성공');
			e.target.parentElement.parentElement.remove();
		}else{
			alert('삭제실패');
			console.error(err);//빨갛게보임
		}	
	})
	.catch(function(err){
		console.log(err);
	 })
	}*/
	
	
	//fatch 삭제
	fetch('removeReply.do?rno='+ rno)
		.then(json=> json.json())//변수가하나면 () 한개 더 필요x,뭐라하는지모르겠다..포기
		.then(data =>{
			//console.log(data);
			if(data.retCode == 'Success'){
				alert('삭제성공');
				e.target.parentElement.parentElement.remove();
			}else{
				alert('삭제실패');
			}
		})
		.catch(err=>console.error(err))//빨갛게보임
 } //end of deleteReplyFnc*/
 
 
 //이벤트등록관련부분부재,버튼클릭해도 아무반응x
 document.querySelector('#addReply').addEventListener('click',addReplyFnc);
 //등록 --해결필요
 function addReplyFnc(e){
	const bno = document.querySelector('#bno').value;
	const reply = document.querySelector('#reply').value;
	if(!bno || !reply || !logId){
		alert('필수값 입력 필수!');
		return;
	}	
	//ajax호출
	/*fetch('addReply.do?bno='+bno+'&reply='+reply+'&replyer='+logId)
		.then(json=> json.json())//이메소드쓰면알아서 jsona문자열타입일경우,파싱작업
		.then(responce =>{//기능구현
			if(responce.retCode == 'Success'){
				alert('등록성공');
				let tr = makeRow(responce.retVal);
				let target = document.querySelector('table:nth-of-type(2) tbody tr');
				document.querySelector('table:nth-of-type(2) tbody').insertBefore(tr,target);//rvo를 
			}
			else{
				alert('등록실패');
			}
		})
		.catch(err => console.error(err));
		*/
		
	//
		//fetch(url)=>get방식요청
		//fetch(url,option) =>post방식
		
	//요청처리방식에 	
	//fetch(url,optuon),디폴트 get방식은 데이터제한,파일업로드할때 등등,데이터사용하는건 post방식	전달데이터많을때
	fetch('addReply.do',{//요청방식 기타등등 지정,get방식은 파라미터 구분?넣었지만 포스트방식에서는 x
			method: 'post',
		//content타입지정  
			headers: {'Content-Type':'application/x-www-form-urlencoded'},//기본값-json,mult팜?
			body:'bno='+bno+'&reply='+reply+'&replyer='+logId
	})
	
	.then(data=> data.json())//json문자열 ->jsp	
	.then(result => {
			if(result.retCode == 'Success'){
			alert('등록성공');
			let tr = makeRow(result.retVal);
			let target = document.querySelector('table:nth-of-type(2) tbody tr');
							document.querySelector('table:nth-of-type(2) tbody').insertBefore(tr,target);
			}
			else{
				alert('등록실패');
			}			
			//console.log(makeRow(result.retVal));
		})
	.catch(err => console.error(err))	
 }
 
 function makeRow(item){//tr생성
 	let tr = document.createElement('tr');//document영역에 tr요소를 만들어줌 = > <tr></tr>
 			tr.setAttribute('data-rno',item.replyNo);//<tr data-rno="item.replyNo"></tr>
 			//글번호,내용,작성자 ->반복,배열일경우 자바스크립트에 forof
 			//.연산자는 고정된 값만 들고옴
 			for(let prop of ['replyNo','reply','replyer']){
 				let td = document.createElement('td');//<td></td>
 				//item['replyNo']동적으로 값 할당가능,[]값을
 				td.innerHTML = item[prop]; //item['replyNo']=item.replyNo
 				tr.appendChild(td);//tr요소에td요소를자식으로붙임 => <tr><td>innerHTML</td></tr>			
 			}
 			//button생성.
 			let td = document.createElement('td');
 			let btn = document.createElement('button');//이벤트리스너,핸들링
 			//tr.remove
 			btn.addEventListener('click',deleteReplyFnc);//function외부에해도되고,안에해도됨,tr에직접remove가능하지만,외부에서는불가
 			
 			btn.innerHTML = '삭제';//라벨
 			btn.className = 'btn btn-danger';//자바스크립트에는 오브젝트.속성 => 복잡한페이지는다른방식으로만듦
 			td.appendChild(btn);
 			tr.appendChild(td);//앞 부모 뒤 자식 -부모자식관계만듦
 			return tr;//makeRow를 호출한 영역으로 tr 반환.
 }//end of makeRow
 
 


//시간빨리끝-먼저처리
//console.log(1);
//console.log(2);
//promise(비동기를 순차적으로보고싶을때)
//1.아무에러없이 정상적으로실행되었을때2.실패했을때 실행매개값,resolve변수 무슨함수일지는모르겠지만 매개값 변수명을 resolve로해둠 
//let promise = new Promise(function(resolve,reject){
	//setTimeout(function(){
	//	resolve("성공했을 때 실행할 함수");	
	//},1000);
	//reject("성공했을 때 실행할 함수");
//});

//promise.then(function(data){
	//console.log(data);
	//return new Promise(function(resolve,reject){
		//resolve("두번째 호출");
	//})
//})
//.then(function(result){
	//console.log(result);//promise아닐경우1
//})

//.cath(function(err){//실패했을때 출력되는 cath메소드에 정의된 함수에 정의된 거 출력,
	//console.log('=>',err);
//});//then정의된 함수에 전달됨,resolve 값->data넣겠다는의미