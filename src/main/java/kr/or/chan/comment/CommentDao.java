package kr.or.chan.comment;

import static kr.or.chan.comment.CommentDaoSqls.*;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

@Repository
public class CommentDao {
	private NamedParameterJdbcTemplate jdbcTemplate;
	private RowMapper<Comment> rowMapper = BeanPropertyRowMapper.newInstance(Comment.class);

	public CommentDao(DataSource dataSource) {
		this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}

	public List<Comment> selectTopThreeComment(int productId) {
		Map<String, Object> params = Collections.singletonMap("productId", productId);
		return jdbcTemplate.query(SELECT_TOP_THREE_COMMENT, params, rowMapper);
	}

	public List<Comment> selectAllComment(int productId) {
		Map<String, Object> params = Collections.singletonMap("productId", productId);
		return jdbcTemplate.query(SELECT_ALL_COMMENT, params, rowMapper);
	}

	public Comment getTotalCountAndAverage(int productId) {
		Map<String, Object> params = Collections.singletonMap("productId", productId);
		return jdbcTemplate.queryForObject(GET_COUNT_AND_AVG_SCORE, params, rowMapper);
	}

	public int insertComment(Comment comment) {
		SqlParameterSource params = new BeanPropertySqlParameterSource(comment);
		KeyHolder keyHolder = new GeneratedKeyHolder();

		return jdbcTemplate.update(INSERT_RESERVATION_USER_COMMENT, params, keyHolder);
	}

	public int insertCommentImage(Comment comment) {
		SqlParameterSource params = new BeanPropertySqlParameterSource(comment);
		KeyHolder keyHolder = new GeneratedKeyHolder();

		return jdbcTemplate.update(INSERT_RESERVATION_USER_COMMENT_IMAGE, params, keyHolder);
	}

	public int insertCommentFileInfo(Comment comment) {
		SqlParameterSource params = new BeanPropertySqlParameterSource(comment);
		KeyHolder keyHolder = new GeneratedKeyHolder();

		return jdbcTemplate.update(INSERT_COMMENT_IMAGE_FILE_INFO, params, keyHolder);
	}
}
