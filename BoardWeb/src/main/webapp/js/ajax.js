/**
 * ajax.js
 * 한페이지에서서버로부터데이터를가져와서추가수정삭제기능을하려함
 * create,appenChild
 * 
 */

/*-----
console.log("start");
fetch('data/sample.json')
  .then(resolve => resolve.json())
  .then(data=> {
	console.log(data); // [{},{}...{}] 배열형태
	data.forEach(function(item,idx,arr){//for문을사용해도되지만
		
	});//함수를 매개값으로 받음,첫번째는 가져온요소,2번째는 index,3번째는배열의 값 그 자체
})
  .catch(err=> {
	console.log(err);
  })
*/

/*
	서버 프로그램(데이터요청->데이터전달)		 -  클라이언트프로그램(jsp 출력,링크누를때마다페이지이동)
	jsp,node,spring	
	req,setAttbute담아서 전송이었는데		
	json 포맷(문자열을파싱 후 여러 dom요소를 페이지보여주는방식으로?)		ajax 기능출력
 */

//frontcontroll=서블릿,-jsp파일로 화면출력방식(6/12기준)
//json을 문자열을 자바스크립트의 객체타입으로 바꿔주는작업 
//fetch()=>
	
/*
확장가능한 마크업랭귀지,태그가지고 담아두기위해만든거,xml
비동기화,자바는 순차적으로 위->아래진행
	ajax.js
	Asynchronous Javascript And Xml
	
	비동기 vs 동기 방식
window객체가 가지고 있는 setTimeout()대표 비동기
두번째는 지연시간,1000ms
*/	
//웹->서버네트워크->요청들어가고->처리결과웹브라우저전달 시간갭이생김
//비동기방식
//자바스크립트는 작업q 저장 처리된값받아옴
//1초정도 작업이걸림,제일큰시간이되면작업이끝남,작업을동시에실행,()작업끝나는거기다리지않고 다른 작업을 중단하지 않아 시간적이점o,처리선후다르기에 고민필요
//2000..1000..1500 ->시간짧은게 먼저출력,코드순서와상관x 작업걸리는시간따라나오는게다름,명시적으로지정해둬서알지만..(아래코드)
/*setTimeout(function(){
	console.log("1");
},1000);

setTimeout(function(){
	console.log("2");
},2000);

//2.5
setTimeout(function(){
	console.log("Start");
},2500);*/


// {"id":1,"first_name":"Hong"} =>json 객체(문자열인데 {})
//key:value,객체가문자열
//->자바스크립트 객체로바꾸는작업 =(파싱:해석,변환): {id: 1, first_name:"Hong"} =>javascript객체

//객체. XMLHttpRequest -- 서버에페이지 요청
//출력요청시작
//console.log("start");//동기함수 1.
let xhtp = new XMLHttpRequest();//객체선언,속성o필드 기능o 메소드(jsp),비동기처리객체,2.
xhtp.open('get','replyList.do?bno=213');//요청할 페이지를 지정.,json'data/sample.json'만요청받는게아니라 다른것들도가눙.boardList.do
xhtp.send();//실제 페이지 요청을 시작. 서버로부터 경로에있는 데이터를 요청시킴
//xhtp.onload = memberList;
xhtp.onload = function(){
	
	console.log(xhtp.responseText);
	let data = JSON.parse(xhtp.responseText);//배열//responseText,url값을 가지고와서json문자열->자바스크립트 jsp객체로파싱
	//웹-결과빠리처리,캐쉬에이전페이지정보담아요청오면일단그냥보여줌,바뀌기전이나오는이유,강력새로고침.
	console.log(data);
	data.forEach(function(item){
		//console.log(item);tr인 이유 변수사용하려고아래
		let tr = makeRow(item);
		//nth-of-type,몇번째요소를가리킬때
		
		//tr을 tbody에 추가(2),실제화면에다요소생성하는코드
		document.querySelector('table:nth-of-type(2) tbody').appendChild(tr);
	});
	//document.querySelector('#show').innerHTML = xhtp.responseText;
};

//등록이벤트
document.querySelector('#addReply').addEventListener('click',addReplyFnc);

