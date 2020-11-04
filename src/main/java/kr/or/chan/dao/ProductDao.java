package kr.or.chan.dao;

import static kr.or.chan.dao.ChanDaoSqls.*;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import kr.or.chan.dto.Product;

@Repository
public class ProductDao {
	private NamedParameterJdbcTemplate jdbcTemplate;
	private RowMapper<Product> rowMapper = BeanPropertyRowMapper.newInstance(Product.class);

	public ProductDao(DataSource dataSource) {
		this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}

	public List<Product> selectAll() {
		return this.jdbcTemplate.query(SELECT_ALL_PRODUCT, rowMapper);
	}

	public Product selectById(long id) {
		Map<String, ?> params = Collections.singletonMap("id", id);
		return this.jdbcTemplate.queryForObject(SELECT_PRODUCT_BY_ID, params, rowMapper);
	}
}
