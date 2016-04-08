package com.findren.homepage.dao;

import java.util.List;

import com.findren.homepage.domain.WechatpayBoard;

public interface WechatpayDao {

	//게시판 글 수 
	public Integer getWechatpayBoardCount();
	
	//리스트 페이징
	public List<WechatpayBoard> getWechatpayBoardList(int startRow, int PAGE_SIZE);
	
	//글 입력
	public void insertWechatpayBoard(WechatpayBoard nb);
	
	//조회수
	public void wechatpayWatchUpdate(int watch, int no);
	
	//글내용
	public WechatpayBoard wechatpayContent(int no);
	
	//다음 글 번호
	public Integer wechatpayNextNo(int no);
	
	//이전글 번호
	public Integer wechatpayPreNo(int no);
	
	//삭제
	public void wechatpayDelete(int no);
	
	//업데이트
	public void updateWechatpayBoard(WechatpayBoard nb);
	
	//게시글 최대 수
	public Integer maxNum();
}
