package kr.or.chan.product;

import java.util.List;

public interface ProductService {
	Product getProductById(int id);

	List<Product> getAllProduct(int start);

	List<Product> getProductsByCategoryId(int start, int categoryId);
}
