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

@RestController
<<<<<<< HEAD
@RequestMapping("/api")
=======
@RequestMapping(path = "/api")
>>>>>>> bfd249f7d67ddcebe5c4caeb50018da9619fee7e
public class ProductApiController {
	@Autowired
	private ProductService productService;
	@Autowired
	private ProductImageService productImageService;

<<<<<<< HEAD
	@GetMapping("/products")
	public List<Product> getProductList(@RequestParam(name = "start", required = false, defaultValue = "0") int start,
		@RequestParam(name = "categoryId", required = false, defaultValue = "0") int categoryId) {
		if (categoryId == 0) {
			return productService.getAllProduct(start);
=======
	@GetMapping(path = "/products")
	public List<Product> getProductList(@RequestParam(name = "start", required = false, defaultValue = "0") int start,
		@RequestParam(name = "categoryId", required = false, defaultValue = "0") int categoryId) {
		if (categoryId == 0) {
			return productService.getProducts(start);
>>>>>>> bfd249f7d67ddcebe5c4caeb50018da9619fee7e
		} else {
			return productService.getProductsByCategoryId(start, categoryId);
		}
	}

<<<<<<< HEAD
	@GetMapping("/products/{displayInfoId}")
	public Product selectProductById(@PathVariable("displayInfoId") int id) {
		return productService.getProductById(id);
	}

	@GetMapping("/productimage/{displayInfoId}")
	public ProductImage getProductImage(@PathVariable("displayInfoId") int productId) {
=======
	@GetMapping(path = "/products/{displayInfoId}")
	public Product selectById(@PathVariable(name = "displayInfoId") int id) {
		return productService.getProductById(id);
	}

	@GetMapping(path = "/productimage/{displayInfoId}")
	public ProductImage getProductImage(@PathVariable(name = "displayInfoId") int productId) {
>>>>>>> bfd249f7d67ddcebe5c4caeb50018da9619fee7e
		return productImageService.getProductImageById(productId);
	}
}