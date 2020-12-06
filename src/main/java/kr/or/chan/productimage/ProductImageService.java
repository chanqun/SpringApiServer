package kr.or.chan.productimage;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
public class ProductImageService {
	@Autowired
	private ProductImageDao productImageDao;

	public List<ProductImage> getProductImageById(int productId) {
		try {
			return productImageDao.selectProductImageById(productId);
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	public ProductImage getProductImageByFileId(int fileId) {
		return productImageDao.selectProductImageByFileId(fileId);
	}
}
