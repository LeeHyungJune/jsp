<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% request.setCharacterEncoding("utf-8");%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/whistle/resources/css/w3.css">
<link rel="stylesheet" type="text/css" href="/whistle/resources/css/base.css">
<script type="text/javascript" src="/whistle/resources/js/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		$('#obtn').click(function(){
			$(location).attr('href','/whistle/test/logout.pink');
		});
		
		$('#mbtn').click(function(){
			
			var txt1 = "12345";
			
			$.ajax({
				url: '/whistle/test/myInfo.pink',
				type: 'post',
				dataType: 'json',
				success: function(obj){			
					
					//	$(location).attr('href','/whistle/test/myInfo.pink');
					
					var mno = obj.mno;
					var name = obj.name;
					var id = obj.id;
					var mail = obj.mail;
					var tel = obj.tel;
					var sdate = obj.sdate;
					var gen = obj.gen;
					
					$('#brd').append(
						'<div id="wrapper" class="w3-content w3-center" style="width:720px;">'+
							'<header>'+
								'<h1 style="font-weight: 600;">회원정보</h1>'+
								'<p></p>'+
							'</header>'+
							'<div class="bdiv" id="div1" >'+
								'<aside>'+
									'<img src="/whistle/resources/img/pic/jennie.jpg" id="jennie" class="imgstyle">'+
								'</aside>'+
								'<section>'+
									'<p></p>'+
									'<article>'+
										'<dl>'+
											'<dt>회원번호</dt>'+
												'<dd>'+ mno +'</dd>'+
										'</dl>'+
										'<dl>'+
											'<dt>회원이름</dt>'+
												'<dd>'+ name +'</dd>'+
										'</dl>'+
										'<dl>'+
											'<dt>아이디</dt>'+
												'<dd>'+ id +'</dd>'+
										'</dl>'+
										'<dl>'+
											'<dt>메일</dt>'+
												'<dd>'+ mail +'</dd>'+
										'</dl>'+
										'<dl>'+
											'<dt>전화번호</dt>'+
												'<dd>'+tel+'</dd>'+
										'</dl>'+
										'<dl>'+
											'<dt>성	별</dt>'+
												'<dd>'+gen+'</dd>'+
										'</dl>'+
										'<dl>'+
											'<dt>가입일</dt>'+
												'<dd>'+sdate+'</dd>'+
										'</dl>'+
								'</article>'+
									'<p></p>'+
								'</section>'+
							'</div>'+
						'</div>'
					);
							
					$('#brd').removeClass('hidden');
					
				},
				error: function(request, status,error){
					alert("code = "+ request.status + " message = " + request.responseText + " error = " + error); // 실패 시 처리
			       }
			});
		});
		
		$('#lbtn').click(function(){
			$(location).attr('href','/whistle/test/myinfo.pink');
		});
	});
</script>
</head>
<body>
	<div class="w3-content w3-center mx650">
<c:if test="${not empty SID}">
	<h1 class="w3-red w3-padding w3-center">Hello ${SID}</h1>
	<div class="w3-col m2 w3-button w3-red" id="obtn">LogOut</div>
	<div class="w3-col m2 w3-button w3-green w3-right" id="mbtn">MyInfo</div>
</c:if>
<c:if test="empty SID">
	<h1 class="w3-blue w3-padding w3-center">Hello JSP</h1>
	<div class="w3-col m2 w3-button w3-pink" id="lbtn">Login</div>
</c:if>
	</div>
	<div class="w3-col hidden" id="brd">
	</div>
	
</body>
</html>