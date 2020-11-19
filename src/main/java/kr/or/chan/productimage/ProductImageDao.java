package kr.or.chan.productimage;

import static kr.or.chan.productimage.ProductImageDaoSqls.*;

import java.util.Collections;
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

<<<<<<< HEAD
	public ProductImage selectProductImageById(int productId) {
=======
	public ProductImage selectOneImage(int productId) {
>>>>>>> bfd249f7d67ddcebe5c4caeb50018da9619fee7e
		Map<String, Object> params = Collections.singletonMap("productId", productId);
		return jdbcTemplate.queryForObject(SELECT_ONE_IMAGE_BY_ID, params, rowMapper);
	}
}
