package kr.or.chan.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
	@Autowired
	private ProductDao productDao;

	public Product getProductDetailByDisplayInfoId(int displayInfoId) {
		return productDao.selectProductDetailByDisplayInfoId(displayInfoId);
	}

	public List<Product> getAllProduct(int start) {
		return productDao.selectAllProduct(start);
	}

	public List<Product> getProductsByCategoryId(int start, int categoryId) {
		return productDao.selectProductByCategoryId(start, categoryId);
	}

	public Product getProductReserveByDisplayInfoId(int displayInfoId) {
		return productDao.selectProductReserveByDisplayInfoId(displayInfoId);
	}
}
