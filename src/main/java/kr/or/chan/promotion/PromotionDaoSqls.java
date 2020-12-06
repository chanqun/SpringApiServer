package kr.or.chan.promotion;

public class PromotionDaoSqls {
	public static final String SELECT_PROMOTION_IMAGE = ""
		+ "SELECT product.id "
		+ "		, promotion.product_id "
		+ "		, display_info.place_name "
		+ "		, product.description "
		+ "		, product.content"
		+ "		, product_image.file_id "
		+ "FROM promotion "
		+ "JOIN product_image ON promotion.product_id = product_image.product_id "
		+ "JOIN display_info ON promotion.product_id = display_info.product_id "
		+ "JOIN product ON promotion.product_id = product.id "
		+ "WHERE product_image.type = 'th'";
}
