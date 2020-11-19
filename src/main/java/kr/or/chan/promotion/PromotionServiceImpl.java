package kr.or.chan.promotion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PromotionServiceImpl implements PromotionService {
	@Autowired
	private PromotionDao promotionDao;

	@Override
<<<<<<< HEAD
	public List<Promotion> getAllPromotion() {
		return promotionDao.selectAllPromotion();
=======
	public List<Promotion> getPromotion() {
		return promotionDao.selectAll();
>>>>>>> bfd249f7d67ddcebe5c4caeb50018da9619fee7e
	}
}
