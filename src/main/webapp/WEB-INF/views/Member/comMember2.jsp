<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
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
    $('input[name="fhm_com_nation"]').change(function(){
    	var fhm_com_nation =  $(':radio[name="fhm_com_nation"]:checked').val();
    	if(fhm_com_nation == "china" || fhm_com_nation == "etc"){
    		$("#addrsearch").hide();
			$("#addrtext").show();    		
    	} else{
    		$("#addrsearch").show();
			$("#addrtext").hide();    		
    	}
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
    $.ajax({
        url: "comaddrsearch",
        type:"post",
        dataType: "text",
        success: function(responseData, statusText, xhr){
        	var result = responseData;
       	 $('#addrsearch').html(result);
        },
        error : function(xhr, statusText, responseData){
           alert("error : " + statusText + "." + xhr.status+ "/ " + xhr.responseText);
        },
     });
}); 
</script>
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
	<form action = "joinCom" method = "post" id="joinform" enctype="multipart/form-data">
	<table>
		<tr>
			<th>구분</th>
			<td>
				<input type="radio" name = fhm_com_part value="comnomal"/>일반기업
				<input type="radio" name = fhm_com_part value="comhead"/>헤드헌팅
				<input type="radio" name = fhm_com_part value="compeople"/>인력송출
			</td>
		</tr>
		<tr>
			<th>국적</th>
			<td>
				<input type = "radio" name = "fhm_com_nation" value="korea"/>한국
				<input type = "radio" name = "fhm_com_nation" value="china"/>중국
				<input type = "radio" name = "fhm_com_nation" value="etc"/>기타
			</td>
		</tr>
		<tr>
			<th>아이디</th>
			<td>
				<input type = "text" name = "fhm_id" id="id" required/>
			</td>
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
			<th>로고</th>
			<td><input type = "file" name = "fhm_com_logo" id = "logo"/></td>
		</tr>
		<tr>
			<th>인사담당자명</th>
			<td><input type = "text" name = "fhm_com_emp" id="emp" required/></td>
		</tr>
		<tr>
			<th>기업형태</th>
			<td>
				<select name="fhm_com_style">
				    <option value="comnomal">선택하세요</option>
				    <option value="enterprise">대기업 계열사, 자회사</option>
				    <option value="small">중소기업(300명 이하)</option>
				    <option value="midsize">중견기업(300명 이상)</option>
				    <option value="venture">벤처기업</option>
				    <option value="foreign-invested">외국 투자기업</option>
				    <option value="foreign-corporation">외국 법인기업</option>
				    <option value="public-agency">국내 공공기관, 공기업</option>
				    <option value="organizations">국내 비영리단체, 협회, 교육재단</option>
				    <option value="foreign-organizations">외국기관, 비영리기구, 단체</option>
				</select>
			</td>
		</tr>
		<tr>
			<th>설립연도</th>
			<td><input type = "date" name = "fhm_com_birth"/></td>
		</tr>
		<tr>
			<th>근로자 수</th>
			<td>
				<input type = "text" name = "fhm_com_person" />명
			</td>
		</tr>
		<tr>
			<th>업종</th>
			<td><input type = "text" name = "fhm_com_biz"/></td>
		</tr>
		<tr>
			<th>홈페이지</th>
			<td>http://<input type = "text" name = "fhm_com_homepage" /></td>
		</tr>
		<tr>
			<th>사업자등록번호</th>
			<td>
				<input type = "text" name = "fhm_com_no1" required/>-
				<input type = "text" name = "fhm_com_no2" required/>-
				<input type = "text" name = "fhm_com_no3" required/><br/>
				사업자등록번호 도용 피해 방지를 위해 기업인증을 시행하고 있습니다.<br/>
				NICE평가정보㈜에 등록되어 있지 않은 기업은<br/>
				사업자등록증 사본을 고객센터(Tel. 1588-9350)로 보내주시기 바랍니다.
			</td>
		</tr>
		<tr>
			<th>대표자명</th>
			<td><input type = "text" name = "fhm_com_ceo" /></td>
		</tr>
		<tr>
			<th>회사명</th>
			<td><input type = "text" name = "fhm_com_name" /></td>
		</tr>
		<tr>
			<th>전화번호</th>
			<td>
				<input type = "tel" name = "fhm_com_phone" />
				숫자만 입력해주세요.
			</td>
		</tr>
		<tr>
			<th>이메일</th>
			<td>
				E-mail 로 발송된 내용을 확인한 후 인증하셔야 회원가입이 완료됩니다.<br/>
				<input type = "email" name = "fhm_com_email" />
			</td>
		</tr>
		<tr>
			<th>주소</th>
			<td>
				<textarea rows="5" cols="100" style="display:none" name="fhm_com_addresstext" id="addrtext"></textarea>
				<div id="addrsearch">
				</div>
			</td>
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
		<tr></tr>
		<tr>
			<th>메일링 서비스</th>
			<td><input type="checkbox" name="fhm_mailing" value="Y"/>정보 메일을 받겠습니다.</td>
		</tr>
	</table>
	<input type="submit" value="회원가입" id="submit"/>
	<a href="javascript:history.back()">취소</a>
	</form>