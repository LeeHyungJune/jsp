$(document).ready(function(){
	/*
	$('#jbtn').click(function(){
		$(location).attr('href','/whistle/member/join.blp');
	});
	
	$('#lbtn').click(function(){
		$(location).attr('href','/whistle/member/login.blp');
	});
	
	$('#obtn').click(function(){
		$(location).attr('href','/whistle/member/logOut.blp');
	});
	
	$('#hbtn').click(function(){
		$(location).attr('href','/whistle/');
	});
	*/
	
	$('.menubtn').click(function(){
		var bid = $(this).attr('id');
		
		var addr = '/whistle/';
		
		switch(bid) {
			case 'hbtn':
			//	기본 주소를 사용
			break;
			case 'lbtn':
			addr = '/whistle/member/login.blp';
			break;
			case 'jbtn':
			addr = '/whistle/member/join.blp';
			break;
			case 'obtn':
			addr = '/whistle/member/logOut.blp';
			break;
			case 'wbtn':
			$('#frm').attr('action','/whistle/reboard/reboardWrite.blp');
			$('#frm').submit();
			return;
		}
		
		$(location).attr('href', addr);
	});
	
	$('.pbtn').click(function(){
		//	페이지 번호 읽기
		var pno = $(this).attr('id');
		
		//	페이지 번호 세팅
		$('#nowPage').val(pno);
		
		//	폼 태그 전송
		$('#frm').submit();
		
	});
	
	$('#listbtn').click(function(){
		//	form 태그의 액션 속성값 변경
		$('#frm').attr('action','/whistle/reboard/reboardList.blp');
		//	사용하지 않는 태그 비활성화
		$('#mno').prop('disabled', true);
		$('#body').prop('disabled', true);
		$('frm').submit();
	});
	
	$('#rbtn').click(function(){
		document.frm.reset();
	});
	/*	글쓰기	*/
	$('#wpbtn').click(function(){
		//	입력된 글 유효성 검사
		var txt = $('#body').val();
		
		txt = txt.trim();
		if(!txt || txt.length == 0) {
			$('#body').val('');
			$('#body').focus();
			return;
		}
		
		$('#body').val(txt);
		
		$('#frm').submit();
	});
	
	$('.w3-button.w70').click(function(){
		//	어떤 버튼이 클릭이 되었는지 알아내고
		var btxt = $(this).html();
		/*
		if(btxt.eqauls('댓글')) {
			
		}
		*/
		//	글번호 읽어오기
		var sno = $(this).parent().attr('id');
		
		if(btxt == '댓글') {
			
			$('#bno').val(sno);
			
			$('#frm').attr('action','/whistle/reboard/reboardComment.blp');
			
			$('#frm').submit();
		}
	});
	
	
});