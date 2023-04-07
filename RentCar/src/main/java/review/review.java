package review;

import java.sql.Timestamp;

public class review {
	
	private int reviewNum;
	private String tittle, contents, writerId;
	private Timestamp writeDate;
	
	
	public review(int reviewNum, String tittle,String contents,String writerId, Timestamp writeDate) {
		this.reviewNum = reviewNum;
		this.tittle = tittle;
		
		this.contents = contents;
		this.writerId = writerId;
		this.writeDate = writeDate;
	}
	public review(reviewDTO reviewDto) {
		this.reviewNum = reviewDto.getReviewNum();
		this.tittle =  reviewDto.getTittle();

		this.contents =  reviewDto.getContents();
		this.writerId =  reviewDto.getWriterId();
		this.writeDate =  reviewDto.getWriteDate();
	}


	public int getReviewNum() {
		return reviewNum;
	}


	public String getTittle() {
		return tittle;
	}


	


	public String getContents() {
		return contents;
	}


	public String getWriterId() {
		return writerId;
	}


	public Timestamp getWriteDate() {
		return writeDate;
	}
	

}
