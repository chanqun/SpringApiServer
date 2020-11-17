package kr.or.chan.comment;

import java.util.Date;

public class Comment {
	private String description;
	private int reservationInfoId;
	private double score;
	private double average;
	private int totalCount;
	private String comment;
	private String reservationEmail;
	private Date reservationDate;
	private String saveFileName;

	public String getSaveFileName() {
		return saveFileName;
	}

	public void setSaveFileName(String saveFileName) {
		this.saveFileName = saveFileName;
	}

	public double getAverage() {
		return average;
	}

	public void setAverage(double average) {
		this.average = average;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getReservationInfoId() {
		return reservationInfoId;
	}

	public void setReservationInfoId(int reservationInfoId) {
		this.reservationInfoId = reservationInfoId;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getReservationEmail() {
		return reservationEmail;
	}

	public void setReservationEmail(String reservationEmail) {
		this.reservationEmail = reservationEmail;
	}

	public Date getReservationDate() {
		return reservationDate;
	}

	public void setReservationDate(Date reservationDate) {
		this.reservationDate = reservationDate;
	}

	@Override
	public String toString() {
		return "Comment [description=" + description + ", reservationInfoId=" + reservationInfoId + ", score=" + score + ", average=" + average + ", totalCount=" + totalCount + ", comment=" + comment + ", reservationEmail="
			+ reservationEmail + ", reservationDate=" + reservationDate + "]";
	}
}
