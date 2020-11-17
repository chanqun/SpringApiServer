package kr.or.chan.comment;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {
	@Autowired
	private CommentDao commentDao;

	@Override
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
	}
}
