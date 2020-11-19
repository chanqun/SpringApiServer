package kr.or.chan.comment;

import java.util.List;

public interface CommentService {
	List<Comment> getTopThreeComment(int productId);

	List<Comment> getAllComment(int productId);

<<<<<<< HEAD
	Comment getTotalCountAndAverage(int productId);
=======
	Comment getTotalCountAverage(int productId);
>>>>>>> bfd249f7d67ddcebe5c4caeb50018da9619fee7e
}
