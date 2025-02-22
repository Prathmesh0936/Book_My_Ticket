package com.prathmesh.bookmyticket.DAO;

public class ChangePasswordDAO {
	
private String password;
	
private String confirmPassword;

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

public String getConfirmPassword() {
	return confirmPassword;
}

public void setConfirmPassword(String confirmPassword) {
	this.confirmPassword = confirmPassword;
}

@Override
public String toString() {
	return "ChangePasswordDAO [password=" + password + ", confirmPassword=" + confirmPassword + "]";
}

}
