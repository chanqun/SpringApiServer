package kr.or.chan.reservation;

import java.util.Date;
import java.util.List;

public class ReservationResponse {
	private int reservationInfoId;
	private int productId;
	private int displayInfoId;
	private int cancelFlag;
	private List<ReservationInfoPrice> price;
	private Date reservationDate;
	private String reservationEmail;
	private String reservationName;
	private String reservationTel;
	private String createDate;
	private String modifyDate;
	private String description;
	private String placeName;
	private int totalPrice;

	public ReservationResponse() {

	}

	public ReservationResponse(int reservationInfoId, int productId, int displayInfoId, int cancelFlag, List<ReservationInfoPrice> price, Date reservationDate, String reservationEmail, String reservationName, String reservationTel,
		String createDate, String modifyDate) {
		this.reservationInfoId = reservationInfoId;
		this.productId = productId;
		this.displayInfoId = displayInfoId;
		this.cancelFlag = cancelFlag;
		this.price = price;
		this.reservationDate = reservationDate;
		this.reservationEmail = reservationEmail;
		this.reservationName = reservationName;
		this.reservationTel = reservationTel;
		this.createDate = createDate;
		this.modifyDate = modifyDate;
	}

	public int getReservationInfoId() {
		return reservationInfoId;
	}

	public void setReservationInfoId(int reservationInfoId) {
		this.reservationInfoId = reservationInfoId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getDisplayInfoId() {
		return displayInfoId;
	}

	public void setDisplayInfoId(int displayInfoId) {
		this.displayInfoId = displayInfoId;
	}

	public int getCancelFlag() {
		return cancelFlag;
	}

	public void setCancelFlag(int cancelFlag) {
		this.cancelFlag = cancelFlag;
	}

	public List<ReservationInfoPrice> getPrice() {
		return price;
	}

	public void setPrice(List<ReservationInfoPrice> price) {
		this.price = price;
	}

	public Date getReservationDate() {
		return reservationDate;
	}

	public void setReservationDate(Date reservationDate) {
		this.reservationDate = reservationDate;
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

	public String getReservationTel() {
		return reservationTel;
	}

	public void setReservationTel(String reservationTel) {
		this.reservationTel = reservationTel;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public String getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(String modifyDate) {
		this.modifyDate = modifyDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPlaceName() {
		return placeName;
	}

	public void setPlaceName(String placeName) {
		this.placeName = placeName;
	}

	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}

	@Override
	public String toString() {
		return "ReservationResponse [reservationInfoId=" + reservationInfoId + ", productId=" + productId + ", displayInfoId=" + displayInfoId + ", cancelFlag=" + cancelFlag + ", price=" + price + ", reservationDate=" + reservationDate
			+ ", reservationEmail=" + reservationEmail + ", reservationName=" + reservationName + ", reservationTel=" + reservationTel + ", createDate=" + createDate + ", modifyDate=" + modifyDate + "]";
	}
}
