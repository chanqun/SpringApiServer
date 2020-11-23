package kr.or.chan.productprice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductPriceService {
	@Autowired
	private ProductPriceDao productPriceDao;

	public List<ProductPrice> getProductPriceById(int productId) {
		return productPriceDao.selectProductPriceById(productId);
	}
}
