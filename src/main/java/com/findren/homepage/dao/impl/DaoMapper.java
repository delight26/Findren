package com.findren.homepage.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;

import com.findren.homepage.domain.Config;
import com.findren.homepage.domain.HeadhuntingBoard;
import com.findren.homepage.domain.JobofferBoard;
import com.findren.homepage.domain.NewsBoard;
import com.findren.homepage.domain.NoticeBoard;
import com.findren.homepage.domain.OnlineBoard;
import com.findren.homepage.domain.PeopleBoard;
import com.findren.homepage.domain.Portfolio;
import com.findren.homepage.domain.PromotionBoard;
import com.findren.homepage.domain.SeoBoard;
import com.findren.homepage.domain.SnsBoard;
import com.findren.homepage.domain.WechatidBoard;
import com.findren.homepage.domain.WechatpayBoard;

public class DaoMapper {

	// 01 공지사항
	private NoticeBoardRMRSE noticeBoardRMRSE = new NoticeBoardRMRSE();

	public NoticeBoardRMRSE getNoticeBoardRMRSE() {
		return noticeBoardRMRSE;
	}

	private class NoticeBoardRMRSE implements RowMapper<NoticeBoard>, ResultSetExtractor<NoticeBoard> {

		@Override
		public NoticeBoard mapRow(ResultSet rs, int rowNum) throws SQLException {
			NoticeBoard notice = new NoticeBoard();
			notice.setWr_id(rs.getInt("wr_id"));
			notice.setWr_subject(rs.getString("wr_subject"));
			notice.setWr_content(rs.getString("wr_content"));
			notice.setMb_id(rs.getString("mb_id"));
			notice.setWr_name(rs.getString("wr_name"));
			notice.setWr_link1(rs.getString("wr_link1"));
			notice.setWr_link2(rs.getString("wr_link2"));
			notice.setWr_link1_hit(rs.getInt("wr_link1_hit"));
			notice.setWr_link2_hit(rs.getInt("wr_link2_hit"));
			notice.setWr_hit(rs.getInt("wr_hit"));
			notice.setWr_datetime(rs.getTimestamp("wr_datetime"));
			notice.setWr_file1(rs.getString("wr_file1"));
			notice.setWr_file2(rs.getString("wr_file2"));
			notice.setWr_ip(rs.getString("wr_ip"));
			notice.setWr_option(rs.getString("wr_option"));

			return notice;
		}

		@Override
		public NoticeBoard extractData(ResultSet rs) throws SQLException, DataAccessException {
			if (rs.next()) {
				NoticeBoard notice = new NoticeBoard();
				notice.setWr_id(rs.getInt("wr_id"));
				notice.setWr_subject(rs.getString("wr_subject"));
				notice.setWr_content(rs.getString("wr_content"));
				notice.setMb_id(rs.getString("mb_id"));
				notice.setWr_name(rs.getString("wr_name"));
				notice.setWr_link1(rs.getString("wr_link1"));
				notice.setWr_link2(rs.getString("wr_link2"));
				notice.setWr_link1_hit(rs.getInt("wr_link1_hit"));
				notice.setWr_link2_hit(rs.getInt("wr_link2_hit"));
				notice.setWr_hit(rs.getInt("wr_hit"));
				notice.setWr_datetime(rs.getTimestamp("wr_datetime"));
				notice.setWr_file1(rs.getString("wr_file1"));
				notice.setWr_file2(rs.getString("wr_file2"));
				notice.setWr_ip(rs.getString("wr_ip"));
				notice.setWr_option(rs.getString("wr_option"));
				return notice;
			}
			return null;
		}
	}

	//설정
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

	// 02 보도자료
	private NewsBoardRMRSE newsBoardRMRSE = new NewsBoardRMRSE();

	public NewsBoardRMRSE getNewsBoardRMRSE() {
		return newsBoardRMRSE;
	}

	private class NewsBoardRMRSE implements RowMapper<NewsBoard>, ResultSetExtractor<NewsBoard> {

		@Override
		public NewsBoard mapRow(ResultSet rs, int rowNum) throws SQLException {
			NewsBoard news = new NewsBoard();
			news.setWr_id(rs.getInt("wr_id"));
			news.setWr_subject(rs.getString("wr_subject"));
			news.setWr_content(rs.getString("wr_content"));
			news.setMb_id(rs.getString("mb_id"));
			news.setWr_name(rs.getString("wr_name"));
			news.setWr_link1(rs.getString("wr_link1"));
			news.setWr_link2(rs.getString("wr_link2"));
			news.setWr_link1_hit(rs.getInt("wr_link1_hit"));
			news.setWr_link2_hit(rs.getInt("wr_link2_hit"));
			news.setWr_hit(rs.getInt("wr_hit"));
			news.setWr_datetime(rs.getTimestamp("wr_datetime"));
			news.setWr_file1(rs.getString("wr_file1"));
			news.setWr_file2(rs.getString("wr_file2"));
			news.setWr_ip(rs.getString("wr_ip"));
			news.setWr_option(rs.getString("wr_option"));

			return news;
		}

