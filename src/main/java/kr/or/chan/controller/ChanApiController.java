package kr.or.chan.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.or.chan.dto.Category;
import kr.or.chan.dto.Product;
import kr.or.chan.dto.Promotion;
import kr.or.chan.service.CategoryService;
import kr.or.chan.service.ProductService;
import kr.or.chan.service.PromotionService;

@RestController
@RequestMapping(path = "/api")
public class ChanApiController {
	@Autowired
	ProductService productService;
	@Autowired
	CategoryService categoryService;
	@Autowired
	PromotionService promotionService;

	@GetMapping(path = "/products")
	public Map<String, Object> getProductList() {
		List<Product> products = productService.getProducts();
		Map<String, Object> map = new HashMap<>();
		map.put("products", products);

		return map;
	}

	@GetMapping(path = "/products/{displayInfoId}")
	public Product selectById(@PathVariable(name = "displayInfoId") long id) {
		Product product = productService.getProductById(id);
		return product;
	}

	@GetMapping(path = "/categories")
	public Map<String, Object> getCategoryList() {
		List<Category> category = categoryService.getCategory();
		Map<String, Object> map = new HashMap<>();
		map.put("category", category);

		return map;
	}

	@GetMapping(path = "/promotions")
	public Map<String, Object> getPromotionList() {
		List<Promotion> promotion = promotionService.getPromotion();
		Map<String, Object> map = new HashMap<>();
		map.put("promotion", promotion);

		return map;
	}
}
