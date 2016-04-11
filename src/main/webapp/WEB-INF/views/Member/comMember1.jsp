<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<script src="http://code.jquery.com/jquery-1.11.3.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	$("#submit").click(function() {
		var useagree = $('input:radio[name="use"]:checked').val();
		var identifyagree = $('input:radio[name="identifyuse"]:checked').val();

		if(useagree=="agree"&&identifyagree=="agree"){
			document.location.href = "comMember2";
		} else{
			alert("[회원가입 이용약관]에 동의를 하셔야 회원가입이 가능합니다.");
		}
	});
});
</script>
</head>
<body>
	<textarea rows="10" cols="150">${ cf.cf_sign }</textarea><br/>
	<input type="radio" name="use" value="agree" />동의합니다 
	<input type="radio" name="use" value="notagree" />동의하지 않습니다<br/>

	<textarea rows="10" cols="150">${ cf.cf_useidentify }</textarea><br/>
	<input type="radio" name="identifyuse" value="agree" />동의합니다
	<input type="radio" name="identifyuse" value="notagree" />동의하지 않습니다 <br />
	<a href="#"><input type="button" id="submit" value="가입하기"/></a>
	<a href="javascript:history.back()">취소</a>
