package kr.or.chan.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.chan.dao.PromotionDao;
import kr.or.chan.dto.Promotion;
import kr.or.chan.service.PromotionService;

@Service
public class PromotionServiceImpl implements PromotionService {
	@Autowired
	PromotionDao promotionDao;

	@Override
	public List<Promotion> getPromotion() {
		return this.promotionDao.selectAll();
	}
}
