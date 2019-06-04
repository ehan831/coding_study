/**
 * 
 */

window.onload = function (){

	var price = new Array();
	var content = new Array();

	var td = document.getElementsByClassName('menu');

	for(var i=0; i<td.length; i++) {
		td[i].onclick = function () {
			// 전체 색상 초기화 - 흰색으로
			for(var j=0;j<td.length;j++) {
				td[j].style.backgroundColor='#ffffff';
			}
			this.style.backgroundColor = "#3d75ff"; // 선택한 상품 색 바꾸기
			content[0] = this.childNodes[0].nodeValue; // 아이템명
			content[1] = this.childNodes[2].nodeValue; // 가격
			// alert(this.childNodes[0].nodeValue);
			// this.childNodes[1].nodeValue +
			// this.childNodes[2].nodeValue); // 중간에 <br> 이 들어있어서 [1]의 값이 이에 대응
		}
	}
	var btn = document.getElementById('btn');
	btn.onclick = function() {
		for(var j=0;j<td.length;j++) {
			td[j].style.backgroundColor='#ffffff';
		}
		content[2] = document.getElementById('count').value; // 개수
		// alert(content[0] + content[1] + content[2]);
		price = parseInt(content[1]) * content[2];
		document.getElementById('total').value = price;
		var temp = content[0] + " / 가격:" + content[1] + " / 개수:" + content[2] + " / 총:" + price +"원 <br>";
		document.getElementById('content').innerHTML += temp;
		document.getElementById('count').value = '1';
	}
	//#### 1. TD에 이벤트 발생
	//#####  2. 확인 버튼 클릭시 선택한 TD의 색을 다시 흰색으로
	//#####  3. 값 계산하여 총합 구하기 - 각각 TD 클릭시 배열에 저장하였다가 계산
}