package com.findren.homepage.dao;

import java.util.List;

import com.findren.homepage.domain.NoticeBoard;

public interface NoticeDao {

	//게시판 글 수 
	public Integer getNoticeBoardCount();
	
	//리스트 페이징
	public List<NoticeBoard> getNoticeBoardList(int startRow, int PAGE_SIZE);
	
	//글 입력
	public void insertNoticeBoard(NoticeBoard nb);
	
	//조회수
	public void noticeWatchUpdate(int watch, int no);
	
	//글내용
	public NoticeBoard noticeContent(int no);
	
	//다음 글 번호
	public Integer noticeNextNo(int no);
	
	//이전글 번호
	public Integer noticePreNo(int no);
	
	//삭제
	public void noticeDelete(int no);
	
	//업데이트
	public void updateNoticeBoard(NoticeBoard nb);
	
	//게시글 최대 수
	public Integer maxNum();
}
