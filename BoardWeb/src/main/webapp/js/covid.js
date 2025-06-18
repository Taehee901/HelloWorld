/**
 * covid.js
 * 
*/

import { makeRow, url } from './covid_module.js';//참조파일,covid_modules의 makeRow,url만 받아서사용
//console.log("10분쉬었다하기.1");
//https보안강화프로토콜


//html순차적실행-jsp,id값가진요소읽어들이기전위치=null에러,module이상x
//document.querySelector('#centerList').innerHTML = "Hello";
//비동기 : 실행후->값추가
let centerAry;//전체센터정보

fetch(url)
	.then(data => data.json())
	.then(result => {
		//console.log(result.data);
		centerAry = result.data;//[{},{},{}....{}]
		//시도정보 배열.
		let sidoAry = [];
		//tr>td*2 ->id #centerList(tbody),innerHTML태그사이에 들어가면 <>innerHTML</>
		//filter는 어떤조건만족하는녀석만만듦
		centerAry.forEach((center, idx) => {//배열 메소드중,함수매개값 [].forEach(function(elem,idx,ary){   })
			//sidoAry에 중복하지 않고 담기
			if(sidoAry.indexOf(center.sido) == -1){//값x,배열에서 indexOf == includes 둘중아무거나해도됨
				sidoAry.push(center.sido);//추가.
			}
			if (idx < 10) {
				//tr 생성하기.
				//let tr = makeRow(center);
				let tr = makeRow(center);
				//console.log(center);
				document.querySelector('#centerList').appendChild(tr);
			}//end of if
		});//end of forEach
		//console.log(sidoAry);//중복제거값
		//sidoAry의 갯수만큼 <option value="sido정보">sido정보</option>
		sidoAry.forEach(sido => {//문자
			let opt = document.createElement('option');//option태그
			opt.value = sido;
			opt.innerText = sido;
			document.querySelector('#sido').appendChild(opt);
		})
	})
	.catch(err => console.log(err))

//btn event,filter메소드반환 ->배열->forEach가능
document.querySelector('button.btn-primary').addEventListener('click', function(e) {
	//목록지우고....
	document.querySelector('#centerList').innerHTML = "";//clear
	let keyword = document.getElementById('centerName').value;//검색값
	//화살표함수는 변수가 하나일 경우 
	centerAry//배열,필터메소드가반환 배열이라 foreach이용 기능구현가능
		.reduce((acc,center)=>{
			if(center.sido == keyword){
				let tr = makeRow(center);
				acc.appenChild(tr);
			}
			return acc;//다음값의 순번으로반환,return x undefined
		},document.querySelector('#centerList'));
		//.filter((center)=> center.centerName.indexOf(keyword) != -1)//문자열,sucearchname index값반환,f = -1,자체t or f
		//.filter((center) => center.centerName.includes(keyword))
		//console.log(filerAry);
		//메소드체인-끝나는영역에.forEach
	//.forEach(center => {
			//let tr = makeRow(center);
			//document.querySelector('#centerList').appendChild(tr);
		//})
});
//select태그의 change이벤트.
document.querySelector('#sido').addEventListener('change',function(e){
	document.querySelector('#centerList').innerHTML = "";//목록 지움
	let keyword = document.getElementById('sido').value;//검색값
	centerAry
	 .filter(center =>center.sido == keyword)
	 .forEach(center =>{
		let tr = makeRow(center);
		document.querySelector('#centerList').appendChild(tr);
	 })
	console.log(keyword);
});
//filter,function,foreach 매개값3ro
// [].push(),[].unshift(),[].pop(맨뒤),[].shift() => [].splice(),매가값으로 추가,수정,삭제 가능
// reduce();//매개값4,acc:이전순번반환해주는값의초기값으로쓰여짐.//다음순번을받는게누산기,이번순번의값이 다음순번의 값으로

//배열에서만 쓸수있는 메소드
let result = [1,3,5,7].reduce(function(acc,elem,idx,ary){
	console.log(acc,elem);//acc이전순번값,elem이번순번값
	if(elem>4){
		let li = document.createElement('li');
		li.innerHTML = elem;
		acc.appendChild(li);
		//acc.push(elem);
	}
	//return acc + elem; //1 다음번에 3의 acc값으로 쓰여짐
	//return acc < elem?elem:acc;//acc<elem 조건 t -> e
	//return acc;//4 이하 [],
	return acc;//<ul><li>5</li></ul> 
},document.querySelector('#target'));//초기값지정 ->1번째 위치(0),[]
//console.log('결과: ', result);//마지막순번반환값,+



