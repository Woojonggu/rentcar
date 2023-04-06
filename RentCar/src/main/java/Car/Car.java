package Car;

import java.sql.Timestamp;

public class Car {
	
	private String carNum, carName, hourPrice,year,seater,possibleAge;
	private Timestamp registDate;
	
	public Car(String carNum, String carName, String hourPrice, String year, String seater, String possibleAge, Timestamp registDate) {
		this.carNum = carNum;
		this.carName = carName;
		this.hourPrice = hourPrice;
		this.year = year;
		this.seater = seater;
		this.possibleAge = possibleAge;
		this.registDate = registDate;
	}
	public Car(CarDTO carDTO) {
		this.carNum =  carDTO.getCarNum();
		this.carName = carDTO.getCarName();
		this.hourPrice = carDTO.getHourPrice();
		this.year = carDTO.getYear();
		this.seater = carDTO.getSeater();
		this.possibleAge = carDTO.getPossibleAge();
		this.registDate = carDTO.getRegistDate();
	}
	public String getCarNum() {
		return carNum;
	}
	public String getCarName() {
		return carName;
	}
	public String getHourPrice() {
		return hourPrice;
	}
	public String getYear() {
		return year;
	}
	public String getSeater() {
		return seater;
	}
	public String getPossibleAge() {
		return possibleAge;
	}
	public Timestamp getRegistDate() {
		return registDate;
	}
	

}
