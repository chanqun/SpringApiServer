package kr.or.chan.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class ChanController {
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
	public String myreservation(HttpSession session) {
		String userEmail = (String)session.getAttribute("email");

		if (userEmail == null) {
			return "bookinglogin";
		} else {
			return "myreservation";
		}
	}
}
