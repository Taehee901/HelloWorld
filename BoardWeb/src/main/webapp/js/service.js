/**
 * 
 * service.js
 * 
 */

//메소드정의-알고자하는파라미터전달

//svc겍체의 add메소드.
const svc ={//오브젝트안에소속,메소드
	add:function(num1=0,num2=0){// = replyList()
		return num1 + num2;
	},
		//replyList:function(bno){
	//목록출력메소드.
	replyList(param = {bno,page},successCallback,errorCallback){//파라미터 원본글정보 , 정상실행함수매개값으로전달,예외처리
		//ajax호출
		fetch('replyList.do?bno='+param.bno +'&page='+param.page)
			.then(data => data.json())//data매개변수이름.json()파싱
			.then(successCallback)//어떤값이 들어올지 모르나 들어오는함수로 전달받아서 반환
			.catch(errorCallback)
			console.log(bno,page);
		},
	//댓글삭제메소드
	removeReply(rno,successCallback,errorCallback){
		//ajax.
		fetch('removeReply.do?rno='+rno)
			.then(data => data.json())
			.then(successCallback)
			.catch(errorCallback)
		
	},
	//댓글등록메소드.,변수3개처리보다오브제트가나음,bno:bno,첫번째매개값은오브젝트타입으로들어와야함,ajax2
	addReply(param={bno,reply,replyer}, successCallback, errorCallback){
		//ajax.
		fetch('addReply.do',{
			method: 'post',
			headers:{'Content-Type':'application/x-www-form-urlencoded'},
			body: 'bno=' +param.bno+ '&reply=' +param.reply+ '&replyer=' +param.replyer
		})
			.then(data => data.json())
			.then(successCallback)
			.catch(errorCallback)
	},
	//댓글전체건수.
	replyCount(bno,successCallback,errorCallback){
		//ajax호출
		fetch('replyCount.do?bno='+bno)
		.then(data => data.json())
		.then(successCallback)
		.catch(errorCallback)
	}
	
}

//add함수.
const add = (num1 , num2) => {
	return num1 + num2;
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
 
 function deleteReplyFnc(){
	
 }