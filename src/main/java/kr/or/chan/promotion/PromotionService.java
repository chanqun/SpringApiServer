package kr.or.chan.promotion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PromotionService {
	@Autowired
	private PromotionDao promotionDao;

	public List<Promotion> getAllPromotion() {
		return promotionDao.selectAllPromotion();
	}
}
