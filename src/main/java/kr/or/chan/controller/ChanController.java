package kr.or.chan.controller;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import kr.or.chan.reservation.ReservationResponse;
import kr.or.chan.reservation.ReservationService;

@Controller
@RequestMapping("/")
public class ChanController {
	@Autowired
	private ReservationService reservationService;

	@GetMapping("main")
	public String main() {
		return "mainpage";
	}

	@GetMapping("detail")
	public String detail() {
		return "detail";
	}

	@GetMapping("review")
	public String review() {
		return "review";
	}

	@GetMapping("reviewWrite")
	public String reviewWrite() {
		return "reviewWrite";
	}

	@GetMapping("reserve")
	public String reserve(Model model) {
		LocalDateTime currentTime = LocalDateTime.now();
		model.addAttribute("currentTime", currentTime);

		return "reserve";
	}

	@GetMapping("myreservation")
	public String myreservation(@SessionAttribute(name = "email", required = false) String userEmail, HttpSession session, Model model) {
		if (Objects.isNull(userEmail)) {
			return "bookinglogin";
		} else {
			List<ReservationResponse> reservationResponseList = reservationService.getAllReservationByEmail(userEmail);
			model.addAttribute("reservationList", reservationResponseList);

			LocalDateTime currentDateTime = LocalDateTime.now();
			model.addAttribute("currentDateTime", currentDateTime);

			return "myreservation";
		}
	}

	@PostMapping("myreservation")
	public String myreservationPost(@SessionAttribute(name = "email", required = false) String userEmail, @RequestParam(name = "reserve_email", required = false) String reservationEmail, HttpSession session, Model model) {
		List<ReservationResponse> reservationResponseList = null;
		if (Objects.nonNull(userEmail)) {
			reservationResponseList = reservationService.getAllReservationByEmail(userEmail);
			model.addAttribute("reservationList", reservationResponseList);

			LocalDateTime currentDateTime = LocalDateTime.now();
			model.addAttribute("currentDateTime", currentDateTime);

			return "myreservation";
		} else if (Objects.nonNull(reservationEmail) && !reservationEmail.trim().equals("")) {
			reservationResponseList = reservationService.getAllReservationByEmail(reservationEmail);
			model.addAttribute("reservationList", reservationResponseList);

			if (reservationResponseList.size() > 0) {
				session.setAttribute("email", reservationEmail);
			}

			LocalDateTime currentDateTime = LocalDateTime.now();
			model.addAttribute("currentDateTime", currentDateTime);

			return "myreservation";
		} else {
			return "bookinglogin";
		}
	}
}
