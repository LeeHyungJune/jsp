//	join.html 에서 전송한 데이터를
//	페이지에 h1 태그로 추가해서 보여주세요

var param = location.search.substring(1);
/*
	param : 'id=jennie&pw=j12345&name=제니'
	
	==>	문자열 배열로 변환
	arr: ['id=jennie', 'pw=j12345', 'name=제니']
	
	==>	
	tmp : ['id', 'jennie'], ['pw', 'j12345'], ['name', '제니']
*/
//	한글 깨짐 처리
param = decodeURIComponent(param);

var arr1= param.split('&');
	
	var data = {}; // 연관배열
	var key = [];
	
	for(var i = 0 ; i < arr1.length ; i++ ){
		// a=1
		var tmp = arr1[i].split('=');
//		alert(tmp);
		// 키값과 데이터가 분리되었으니 쌍으로 data에 채워준다.
		key[i] = tmp[0];
		
		data[tmp[0]] = tmp[1];
	}
	
	for(var i = 0 ; i < arr1.length ; i++ ){
		document.write('<h1 class="w3-blue w3-center w3-padding">' + key[i] + data[key[i]] + '</h1>'); 
	}
