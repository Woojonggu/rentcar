package User;

import java.sql.Timestamp;

public class UserDTO {
	
	private int usersNum;
	private String usersName,phone,clientID,password,age;
	private Timestamp registDate;
	
	public UserDTO(int usersNum,String usersName,String phone,String clientID,String password, String age, Timestamp registDate) {
		this.usersNum = usersNum;
		this.usersName = usersName;
		this.phone = phone;
		this.clientID = clientID;
		this.password = password;
		this.age = age;
		this.registDate = registDate;
	}

	public int getUsersNum() {
		return usersNum;
	}

	public void setUsersNum(int usersNum) {
		this.usersNum = usersNum;
	}

	public String getUsersName() {
		return usersName;
	}

	public void setUsersName(String usersName) {
		this.usersName = usersName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getClientID() {
		return clientID;
	}

	public void setClientID(String clientID) {
		this.clientID = clientID;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public Timestamp getRegistDate() {
		return registDate;
	}

	public void setRegistDate(Timestamp registDate) {
		this.registDate = registDate;
	}

}
