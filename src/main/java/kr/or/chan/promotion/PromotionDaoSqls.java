package kr.or.chan.promotion;

public class PromotionDaoSqls {
	public static final String SELECT_PROMOTION_IMAGE = ""
		+ "SELECT product_image.id "
		+ "		, promotion.product_id "
		+ "		, display_info.place_name "
		+ "		, product.description "
		+ "		, product.content "
		+ "FROM promotion "
		+ "JOIN product_image ON promotion.product_id = product_image.product_id "
		+ "JOIN display_info ON promotion.product_id = display_info.product_id "
		+ "JOIN product ON promotion.product_id = product.id "
		+ "GROUP BY product_id ";
}
