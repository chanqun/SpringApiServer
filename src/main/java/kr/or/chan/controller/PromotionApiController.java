package kr.or.chan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.or.chan.promotion.Promotion;
import kr.or.chan.promotion.PromotionService;

@RestController
@RequestMapping(path = "/api")
public class PromotionApiController {
	@Autowired
	private PromotionService promotionService;

	@GetMapping(path = "/promotions")
	public List<Promotion> getPromotionList() {
		return promotionService.getPromotion();
	}
}
