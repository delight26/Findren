/**
 * 
 */

//게시판 글쓰기
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

//보도자료 게시글 삭제 확인(newsList.jsp)
$(function(){
	$("#newsDelete").click(function(){
		var message = "선택한 게시물을 정말 삭제하시겠습니까?\n" 
				+"한번 삭제한 자료는 복구할 수 없습니다.";
		if(confirm(message) == true){
			$("#form1").attr({action:'newsDelete', method:'post'}).submit();
		}
	});	
});

//포트폴리오 게시글 삭제 확인(portfolioList.jsp)
$(function(){
	$("#portfolioDelete").click(function(){
		var message = "선택한 게시물을 정말 삭제하시겠습니까?\n" 
				+"한번 삭제한 자료는 복구할 수 없습니다.";
		if(confirm(message) == true){
			$("#form1").attr({action:'portfolioDelete', method:'post'}).submit();
		}
	});	
});

//프로모션 게시글 삭제 확인(promotionList.jsp)
$(function(){
	$("#promotionDelete").click(function(){
		var message = "선택한 게시물을 정말 삭제하시겠습니까?\n" 
				+"한번 삭제한 자료는 복구할 수 없습니다.";
		if(confirm(message) == true){
			$("#form1").attr({action:'promotionDelete', method:'post'}).submit();
		}
	});	
});

//온라인마케팅 게시글 삭제 확인(onlineList.jsp)
$(function(){
	$("#onlineDelete").click(function(){
		var message = "선택한 게시물을 정말 삭제하시겠습니까?\n" 
				+"한번 삭제한 자료는 복구할 수 없습니다.";
		if(confirm(message) == true){
			$("#form1").attr({action:'onlineDelete', method:'post'}).submit();
		}
	});	
});

//SNS 게시글 삭제 확인(snsList.jsp)
$(function(){
	$("#snsDelete").click(function(){
		var message = "선택한 게시물을 정말 삭제하시겠습니까?\n" 
				+"한번 삭제한 자료는 복구할 수 없습니다.";
		if(confirm(message) == true){
			$("#form1").attr({action:'snsDelete', method:'post'}).submit();
		}
	});	
});

//SEO 게시글 삭제 확인(seoDelete.jsp)
$(function(){
	$("#seoDelete").click(function(){
		var message = "선택한 게시물을 정말 삭제하시겠습니까?\n" 
				+"한번 삭제한 자료는 복구할 수 없습니다.";
		if(confirm(message) == true){
			$("#form1").attr({action:'seoDelete', method:'post'}).submit();
		}
	});	
});

//공중계정 게시글 삭제 확인(wechatidList.jsp)
$(function(){
	$("#wechatidDelete").click(function(){
		var message = "선택한 게시물을 정말 삭제하시겠습니까?\n" 
				+"한번 삭제한 자료는 복구할 수 없습니다.";
		if(confirm(message) == true){
			$("#form1").attr({action:'wechatidDelete', method:'post'}).submit();
		}
	});	
});

//위챗페이 게시글 삭제 확인(wechatpayList.jsp)
$(function(){
	$("#wechatpayDelete").click(function(){
		var message = "선택한 게시물을 정말 삭제하시겠습니까?\n" 
				+"한번 삭제한 자료는 복구할 수 없습니다.";
		if(confirm(message) == true){
			$("#form1").attr({action:'wechatpayDelete', method:'post'}).submit();
		}
	});	
});

//구인구직 게시글 삭제 확인(jobofferList.jsp)
$(function(){
	$("#jobofferDelete").click(function(){
		var message = "선택한 게시물을 정말 삭제하시겠습니까?\n" 
				+"한번 삭제한 자료는 복구할 수 없습니다.";
		if(confirm(message) == true){
			$("#form1").attr({action:'jobofferDelete', method:'post'}).submit();
		}
	});	
});

//헤드헌팅 게시글 삭제 확인(onlineList.jsp)
$(function(){
	$("#headhuntingDelete").click(function(){
		var message = "선택한 게시물을 정말 삭제하시겠습니까?\n" 
				+"한번 삭제한 자료는 복구할 수 없습니다.";
		if(confirm(message) == true){
			$("#form1").attr({action:'headhuntingDelete', method:'post'}).submit();
		}
	});	
});

//인력파견 게시글 삭제 확인(onlineList.jsp)
$(function(){
	$("#peopleDelete").click(function(){
		var message = "선택한 게시물을 정말 삭제하시겠습니까?\n" 
				+"한번 삭제한 자료는 복구할 수 없습니다.";
		if(confirm(message) == true){
			$("#form1").attr({action:'peopleDelete', method:'post'}).submit();
		}
	});	
});
