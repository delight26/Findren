package com.findren.homepage.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.findren.homepage.dao.SeoDao;
import com.findren.homepage.domain.SeoBoard;

@Repository
public class SeoDaoImpl implements SeoDao {

	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}
	private SqlParameterSource Seoparam;
	private String sql;
	private DaoMapper dm = new DaoMapper();

	@Override
	public Integer getSeoBoardCount() 
	{
		Seoparam = new MapSqlParameterSource("findren_write_07_board", "findren_write_07_board");
		sql = "select count(*) from findren_write_07_board";
		return namedParameterJdbcTemplate.queryForObject(sql, Seoparam, Integer.class);
	}

	@Override
	public List<SeoBoard> getSeoBoardList(int startRow, int PAGE_SIZE) 
	{
		Seoparam = new MapSqlParameterSource("startRow", startRow).addValue("PAGE_SIZE",
				PAGE_SIZE);
		sql = "select * from findren_write_07_board order by wr_datetime desc limit :startRow, :PAGE_SIZE";
		return namedParameterJdbcTemplate.query(sql, Seoparam, dm.getSEORMRSE());
	}

	@Override
	public void insertSeoBoard(SeoBoard nb) {
		Seoparam = new BeanPropertySqlParameterSource(nb);
		sql = "insert into findren_write_07_board (wr_id, wr_subject, wr_content, mb_id, wr_name, wr_link1, wr_link2, wr_link1_hit, wr_link2_hit,"
				+ "wr_hit, wr_datetime, wr_file1, wr_file2, wr_ip, wr_option) "
				+ "values(0, :wr_subject, :wr_content, :mb_id, :wr_name, :wr_link1, :wr_link2, 0, 0,"
				+ "0, :wr_datetime, :wr_file1, :wr_file2, :wr_ip, :wr_option)";
		namedParameterJdbcTemplate.update(sql, Seoparam);
	}
	
	@Override
	public void seoWatchUpdate(int watch, int no) {
		Seoparam = new MapSqlParameterSource("watch", watch).addValue("no", no);
		sql = "update findren_write_07_board set wr_hit = :watch where wr_id = :no";
		namedParameterJdbcTemplate.update(sql, Seoparam);
		
	}
	
	@Override
	public SeoBoard seoContent(int no) {
		Seoparam = new MapSqlParameterSource("no", no);
		sql = "select * from findren_write_07_board where wr_id = :no";
		return namedParameterJdbcTemplate.query(sql, Seoparam, dm.getSEORMRSE());
	}
	
	@Override
	public Integer seoNextNo(int no) {
		Seoparam = new MapSqlParameterSource("no", no);
		sql = "SELECT max(wr_id) FROM findren_write_07_board nb WHERE wr_id < :no;";
		return namedParameterJdbcTemplate.queryForObject(
				sql, Seoparam, Integer.class);
	}
	
	@Override
	public Integer seoPreNo(int no) {
		Seoparam = new MapSqlParameterSource("no", no);
		sql = "SELECT min(wr_id) FROM findren_write_07_board nb WHERE wr_id > :no;";
		return namedParameterJdbcTemplate.queryForObject(
				sql, Seoparam, Integer.class);
	}
	
	@Override
	public void seoDelete(int no) {
		Seoparam = new MapSqlParameterSource("no", no);
		sql = "delete from findren_write_07_board where wr_id = :no";
		namedParameterJdbcTemplate.update(sql, Seoparam);
	}
	
	@Override
	public void updateSeoBoard(SeoBoard nb) {
		Seoparam = new BeanPropertySqlParameterSource(nb);
		if(!nb.getWr_file1().isEmpty() && !nb.getWr_file2().isEmpty()){
			sql = "update findren_write_07_board set wr_subject = :wr_subject, wr_content = :wr_content, wr_link1 = :wr_link1, wr_link2 = :wr_link2,"
				+ "wr_datetime = :wr_datetime, wr_file1 = :wr_file1, wr_file2 = :wr_file2, wr_ip = :wr_ip, wr_option = :wr_option where wr_id = :wr_id";
		} else if(!nb.getWr_file1().isEmpty() && nb.getWr_file2().isEmpty()){
			sql = "update findren_write_07_board set wr_subject = :wr_subject, wr_content = :wr_content, wr_link1 = :wr_link1, wr_link2 = :wr_link2,"
					+ "wr_datetime = :wr_datetime, wr_file1 = :wr_file1, wr_ip = :wr_ip, wr_option = :wr_option where wr_id = :wr_id";
		} else if(nb.getWr_file1().isEmpty() && !nb.getWr_file2().isEmpty()){
			sql = "update findren_write_07_board set wr_subject = :wr_subject, wr_content = :wr_content, wr_link1 = :wr_link1, wr_link2 = :wr_link2,"
					+ "wr_datetime = :wr_datetime, wr_file2 = :wr_file2, wr_ip = :wr_ip, wr_option = :wr_option where wr_id = :wr_id";
		}
		namedParameterJdbcTemplate.update(sql, Seoparam);
	}
	
	@Override
	public Integer maxNum() {
		Seoparam = new MapSqlParameterSource("findren_write_07_board", "findren_write_07_board");
		sql = "select max(wr_num) from findren_write_07_board";
		return namedParameterJdbcTemplate.queryForObject(sql, Seoparam, Integer.class);
	}
}
