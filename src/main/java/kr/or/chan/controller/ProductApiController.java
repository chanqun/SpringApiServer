package kr.or.chan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kr.or.chan.product.Product;
import kr.or.chan.product.ProductService;
import kr.or.chan.productimage.ProductImage;
import kr.or.chan.productimage.ProductImageService;
import kr.or.chan.productprice.ProductPrice;
import kr.or.chan.productprice.ProductPriceService;

@RestController
@RequestMapping("/api")
public class ProductApiController {
	@Autowired
	private ProductService productService;
	@Autowired
	private ProductImageService productImageService;
	@Autowired
	private ProductPriceService productPriceService;

	@GetMapping("/products")
	public List<Product> getProductList(@RequestParam(name = "start", required = false, defaultValue = "0") int start,
		@RequestParam(name = "categoryId", required = false, defaultValue = "0") int categoryId) {
		if (categoryId == 0) {
			return productService.getAllProduct(start);
		} else {
			return productService.getProductsByCategoryId(start, categoryId);
		}
	}

	@GetMapping("/products/{id}")
	public Product selectProductById(@PathVariable int id) {
		return productService.getProductById(id);
	}

	@GetMapping("/productimage/{productId}")
	public List<ProductImage> getProductImage(@PathVariable int productId) {
		return productImageService.getProductImageById(productId);
	}

	@GetMapping("/productprice/{productId}")
	public List<ProductPrice> selectProductPriceById(@PathVariable int productId) {
		return productPriceService.getProductPriceById(productId);
	}

	@GetMapping("/displayinfo/{displayInfoId}")
	public Product selectProductDisplayInfoById(@PathVariable int displayInfoId) {
		return productService.getProductDisplayInfoById(displayInfoId);
	}
}
