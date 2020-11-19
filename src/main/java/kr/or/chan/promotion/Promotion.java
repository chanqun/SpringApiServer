package kr.or.chan.promotion;

public class Promotion {
	private int id;
	private int productId;
	private String description;
	private String content;
	private String placeName;

<<<<<<< HEAD
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

=======
>>>>>>> bfd249f7d67ddcebe5c4caeb50018da9619fee7e
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

	public String getPlaceName() {
		return placeName;
	}

	public void setPlaceName(String placeName) {
		this.placeName = placeName;
	}

<<<<<<< HEAD
=======
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

>>>>>>> bfd249f7d67ddcebe5c4caeb50018da9619fee7e
	@Override
	public String toString() {
		return "Promotion [id=" + id + ", productId=" + productId + ", description=" + description + ", content=" + content + ", placeName=" + placeName + "]";
	}
}
