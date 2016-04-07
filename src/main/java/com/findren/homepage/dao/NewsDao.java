package com.findren.homepage.dao;

import java.util.List;

import com.findren.homepage.domain.NewsBoard;

public interface NewsDao {

	//게시판 글 수 
	public Integer getNewsBoardCount();
	
	//리스트 페이징
	public List<NewsBoard> getNewsBoardList(int startRow, int PAGE_SIZE);
	
	//글 입력
	public void insertNewsBoard(NewsBoard nb);
	
	//조회수
	public void newsWatchUpdate(int watch, int no);
	
	//글내용
	public NewsBoard newsContent(int no);
	
	//다음 글 번호
	public Integer newsNextNo(int no);
	
	//이전글 번호
	public Integer newsPreNo(int no);
	
	//삭제
	public void newsDelete(int no);
	
	//업데이트
	public void updateNewsBoard(NewsBoard nb);
	
	//게시글 최대 수
	public Integer maxNum();
}
