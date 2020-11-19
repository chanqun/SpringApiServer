package kr.or.chan.productimage;

public class ProductImage {
	private int id;
	private int productId;
	private String type;
	private int fileId;
	private String description;
<<<<<<< HEAD
	private String saveFileImageName;
=======

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
>>>>>>> bfd249f7d67ddcebe5c4caeb50018da9619fee7e

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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getFileId() {
		return fileId;
	}

	public void setFileId(int fileId) {
		this.fileId = fileId;
	}

<<<<<<< HEAD
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getSaveFileImageName() {
		return saveFileImageName;
	}

	public void setSaveFileImageName(String saveFileImageName) {
		this.saveFileImageName = saveFileImageName;
	}

=======
>>>>>>> bfd249f7d67ddcebe5c4caeb50018da9619fee7e
	@Override
	public String toString() {
		return "ProductImage [id=" + id + ", productId=" + productId + ", type=" + type + ", fileId=" + fileId + "]";
	}
}
