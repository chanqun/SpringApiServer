package kr.or.chan.productimage;

public class ProductImageDaoSqls {
	public static final String SELECT_ALL_IMAGE_BY_ID = ""
		+ "SELECT product_image.id"
		+ "		, product_id "
		+ " 	, type "
		+ "		, file_id "
		+ "		, description "
		+ "FROM product_image "
		+ "JOIN product ON product.id = product_image.product_id "
		+ "WHERE product_id = :productId "
		+ "AND type != 'th'";
}
