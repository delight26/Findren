package com.findren.homepage.dao;

import java.util.List;

import com.findren.homepage.domain.OnlineBoard;

public interface OnlineDao {

	//게시판 글 수 
	public Integer getOnlineBoardCount();
	
	//리스트 페이징
	public List<OnlineBoard> getOnlineBoardList(int startRow, int PAGE_SIZE);
	
	//글 입력
	public void insertOnlineBoard(OnlineBoard online);
	
	//조회수
	public void onlineWatchUpdate(int watch, int no);
	
	//글내용
	public OnlineBoard onlineContent(int no);
	
	//다음 글 번호
	public Integer onlineNextNo(int no);
	
	//이전글 번호
	public Integer onlinePreNo(int no);
	
	//삭제
	public void onlineDelete(int no);
	
	//업데이트
	public void updateOnlineBoard(OnlineBoard online);
	
	//게시글 최대 수
	public Integer maxNum();
}
