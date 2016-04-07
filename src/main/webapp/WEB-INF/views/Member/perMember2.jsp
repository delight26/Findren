<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
			<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<script type="text/javascript" src="http://www.google.com/recaptcha/api/js/recaptcha_ajax.js"></script>
<script>
$(function(){
     
    var siteKey = "6LdkmxwTAAAAAPALNWYHlctTEGXmdADPEhdUfDRZ";//Site key
    var div = "recaptcha";
    Recaptcha.create(siteKey, div, {theme: "red"});
         
    $("#recaptchaCheck").click(function(){
         
        var challenge = Recaptcha.get_challenge();
        var response = Recaptcha.get_response();
        var host = $(location).attr('host');
         
        $.ajax({
            type: "POST",
            url: "validateRecaptcha",
            async: false,
            data: {
                host: host,
                challenge: challenge,
                response: response
            },
            success: function(data) {
                if(data=="Y") {
                    $("#rechaptcha").val("Success!");
                    $("#recaptchaCheck").hide();
                }else{
                    $("#rechaptcha").val("Incorrect Recaptcha! Please try again!");
                    Recaptcha.reload();
                }
            }
        });
         
    });
    $("#submit").click(function(){
    	var rechaptcha = $("#rechaptcha").val();
    	var pass = $("#pass").val();
    	var passconfirm = $("#passconfirm").val();
    	if(rechaptcha == "Success!"){
    		if(pass == passconfirm){
    			$("#joinform").submit();
    		}else{
    			event.preventDefault();
    			alert("패스워드와 패스워드 확인이 같지 않습니다.");
    		}
    	}
    });
}); 
</script>
</head>
<body>
	<form action = "joinPer" method = "post" id="joinform">
	<table>
		<tr>
			<th>아이디</th>
			<td><input type = "text" name = "fhm_id" id="id" required/></td>
		</tr>
		<tr>
			<th>패스워드</th>
			<td><input type = "password" name = "fhm_pw" id="pass" required/></td>
		</tr>
		<tr>
			<th>패스워드 확인</th>
			<td><input type = "password" id="passconfirm" required/></td>
		</tr>
		<tr>
			<th>이름</th>
			<td><input type = "text" name = "fhm_name" id = name required/></td>
		</tr>
		<tr>
			<th>국적</th>
			<td>
				<input type = "radio" name = "fhm_per_nation" value="korea"/>한국
				<input type = "radio" name = "fhm_per_nation" value="china"/>중국
				<input type = "radio" name = "fhm_per_nation" value="etc"/>한국
			</td>
		</tr>
		<tr>
			<th>이메일</th>
			<td><input type = "email" name = "fhm_per_email" id="email" required/></td>
		</tr>
		<tr>
			<th>생년월일</th>
			<td><input type = "date" name = "fhm_per_birth"/></td>
		</tr>
		<tr>
			<th>성별</th>
			<td>
				<input type = "radio" name = "fhm_sex" value="man"/>남자
				<input type = "radio" name = "fhm_sex" value="woman"/>여자
			</td>
		</tr>
		<tr>
			<th>전화번호</th>
			<td><input type = "tel" name = "fhm_per_phone"/></td>
		</tr>
		<tr>
			<th>핸드폰번호</th>
			<td><input type = "tel" name = "fhm_per_cell" id="cell" required/></td>
		</tr>
		<tr>
			<td colspan="2">
				<div id="recaptcha">
				<div class="g-recaptcha" data-sitekey="6LdkmxwTAAAAAPALNWYHlctTEGXmdADPEhdUfDRZ"></div>
				</div>
				<input type = "text" id = "rechaptcha" readonly/>
				<input id="recaptchaCheck" type="button" value="Check">
			</td>
		</tr>
	</table>
	<input type="submit" value="회원가입" id="submit"/>
	<a href="javascript:history.back()">취소</a>
	</form>
</body>
</html>