package kr.or.chan.category;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService {
	@Autowired
	private CategoryDao categoryDao;

	@Override
<<<<<<< HEAD
	public List<Category> getAllCategory() {
		return categoryDao.selectAllCategory();
=======
	public List<Category> getCategory() {
		return categoryDao.selectAll();
>>>>>>> bfd249f7d67ddcebe5c4caeb50018da9619fee7e
	}
}
