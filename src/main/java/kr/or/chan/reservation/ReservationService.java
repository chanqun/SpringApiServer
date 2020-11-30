package kr.or.chan.reservation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ReservationService {
	@Autowired
	private ReservationDao reservationDao;

	@Transactional
	public void createReservation(ReservationParameter reservationParameter) {
		ReservationInfo reservationInfo = new ReservationInfo(reservationParameter);

		int randomPlusDay = (int)((Math.random() * 4) + 1);
		reservationInfo.setReservationDate(reservationInfo.getReservationDate().plusDays(randomPlusDay));

		int reservationInfoKey = reservationDao.insertReservationInfo(reservationInfo);

		for (ReservationInfoPrice reservationInfoPrice : reservationParameter.getPrice()) {
			reservationInfoPrice.setReservationInfoId(reservationInfoKey);
			Integer reservationPriceKey = reservationDao.insertReservationPrice(reservationInfoPrice);
			reservationInfoPrice.setReservationInfoId(reservationPriceKey);
		}
	}

	public List<ReservationResponse> getAllReservationByEmail(String reservationEmail) {
		return reservationDao.selectReservationInfoByEmail(reservationEmail);
	}

	public void cancelReservationByReservationInfoId(int reservationInfoId) {
		reservationDao.updateReservationByReservationInfoId(reservationInfoId);
	}
}
