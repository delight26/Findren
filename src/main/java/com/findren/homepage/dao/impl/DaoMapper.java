package com.findren.homepage.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import com.findren.homepage.domain.Config;
import com.findren.homepage.domain.NewsBoard;
import com.findren.homepage.domain.NoticeBoard;
import com.findren.homepage.domain.PromotionBoard;

public class DaoMapper {

	//공지사항 
	private NoticeBoardRMRSE noticeBoardRMRSE = new NoticeBoardRMRSE();

	public NoticeBoardRMRSE getNoticeBoardRMRSE() {
		return noticeBoardRMRSE;
	}

	private class NoticeBoardRMRSE implements RowMapper<NoticeBoard>, ResultSetExtractor<NoticeBoard> {

		@Override
		public NoticeBoard mapRow(ResultSet rs, int rowNum) throws SQLException {
			NoticeBoard nb = new NoticeBoard();
			nb.setWr_id(rs.getInt("wr_id"));
			nb.setWr_subject(rs.getString("wr_subject"));
			nb.setWr_content(rs.getString("wr_content"));
			nb.setMb_id(rs.getString("mb_id"));
			nb.setWr_name(rs.getString("wr_name"));
			nb.setWr_link1(rs.getString("wr_link1"));
			nb.setWr_link2(rs.getString("wr_link2"));
			nb.setWr_link1_hit(rs.getInt("wr_link1_hit"));
			nb.setWr_link2_hit(rs.getInt("wr_link2_hit"));
			nb.setWr_hit(rs.getInt("wr_hit"));
			nb.setWr_datetime(rs.getTimestamp("wr_datetime"));
			nb.setWr_file1(rs.getString("wr_file1"));
			nb.setWr_file2(rs.getString("wr_file2"));
			nb.setWr_ip(rs.getString("wr_ip"));
			nb.setWr_option(rs.getString("wr_option"));

			return nb;
		}

		@Override
		public NoticeBoard extractData(ResultSet rs) throws SQLException, DataAccessException {
			if (rs.next()) {
				NoticeBoard nb = new NoticeBoard();
				nb.setWr_id(rs.getInt("wr_id"));
				nb.setWr_subject(rs.getString("wr_subject"));
				nb.setWr_content(rs.getString("wr_content"));
				nb.setMb_id(rs.getString("mb_id"));
				nb.setWr_name(rs.getString("wr_name"));
				nb.setWr_link1(rs.getString("wr_link1"));
				nb.setWr_link2(rs.getString("wr_link2"));
				nb.setWr_link1_hit(rs.getInt("wr_link1_hit"));
				nb.setWr_link2_hit(rs.getInt("wr_link2_hit"));
				nb.setWr_hit(rs.getInt("wr_hit"));
				nb.setWr_datetime(rs.getTimestamp("wr_datetime"));
				nb.setWr_file1(rs.getString("wr_file1"));
				nb.setWr_file2(rs.getString("wr_file2"));
				nb.setWr_ip(rs.getString("wr_ip"));
				nb.setWr_option(rs.getString("wr_option"));
				return nb;
			}
			return null;
		}
	}

	private ConfigRMRSE configRMRSE = new ConfigRMRSE();

	public ConfigRMRSE getConfigRMRSE() {
		return configRMRSE;
	}

	private class ConfigRMRSE implements RowMapper<Config>, ResultSetExtractor<Config> {
		@Override
		public Config mapRow(ResultSet rs, int pageNum) throws SQLException {
			Config cf = new Config();
			cf.setCf_sign(rs.getString("cf_sign"));
			cf.setCf_useidentify(rs.getString("cf_useidentify"));
			return cf;
		}

		@Override
		public Config extractData(ResultSet rs) throws SQLException, DataAccessException {
			if (rs.next()) {
				Config cf = new Config();
				cf.setCf_sign(rs.getString("cf_sign"));
				cf.setCf_useidentify(rs.getString("cf_useidentify"));
				return cf;
			}
			return null;
		}
	}
	
	//보도자료
		private NewsBoardRMRSE newsBoardRMRSE = new NewsBoardRMRSE();
		
