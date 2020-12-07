package kr.or.chan.category;

public class CategoryDaoSqls {
	public static final String SELECT_CATEGORIES = ""
		+ "SELECT count(*) count"
		+ "		, product.category_id id"
		+ "		, category.name "
		+ "FROM product "
		+ "JOIN category "
		+ "ON product.category_id = category.id "
		+ "GROUP BY category_id";
}
