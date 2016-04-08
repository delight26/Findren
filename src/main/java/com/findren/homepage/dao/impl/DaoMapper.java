package com.findren.homepage.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import com.findren.homepage.domain.Config;
import com.findren.homepage.domain.NewsBoard;
import com.findren.homepage.domain.NoticeBoard;
import com.findren.homepage.domain.Online;
import com.findren.homepage.domain.Portfolio;
import com.findren.homepage.domain.Promotion;
import com.findren.homepage.domain.SEO;
import com.findren.homepage.domain.SNS;

public class DaoMapper {

	//01 공지사항
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
	
	//02 보도자료
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

	//03 포트폴리오 
	private PortfolioRMRSE portfolioRMRSE = new PortfolioRMRSE();
	
	public PortfolioRMRSE getPortfolioRMRSE() {
		return portfolioRMRSE;
	}
	private class PortfolioRMRSE implements RowMapper<Portfolio>, ResultSetExtractor<Portfolio>{
		
		@Override
		public Portfolio mapRow(ResultSet rs, int rowNum) throws SQLException {
			Portfolio portfolio = new Portfolio();
			portfolio.setWr_id(rs.getInt("wr_id"));
			portfolio.setWr_subject(rs.getString("wr_subject"));
			portfolio.setWr_content(rs.getString("wr_content"));
			portfolio.setMb_id(rs.getString("mb_id"));
			portfolio.setWr_name(rs.getString("wr_name"));
			portfolio.setWr_link1(rs.getString("wr_link1"));
			portfolio.setWr_link2(rs.getString("wr_link2"));
			portfolio.setWr_link1_hit(rs.getInt("wr_link1_hit"));
			portfolio.setWr_link2_hit(rs.getInt("wr_link2_hit"));
			portfolio.setWr_hit(rs.getInt("wr_hit"));
			portfolio.setWr_datetime(rs.getTimestamp("wr_datetime"));
			portfolio.setWr_file1(rs.getString("wr_file1"));
			portfolio.setWr_file2(rs.getString("wr_file2"));
			portfolio.setWr_ip(rs.getString("wr_ip"));
			portfolio.setWr_option(rs.getString("wr_option"));
			
			return portfolio;
		}
		
		@Override
		public Portfolio extractData(ResultSet rs) throws SQLException, DataAccessException {
			if(rs.next()){
			Portfolio portfolio = new Portfolio();
			portfolio.setWr_id(rs.getInt("wr_id"));
			portfolio.setWr_subject(rs.getString("wr_subject"));
			portfolio.setWr_content(rs.getString("wr_content"));
			portfolio.setMb_id(rs.getString("mb_id"));
			portfolio.setWr_name(rs.getString("wr_name"));
			portfolio.setWr_link1(rs.getString("wr_link1"));
			portfolio.setWr_link2(rs.getString("wr_link2"));
			portfolio.setWr_link1_hit(rs.getInt("wr_link1_hit"));
			portfolio.setWr_link2_hit(rs.getInt("wr_link2_hit"));
			portfolio.setWr_hit(rs.getInt("wr_hit"));
			portfolio.setWr_datetime(rs.getTimestamp("wr_datetime"));
			portfolio.setWr_file1(rs.getString("wr_file1"));
			portfolio.setWr_file2(rs.getString("wr_file2"));
			portfolio.setWr_ip(rs.getString("wr_ip"));
			portfolio.setWr_option(rs.getString("wr_option"));
			return portfolio;
			}
			return null;
		}
	}
	
	//04 가맹점 홍보 및 광고  
	private PromotionRMRSE promotionRMRSE = new PromotionRMRSE();
	
	public PromotionRMRSE getPromotionRMRSE() {
		return promotionRMRSE;
	}
	private class PromotionRMRSE implements RowMapper<Promotion>, ResultSetExtractor<Promotion>{
		
