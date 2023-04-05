package Car;

import java.sql.Timestamp;

public class CarDTO {
	
	private int carNum;
	private String carName, hourPrice,year,seater,possibleAge;
	private Timestamp registDate;
	
	public CarDTO(int carNum, String carName, String hourPrice, String year, String seater, String possibleAge, Timestamp registDate) {
		this.carNum = carNum;
		this.carName = carName;
		this.hourPrice = hourPrice;
		this.year = year;
		this.seater = seater;
		this.possibleAge = possibleAge;
		this.registDate = registDate;
	}

	public int getCarNum() {
		return carNum;
	}

	public void setCarNum(int carNum) {
		this.carNum = carNum;
	}

	public String getCarName() {
		return carName;
	}

	public void setCarName(String carName) {
		this.carName = carName;
	}

	public String getHourPrice() {
		return hourPrice;
	}

	public void setHourPrice(String hourPrice) {
		this.hourPrice = hourPrice;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getSeater() {
		return seater;
	}

	public void setSeater(String seater) {
		this.seater = seater;
	}

	public String getPossibleAge() {
		return possibleAge;
	}

	public void setPossibleAge(String possibleAge) {
		this.possibleAge = possibleAge;
	}

	public Timestamp getRegistDate() {
		return registDate;
	}

	public void setRegistDate(Timestamp registDate) {
		this.registDate = registDate;
	}

}
