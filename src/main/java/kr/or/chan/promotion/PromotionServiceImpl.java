package kr.or.chan.promotion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PromotionServiceImpl implements PromotionService {
	@Autowired
	private PromotionDao promotionDao;

	@Override
	public List<Promotion> getPromotion() {
		return promotionDao.selectAll();
	}
}
