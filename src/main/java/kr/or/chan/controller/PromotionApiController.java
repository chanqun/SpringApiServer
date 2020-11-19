package kr.or.chan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.or.chan.promotion.Promotion;
import kr.or.chan.promotion.PromotionService;

@RestController
<<<<<<< HEAD
@RequestMapping("/api")
=======
@RequestMapping(path = "/api")
>>>>>>> bfd249f7d67ddcebe5c4caeb50018da9619fee7e
public class PromotionApiController {
	@Autowired
	private PromotionService promotionService;

<<<<<<< HEAD
	@GetMapping("/promotions")
	public List<Promotion> getPromotionList() {
		return promotionService.getAllPromotion();
=======
	@GetMapping(path = "/promotions")
	public List<Promotion> getPromotionList() {
		return promotionService.getPromotion();
>>>>>>> bfd249f7d67ddcebe5c4caeb50018da9619fee7e
	}
}
