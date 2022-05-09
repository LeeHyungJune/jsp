<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/whistle/resources/css/w3.css">
<link rel="stylesheet" type="text/css" href="/whistle/resources/css/base.css?after">
</head>
<body>
<!--  -->
<%
	String[] color = new String[]{
			"w3-pink","w3-purple","w3-deep-purple","w3-indigo",
			"w3-blue","w3-aqua","w3-teal","w3-green"			
	};

%>
	<div class="w3-content mx650 w3-center">
		<h1 class="w3-pink w3-padding">구구단</h1>
		
		<div class="w3-col w3-padding w3-margin-top">
			<!--
			 	스크립트 릿 방식을 이용해서 구구단을 작성 
			-->
			<%
				for(int i = 0 ; i < 8 ; i++) {
			%>	
				<div class="w3-col w3-col box w3-margin-top w135 ml10 w3-card-4">
					<h2 class="w3-col box w135 <%=color[i]%>" style="margin: 0px;"><%=i+2 %>단</h2>
					<div class="w3-col w3-border w135" >
			<%
					for(int j = 0 ; j < 9 ; j++) {
			%>
						<h4 class="w3-col"><%=i+2 %> x <%=j+1 %> = <%=(i+2)*(j+1) %></h4>
			<%
					}
			%>
					</div>
				</div>
			<%
				}
			%>		
		</div>
	</div>
</body>
</html>