package com.findren.homepage.dao;

import java.util.List;

import com.findren.homepage.domain.NoticeBoard;

public interface NoticeDao {

	public Integer getNoticeBoardCount();
	
	public List<NoticeBoard> getNoticeBoardList(int startRow, int PAGE_SIZE);
	
	public void insertNoticeBoard(NoticeBoard nb);
	
	public void noticeWatchUpdate(int watch, int no);
	
	public NoticeBoard noticeContent(int no);
	
	public Integer noticeNextNo(int no);
	
	public Integer noticePreNo(int no);
}
