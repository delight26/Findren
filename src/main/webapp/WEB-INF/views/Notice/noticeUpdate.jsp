<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript" src="resources/editor/js/HuskyEZCreator.js" charset="utf-8"></script>
<script type="text/javascript" src="//cdnjs.cloudflare.com/ajax/libs/jquery/1.9.0/jquery.js"></script>
<script type="text/javascript">
var oEditors = [];
$(function(){
					nhn.husky.EZCreator.createInIFrame({
						oAppRef: oEditors,
						elPlaceHolder: "ir1",
						//SmartEditor2Skin.html 파일이 존재하는 경로
						sSkinURI: "resources/editor/SmartEditor2Skin.html",	
						htParams : {
							// 툴바 사용 여부 (true:사용/ false:사용하지 않음)
							bUseToolbar : true,				
							// 입력창 크기 조절바 사용 여부 (true:사용/ false:사용하지 않음)
							bUseVerticalResizer : true,		
							// 모드 탭(Editor | HTML | TEXT) 사용 여부 (true:사용/ false:사용하지 않음)
							bUseModeChanger : true,			
							fOnBeforeUnload : function(){
								
							}
						}, 
						fOnAppLoad : function(){
							//기존 저장된 내용의 text 내용을 에디터상에 뿌려주고자 할때 사용
						},
						fCreator: "createSEditor2"
					});
					$("#savebutton").click(function(){
				        //id가 smarteditor인 textarea에 에디터에서 대입
				        oEditors.getById["ir1"].exec("UPDATE_CONTENTS_FIELD", []);
				         
				        // 이부분에 에디터 validation 검증
				         
				        //폼 submit
				        $("#frm").submit();
				    });
				});
</script>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
<form id="frm" action="noticeUpdateResult" method="post" enctype="multipart/form-data">
	<table>
		<tr>
			<td>옵션</td>
			<td>
				<input type="checkbox" value="notice" name="type"/>공지
				<input type="hidden" value="${ nb.notice_No }"  name="no"/>
			</td>
		</tr>
		<tr>
			<td>제목</td>
			<td><input type="text" name="title" value="${ nb.notice_Title }"/></td>
		</tr>
   	<tr>
   	<td>내용</td>
   	<td style="width:766px; height:412px;"><textarea name="content" id="ir1" rows="10" cols="100">${ nb.notice_Content }</textarea></td>
		<tr>
			<td>링크 1</td>
			<td><input type="text" name="link1" value="${ nb.notice_Link1 }"/></td>
		</tr>
		<tr>
			<td>링크 2</td>
			<td><input type="text" name="link2"/>${ nb.notice_Link2 }</td>
		</tr>
		<tr>
			<td>파일 1</td>
			<td><input type="file" name="file1"/></td>
		</tr>
		<tr>
			<td>파일 2</td>
			<td><input type="file" name="file2"/></td>
		</tr>
	</table>
		<input type="button" id="savebutton" value="작성완료" />
		<input type="button" id="cancel" value="취소" />
</form>
</body>
</html>