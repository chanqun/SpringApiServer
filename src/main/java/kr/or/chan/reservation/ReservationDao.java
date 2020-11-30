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
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

@Repository
public class ReservationDao {
	private NamedParameterJdbcTemplate jdbcTemplate;
	private RowMapper<ReservationResponse> reservationResponseRowMapper = BeanPropertyRowMapper.newInstance(ReservationResponse.class);
	private SimpleJdbcInsert reservationInfoPriceInsertAction;

	public ReservationDao(DataSource dataSource) {
		this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
		this.reservationInfoPriceInsertAction = new SimpleJdbcInsert(dataSource).withTableName("reservation_info_price").usingGeneratedKeyColumns("id");
	}

	public int insertReservationInfo(ReservationInfo reservationInfo) {
		SqlParameterSource params = new BeanPropertySqlParameterSource(reservationInfo);
		KeyHolder keyHolder = new GeneratedKeyHolder();

		jdbcTemplate.update(INSERT_RESERVATION, params, keyHolder);

		return keyHolder.getKey().intValue();
	}

	public int insertReservationPrice(ReservationInfoPrice reservationInfoPrice) {
		SqlParameterSource params = new BeanPropertySqlParameterSource(reservationInfoPrice);
		return reservationInfoPriceInsertAction.executeAndReturnKey(params).intValue();
	}

	public List<ReservationResponse> selectReservationInfoByEmail(String reservationEmail) {
		Map<String, Object> params = Collections.singletonMap("reservationEmail", reservationEmail);
		return jdbcTemplate.query(SELECT_RESERVATION_INFO_BY_EMAIL, params, reservationResponseRowMapper);
	}

	public int updateReservationByReservationInfoId(int reservationInfoId) {
		int cancelReservation = 1;

		Map<String, Object> params = new HashMap<>();
		params.put("reservationInfoId", reservationInfoId);
		params.put("cancelFlag", cancelReservation);

		return jdbcTemplate.update(UPDATE_RESERVATION_BY_INFO_ID, params);
	}
}