		public NewsBoardRMRSE getNewsBoardRMRSE() {
			return newsBoardRMRSE;
		}
		private class NewsBoardRMRSE implements RowMapper<NewsBoard>, ResultSetExtractor<NewsBoard>{
			
			@Override
			public NewsBoard mapRow(ResultSet rs, int rowNum) throws SQLException {
				NewsBoard nb = new NewsBoard();
				nb.setWr_id(rs.getInt("wr_id"));
				nb.setWr_subject(rs.getString("wr_subject"));
				nb.setWr_content(rs.getString("wr_content"));
				nb.setMb_id(rs.getString("mb_id"));
				nb.setWr_name(rs.getString("wr_name"));
				nb.setWr_link1(rs.getString("wr_link1"));
				nb.setWr_link2(rs.getString("wr_link2"));
				nb.setWr_link1_hit(rs.getInt("wr_link1_hit"));
				nb.setWr_link2_hit(rs.getInt("wr_link2_hit"));
				nb.setWr_hit(rs.getInt("wr_hit"));
				nb.setWr_datetime(rs.getTimestamp("wr_datetime"));
				nb.setWr_file1(rs.getString("wr_file1"));
				nb.setWr_file2(rs.getString("wr_file2"));
				nb.setWr_ip(rs.getString("wr_ip"));
				nb.setWr_option(rs.getString("wr_option"));
				
				return nb;
			}
			
			@Override
			public NewsBoard extractData(ResultSet rs) throws SQLException, DataAccessException {
				if(rs.next()){
				NewsBoard nb = new NewsBoard();
				nb.setWr_id(rs.getInt("wr_id"));
				nb.setWr_subject(rs.getString("wr_subject"));
				nb.setWr_content(rs.getString("wr_content"));
				nb.setMb_id(rs.getString("mb_id"));
				nb.setWr_name(rs.getString("wr_name"));
				nb.setWr_link1(rs.getString("wr_link1"));
				nb.setWr_link2(rs.getString("wr_link2"));
				nb.setWr_link1_hit(rs.getInt("wr_link1_hit"));
				nb.setWr_link2_hit(rs.getInt("wr_link2_hit"));
				nb.setWr_hit(rs.getInt("wr_hit"));
				nb.setWr_datetime(rs.getTimestamp("wr_datetime"));
				nb.setWr_file1(rs.getString("wr_file1"));
				nb.setWr_file2(rs.getString("wr_file2"));
				nb.setWr_ip(rs.getString("wr_ip"));
				nb.setWr_option(rs.getString("wr_option"));
				return nb;
				}
				return null;
			}
		}
		
		//가맹점홍보
				private PromotionBoardRMRSE promotionBoardRMRSE = new PromotionBoardRMRSE();
				
				public PromotionBoardRMRSE getPromotionBoardRMRSE() {
					return promotionBoardRMRSE;
				}
				private class PromotionBoardRMRSE implements RowMapper<PromotionBoard>, ResultSetExtractor<PromotionBoard>{
					
					@Override
					public PromotionBoard mapRow(ResultSet rs, int rowNum) throws SQLException {
						PromotionBoard promotion = new PromotionBoard();
						promotion.setWr_id(rs.getInt("wr_id"));
						promotion.setWr_subject(rs.getString("wr_subject"));
						promotion.setWr_content(rs.getString("wr_content"));
						promotion.setMb_id(rs.getString("mb_id"));
						promotion.setWr_name(rs.getString("wr_name"));
						promotion.setWr_link1(rs.getString("wr_link1"));
						promotion.setWr_link2(rs.getString("wr_link2"));
						promotion.setWr_link1_hit(rs.getInt("wr_link1_hit"));
						promotion.setWr_link2_hit(rs.getInt("wr_link2_hit"));
						promotion.setWr_hit(rs.getInt("wr_hit"));
						promotion.setWr_datetime(rs.getTimestamp("wr_datetime"));
						promotion.setWr_file1(rs.getString("wr_file1"));
						promotion.setWr_file2(rs.getString("wr_file2"));
						promotion.setWr_ip(rs.getString("wr_ip"));
						promotion.setWr_option(rs.getString("wr_option"));
						
						return promotion;
					}
					
