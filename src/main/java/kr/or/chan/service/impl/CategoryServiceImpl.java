package kr.or.chan.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.chan.dao.CategoryDao;
import kr.or.chan.dto.Category;
import kr.or.chan.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {
	@Autowired
	CategoryDao categoryDao;
	
	@Override
	public List<Category> getCategory() {
		return this.categoryDao.selectAll();
	}
}
