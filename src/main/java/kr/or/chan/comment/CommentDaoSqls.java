package kr.or.chan.comment;

public class CommentDaoSqls {
	public static final String SELECT_ALL_COMMENT = ""
		+ "SELECT reservation_user_comment.reservation_info_id"
		+ "		, score"
		+ "		, comment"
		+ "		, CONCAT(LEFT(reservation_email, 4), '****') reservation_email"
		+ "		, reservation_date"
		+ "		, description"
		+ " 	, save_file_name "
		+ "FROM reservation_user_comment "
		+ "JOIN reservation_info ON reservation_user_comment.reservation_info_id = reservation_info.id "
		+ "JOIN product ON product.id = reservation_user_comment.product_id "
		+ "LEFT JOIN reservation_user_comment_image ON reservation_user_comment_image.reservation_user_comment_id = reservation_user_comment.id "
		+ "LEFT JOIN file_info ON file_info.id = reservation_user_comment_image.file_id "
		+ "WHERE reservation_user_comment.product_id = :productId";
	public static final String GET_COUNT_AND_AVG_SCORE = ""
		+ "SELECT count(*) total_count"
		+ " 	, ROUND(COALESCE(avg(score), 0), 1) average "
		+ "FROM reservation_user_comment "
		+ "WHERE reservation_user_comment.product_id = :productId";
	public static final String SELECT_TOP_THREE_COMMENT = ""
		+ "SELECT reservation_user_comment.reservation_info_id"
		+ "		, score"
		+ "		, comment"
		+ "		, CONCAT(LEFT(reservation_email, 4), '****') reservation_email"
		+ "		, reservation_date"
		+ "		, description"
		+ " 	, save_file_name "
		+ "FROM reservation_user_comment "
		+ "JOIN reservation_info ON reservation_user_comment.reservation_info_id = reservation_info.id "
		+ "JOIN product ON product.id = reservation_user_comment.product_id "
		+ "LEFT JOIN reservation_user_comment_image ON reservation_user_comment_image.reservation_user_comment_id = reservation_user_comment.id "
		+ "LEFT JOIN file_info ON file_info.id = reservation_user_comment_image.file_id "
		+ "WHERE reservation_user_comment.product_id = :productId "
		+ "LIMIT 3";
}
