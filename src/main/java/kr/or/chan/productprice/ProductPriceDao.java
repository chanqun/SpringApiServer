package kr.or.chan.productprice;

import static kr.or.chan.productprice.ProductPriceDaoSqls.*;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ProductPriceDao {
	private NamedParameterJdbcTemplate jdbcTemplate;
	private RowMapper<ProductPrice> rowMapper = BeanPropertyRowMapper.newInstance(ProductPrice.class);

	public ProductPriceDao(DataSource dataSource) {
		this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}

	public List<ProductPrice> selectProductPriceById(int productId) {
		Map<String, Object> params = Collections.singletonMap("productId", productId);
		return jdbcTemplate.query(SELECT_PRODUCT_PRICE_BY_ID, params, rowMapper);
	}
}
