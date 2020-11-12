package kr.or.chan.productimage;

import static kr.or.chan.productimage.ProductImageDaoSqls.*;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ProductImageDao {
	private NamedParameterJdbcTemplate jdbcTemplate;
	private RowMapper<ProductImage> rowMapper = BeanPropertyRowMapper.newInstance(ProductImage.class);

	public ProductImageDao(DataSource dataSource) {
		this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}

	public List<ProductImage> selectAllImage(int productId) {
		Map<String, Object> params = Collections.singletonMap("productId", productId);
		return jdbcTemplate.query(SELECT_ALL_IMAGE_BY_ID, params, rowMapper);
	}
}
