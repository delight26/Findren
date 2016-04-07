package com.findren.homepage.dao;

import java.util.List;

import com.findren.homepage.domain.PortfolioBoard;

public interface PortfolioDao {

	//게시판 글 수 
	public Integer getPortfolioBoardCount();
	
	//리스트 페이징
	public List<PortfolioBoard> getPortfolioBoardList(int startRow, int PAGE_SIZE);
	
	//글 입력
	public void insertPortfolioBoard(PortfolioBoard nb);
	
	//조회수
	public void portfolioWatchUpdate(int watch, int no);
	
	//글내용
	public PortfolioBoard portfolioContent(int no);
	
	//다음 글 번호
	public Integer portfolioNextNo(int no);
	
	//이전글 번호
	public Integer portfolioPreNo(int no);
	
	//삭제
	public void portfolioDelete(int no);
	
	//업데이트
	public void updatePortfolioBoard(PortfolioBoard nb);
	
	//게시글 최대 수
	public Integer maxNum();
}
