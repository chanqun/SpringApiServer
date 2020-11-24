package kr.or.chan.productimage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
public class ProductImageService {
	@Autowired
	private ProductImageDao productImageDao;

	public ProductImage getProductImageById(int productId) {
		try {
			return productImageDao.selectProductImageById(productId);
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}
}
