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
		return productDao.selectProductById(id);
	}

	@Override
	public List<Product> getAllProduct(int start) {
		return productDao.selectAllProduct(start);
	}

	@Override
	public List<Product> getProductsByCategoryId(int start, int categoryId) {
		return productDao.selectProductByCategoryId(start, categoryId);
	}
}
