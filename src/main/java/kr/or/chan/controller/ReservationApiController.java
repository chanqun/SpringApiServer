package kr.or.chan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kr.or.chan.reservation.ReservationParameter;
import kr.or.chan.reservation.ReservationResponse;
import kr.or.chan.reservation.ReservationService;

@RestController
@RequestMapping("/api/reservations")
public class ReservationApiController {
	@Autowired
	private ReservationService reservationService;

	@PostMapping
	public void createReservation(@RequestBody ReservationParameter reservationParameter) {
		reservationService.createReservation(reservationParameter);
	}

	@GetMapping
	public List<ReservationResponse> getReservationsByEmail(@RequestParam("reservationEmail") String reservationEmail) {
		return reservationService.getAllReservationByEmail(reservationEmail);
	}

	@PutMapping("/{reservationInfoId}")
	public void cancelReservationByReservationInfoId(@PathVariable int reservationInfoId) {
		reservationService.cancelReservationByReservationInfoId(reservationInfoId);
	}
}
