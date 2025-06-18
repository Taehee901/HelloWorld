/**
 * covid.js
 * 
*/

import { makeRow,url } from './covid_module.js';//참조파일,covid_modules의 makeRow,url만 받아서사용
//console.log("10분쉬었다하기.1");
//https보안강화프로토콜
		

//html순차적실행-jsp,id값가진요소읽어들이기전위치=null에러,module이상x
//document.querySelector('#centerList').innerHTML = "Hello";
	//비동기 : 실행후->값추가
	let centerAry;//전체센터정보
	
	fetch(url)
		.then(data => data.json())
		.then(result =>{
			//console.log(result.data);
			centerAry = result.data;//[{},{},{}....{}]
			//tr>td*2 ->id #centerList(tbody),innerHTML태그사이에 들어가면 <>innerHTML</>
			//filter는 어떤조건만족하는녀석만만듦
			centerAry.forEach((center,idx) => {//배열 메소드중,함수매개값 [].forEach(function(elem,idx,ary){   })
				if(idx < 10){
					//tr 생성하기.
					//let tr = makeRow(center);
					let tr = makeRow(center);
					document.querySelector('#centerList').appendChild(tr);
				}//end of if
				
			});//end of forEach

		})
		.catch(err => console.log(err))
		
//btn event,filter메소드반환 ->배열->forEach가능
document.querySelector('button.btn-primary').addEventListener('click',function(e){
	//목록지우고....
	document.querySelector('#centerList').innerHTML = "";//clear
	let keyword = document.getElementById('centerName').value;//검색값
	let filerAry =  centerAry.filter((center)=>{
		if(center.centerName.indexOf(keyword) != -1){//문자열,sucearchname index값반환,f = -1
			return true;
		}
		return false;
	});
	console.log(filerAry);
	filerAry.forEach(center =>{
		let tr = makeRow(center);
		document.querySelector('#centerList').appendChild(tr);
	})
})