//댓글 등록 함수 $적용jspx
function addReplyFnc(e){
	const bno = document.querySelector('#bno').value;//input,value값,html면innerhtml
	const reply = document.querySelector('#reply').value; //HTML 입력 요소의 값을 읽을때
	//필수값입력.공백값은 f
	if(!bno || !reply || !logId){
		alert('필수값 입력!');
		return;//아랫코드실행x
	}
	const addAjax = new XMLHttpRequest();//=fetch 비동기처리해주는거 같음,간편.프라미스??를가지고처리
	addAjax.open('get','addReply.do?bno='+bno+'&reply='+reply+'&replyer='+logId);
	addAjax.send();
	addAjax.onload = function(ev){
		console.log(addAjax);
		let result = JSON.parse(addAjax.responseText);//비동기방식으로처리 ajax.parse-> json문자열 ->javascript,responseText처리값을담아줌,파싱대상을잘파악필요
		console.log(result);
		if(result.retCode == 'Success'){
			alert('등록성공');
			let tr = makeRow(result.retVal);//rvo
			console.log(tr);
			//appendChild->제일마지막위치에다가붙여줌(등록기준)
			//역순
			//부모요소.insertBefore(새요소,대상)->대상앞에 새요소넣어줌,querySelector선택자여러개있어도 첫번째거가져옴
			let target = document.querySelector('table:nth-of-type(2) tbody tr');
			//insertBefore 부모요소 안에서 새로운 요소를 대상의 바로 앞에 새로 추가(설명을잘못하겠다..)
			document.querySelector('table:nth-of-type(2) tbody').insertBefore(tr,target);//rvo를 
			//document.querySelector('table:nth-of-type(2) tbody').appendChild(tr);
		}
		else{
			alert('등록실패');
		}
	}
}
//xml이용
//댓글삭제 함수.e 이벤트핸들러는이벤트가매개값으로전달(이벤트발생하면실행할함수)
function deleteReplyFnc(e){
	//prompt 사용자값입력,confirm 확인 t
	if(!confirm("삭제하시겠습니까?")){
		return;
	}
	console.log(e);
	//상위-상위-자식요소->tr속성에어튜르뷰트활용값담아서잉용(dataset어튜류뷰트에저장할때화면의요소들은 dataset정보담아서,실제현재요소의dataset값중 rno를반환)
	//댓글번호파라미터전달,ajax호출xdb삭제x
	let rno = e.target.parentElement.parentElement.dataset.rno;//tr -rno
	console.log(rno);
	const delAjax = new XMLHttpRequest();
	delAjax.open('get','removeReply.do?rno='+rno);//페이지지정(요청)
	delAjax.send();//실서버에데이터요청,result.retCode
	delAjax.onload = function(ev){//function e아닌 중복된변수이름이라 onload쪽을인식 에러발생
		let result = JSON.parse(delAjax.responseText);//처리결과담김,succes..json문자열
		if(result.retCode == 'Success'){
			e.target.parentElement.parentElement.remove();//화면처리.			
		}else{
			alert('처리실패');
		}
		
	};//처리데이터불러왔을때,on속성은 이벤트관련속성 - function이용시 이벤트핸들러
}//end of deleteReplyFnc.

//댓글을 화면에출력하는
//댓글을 row생성.,item이름바뀌면 item부분변경
function makeRow(item){
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




//목록
function memberList(){//3,//함수,이름x 익명함수function()
	//console.log("1");
	//console.log(xhtp.responseText);//xthp에들어갈속성출력,responseText(json문자열출력),parsing
	let data = JSON.parse(xhtp.responseText);//문자열을 JavaScript 객체로 변환 parse
	//console.log(data);//결과 = 배열
	
	let str = "<ul>";
	data.forEach(function(item,idx,arr){
		console.log(item);//한건한건에대한 정보,배열이어떤값을가져오는지에따라매번값다름
		str += "<li>"+item.id+","+item.first_name+"</li>";
	});//함수매개값
	str += "</ul>";
	//document.querySelector('#show').innerHTML = str;//str속성 dom
	document.querySelector('#show').innerHTML = str;
	
	
	//자바스크립트{}=오브젝트
	//response,responsetext=서버로부터가지고온데이터가o
 //자바스크립트에서 on 속성 => 이벤트와 관련,서버페이지요청하고 받아오면 발생하는 이벤트, 함수요청하면 이게 이벤트핸들러
}
//출력요청끝,작업끝날대까지기다리지x 그다음코드를진행시킴= 비동기방식으로처리
console.log("end");   //2

//ajax 핸들러,같은페이지삭제

//1끝나야 다음번호가 2번이 실행 =>동기 방식
//작업끝나는거기다려야함.(1번끝-2번)
/*console.log("1");
console.log("2");
console.log("Start");	
	
//1초 뒤 2번째 작업진행 기다려야함 순서대로진행 작업오래걸림-5.5s작업시간걸림 - 동기방식
setTimeout(function(){
	console.log("1");
	setTimeout(function(){
		console.log("2");
	setTimeout(function(){
		console.log("Start");
	},2500);
	},2000);
},1000);*/


	
/*console.log("start");
fetch('data/sample.json')
  .then(resolve => resolve.json())
  .then(data=> {
	console.log(data); // [{},{}...{}] 배열형태
	data.forEach(function(item,idx,arr){//for문을사용해도되지만
		
	});//함수를 매개값으로 받음,첫번째는 가져온요소,2번째는 index,3번째는배열의 값 그 자체
})
  .catch(err=> {
	console.log(err);
  })*/
