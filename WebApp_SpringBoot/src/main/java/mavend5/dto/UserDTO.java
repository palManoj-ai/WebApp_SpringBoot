package mavend5.dto;

public class UserDTO {
	String email;
	String password;
	String phoneno;
	public UserDTO() {}
	public UserDTO(String email, String password, String phoneno) {
		super();
		this.email = email;
		this.password = password;
		this.phoneno = phoneno;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhoneno() {
		return phoneno;
	}
	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}
	

	
}