					@Override
					public PromotionBoard extractData(ResultSet rs) throws SQLException, DataAccessException {
						if(rs.next()){
						PromotionBoard promotion = new PromotionBoard();
						promotion.setWr_id(rs.getInt("wr_id"));
						promotion.setWr_subject(rs.getString("wr_subject"));
						promotion.setWr_content(rs.getString("wr_content"));
						promotion.setMb_id(rs.getString("mb_id"));
						promotion.setWr_name(rs.getString("wr_name"));
						promotion.setWr_link1(rs.getString("wr_link1"));
						promotion.setWr_link2(rs.getString("wr_link2"));
						promotion.setWr_link1_hit(rs.getInt("wr_link1_hit"));
						promotion.setWr_link2_hit(rs.getInt("wr_link2_hit"));
						promotion.setWr_hit(rs.getInt("wr_hit"));
						promotion.setWr_datetime(rs.getTimestamp("wr_datetime"));
						promotion.setWr_file1(rs.getString("wr_file1"));
						promotion.setWr_file2(rs.getString("wr_file2"));
						promotion.setWr_ip(rs.getString("wr_ip"));
						promotion.setWr_option(rs.getString("wr_option"));
						return promotion;
						}
						return null;
					}
				}
}
//		//보도자료
//		private PortfolioBoardRMRSE portfolioBoardRMRSE = new PortfolioBoardRMRSE();
//		
//		public PortfolioBoardRMRSE getPortfolioBoardRMRSE() {
//			return newsPortfolioRMRSE;
//		}
//		private class PortfolioBoardRMRSE implements RowMapper<NewsBoard>, ResultSetExtractor<NewsBoard>{
//			
//			@Override
//			public PortfolioBoard mapRow(ResultSet rs, int rowNum) throws SQLException {
//				PortfolioBoard fb = new PortfolioBoard();
//				fb.setWr_id(rs.getInt("wr_id"));
//				fb.setWr_subject(rs.getString("wr_subject"));
//				fb.setWr_content(rs.getString("wr_content"));
//				fb.setMb_id(rs.getString("mb_id"));
//				fb.setWr_name(rs.getString("wr_name"));
//				fb.setWr_link1(rs.getString("wr_link1"));
//				fb.setWr_link2(rs.getString("wr_link2"));
//				fb.setWr_link1_hit(rs.getInt("wr_link1_hit"));
//				fb.setWr_link2_hit(rs.getInt("wr_link2_hit"));
//				fb.setWr_hit(rs.getInt("wr_hit"));
//				fb.setWr_datetime(rs.getTimestamp("wr_datetime"));
//				fb.setWr_file1(rs.getString("wr_file1"));
//				fb.setWr_file2(rs.getString("wr_file2"));
//				fb.setWr_ip(rs.getString("wr_ip"));
//				fb.setWr_option(rs.getString("wr_option"));
//				
//				return fb;
//			}
//			
//			@Override
//			public PortfolioBoard extractData(ResultSet rs) throws SQLException, DataAccessException {
//				if(rs.next()){
//				PortfolioBoard fb = new PortfolioBoard();
//				fb.setWr_id(rs.getInt("wr_id"));
//				fb.setWr_subject(rs.getString("wr_subject"));
//				fb.setWr_content(rs.getString("wr_content"));
//				fb.setMb_id(rs.getString("mb_id"));
//				fb.setWr_name(rs.getString("wr_name"));
//				fb.setWr_link1(rs.getString("wr_link1"));
//				fb.setWr_link2(rs.getString("wr_link2"));
//				fb.setWr_link1_hit(rs.getInt("wr_link1_hit"));
//				fb.setWr_link2_hit(rs.getInt("wr_link2_hit"));
//				fb.setWr_hit(rs.getInt("wr_hit"));
//				fb.setWr_datetime(rs.getTimestamp("wr_datetime"));
//				fb.setWr_file1(rs.getString("wr_file1"));
//				fb.setWr_file2(rs.getString("wr_file2"));
//				fb.setWr_ip(rs.getString("wr_ip"));
//				fb.setWr_option(rs.getString("wr_option"));
//				return fb;
//				}
//				return null;
//			}
//		}
//}
