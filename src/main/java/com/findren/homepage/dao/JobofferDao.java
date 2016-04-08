package com.findren.homepage.dao;

import java.util.List;

import com.findren.homepage.domain.JobofferBoard;

public interface JobofferDao {

	//게시판 글 수 
	public Integer getJobofferBoardCount();
	
	//리스트 페이징
	public List<JobofferBoard> getJobofferBoardList(int startRow, int PAGE_SIZE);
	
	//글 입력
	public void insertJobofferBoard(JobofferBoard joboffer);
	
	//조회수
	public void jobofferWatchUpdate(int watch, int no);
	
	//글내용
	public JobofferBoard jobofferContent(int no);
	
	//다음 글 번호
	public Integer jobofferNextNo(int no);
	
	//이전글 번호
	public Integer jobofferPreNo(int no);
	
	//삭제
	public void jobofferDelete(int no);
	
	//업데이트
	public void updateJobofferBoard(JobofferBoard joboffer);
	
	//게시글 최대 수
	public Integer maxNum();
}
