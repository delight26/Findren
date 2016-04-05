/**
 * 
 */

//게시글 삭제 확인(noticeList.jsp)
$(function(){
	$("#noticeDelete").click(function(){
		var message = "선택한 게시물을 정말 삭제하시겠습니까?\n" 
				+"한번 삭제한 자료는 복구할 수 없습니다.";
		if(confirm(message) == true){
			$("#form1").attr({action:'noticeDelete', method:'post'}).submit();
		}
	});	
});