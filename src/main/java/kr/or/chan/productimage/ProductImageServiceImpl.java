package kr.or.chan.productimage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
public class ProductImageServiceImpl implements ProductImageService {
	@Autowired
	private ProductImageDao productImageDao;

	@Override
	public ProductImage getProductImageById(int productId) {
		try {
<<<<<<< HEAD
			return productImageDao.selectProductImageById(productId);
=======
			return productImageDao.selectOneImage(productId);
>>>>>>> bfd249f7d67ddcebe5c4caeb50018da9619fee7e
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}
}
