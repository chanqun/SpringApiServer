package kr.or.chan.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.chan.dao.ProductDao;
import kr.or.chan.dto.Product;
import kr.or.chan.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{
	@Autowired
	ProductDao productDao;

	@Override
	public List<Product> getProducts() {
		return productDao.selectAll();
	}

	@Override
	public Product getProductById(long id) {
		return productDao.selectById(id);
	}
}