		@Override
		public NewsBoard extractData(ResultSet rs) throws SQLException, DataAccessException {
			if (rs.next()) {
				NewsBoard news = new NewsBoard();
				news.setWr_id(rs.getInt("wr_id"));
				news.setWr_subject(rs.getString("wr_subject"));
				news.setWr_content(rs.getString("wr_content"));
				news.setMb_id(rs.getString("mb_id"));
				news.setWr_name(rs.getString("wr_name"));
				news.setWr_link1(rs.getString("wr_link1"));
				news.setWr_link2(rs.getString("wr_link2"));
				news.setWr_link1_hit(rs.getInt("wr_link1_hit"));
				news.setWr_link2_hit(rs.getInt("wr_link2_hit"));
				news.setWr_hit(rs.getInt("wr_hit"));
				news.setWr_datetime(rs.getTimestamp("wr_datetime"));
				news.setWr_file1(rs.getString("wr_file1"));
				news.setWr_file2(rs.getString("wr_file2"));
				news.setWr_ip(rs.getString("wr_ip"));
				news.setWr_option(rs.getString("wr_option"));
				return news;
			}
			return null;
		}
	}

	// 03 포트폴리오
	private PortfolioRMRSE portfolioRMRSE = new PortfolioRMRSE();

	public PortfolioRMRSE getPortfolioRMRSE() {
		return portfolioRMRSE;
	}

