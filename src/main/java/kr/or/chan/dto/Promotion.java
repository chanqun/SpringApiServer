package kr.or.chan.dto;

public class Promotion {
	private int id;
	private int productId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	@Override
	public String toString() {
		return "PromotionDto [id=" + id + ", productId=" + productId + "]";
	}
}
