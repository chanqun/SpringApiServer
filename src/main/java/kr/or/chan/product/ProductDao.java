package kr.or.chan.product;

import static kr.or.chan.product.ProductDaoSqls.*;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ProductDao {
	private NamedParameterJdbcTemplate jdbcTemplate;
	private RowMapper<Product> rowMapper = BeanPropertyRowMapper.newInstance(Product.class);

	public ProductDao(DataSource dataSource) {
		this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}

	public Product selectProductDetailByDisplayInfoId(int displayInfoId) {
		Map<String, Object> params = Collections.singletonMap("displayInfoId", displayInfoId);
		return jdbcTemplate.queryForObject(SELECT_PRODUCT_BY_DISPLAY_ID, params, rowMapper);
	}

	public List<Product> selectAllProduct(int start) {
		Map<String, Object> params = new HashMap<>();
		params.put("start", start);
		params.put("limit", GET_MORE_PRODUCT_COUNT);

		return jdbcTemplate.query(SELECT_ALL_PRODUCT, params, rowMapper);
	}

	public List<Product> selectProductByCategoryId(int start, int categoryId) {
		Map<String, Object> params = new HashMap<>();
		params.put("start", start);
		params.put("categoryId", categoryId);
		params.put("limit", GET_MORE_PRODUCT_COUNT);

		return jdbcTemplate.query(SELECT_PRODUCT_BY_CATEGORY_ID, params, rowMapper);
	}

	public Product selectProductReserveByDisplayInfoId(int displayInfoId) {
		Map<String, Object> params = Collections.singletonMap("displayInfoId", displayInfoId);
		return jdbcTemplate.queryForObject(SELECT_PRODUCT_BY_DISPLAYINFO_ID, params, rowMapper);
	}
}
