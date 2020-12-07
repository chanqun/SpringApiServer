package kr.or.chan.comment;

public class CommentDaoSqls {
	public static final String SELECT_ALL_COMMENT = ""
		+ "SELECT reservation_user_comment.reservation_info_id"
		+ "		, reservation_user_comment.score"
		+ "		, reservation_user_comment.comment"
		+ "		, LEFT(reservation_info.reservation_email, 4) reservation_email"
		+ "		, reservation_info.reservation_date"
		+ "		, product.description"
		+ " 	, IFNULL(reservation_user_comment_image.file_id, 0) file_id "
		+ "FROM reservation_user_comment "
		+ "JOIN reservation_info ON reservation_user_comment.reservation_info_id = reservation_info.id "
		+ "JOIN product ON product.id = reservation_user_comment.product_id "
		+ "LEFT JOIN reservation_user_comment_image ON reservation_user_comment_image.reservation_user_comment_id = reservation_user_comment.id "
		+ "WHERE reservation_user_comment.product_id = :productId";

	public static final String GET_COUNT_AND_AVG_SCORE = ""
		+ "SELECT count(*) total_count"
		+ " 	, ROUND(COALESCE(avg(score), 0), 1) average "
		+ "FROM reservation_user_comment "
		+ "WHERE reservation_user_comment.product_id = :productId";

	public static final String SELECT_TOP_THREE_COMMENT = ""
		+ "SELECT reservation_user_comment.reservation_info_id"
		+ "		, reservation_user_comment.score"
		+ "		, reservation_user_comment.comment"
		+ "		, LEFT(reservation_info.reservation_email, 4) reservation_email"
		+ "		, reservation_info.reservation_date"
		+ "		, product.description"
		+ " 	, IFNULL(reservation_user_comment_image.file_id, 0) file_id  "
		+ "FROM reservation_user_comment "
		+ "JOIN reservation_info ON reservation_user_comment.reservation_info_id = reservation_info.id "
		+ "JOIN product ON product.id = reservation_user_comment.product_id "
		+ "LEFT JOIN reservation_user_comment_image ON reservation_user_comment_image.reservation_user_comment_id = reservation_user_comment.id "
		+ "WHERE reservation_user_comment.product_id = :productId "
		+ "LIMIT 3";

	public static final String INSERT_RESERVATION_USER_COMMENT = ""
		+ "INSERT INTO reservation_user_comment "
		+ "(product_id, reservation_info_id, score, comment, create_date, modify_date) "
		+ "VALUES "
		+ "(:productId, :reservationInfoId, :score, :comment, now(), now())";

	public static final String INSERT_COMMENT_IMAGE_INFO = ""
		+ "INSERT INTO reservation_user_comment_image "
		+ "(reservation_info_id, reservation_user_comment_id, file_id) "
		+ "VALUES "
		+ "(:reservationInfoId, :commentId, :fileId)";

	public static final String INSERT_COMMENT_IMAGE = ""
		+ "INSERT INTO file_info "
		+ "(file_name, save_file_name, content_type, delete_flag, create_date, modify_date) "
		+ "VALUES "
		+ "(:fileName, :saveFileName, :contentType, 0, NOW(), NOW())";
}
