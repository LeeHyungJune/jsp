/*
var pat1 = /^[a-z]{5}/i;

var str = 'Black pink';

var result = pat1.test(str);
var result2 = pat1.exec(str);


console.log('result: '+result);
console.log('result2: '+result2);
*/

//	아이디를 입력받아서 
//	아이디가 영문자로 8글자 이내이면
//	콘솔 화면에 출력하고
//	형식에 맞지 않으면 입력된 내용을
//	지우고 '형식에 맞지않은 아이디' 를
//	출력하시오.


//	리셋버튼 클릭이벤트
document.getElementById('rbtn').onclick = function() {
//	document.getElementById('tid').value = '';
	var sid = document.getElementById('tid').value;
	if(sid) {
		//	변수에 데이터가 채워져 있는 경우 (null 또는 undefined 가 아닌 상태)
		document.getElementById('tpw').focus();
	} else{
		//	sid에 데이터가 채워져 있지 않은 경우(numm 또는 undefined 인 경우)
		document.getElementById('tid').focus();
	}
};

/*
//	로그인버튼 클릭이벤트
document.getElementById('lbtn').onclick = function() {
	var sid = document.getElementById('tid').value;
	var pat = new RegExp('^[a-z]{4,8}$');
	
	var result = pat.test(sid);
	
	if(result == true) {
		console.log('입력된 아이디: '+sid);
	} else {
		document.getElementById('tid').value = '';
		alert('형식에 맞지 않은 아이디입니다.');
	};
}
*/

/*
	로그인 버튼을 클릭하면 아이디와 비밀번호를 읽어서
	유효성 검사를 하고
	검사에 통과하면 test.html 로 아이디와 비밀번호를 전달하시오
	통과하지 않은 경우 입력 내용을 모두 지우고 다시 입력하도록 하시오
	
	비밀번호는 첫문자는 알파벳이어야하고
	숫자와 알파벳으로 구성된 4글자 이상 8글자 이하로 입력해야 한다.
*/

document.getElementById('lbtn').onclick = function() {
	var sid = document.getElementById('tid').value;
	var spw = document.getElementById('tpw').value;
	
	var idPat = /^[e-zA-Z]{4,8}$/;
	var pwPat = /^[e-zA-Z]e-zA-Z0-9]{3,7}$/;
	
	var iresult = idPat.test(sid);
	var presult = pwPat.test(spw);
	
	if(iresult == true && presult == true) {
		// location.href= 'test.html?id=' + sid + '&pw=' + spw;
		
		//	데이터 전송용 form 태그의 input 태그에 읽은 데이터를 입력해서 전송하시오
		document.getElementById('id').value = sid;
		document.getElementById('pw').value = spw;
		
		document.getElementById('frm').submit();
		
	} else {
		document.getElementById('tid').value = '';
		document.getElementById('tpw').value = '';
		alert('입력 오류입니다.');
	};
}
