<%@ page language="java" contentType="text/html; charset=UTF-8" 	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<title>중국인찾기 메인페이지</title>
<link href="resources/css/bootstrap.min.css" rel="stylesheet">
<link href="resources/css/modern-business.css" rel="stylesheet">
<link href="resources/css/main.css" rel="stylesheet">
<link href="resources/css/board.css" rel="stylesheet">
</head>
<body>
	<div class="findren home">
		
		<%@ include file = "/WEB-INF/views/Main/mianNav.jsp" %>
		
			<div class="findren mainbody">
				<jsp:include page="/WEB-INF/views/${content }.jsp"></jsp:include>
			</div>
		
		<div class="clear"></div>
		<%@ include file = "/WEB-INF/views/Main/mainFooter.jsp" %>
		
	</div>
	

<!-- jQuery -->
<script src="https://code.jquery.com/jquery-1.12.3.js"></script>
<script src="https://code.jquery.com/jquery-1.12.3.min.js"></script>
<script src="https://code.jquery.com/jquery-2.2.3.js"></script>
<script src="https://code.jquery.com/jquery-2.2.3.min.js"></script>
<script type="text/javascript" src="resources/js/Board.js"></script>

<!-- Bootstrap Core JavaScript -->
<script src="resources/js/bootstrap.min.js"></script>

    
</body>
</html>

