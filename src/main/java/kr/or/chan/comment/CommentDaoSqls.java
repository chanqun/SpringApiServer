package kr.or.chan.comment;

public class CommentDaoSqls {
	public static final String SELECT_ALL_COMMENT = ""
		+ "SELECT reservation_info_id"
		+ "		, score"
		+ "		, comment"
		+ "		, reservation_email"
		+ "		, reservation_date"
		+ "		, description "
		+ "FROM reservation_user_comment "
		+ "JOIN reservation_info ON reservation_user_comment.reservation_info_id = reservation_info.id "
		+ "JOIN product ON product.id = reservation_user_comment.product_id "
		+ "WHERE reservation_user_comment.product_id = :productId";
}
