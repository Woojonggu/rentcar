package review;

import java.sql.Timestamp;

public class reviewDTO {
	
	private int reviewNum;
	private String tittle, contents, writerId;
	private Timestamp writeDate;
	
	
	public reviewDTO(int reviewNum, String tittle,String contents,String writerId, Timestamp writeDate) {
		this.reviewNum = reviewNum;
		this.tittle = tittle;
		
		this.contents = contents;
		this.writerId = writerId;
		this.writeDate = writeDate;
	}


	public int getReviewNum() {
		return reviewNum;
	}


	public void setReviewNum(int reviewNum) {
		this.reviewNum = reviewNum;
	}


	public String getTittle() {
		return tittle;
	}


	public void setTittle(String tittle) {
		this.tittle = tittle;
	}




	public String getContents() {
		return contents;
	}


	public void setContents(String contents) {
		this.contents = contents;
	}


	public String getWriterId() {
		return writerId;
	}


	public void setWriterId(String writerId) {
		this.writerId = writerId;
	}


	public Timestamp getWriteDate() {
		return writeDate;
	}


	public void setWriteDate(Timestamp writeDate) {
		this.writeDate = writeDate;
	}

}
