package kr.or.chan.comment;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService {
	@Autowired
	private CommentDao commentDao;

	public List<Comment> getAllComment(int productId) {
		return commentDao.selectAllComment(productId);
	}

	public List<Comment> getTopThreeComment(int productId) {
		return commentDao.selectTopThreeComment(productId);
	}

	public Comment getTotalCountAndAverage(int productId) {
		return commentDao.getTotalCountAndAverage(productId);
	}
}
