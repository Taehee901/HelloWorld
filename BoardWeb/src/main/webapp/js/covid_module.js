/**
 * covid_module.js
 */
//const defaultNum = 10;
let url = `https://api.odcloud.kr/api/15077586/v1/centers?page=1&perPage=284&serviceKey=tdv9loTfi9mJTgAVjgLhSIG8X5xbvFFBiZ0pd9tg%2FuSvquFV8uJoyMVoEW0VmVywHcE0siasNNjwWl0YZOKz4g%3D%3D`;
function makeRow(center) {
	let tr = document.createElement('tr');
	tr.addEventListener('click', function(e) {
		window.open('map.jsp?lat=' + center.lat + '&lng=' + center.lng +'&name='+center.centerName);//호출페이지
	});

	for (const prop of ['id', 'centerName', 'phoneNumber']) {//배열
		let td = document.createElement('td');//<td></td>
		td.innerHTML = center[prop];//<td>1</td> //center['id']
		tr.appendChild(td);
	}
	return tr;
}
//내보내기하고싶은기능들만선택적으로defaultNum,외부로출력defaultNum,
export { makeRow, url }