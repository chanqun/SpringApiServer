package kr.or.chan.promotion;

import static kr.or.chan.promotion.PromotionDaoSqls.*;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class PromotionDao {
	private NamedParameterJdbcTemplate jdbcTemplate;
	private RowMapper<Promotion> rowMapper = BeanPropertyRowMapper.newInstance(Promotion.class);

	public PromotionDao(DataSource dataSource) {
		this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}

<<<<<<< HEAD
	public List<Promotion> selectAllPromotion() {
=======
	public List<Promotion> selectAll() {
>>>>>>> bfd249f7d67ddcebe5c4caeb50018da9619fee7e
		return jdbcTemplate.query(SELECT_PROMOTION_IMAGE, rowMapper);
	}
}
