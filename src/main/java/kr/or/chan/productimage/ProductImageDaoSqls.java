package kr.or.chan.productimage;

public class ProductImageDaoSqls {
	public static final String SELECT_ONE_IMAGE_BY_ID = ""
		+ "SELECT product_image.id"
		+ "		, product_id "
		+ " 	, type "
		+ "		, file_id "
		+ "		, description "
		+ "		, save_file_name "
		+ "FROM product_image "
		+ "JOIN product ON product.id = product_image.product_id "
		+ "LEFT JOIN file_info ON file_info.id = product_image.file_id "
		+ "WHERE product_id = :productId "
		+ "AND type = 'et' "
		+ "LIMIT 1";
}
