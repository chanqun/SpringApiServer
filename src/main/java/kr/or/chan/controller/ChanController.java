package kr.or.chan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ChanController {
<<<<<<< HEAD
	@GetMapping("/main")
=======
	@GetMapping(path = "/main")
>>>>>>> bfd249f7d67ddcebe5c4caeb50018da9619fee7e
	public String main() {
		return "mainpage";
	}

<<<<<<< HEAD
	@GetMapping("/detail")
=======
	@GetMapping(path = "/detail")
>>>>>>> bfd249f7d67ddcebe5c4caeb50018da9619fee7e
	public String detail() {
		return "detail";
	}

<<<<<<< HEAD
	@GetMapping("/review")
=======
	@GetMapping(path = "/review")
>>>>>>> bfd249f7d67ddcebe5c4caeb50018da9619fee7e
	public String review() {
		return "review";
	}

<<<<<<< HEAD
	@GetMapping("/reserve")
=======
	@GetMapping(path = "/reserve")
>>>>>>> bfd249f7d67ddcebe5c4caeb50018da9619fee7e
	public String reserve() {
		return "reserve";
	}

<<<<<<< HEAD
	@GetMapping("/myreservation")
	public String myreservation() {
		return "myreservation";
	}

	@GetMapping("/error")
	public String error() {
		return "error";
	}
=======
	@GetMapping(path = "/myreservation")
	public String myreservation() {
		return "myreservation";
	}
>>>>>>> bfd249f7d67ddcebe5c4caeb50018da9619fee7e
}
