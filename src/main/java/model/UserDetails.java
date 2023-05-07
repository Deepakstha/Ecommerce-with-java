package model;

public class UserDetails {
	private String userId;
	private String fullname;
	private String phonenumber;
	private String email;
	private String gender;
	private String password;
	private String userType;
	private String image;
	public UserDetails(String userId, String fullname, String phonenumber, String email, String gender, String password,
			String userType, String image) {
		this.userId = userId;
		this.fullname = fullname;
		this.phonenumber = phonenumber;
		this.email = email;
		this.gender = gender;
		this.password = password;
		this.userType = userType;
		this.image = image;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}	
	
	
	
}
