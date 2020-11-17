package kr.or.chan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kr.or.chan.comment.Comment;
import kr.or.chan.comment.CommentService;

@RestController
@RequestMapping(path = "/api")
public class CommentApiController {
	@Autowired
	private CommentService commentService;

	@GetMapping(path = "/comment")
	public List<Comment> getCommentList(@RequestParam(name = "productId", required = true, defaultValue = "0") int productId, @RequestParam(name = "limit", required = false, defaultValue = "0") int limit) {
		if (limit == 0) {
			return commentService.getAllComment(productId);
		} else {
			return commentService.getTopThreeComment(productId);
		}
	}

	@GetMapping(path = "/comment/avg")
	public Comment getCommentTotalAverage(@RequestParam(name = "productId", required = true, defaultValue = "0") int productId) {
		return commentService.getTotalCountAverage(productId);
	}
}
