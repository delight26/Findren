package com.findren.homepage.dao;

import java.util.List;

import com.findren.homepage.domain.PromotionBoard;

public interface PromotionDao {

	//게시판 글 수 
	public Integer getPromotionBoardCount();
	
	//리스트 페이징
	public List<PromotionBoard> getPromotionBoardList(int startRow, int PAGE_SIZE);
	
	//글 입력
	public void insertPromotionBoard(PromotionBoard pb);
	
	//조회수
	public void promotionWatchUpdate(int watch, int no);
	
	//글내용
	public PromotionBoard promotionContent(int no);
	
	//다음 글 번호
	public Integer promotionNextNo(int no);
	
	//이전글 번호
	public Integer promotionPreNo(int no);
	
	//삭제
	public void promotionDelete(int no);
	
	//업데이트
	public void updatePromotionBoard(PromotionBoard pb);
	
	//게시글 최대 수
	public Integer maxNum();
}
