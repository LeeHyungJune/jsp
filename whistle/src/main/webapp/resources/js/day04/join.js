//	join 버튼 클릭이벤트
document.getElementById('jbtn').onclick = function() {
	/*
	//	데이터 입력 체크
	var sname = document.getElementById('name').value;
	if(!sname) {
		document.getElementById('name').focus();
		return;
	}
	var sid = document.getElementById('id').value;
	if(!sid) {
		document.getElementById('id').focus();
		return;
	}
	var spw = document.getElementById('pw').value;
	if(!spw) {
		document.getElementById('pw').focus();
		return;
	}
	*/
	var el = document.getElementsByClassName('ck');
	for(var i = 0 ; i < el.length ; i++) {
		var tmp = el[i].value;
		if(!tmp){
			el[i].focus();
			return;
		}
	}
	
	document.getElementById('frm').submit();
	
}

//	reset 버튼 이벤트 처리
document.getElementById('rbtn').onclick = function() {
	//	document.getElementById('frm').reset();
	var sid = document.frm.id.value;
	alert(sid);
	document.frm.reset();
}

//	home 버튼 이벤트 처리
document.getElementById('hbtn').onclick = function() {
	location.href="/black/index.html";
}

/*
	M	-	MongoDB
	E	-	Express
	A	-	AngularJS
	N	-	Node.js
*/