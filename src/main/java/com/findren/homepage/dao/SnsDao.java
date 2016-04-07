package com.findren.homepage.dao;

import java.util.List;

import com.findren.homepage.domain.SnsBoard;

public interface SnsDao {

	//게시판 글 수 
	public Integer getSnsBoardCount();
	
	//리스트 페이징
	public List<SnsBoard> getSnsBoardList(int startRow, int PAGE_SIZE);
	
	//글 입력
	public void insertSnsBoard(SnsBoard nb);
	
	//조회수
	public void snsWatchUpdate(int watch, int no);
	
	//글내용
	public SnsBoard snsContent(int no);
	
	//다음 글 번호
	public Integer snsNextNo(int no);
	
	//이전글 번호
	public Integer snsPreNo(int no);
	
	//삭제
	public void snsDelete(int no);
	
	//업데이트
	public void updateSnsBoard(SnsBoard nb);
	
	//게시글 최대 수
	public Integer maxNum();
}
