package model;

public class Products {
	private String productId;
	private String productTitle;
	private String productDescription;
	private int price ;
	private int discount;
	private int quantity ;
	private String category ;
	private String image  ;
	public Products(String productId, String productTitle, String productDescription, int price, int discount,int quantity, String category, String image) {
		this.productId = productId;
		this.productTitle = productTitle;
		this.productDescription = productDescription;
		this.price = price;
		this.discount = discount;
		this.quantity = quantity;
		this.category = category;
		this.image = image;
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
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getDiscount() {
		return discount;
	}
	public void setDiscount(int discount) {
		this.discount = discount;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	
	
	
	
}
