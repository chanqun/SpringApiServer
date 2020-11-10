package kr.or.chan.product;

import java.util.List;

public interface ProductService {
	List<Product> getProducts(int start);

	List<Product> getProductsByCategoryId(int start, int categoryId);

	Product getProductById(int id);
}
