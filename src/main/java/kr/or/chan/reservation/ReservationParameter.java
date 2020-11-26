package kr.or.chan.reservation;

import java.util.List;

public class ReservationParameter {
	private int displayInfoId;
	private int productId;
	private String reservationEmail;
	private String reservationName;
	private String reservationTel;
	private List<ReservationInfoPrice> price;

	public ReservationParameter() {

	}

	public ReservationParameter(int displayInfoId, int productId, String reservationEmail, String reservationName, String reservationTel, List<ReservationInfoPrice> price) {
		this.displayInfoId = displayInfoId;
		this.productId = productId;
		this.reservationEmail = reservationEmail;
		this.reservationName = reservationName;
		this.reservationTel = reservationTel;
		this.price = price;
	}

	public int getDisplayInfoId() {
		return displayInfoId;
	}

	public void setDisplayInfoId(int displayInfoId) {
		this.displayInfoId = displayInfoId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getReservationEmail() {
		return reservationEmail;
	}

	public void setReservationEmail(String reservationEmail) {
		this.reservationEmail = reservationEmail;
	}

	public String getReservationName() {
		return reservationName;
	}

	public void setReservationName(String reservationName) {
		this.reservationName = reservationName;
	}

	public List<ReservationInfoPrice> getPrice() {
		return price;
	}

	public void setPrice(List<ReservationInfoPrice> price) {
		this.price = price;
	}

	public String getReservationTel() {
		return reservationTel;
	}

	public void setReservationTel(String reservationTel) {
		this.reservationTel = reservationTel;
	}

	@Override
	public String toString() {
		return "ReservationParameter [displayInfoId=" + displayInfoId + ", productId=" + productId + ", reservationEmail=" + reservationEmail + ", reservationName=" + reservationName + ", reservationTel=" + reservationTel
			+ ", price=" + price + "]";
	}
}
