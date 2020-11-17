package kr.or.chan.comment;

import java.util.List;

public interface CommentService {
	List<Comment> getTopThreeComment(int productId);

	List<Comment> getAllComment(int productId);

	Comment getTotalCountAverage(int productId);
}
