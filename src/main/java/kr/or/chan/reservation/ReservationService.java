package kr.or.chan.reservation;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ReservationService {
	@Autowired
	private ReservationDao reservationDao;

	@Transactional
	public boolean createReservation(ReservationParameter reservationParameter) {
		ReservationInfo reservationInfo = new ReservationInfo(reservationParameter.getProductId(), reservationParameter.getDisplayInfoId(), reservationParameter.getReservationName(), reservationParameter.getReservationTel(),
			reservationParameter.getReservationEmail(), 0, new Date());

		int reservationInfoKey = reservationDao.insertReservationInfo(reservationInfo);

		for (ReservationInfoPrice reservationInfoPrice : reservationParameter.getPrice()) {
			reservationInfoPrice.setReservationInfoId(reservationInfoKey);
			Integer reservationPriceKey = reservationDao.insertReservationPrice(reservationInfoPrice);
			reservationInfoPrice.setReservationInfoId(reservationPriceKey);
		}

		return true;
	}
}
