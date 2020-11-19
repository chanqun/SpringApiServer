package kr.or.chan.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductDao productDao;

	@Override
	public Product getProductById(int id) {
<<<<<<< HEAD
		return productDao.selectProductById(id);
	}

	@Override
	public List<Product> getAllProduct(int start) {
		return productDao.selectAllProduct(start);
=======
		return productDao.selectById(id);
	}

	@Override
	public List<Product> getProducts(int start) {
		return productDao.selectAll(start);
>>>>>>> bfd249f7d67ddcebe5c4caeb50018da9619fee7e
	}

	@Override
	public List<Product> getProductsByCategoryId(int start, int categoryId) {
<<<<<<< HEAD
		return productDao.selectProductByCategoryId(start, categoryId);
=======
		return productDao.selectByCategoryId(start, categoryId);
>>>>>>> bfd249f7d67ddcebe5c4caeb50018da9619fee7e
	}
}
