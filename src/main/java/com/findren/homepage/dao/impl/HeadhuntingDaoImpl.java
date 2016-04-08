package com.findren.homepage.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.findren.homepage.dao.HeadhuntingDao;
import com.findren.homepage.domain.HeadhuntingBoard;

@Repository
public class HeadhuntingDaoImpl implements HeadhuntingDao {

	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}
	private SqlParameterSource headhuntingparam;
	private String sql;
	private DaoMapper dm = new DaoMapper();

	@Override
	public Integer getHeadhuntingBoardCount() 
	{
		headhuntingparam = new MapSqlParameterSource("findren_write_11_board", "findren_write_11_board");
		sql = "select count(*) from findren_write_11_board";
		return namedParameterJdbcTemplate.queryForObject(sql, headhuntingparam, Integer.class);
	}

	@Override
	public List<HeadhuntingBoard> getHeadhuntingBoardList(int startRow, int PAGE_SIZE) 
	{
		headhuntingparam = new MapSqlParameterSource("startRow", startRow).addValue("PAGE_SIZE",
				PAGE_SIZE);
		sql = "select * from findren_write_11_board order by wr_datetime desc limit :startRow, :PAGE_SIZE";
		return namedParameterJdbcTemplate.query(sql, headhuntingparam, dm.getHeadhuntingRMRSE());
	}

	@Override
	public void insertHeadhuntingBoard(HeadhuntingBoard nb) {
		headhuntingparam = new BeanPropertySqlParameterSource(nb);
		sql = "insert into findren_write_11_board (wr_id, wr_subject, wr_content, mb_id, wr_name, wr_link1, wr_link2, wr_link1_hit, wr_link2_hit,"
				+ "wr_hit, wr_datetime, wr_file1, wr_file2, wr_ip, wr_option) "
				+ "values(0, :wr_subject, :wr_content, :mb_id, :wr_name, :wr_link1, :wr_link2, 0, 0,"
				+ "0, :wr_datetime, :wr_file1, :wr_file2, :wr_ip, :wr_option)";
		namedParameterJdbcTemplate.update(sql, headhuntingparam);
	}
	
	@Override
	public void headhuntingWatchUpdate(int watch, int no) {
		headhuntingparam = new MapSqlParameterSource("watch", watch).addValue("no", no);
		sql = "update findren_write_11_board set wr_hit = :watch where wr_id = :no";
		namedParameterJdbcTemplate.update(sql, headhuntingparam);
		
	}
	
	@Override
	public HeadhuntingBoard headhuntingContent(int no) {
		headhuntingparam = new MapSqlParameterSource("no", no);
		sql = "select * from findren_write_11_board where wr_id = :no";
		return namedParameterJdbcTemplate.query(sql, headhuntingparam, dm.getHeadhuntingRMRSE());
	}
	
	@Override
	public Integer headhuntingNextNo(int no) {
		headhuntingparam = new MapSqlParameterSource("no", no);
		sql = "SELECT max(wr_id) FROM findren_write_11_board nb WHERE wr_id < :no;";
		return namedParameterJdbcTemplate.queryForObject(
				sql, headhuntingparam, Integer.class);
	}
	
	@Override
	public Integer headhuntingPreNo(int no) {
		headhuntingparam = new MapSqlParameterSource("no", no);
		sql = "SELECT min(wr_id) FROM findren_write_11_board nb WHERE wr_id > :no;";
		return namedParameterJdbcTemplate.queryForObject(
				sql, headhuntingparam, Integer.class);
	}
	
	@Override
	public void headhuntingDelete(int no) {
		headhuntingparam = new MapSqlParameterSource("no", no);
		sql = "delete from findren_write_11_board where wr_id = :no";
		namedParameterJdbcTemplate.update(sql, headhuntingparam);
	}
	
	@Override
	public void updateHeadhuntingBoard(HeadhuntingBoard nb) {
		headhuntingparam = new BeanPropertySqlParameterSource(nb);
		if(!nb.getWr_file1().isEmpty() && !nb.getWr_file2().isEmpty()){
			sql = "update findren_write_11_board set wr_subject = :wr_subject, wr_content = :wr_content, wr_link1 = :wr_link1, wr_link2 = :wr_link2,"
				+ "wr_datetime = :wr_datetime, wr_file1 = :wr_file1, wr_file2 = :wr_file2, wr_ip = :wr_ip, wr_option = :wr_option where wr_id = :wr_id";
		} else if(!nb.getWr_file1().isEmpty() && nb.getWr_file2().isEmpty()){
			sql = "update findren_write_11_board set wr_subject = :wr_subject, wr_content = :wr_content, wr_link1 = :wr_link1, wr_link2 = :wr_link2,"
					+ "wr_datetime = :wr_datetime, wr_file1 = :wr_file1, wr_ip = :wr_ip, wr_option = :wr_option where wr_id = :wr_id";
		} else if(nb.getWr_file1().isEmpty() && !nb.getWr_file2().isEmpty()){
			sql = "update findren_write_11_board set wr_subject = :wr_subject, wr_content = :wr_content, wr_link1 = :wr_link1, wr_link2 = :wr_link2,"
					+ "wr_datetime = :wr_datetime, wr_file2 = :wr_file2, wr_ip = :wr_ip, wr_option = :wr_option where wr_id = :wr_id";
		}
		namedParameterJdbcTemplate.update(sql, headhuntingparam);
	}
	
	@Override
	public Integer maxNum() {
		headhuntingparam = new MapSqlParameterSource("findren_write_11_board", "findren_write_11_board");
		sql = "select max(wr_num) from findren_write_11_board";
		return namedParameterJdbcTemplate.queryForObject(sql, headhuntingparam, Integer.class);
	}
}
