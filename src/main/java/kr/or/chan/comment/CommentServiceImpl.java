package kr.or.chan.comment;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {
	@Autowired
	private CommentDao commentDao;

	@Override
<<<<<<< HEAD
	public List<Comment> getAllComment(int productId) {
		return commentDao.selectAllComment(productId);
	}

	@Override
	public List<Comment> getTopThreeComment(int productId) {
		return commentDao.selectTopThreeComment(productId);
	}

	@Override
	public Comment getTotalCountAndAverage(int productId) {
		return commentDao.getTotalCountAndAverage(productId);
=======
	public List<Comment> getTopThreeComment(int productId) {
		return commentDao.selectTopThreeComment(productId);
	}

	@Override
	public Comment getTotalCountAverage(int productId) {
		return commentDao.getTotalCountAverage(productId);
	}

	@Override
	public List<Comment> getAllComment(int productId) {
		return commentDao.selectAllComment(productId);
>>>>>>> bfd249f7d67ddcebe5c4caeb50018da9619fee7e
	}
}
