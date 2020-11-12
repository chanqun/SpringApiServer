package kr.or.chan.product;

import java.util.Date;

public class Product {
	private int id;
	private int categoryId;
	private String description;
	private String content;
	private Date createDate;
	private Date modifyDate;
	private int imageId;
	private String placeName;
	private String tel;
	private String placeLot;
	private String placeStreet;

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getPlaceLot() {
		return placeLot;
	}

	public void setPlaceLot(String placeLot) {
		this.placeLot = placeLot;
	}

	public String getPlaceStreet() {
		return placeStreet;
	}

	public void setPlaceStreet(String placeStreet) {
		this.placeStreet = placeStreet;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}

	public int getImageId() {
		return imageId;
	}

	public void setImageId(int imageId) {
		this.imageId = imageId;
	}

	public String getPlaceName() {
		return placeName;
	}

	public void setPlaceName(String placeName) {
		this.placeName = placeName;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", categoryId=" + categoryId + ", description=" + description + ", content=" + content + ", createDate=" + createDate + ", modifyDate=" + modifyDate + ", imageId=" + imageId + ", placeName=" + placeName
			+ ", tel=" + tel + ", placeLot=" + placeLot + ", placeStreet=" + placeStreet + "]";
	}
}
