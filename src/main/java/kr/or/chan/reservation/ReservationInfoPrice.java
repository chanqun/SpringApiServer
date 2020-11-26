package kr.or.chan.reservation;

public class ReservationInfoPrice {
	private int id;
	private int reservationInfoId;
	private int productPriceId;
	private int count;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getReservationInfoId() {
		return reservationInfoId;
	}

	public void setReservationInfoId(int reservationInfoId) {
		this.reservationInfoId = reservationInfoId;
	}

	public int getProductPriceId() {
		return productPriceId;
	}

	public void setProductPriceId(int productPriceId) {
		this.productPriceId = productPriceId;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "ReservationInfoPrice [id=" + id + ", reservationInfoId=" + reservationInfoId + ", productPriceId=" + productPriceId + ", count=" + count + "]";
	}
}
