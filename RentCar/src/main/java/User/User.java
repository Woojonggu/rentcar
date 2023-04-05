package User;

import java.sql.Timestamp;

public class User {
	private int usersNum;
	private String usersName,phone,clientID,password,age;
	private Timestamp registDate;
	
	public User(int usersNum,String usersName,String phone,String clientID,String password, String age, Timestamp registDate) {
		this.usersNum = usersNum;
		this.usersName = usersName;
		this.phone = phone;
		this.clientID = clientID;
		this.password = password;
		this.age = age;
		this.registDate = registDate;
	}	
	public User(UserDTO userDto) {
		this.usersNum = userDto.getUsersNum();
		this.usersName = userDto.getUsersName();
		this.phone = userDto.getPhone();
		this.clientID = userDto.getClientID();
		this.password = userDto.getPassword();
		this.age = userDto.getAge();
		this.registDate = userDto.getRegistDate();
	}

	public int getUsersNum() {
		return usersNum;
	}

	public String getUsersName() {
		return usersName;
	}

	public String getPhone() {
		return phone;
	}

	public String getClientID() {
		return clientID;
	}

	public String getPassword() {
		return password;
	}

	public String getAge() {
		return age;
	}

	public Timestamp getRegistDate() {
		return registDate;
	}
	
	
	// 현재시간 가져오는방법
//	Timestamp now = new Timestamp(System.currentTimeMillis());
//	System.out.println(now);
}
