package kr.or.chan.comment;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

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

	public int addComment(Comment comment) {
		return commentDao.insertComment(comment);
	}

	public int addCommentWithImage(Comment comment, MultipartFile imageFile) {
		return commentDao.insertCommentImage(comment);
	}
}
