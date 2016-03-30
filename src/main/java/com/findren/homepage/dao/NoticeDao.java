package com.findren.homepage.dao;

import java.util.List;

import com.findren.homepage.domain.NoticeBoard;

public interface NoticeDao {

	public Integer getNoticeBoardCount();
	
	public List<NoticeBoard> getNoticeBoardList(int startRow, int PAGE_SIZE);
}