		@Override
		public Promotion mapRow(ResultSet rs, int rowNum) throws SQLException {
			Promotion promotion = new Promotion();
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
		public Promotion extractData(ResultSet rs) throws SQLException, DataAccessException {
			if(rs.next()){
			Promotion promotion = new Promotion();
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
	
	//05 온라인마케팅 
	private OnlineRMRSE onlineRMRSE = new OnlineRMRSE();
	
	public OnlineRMRSE getOnlineRMRSE() {
		return onlineRMRSE;
	}
	private class OnlineRMRSE implements RowMapper<Online>, ResultSetExtractor<Online>{
		
		@Override
		public Online mapRow(ResultSet rs, int rowNum) throws SQLException {
			Online online = new Online();
			online.setWr_id(rs.getInt("wr_id"));
			online.setWr_subject(rs.getString("wr_subject"));
			online.setWr_content(rs.getString("wr_content"));
			online.setMb_id(rs.getString("mb_id"));
			online.setWr_name(rs.getString("wr_name"));
			online.setWr_link1(rs.getString("wr_link1"));
			online.setWr_link2(rs.getString("wr_link2"));
			online.setWr_link1_hit(rs.getInt("wr_link1_hit"));
			online.setWr_link2_hit(rs.getInt("wr_link2_hit"));
			online.setWr_hit(rs.getInt("wr_hit"));
			online.setWr_datetime(rs.getTimestamp("wr_datetime"));
			online.setWr_file1(rs.getString("wr_file1"));
			online.setWr_file2(rs.getString("wr_file2"));
			online.setWr_ip(rs.getString("wr_ip"));
			online.setWr_option(rs.getString("wr_option"));
			
			return online;
		}
		
		@Override
		public Online extractData(ResultSet rs) throws SQLException, DataAccessException {
			if(rs.next()){
			Online online = new Online();
			online.setWr_id(rs.getInt("wr_id"));
			online.setWr_subject(rs.getString("wr_subject"));
			online.setWr_content(rs.getString("wr_content"));
			online.setMb_id(rs.getString("mb_id"));
			online.setWr_name(rs.getString("wr_name"));
			online.setWr_link1(rs.getString("wr_link1"));
			online.setWr_link2(rs.getString("wr_link2"));
			online.setWr_link1_hit(rs.getInt("wr_link1_hit"));
			online.setWr_link2_hit(rs.getInt("wr_link2_hit"));
			online.setWr_hit(rs.getInt("wr_hit"));
			online.setWr_datetime(rs.getTimestamp("wr_datetime"));
			online.setWr_file1(rs.getString("wr_file1"));
			online.setWr_file2(rs.getString("wr_file2"));
			online.setWr_ip(rs.getString("wr_ip"));
			online.setWr_option(rs.getString("wr_option"));
			return online;
			}
			return null;
		}
	}	
	
	//06 SNS마케팅 
	private SNSRMRSE snsRMRSE = new SNSRMRSE();
	
	public SNSRMRSE getSNSRMRSE() {
		return snsRMRSE;
	}
	private class SNSRMRSE implements RowMapper<SNS>, ResultSetExtractor<SNS>{
		
		@Override
		public SNS mapRow(ResultSet rs, int rowNum) throws SQLException {
			SNS sns = new SNS();
			sns.setWr_id(rs.getInt("wr_id"));
			sns.setWr_subject(rs.getString("wr_subject"));
			sns.setWr_content(rs.getString("wr_content"));
			sns.setMb_id(rs.getString("mb_id"));
			sns.setWr_name(rs.getString("wr_name"));
			sns.setWr_link1(rs.getString("wr_link1"));
			sns.setWr_link2(rs.getString("wr_link2"));
			sns.setWr_link1_hit(rs.getInt("wr_link1_hit"));
			sns.setWr_link2_hit(rs.getInt("wr_link2_hit"));
			sns.setWr_hit(rs.getInt("wr_hit"));
			sns.setWr_datetime(rs.getTimestamp("wr_datetime"));
			sns.setWr_file1(rs.getString("wr_file1"));
			sns.setWr_file2(rs.getString("wr_file2"));
			sns.setWr_ip(rs.getString("wr_ip"));
			sns.setWr_option(rs.getString("wr_option"));
			
			return sns;
		}
		
		@Override
		public SNS extractData(ResultSet rs) throws SQLException, DataAccessException {
			if(rs.next()){
			SNS sns = new SNS();
			sns.setWr_id(rs.getInt("wr_id"));
			sns.setWr_subject(rs.getString("wr_subject"));
			sns.setWr_content(rs.getString("wr_content"));
			sns.setMb_id(rs.getString("mb_id"));
			sns.setWr_name(rs.getString("wr_name"));
			sns.setWr_link1(rs.getString("wr_link1"));
			sns.setWr_link2(rs.getString("wr_link2"));
			sns.setWr_link1_hit(rs.getInt("wr_link1_hit"));
			sns.setWr_link2_hit(rs.getInt("wr_link2_hit"));
			sns.setWr_hit(rs.getInt("wr_hit"));
			sns.setWr_datetime(rs.getTimestamp("wr_datetime"));
			sns.setWr_file1(rs.getString("wr_file1"));
			sns.setWr_file2(rs.getString("wr_file2"));
			sns.setWr_ip(rs.getString("wr_ip"));
			sns.setWr_option(rs.getString("wr_option"));
			return sns;
			}
			return null;
		}
	}	
	
	//07 SEO마케팅 
	private SEORMRSE seoRMRSE = new SEORMRSE();
	
	public SEORMRSE getSEORMRSE() {
		return seoRMRSE;
	}
	private class SEORMRSE implements RowMapper<SEO>, ResultSetExtractor<SEO>{
		
		@Override
		public SEO mapRow(ResultSet rs, int rowNum) throws SQLException {
			SEO seo = new SEO();
			seo.setWr_id(rs.getInt("wr_id"));
			seo.setWr_subject(rs.getString("wr_subject"));
			seo.setWr_content(rs.getString("wr_content"));
			seo.setMb_id(rs.getString("mb_id"));
			seo.setWr_name(rs.getString("wr_name"));
			seo.setWr_link1(rs.getString("wr_link1"));
			seo.setWr_link2(rs.getString("wr_link2"));
			seo.setWr_link1_hit(rs.getInt("wr_link1_hit"));
			seo.setWr_link2_hit(rs.getInt("wr_link2_hit"));
			seo.setWr_hit(rs.getInt("wr_hit"));
			seo.setWr_datetime(rs.getTimestamp("wr_datetime"));
			seo.setWr_file1(rs.getString("wr_file1"));
			seo.setWr_file2(rs.getString("wr_file2"));
			seo.setWr_ip(rs.getString("wr_ip"));
			seo.setWr_option(rs.getString("wr_option"));
			
			return seo;
		}
		
		@Override
		public SEO extractData(ResultSet rs) throws SQLException, DataAccessException {
			if(rs.next()){
			SEO seo = new SEO();
			seo.setWr_id(rs.getInt("wr_id"));
			seo.setWr_subject(rs.getString("wr_subject"));
			seo.setWr_content(rs.getString("wr_content"));
			seo.setMb_id(rs.getString("mb_id"));
			seo.setWr_name(rs.getString("wr_name"));
			seo.setWr_link1(rs.getString("wr_link1"));
			seo.setWr_link2(rs.getString("wr_link2"));
			seo.setWr_link1_hit(rs.getInt("wr_link1_hit"));
			seo.setWr_link2_hit(rs.getInt("wr_link2_hit"));
			seo.setWr_hit(rs.getInt("wr_hit"));
			seo.setWr_datetime(rs.getTimestamp("wr_datetime"));
			seo.setWr_file1(rs.getString("wr_file1"));
			seo.setWr_file2(rs.getString("wr_file2"));
			seo.setWr_ip(rs.getString("wr_ip"));
			seo.setWr_option(rs.getString("wr_option"));
			return seo;
			}
			return null;
		}
	}	
	
	
	
}
