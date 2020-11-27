package kr.or.chan.reservation;

import static kr.or.chan.reservation.ReservationDaoSqls.*;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

@Repository
public class ReservationDao {
	private NamedParameterJdbcTemplate jdbcTemplate;
	private RowMapper<ReservationResponse> reservationResponseRowMapper = BeanPropertyRowMapper.newInstance(ReservationResponse.class);
	private SimpleJdbcInsert reservationInfoInsertAction;
	private SimpleJdbcInsert reservationInfoPriceInsertAction;

	public ReservationDao(DataSource dataSource) {
		this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
		this.reservationInfoInsertAction = new SimpleJdbcInsert(dataSource).withTableName("reservation_info").usingGeneratedKeyColumns("id");
		this.reservationInfoPriceInsertAction = new SimpleJdbcInsert(dataSource).withTableName("reservation_info_price").usingGeneratedKeyColumns("id");
	}

	public int insertReservationInfo(ReservationInfo reservationInfo) {
		Map<String, Object> params = new HashMap<>();
		params.put("product_id", reservationInfo.getProductId());
		params.put("display_info_id", reservationInfo.getDisplayInfoId());
		params.put("reservation_name", reservationInfo.getReservationName());
		params.put("reservation_tel", reservationInfo.getReservationTel());
		params.put("reservation_email", reservationInfo.getReservationEmail());
		params.put("cancel_flag", reservationInfo.getCancelFlag());
		params.put("reservation_date", reservationInfo.getReservationDate());
		params.put("create_date", reservationInfo.getReservationDate());
		params.put("modify_date", reservationInfo.getReservationDate());

		return reservationInfoInsertAction.executeAndReturnKey(params).intValue();
	}

	public int insertReservationPrice(ReservationInfoPrice reservationInfoPrice) {
		SqlParameterSource params = new BeanPropertySqlParameterSource(reservationInfoPrice);
		return reservationInfoPriceInsertAction.executeAndReturnKey(params).intValue();
	}

	public List<ReservationResponse> selectReservationInfoByEmail(String reservationEmail) {
		Map<String, Object> params = Collections.singletonMap("reservationEmail", reservationEmail);
		return jdbcTemplate.query(SELECT_RESERVATION_INFO_BY_EMAIL, params, reservationResponseRowMapper);
	}
}
