package kr.or.chan.category;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {
	@Autowired
	private CategoryDao categoryDao;

	public List<Category> getAllCategory() {
		return categoryDao.selectAllCategory();
	}
}