	private class PortfolioRMRSE implements RowMapper<Portfolio>, ResultSetExtractor<Portfolio> {

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
			if (rs.next()) {
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

	// 04 가맹점 홍보 및 광고
	private PromotionRMRSE promotionRMRSE = new PromotionRMRSE();

	public PromotionRMRSE getPromotionRMRSE() {
		return promotionRMRSE;
	}

	private class PromotionRMRSE implements RowMapper<PromotionBoard>, ResultSetExtractor<PromotionBoard> {

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
			if (rs.next()) {
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

	// 05 온라인마케팅
	private OnlineRMRSE onlineRMRSE = new OnlineRMRSE();

	public OnlineRMRSE getOnlineRMRSE() {
		return onlineRMRSE;
	}

	private class OnlineRMRSE implements RowMapper<OnlineBoard>, ResultSetExtractor<OnlineBoard> {

		@Override
		public OnlineBoard mapRow(ResultSet rs, int rowNum) throws SQLException {
			OnlineBoard online = new OnlineBoard();
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
		public OnlineBoard extractData(ResultSet rs) throws SQLException, DataAccessException {
			if (rs.next()) {
				OnlineBoard online = new OnlineBoard();
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

	// 06 SNS마케팅
	private SNSRMRSE snsRMRSE = new SNSRMRSE();

	public SNSRMRSE getSNSRMRSE() {
		return snsRMRSE;
	}

	private class SNSRMRSE implements RowMapper<SnsBoard>, ResultSetExtractor<SnsBoard> {

		@Override
		public SnsBoard mapRow(ResultSet rs, int rowNum) throws SQLException {
			SnsBoard sns = new SnsBoard();
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
		public SnsBoard extractData(ResultSet rs) throws SQLException, DataAccessException {
			if (rs.next()) {
				SnsBoard sns = new SnsBoard();
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

	// 07 SEO마케팅
	private SEORMRSE seoRMRSE = new SEORMRSE();

	public SEORMRSE getSEORMRSE() {
		return seoRMRSE;
	}

	private class SEORMRSE implements RowMapper<SeoBoard>, ResultSetExtractor<SeoBoard> {

		@Override
		public SeoBoard mapRow(ResultSet rs, int rowNum) throws SQLException {
			SeoBoard seo = new SeoBoard();
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
		public SeoBoard extractData(ResultSet rs) throws SQLException, DataAccessException {
			if (rs.next()) {
				SeoBoard seo = new SeoBoard();
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
	
	// 08 위챗공중계정
	private WechatidRMRSE wechatidRMRSE = new WechatidRMRSE();

	public WechatpayRMRSE getWechatpayRMRSE() {
		return wechatpayRMRSE;
	}
	
	private class WechatidRMRSE implements RowMapper<WechatidBoard>, ResultSetExtractor<WechatidBoard> {

		@Override
		public WechatidBoard mapRow(ResultSet rs, int rowNum) throws SQLException {
			WechatidBoard wcid = new WechatidBoard();
			wcid.setWr_id(rs.getInt("wr_id"));
			wcid.setWr_subject(rs.getString("wr_subject"));
			wcid.setWr_content(rs.getString("wr_content"));
			wcid.setMb_id(rs.getString("mb_id"));
			wcid.setWr_name(rs.getString("wr_name"));
			wcid.setWr_link1(rs.getString("wr_link1"));
			wcid.setWr_link2(rs.getString("wr_link2"));
			wcid.setWr_link1_hit(rs.getInt("wr_link1_hit"));
			wcid.setWr_link2_hit(rs.getInt("wr_link2_hit"));
			wcid.setWr_hit(rs.getInt("wr_hit"));
			wcid.setWr_datetime(rs.getTimestamp("wr_datetime"));
			wcid.setWr_file1(rs.getString("wr_file1"));
			wcid.setWr_file2(rs.getString("wr_file2"));
			wcid.setWr_ip(rs.getString("wr_ip"));
			wcid.setWr_option(rs.getString("wr_option"));

			return wcid;
		}

		@Override
		public WechatidBoard extractData(ResultSet rs) throws SQLException, DataAccessException {
			if (rs.next()) {
				WechatidBoard wcid = new WechatidBoard();
				wcid.setWr_id(rs.getInt("wr_id"));
				wcid.setWr_subject(rs.getString("wr_subject"));
				wcid.setWr_content(rs.getString("wr_content"));
				wcid.setMb_id(rs.getString("mb_id"));
				wcid.setWr_name(rs.getString("wr_name"));
				wcid.setWr_link1(rs.getString("wr_link1"));
				wcid.setWr_link2(rs.getString("wr_link2"));
				wcid.setWr_link1_hit(rs.getInt("wr_link1_hit"));
				wcid.setWr_link2_hit(rs.getInt("wr_link2_hit"));
				wcid.setWr_hit(rs.getInt("wr_hit"));
				wcid.setWr_datetime(rs.getTimestamp("wr_datetime"));
				wcid.setWr_file1(rs.getString("wr_file1"));
				wcid.setWr_file2(rs.getString("wr_file2"));
				wcid.setWr_ip(rs.getString("wr_ip"));
				wcid.setWr_option(rs.getString("wr_option"));

				return wcid;
			}
			return null;
		}
	}
	
	//09 위챗페이
	private WechatpayRMRSE wechatpayRMRSE = new WechatpayRMRSE();

	public WechatidRMRSE getWechatidRMRSE() {
		return wechatidRMRSE;
	}
	
	private class WechatpayRMRSE implements RowMapper<WechatpayBoard>, ResultSetExtractor<WechatpayBoard> {

		@Override
		public WechatpayBoard mapRow(ResultSet rs, int rowNum) throws SQLException {
			WechatpayBoard wcp = new WechatpayBoard();
			wcp.setWr_id(rs.getInt("wr_id"));
			wcp.setWr_subject(rs.getString("wr_subject"));
			wcp.setWr_content(rs.getString("wr_content"));
			wcp.setMb_id(rs.getString("mb_id"));
			wcp.setWr_name(rs.getString("wr_name"));
			wcp.setWr_link1(rs.getString("wr_link1"));
			wcp.setWr_link2(rs.getString("wr_link2"));
			wcp.setWr_link1_hit(rs.getInt("wr_link1_hit"));
			wcp.setWr_link2_hit(rs.getInt("wr_link2_hit"));
			wcp.setWr_hit(rs.getInt("wr_hit"));
			wcp.setWr_datetime(rs.getTimestamp("wr_datetime"));
			wcp.setWr_file1(rs.getString("wr_file1"));
			wcp.setWr_file2(rs.getString("wr_file2"));
			wcp.setWr_ip(rs.getString("wr_ip"));
			wcp.setWr_option(rs.getString("wr_option"));

			return wcp;
		}

		@Override
		public WechatpayBoard extractData(ResultSet rs) throws SQLException, DataAccessException {
			if (rs.next()) {
				WechatpayBoard wcp = new WechatpayBoard();
				wcp.setWr_id(rs.getInt("wr_id"));
				wcp.setWr_subject(rs.getString("wr_subject"));
				wcp.setWr_content(rs.getString("wr_content"));
				wcp.setMb_id(rs.getString("mb_id"));
				wcp.setWr_name(rs.getString("wr_name"));
				wcp.setWr_link1(rs.getString("wr_link1"));
				wcp.setWr_link2(rs.getString("wr_link2"));
				wcp.setWr_link1_hit(rs.getInt("wr_link1_hit"));
				wcp.setWr_link2_hit(rs.getInt("wr_link2_hit"));
				wcp.setWr_hit(rs.getInt("wr_hit"));
				wcp.setWr_datetime(rs.getTimestamp("wr_datetime"));
				wcp.setWr_file1(rs.getString("wr_file1"));
				wcp.setWr_file2(rs.getString("wr_file2"));
				wcp.setWr_ip(rs.getString("wr_ip"));
				wcp.setWr_option(rs.getString("wr_option"));

				return wcp;
			}
			return null;
		}
	}

	//10 구인구직 
	private JobofferRMRSE jobofferRMRSE = new JobofferRMRSE();

	public JobofferRMRSE getJobofferRMRSE() {
		return jobofferRMRSE;
	}
	
	private class JobofferRMRSE implements RowMapper<JobofferBoard>, ResultSetExtractor<JobofferBoard> {

		@Override
		public JobofferBoard mapRow(ResultSet rs, int rowNum) throws SQLException {
			JobofferBoard joboffer = new JobofferBoard();
			joboffer.setWr_id(rs.getInt("wr_id"));
			joboffer.setWr_subject(rs.getString("wr_subject"));
			joboffer.setWr_content(rs.getString("wr_content"));
			joboffer.setMb_id(rs.getString("mb_id"));
			joboffer.setWr_name(rs.getString("wr_name"));
			joboffer.setWr_link1(rs.getString("wr_link1"));
			joboffer.setWr_link2(rs.getString("wr_link2"));
			joboffer.setWr_link1_hit(rs.getInt("wr_link1_hit"));
			joboffer.setWr_link2_hit(rs.getInt("wr_link2_hit"));
			joboffer.setWr_hit(rs.getInt("wr_hit"));
			joboffer.setWr_datetime(rs.getTimestamp("wr_datetime"));
			joboffer.setWr_file1(rs.getString("wr_file1"));
			joboffer.setWr_file2(rs.getString("wr_file2"));
			joboffer.setWr_ip(rs.getString("wr_ip"));
			joboffer.setWr_option(rs.getString("wr_option"));

			return joboffer;
		}

		@Override
		public JobofferBoard extractData(ResultSet rs) throws SQLException, DataAccessException {
			if (rs.next()) {
				JobofferBoard joboffer = new JobofferBoard();
				joboffer.setWr_id(rs.getInt("wr_id"));
				joboffer.setWr_subject(rs.getString("wr_subject"));
				joboffer.setWr_content(rs.getString("wr_content"));
				joboffer.setMb_id(rs.getString("mb_id"));
				joboffer.setWr_name(rs.getString("wr_name"));
				joboffer.setWr_link1(rs.getString("wr_link1"));
				joboffer.setWr_link2(rs.getString("wr_link2"));
				joboffer.setWr_link1_hit(rs.getInt("wr_link1_hit"));
				joboffer.setWr_link2_hit(rs.getInt("wr_link2_hit"));
				joboffer.setWr_hit(rs.getInt("wr_hit"));
				joboffer.setWr_datetime(rs.getTimestamp("wr_datetime"));
				joboffer.setWr_file1(rs.getString("wr_file1"));
				joboffer.setWr_file2(rs.getString("wr_file2"));
				joboffer.setWr_ip(rs.getString("wr_ip"));
				joboffer.setWr_option(rs.getString("wr_option"));

				return joboffer;
			}
			return null;
		}
	}
	
	//11 해드헌팅 
	private HeadhuntingRMRSE headhuntingRMRSE = new HeadhuntingRMRSE();

	public HeadhuntingRMRSE getHeadhuntingRMRSE() {
		return headhuntingRMRSE;
	}
	
	private class HeadhuntingRMRSE implements RowMapper<HeadhuntingBoard>, ResultSetExtractor<HeadhuntingBoard> {

		@Override
		public HeadhuntingBoard mapRow(ResultSet rs, int rowNum) throws SQLException {
			HeadhuntingBoard headhunting = new HeadhuntingBoard();
			headhunting.setWr_id(rs.getInt("wr_id"));
			headhunting.setWr_subject(rs.getString("wr_subject"));
			headhunting.setWr_content(rs.getString("wr_content"));
			headhunting.setMb_id(rs.getString("mb_id"));
			headhunting.setWr_name(rs.getString("wr_name"));
			headhunting.setWr_link1(rs.getString("wr_link1"));
			headhunting.setWr_link2(rs.getString("wr_link2"));
			headhunting.setWr_link1_hit(rs.getInt("wr_link1_hit"));
			headhunting.setWr_link2_hit(rs.getInt("wr_link2_hit"));
			headhunting.setWr_hit(rs.getInt("wr_hit"));
			headhunting.setWr_datetime(rs.getTimestamp("wr_datetime"));
			headhunting.setWr_file1(rs.getString("wr_file1"));
			headhunting.setWr_file2(rs.getString("wr_file2"));
			headhunting.setWr_ip(rs.getString("wr_ip"));
			headhunting.setWr_option(rs.getString("wr_option"));

			return headhunting;
		}

		@Override
		public HeadhuntingBoard extractData(ResultSet rs) throws SQLException, DataAccessException {
			if (rs.next()) {
				HeadhuntingBoard headhunting = new HeadhuntingBoard();
				headhunting.setWr_id(rs.getInt("wr_id"));
				headhunting.setWr_subject(rs.getString("wr_subject"));
				headhunting.setWr_content(rs.getString("wr_content"));
				headhunting.setMb_id(rs.getString("mb_id"));
				headhunting.setWr_name(rs.getString("wr_name"));
				headhunting.setWr_link1(rs.getString("wr_link1"));
				headhunting.setWr_link2(rs.getString("wr_link2"));
				headhunting.setWr_link1_hit(rs.getInt("wr_link1_hit"));
				headhunting.setWr_link2_hit(rs.getInt("wr_link2_hit"));
				headhunting.setWr_hit(rs.getInt("wr_hit"));
				headhunting.setWr_datetime(rs.getTimestamp("wr_datetime"));
				headhunting.setWr_file1(rs.getString("wr_file1"));
				headhunting.setWr_file2(rs.getString("wr_file2"));
				headhunting.setWr_ip(rs.getString("wr_ip"));
				headhunting.setWr_option(rs.getString("wr_option"));

				return headhunting;
			}
			return null;
		}
	}
	
	//12 인력파견 
	private PeopleRMRSE peopleRMRSE = new PeopleRMRSE();

	public PeopleRMRSE getPeopleRMRSE() {
		return peopleRMRSE;
	}
	
	private class PeopleRMRSE implements RowMapper<PeopleBoard>, ResultSetExtractor<PeopleBoard> {

		@Override
		public PeopleBoard mapRow(ResultSet rs, int rowNum) throws SQLException {
			PeopleBoard people = new PeopleBoard();
			people.setWr_id(rs.getInt("wr_id"));
			people.setWr_subject(rs.getString("wr_subject"));
			people.setWr_content(rs.getString("wr_content"));
			people.setMb_id(rs.getString("mb_id"));
			people.setWr_name(rs.getString("wr_name"));
			people.setWr_link1(rs.getString("wr_link1"));
			people.setWr_link2(rs.getString("wr_link2"));
			people.setWr_link1_hit(rs.getInt("wr_link1_hit"));
			people.setWr_link2_hit(rs.getInt("wr_link2_hit"));
			people.setWr_hit(rs.getInt("wr_hit"));
			people.setWr_datetime(rs.getTimestamp("wr_datetime"));
			people.setWr_file1(rs.getString("wr_file1"));
			people.setWr_file2(rs.getString("wr_file2"));
			people.setWr_ip(rs.getString("wr_ip"));
			people.setWr_option(rs.getString("wr_option"));

			return people;
		}

		@Override
		public PeopleBoard extractData(ResultSet rs) throws SQLException, DataAccessException {
			if (rs.next()) {
				PeopleBoard people = new PeopleBoard();
				people.setWr_id(rs.getInt("wr_id"));
				people.setWr_subject(rs.getString("wr_subject"));
				people.setWr_content(rs.getString("wr_content"));
				people.setMb_id(rs.getString("mb_id"));
				people.setWr_name(rs.getString("wr_name"));
				people.setWr_link1(rs.getString("wr_link1"));
				people.setWr_link2(rs.getString("wr_link2"));
				people.setWr_link1_hit(rs.getInt("wr_link1_hit"));
				people.setWr_link2_hit(rs.getInt("wr_link2_hit"));
				people.setWr_hit(rs.getInt("wr_hit"));
				people.setWr_datetime(rs.getTimestamp("wr_datetime"));
				people.setWr_file1(rs.getString("wr_file1"));
				people.setWr_file2(rs.getString("wr_file2"));
				people.setWr_ip(rs.getString("wr_ip"));
				people.setWr_option(rs.getString("wr_option"));

				return people;
			}
			return null;
		}
	}
}