package com.findren.homepage.dao;

import java.util.List;

import com.findren.homepage.domain.HeadhuntingBoard;

public interface HeadhuntingDao {

	//게시판 글 수 
	public Integer getHeadhuntingBoardCount();
	
	//리스트 페이징
	public List<HeadhuntingBoard> getHeadhuntingBoardList(int startRow, int PAGE_SIZE);
	
	//글 입력
	public void insertHeadhuntingBoard(HeadhuntingBoard nb);
	
	//조회수
	public void headhuntingWatchUpdate(int watch, int no);
	
	//글내용
	public HeadhuntingBoard headhuntingContent(int no);
	
	//다음 글 번호
	public Integer headhuntingNextNo(int no);
	
	//이전글 번호
	public Integer headhuntingPreNo(int no);
	
	//삭제
	public void headhuntingDelete(int no);
	
	//업데이트
	public void updateHeadhuntingBoard(HeadhuntingBoard nb);
	
	//게시글 최대 수
	public Integer maxNum();
}
