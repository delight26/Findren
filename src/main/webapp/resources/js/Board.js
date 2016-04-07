/**
 * 
 */

//공지사항 게시글 삭제 확인(noticeList.jsp)
$(function(){
	$("#noticeDelete").click(function(){
		var message = "선택한 게시물을 정말 삭제하시겠습니까?\n" 
				+"한번 삭제한 자료는 복구할 수 없습니다.";
		if(confirm(message) == true){
			$("#form1").attr({action:'noticeDelete', method:'post'}).submit();
		}
	});	
});

//공지사항 게시판 글쓰기
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

//보도자 게시글 삭제 확인(noticeList.jsp)
$(function(){
	$("#newsDelete").click(function(){
		var message = "선택한 게시물을 정말 삭제하시겠습니까?\n" 
				+"한번 삭제한 자료는 복구할 수 없습니다.";
		if(confirm(message) == true){
			$("#form1").attr({action:'newsDelete', method:'post'}).submit();
		}
	});	
});

