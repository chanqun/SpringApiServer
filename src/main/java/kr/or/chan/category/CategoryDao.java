package kr.or.chan.category;

import static kr.or.chan.category.CategoryDaoSqls.*;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CategoryDao {
	private NamedParameterJdbcTemplate jdbcTemplate;
	private RowMapper<Category> rowMapper = BeanPropertyRowMapper.newInstance(Category.class);

	public CategoryDao(DataSource dataSource) {
		this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}

	public List<Category> selectAllCategory() {
		return jdbcTemplate.query(SELECT_CATEGORIES, rowMapper);
	}
}
