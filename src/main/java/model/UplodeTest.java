package model;

public class UplodeTest {
	private String fullname;
	private String password;
	private String imgaePath;
	
	public UplodeTest(String fullname, String password, String imgaePath) {
		this.fullname = fullname;
		this.password = password;
		this.imgaePath = imgaePath;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getImgaePath() {
		return imgaePath;
	}

	public void setImgaePath(String imgaePath) {
		this.imgaePath = imgaePath;
	}
	
	
}
