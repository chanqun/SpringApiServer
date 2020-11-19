package kr.or.chan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.or.chan.category.Category;
import kr.or.chan.category.CategoryService;

@RestController
<<<<<<< HEAD
@RequestMapping("/api")
=======
@RequestMapping(path = "/api")
>>>>>>> bfd249f7d67ddcebe5c4caeb50018da9619fee7e
public class CategoryApiController {
	@Autowired
	private CategoryService categoryService;

<<<<<<< HEAD
	@GetMapping("/categories")
	public List<Category> getCategoryList() {
		return categoryService.getAllCategory();
=======
	@GetMapping(path = "/categories")
	public List<Category> getCategoryList() {
		return categoryService.getCategory();
>>>>>>> bfd249f7d67ddcebe5c4caeb50018da9619fee7e
	}
}
