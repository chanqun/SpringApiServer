package kr.or.chan.controller;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import kr.or.chan.comment.Comment;
import kr.or.chan.comment.CommentService;
import kr.or.chan.reservation.ReservationParameter;
import kr.or.chan.reservation.ReservationResponse;
import kr.or.chan.reservation.ReservationService;

@RestController
@RequestMapping("/api/reservations")
public class ReservationApiController {
	@Autowired
	private ReservationService reservationService;
	@Autowired
	private CommentService commentService;

	@PostMapping
	public void createReservation(@RequestBody ReservationParameter reservationParameter) {
		reservationService.createReservation(reservationParameter);
	}

	@GetMapping
	public List<ReservationResponse> getReservationsByEmail(@RequestParam String reservationEmail) {
		return reservationService.getAllReservationByEmail(reservationEmail);
	}

	@PutMapping("/{reservationInfoId}")
	public void cancelReservationByReservationInfoId(@PathVariable int reservationInfoId) {
		reservationService.cancelReservationByReservationInfoId(reservationInfoId);
	}

	@PostMapping("/{reservationId}/comments")
	public int saveComment(@PathVariable int reservationId, @ModelAttribute Comment comment, @RequestParam(name = "imageFile", required = false) MultipartFile imageFile) {
		comment.setReservationInfoId(reservationId);

		if (Objects.isNull(imageFile)) {
			return commentService.addComment(comment);
		} else {
			return commentService.addCommentWithImage(comment, imageFile);
		}
	}
}
