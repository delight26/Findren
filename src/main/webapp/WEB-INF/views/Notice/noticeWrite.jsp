<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
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
						//SmartEditor2Skin.html ������ �����ϴ� ���
						sSkinURI: "resources/editor/SmartEditor2Skin.html",	
						htParams : {
							// ���� ��� ���� (true:���/ false:������� ����)
							bUseToolbar : true,				
							// �Է�â ũ�� ������ ��� ���� (true:���/ false:������� ����)
							bUseVerticalResizer : true,		
							// ��� ��(Editor | HTML | TEXT) ��� ���� (true:���/ false:������� ����)
							bUseModeChanger : true,			
							fOnBeforeUnload : function(){
								
							}
						}, 
						fOnAppLoad : function(){
							//���� ����� ������ text ������ �����ͻ� �ѷ��ְ��� �Ҷ� ���
						},
						fCreator: "createSEditor2"
					});
					$("#savebutton").click(function(){
				        //id�� smarteditor�� textarea�� �����Ϳ��� ����
				        oEditors.getById["ir1"].exec("UPDATE_CONTENTS_FIELD", []);
				         
				        // �̺κп� ������ validation ����
				         
				        //�� submit
				        $("#frm").submit();
				    });
				});
</script>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
<form id="frm" action="noticeWriteResult" method="post" enctype="multipart/form-data">
	<table>
		<tr>
			<td>�ɼ�</td>
			<td><input type="checkbox" value="notice" name="type">����</td>
		</tr>
		<tr>
			<td>����</td>
			<td><input type="text" name="title"/></td>
		</tr>
   	<tr>
   	<td>����</td>
   	<td style="width:766px; height:412px;"><textarea name="content" id="ir1" rows="10" cols="100"></textarea></td>
		<tr>
			<td>��ũ 1</td>
			<td><input type="text" name="link1"/></td>
		</tr>
		<tr>
			<td>��ũ 2</td>
			<td><input type="text" name="link2"/></td>
		</tr>
		<tr>
			<td>���� 1</td>
			<td><input type="file" name="file1"/></td>
		</tr>
		<tr>
			<td>���� 2</td>
			<td><input type="file" name="file2"/></td>
		</tr>
	</table>
		<input type="button" id="savebutton" value="�ۼ��Ϸ�" />
		<input type="button" id="cancel" value="���" />
</form>
</body>
</html>