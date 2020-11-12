package kr.or.chan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kr.or.chan.category.Category;
import kr.or.chan.category.CategoryService;
import kr.or.chan.product.Product;
import kr.or.chan.product.ProductService;
import kr.or.chan.productimage.ProductImage;
import kr.or.chan.productimage.ProductImageService;
import kr.or.chan.promotion.Promotion;
import kr.or.chan.promotion.PromotionService;

@RestController
@RequestMapping(path = "/api")
public class ChanApiController {
	@Autowired
	private ProductService productService;
	@Autowired
	private CategoryService categoryService;
	@Autowired
	private PromotionService promotionService;
	@Autowired
	private ProductImageService productImageService;

	@GetMapping(path = "/products")
	public List<Product> getProductList(@RequestParam(name = "start", required = false, defaultValue = "0") int start,
		@RequestParam(name = "categoryId", required = false, defaultValue = "0") int categoryId) {
		if (categoryId == 0) {
			return productService.getProducts(start);
		} else {
			return productService.getProductsByCategoryId(start, categoryId);
		}
	}

	@GetMapping(path = "/categories")
	public List<Category> getCategoryList() {
		return categoryService.getCategory();
	}

	@GetMapping(path = "/promotions")
	public List<Promotion> getPromotionList() {
		return promotionService.getPromotion();
	}

	@GetMapping(path = "/products/{displayInfoId}")
	public Product selectById(@PathVariable(name = "displayInfoId") int id) {
		return productService.getProductById(id);
	}

	@GetMapping(path = "/productimage/{displayInfoId}")
	public List<ProductImage> getProductImageList(@PathVariable(name = "displayInfoId") int productId) {
		return productImageService.getProductImageById(productId);
	}
}
