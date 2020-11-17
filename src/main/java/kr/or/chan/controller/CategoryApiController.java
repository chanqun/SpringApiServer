package kr.or.chan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.or.chan.category.Category;
import kr.or.chan.category.CategoryService;

@RestController
@RequestMapping(path = "/api")
public class CategoryApiController {
	@Autowired
	private CategoryService categoryService;

	@GetMapping(path = "/categories")
	public List<Category> getCategoryList() {
		return categoryService.getCategory();
	}
}
