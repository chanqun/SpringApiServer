package kr.or.chan.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

	@GetMapping("reserve")
	public String reserve() {
		return "reserve";
	}

	@GetMapping("myreservation")
	public String myreservation(@RequestParam(name = "reserve_email", required = false) String reservationEmail, HttpSession session, Model model) {
		String userEmail = (String)session.getAttribute("email");
		List<ReservationResponse> reservationResponseList = null;

		if (userEmail != null) {
			reservationResponseList = reservationService.getAllReservationByEmail(userEmail);
			model.addAttribute("reservationList", reservationResponseList);

			return "myreservation";
		} else if (reservationEmail != null && !"".equals(reservationEmail.trim())) {
			reservationResponseList = reservationService.getAllReservationByEmail(reservationEmail);
			session.setAttribute("email", reservationEmail);
			model.addAttribute("reservationList", reservationResponseList);

			return "myreservation";
		} else {
			return "bookinglogin";
		}
	}
}
