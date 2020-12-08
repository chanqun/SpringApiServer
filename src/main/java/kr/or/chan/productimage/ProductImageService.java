package kr.or.chan.productimage;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
public class ProductImageService {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private ProductImageDao productImageDao;

	public List<ProductImage> getProductImageById(int productId) {
		try {
			return productImageDao.selectProductImageById(productId);
		} catch (EmptyResultDataAccessException ex) {
			logger.error("Excption [getProductImage] productId : {}", productId, ex);
			return null;
		}
	}

	public ProductImage getProductImageByFileId(int fileId) {
		return productImageDao.selectProductImageByFileId(fileId);
	}
}
