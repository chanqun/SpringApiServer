package kr.or.chan.productprice;

public class ProductPriceDaoSqls {
	public static final String SELECT_PRODUCT_PRICE_BY_ID = ""
		+ "SELECT product_price.id"
		+ "		, product_price.price_type_name"
		+ "		, product_price.price"
		+ "		, product_price.discount_rate "
		+ "FROM product_price "
		+ "WHERE product_id = :productId";
}
