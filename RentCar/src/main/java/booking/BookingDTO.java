package booking;

import java.sql.Timestamp;

public class BookingDTO {
	
	private int clientNum;
	private String carNum,carName,borrowDate,totalPayment, returnDate;
	Timestamp registDate ;

	public BookingDTO(int clientNum, String carNum, String carName, String borrowDate, String totalPayment, String returnDate, Timestamp registDate) {
		this.clientNum = clientNum;
		this.carNum = carNum;
		this.carName = carName;
		this.borrowDate = borrowDate;
		this.totalPayment = totalPayment;
		this.returnDate = returnDate;
		this.registDate = registDate;
	}

	public int getClientNum() {
		return clientNum;
	}

	public void setClientNum(int clientNum) {
		this.clientNum = clientNum;
	}

	public String getCarNum() {
		return carNum;
	}

	public void setCarNum(String carNum) {
		this.carNum = carNum;
	}

	public String getCarName() {
		return carName;
	}

	public void setCarName(String carName) {
		this.carName = carName;
	}

	public String getBorrowDate() {
		return borrowDate;
	}

	public void setBorrowDate(String borrowDate) {
		this.borrowDate = borrowDate;
	}

	public String getTotalPayment() {
		return totalPayment;
	}

	public void setTotalPayment(String totalPayment) {
		this.totalPayment = totalPayment;
	}

	public String getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(String returnDate) {
		this.returnDate = returnDate;
	}

	public Timestamp getRegistDate() {
		return registDate;
	}

	public void setRegistDate(Timestamp registDate) {
		this.registDate = registDate;
	}

}
