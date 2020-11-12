package kr.or.chan.productimage;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductImageServiceImpl implements ProductImageService {
	@Autowired
	private ProductImageDao productImageDao;

	@Override
	public List<ProductImage> getProductImageById(int productId) {
		return productImageDao.selectAllImage(productId);
	}
}
