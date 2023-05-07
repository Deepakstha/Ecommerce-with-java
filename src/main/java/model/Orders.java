package model;

public class Orders {
	private String orderId;
	private String productId;
	private String productTitle;
	private String productDescription;
	private String price;
	private String image;
	public Orders(String orderId, String productId, String productTitle, String productDescription, String price,
			String image) {
		this.orderId = orderId;
		this.productId = productId;
		this.productTitle = productTitle;
		this.productDescription = productDescription;
		this.price = price;
		this.image = image;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getProductTitle() {
		return productTitle;
	}
	public void setProductTitle(String productTitle) {
		this.productTitle = productTitle;
	}
	public String getProductDescription() {
		return productDescription;
	}
	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	
	
	
	
}
