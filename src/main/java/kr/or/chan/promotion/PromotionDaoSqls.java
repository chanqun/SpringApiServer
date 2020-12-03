package kr.or.chan.promotion;

public class PromotionDaoSqls {
	public static final String SELECT_PROMOTION_IMAGE = ""
		+ "SELECT product.id "
		+ "		, promotion.product_id "
		+ "		, display_info.place_name "
		+ "		, product.description "
		+ "		, product.content"
		+ "		, file_info.save_file_name "
		+ "FROM promotion "
		+ "JOIN product_image ON promotion.product_id = product_image.product_id "
		+ "JOIN display_info ON promotion.product_id = display_info.product_id "
		+ "JOIN product ON promotion.product_id = product.id "
		+ "JOIN file_info ON file_info.id = product_image.file_id "
		+ "WHERE product_image.type = 'th'";
}
