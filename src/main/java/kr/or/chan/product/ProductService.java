package kr.or.chan.product;

import java.util.List;

public interface ProductService {
<<<<<<< HEAD
	Product getProductById(int id);

	List<Product> getAllProduct(int start);

	List<Product> getProductsByCategoryId(int start, int categoryId);
=======
	List<Product> getProducts(int start);

	List<Product> getProductsByCategoryId(int start, int categoryId);

	Product getProductById(int id);
>>>>>>> bfd249f7d67ddcebe5c4caeb50018da9619fee7e
}
