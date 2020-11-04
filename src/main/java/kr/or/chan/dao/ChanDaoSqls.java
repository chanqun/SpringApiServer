package kr.or.chan.dao;

public class ChanDaoSqls {
	public static final String SELECT_ALL_PRODUCT = "SELECT id, category_id, description, content, event, create_date, modify_date FROM product";
	public static final String SELECT_PRODUCT_BY_ID = "SELECT id, category_id, description, content, event, create_date, modify_date FROM product WHERE id = :id";
	public static final String SELECT_ALL_CATEGORY = "SELECT id, name FROM category";
	public static final String SELECT_ALL_PROMOTION = "SELECT id, product_id FROM promotion";
}
