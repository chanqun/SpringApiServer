package kr.or.chan.dao;

import static kr.or.chan.dao.ChanDaoSqls.*;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import kr.or.chan.dto.Category;

@Repository
public class CategoryDao {
	private NamedParameterJdbcTemplate jdbcTemplate;
	private RowMapper<Category> rowMapper = BeanPropertyRowMapper.newInstance(Category.class);

	public CategoryDao(DataSource dataSource) {
		this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}
	
	public List<Category> selectAll() {
		return this.jdbcTemplate.query(SELECT_ALL_CATEGORY, rowMapper);
	}
}
