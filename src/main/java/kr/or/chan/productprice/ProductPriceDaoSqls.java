package kr.or.chan.productprice;

public class ProductPriceDaoSqls {
	public static final String SELECT_PRODUCT_PRICE_BY_ID = ""
		+ "SELECT price_type_name"
		+ "		, price"
		+ "		, discount_rate "
		+ "FROM product_price "
		+ "WHERE product_id = :productId";
}
