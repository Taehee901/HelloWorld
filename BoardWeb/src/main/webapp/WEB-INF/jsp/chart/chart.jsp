<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <script type="text/javascript">
      google.charts.load('current', {'packages':['corechart']});
      google.charts.setOnLoadCallback(drawChart);//함수매개값

      function drawChart() {
		//ajax호출,서버로부터데이터들고와서,then안에넣어야함,비동기방식->동기,async await
		fetch('chart.do')
		.then(data => data.json())
		.then(result => {//json를 데이터찍음->배열,object
			console.log(result); //[{},{}....{}]
			let dataAry = [];//[[],[]]
			dataAry.push(['작성자','작성건수']);
			result.forEach(function(item){
				dataAry.push([item.memberName,item.cnt]);
			})
			console.log(dataAry);
	    	//chart.data,배열안에배열
	    	//실제 페이지 출력
	        var data = google.visualization.arrayToDataTable(dataAry);
	    	//차트제목
	        var options = {
	          title: '사용자별 게시건수'
	        };
			//getElementById=id값요소를가져옴,queryselecter('#piechart')
	        var chart = new google.visualization.PieChart(document.getElementById('piechart'));
	        chart.draw(data, options);
		})
		.catch(err => console.log(err));

      }
    </script>
  </head>
  <body>
  <!-- chatr그려지는영역 -->
    <div id="piechart" style="width: 900px; height: 500px;"></div>
  </body>
</html>
