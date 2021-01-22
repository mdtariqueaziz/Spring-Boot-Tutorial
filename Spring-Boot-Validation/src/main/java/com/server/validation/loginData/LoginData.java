package com.server.validation.loginData;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class LoginData {
	@NotBlank(message = "This field is Required !!")
	@Size(max = 12, min = 4, message = "Lenght should be at least 4 character and maximum 12 character !!")
	private String userName;
	@NotBlank(message = "This field is Required !!")
	private String email;
	@AssertTrue(message="Please agree terms and conditions")
	private boolean agreed;

	public boolean isAgreed() {
		return agreed;
	}

	public void setAgreed(boolean agreed) {
		this.agreed = agreed;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "LoginData [userName=" + userName + ", email=" + email + "]";
	}

}
