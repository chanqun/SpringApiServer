package kr.or.chan.productimage;

public class ProductImageDaoSqls {
	public static final String SELECT_IMAGE_BY_ID = ""
		+ "SELECT product_image.id"
		+ "		, product_image.product_id"
		+ " 	, product_image.type"
		+ "		, product_image.file_id"
		+ "		, product.description"
		+ "		, file_info.save_file_name "
		+ "FROM product_image "
		+ "JOIN product ON product.id = product_image.product_id "
		+ "LEFT JOIN file_info ON file_info.id = product_image.file_id "
		+ "WHERE product_id = :productId "
		+ "AND type IN ('th', 'et') "
		+ "LIMIT 2";

	public static final String SELECT_IMAGE_BY_FILE_ID = ""
		+ "SELECT file_info.file_name"
		+ "		, file_info.save_file_name"
		+ "		, file_info.content_type "
		+ "FROM file_info "
		+ "WHERE id = :fileId";
}
