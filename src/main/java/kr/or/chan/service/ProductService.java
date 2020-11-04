package kr.or.chan.service;

import java.util.List;

import kr.or.chan.dto.Product;

public interface ProductService {
	public List<Product> getProducts();
	public Product getProductById(long id);
}
