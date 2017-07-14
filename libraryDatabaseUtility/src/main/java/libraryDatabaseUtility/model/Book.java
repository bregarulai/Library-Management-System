/* POJO class for book object*
 * 
 */
package libraryDatabaseUtility.model;

import java.sql.Date;

/**
 * @author Flavio Luis
 *
 */
public class Book {
	private long bookId;
	private String bookTitle;
	private String bookAuthor;
	private boolean available;
	private Date checkoutDate;
	private Date returnedDate;
	private long memberId;
	
	
	public Book() {
		
	}


	/**
	 * @param bookId
	 * @param bookTitle
	 * @param bookAuthor
	 */
	public Book(long bookId, String bookTitle, String bookAuthor) {
		this.bookId = bookId;
		this.bookTitle = bookTitle;
		this.bookAuthor = bookAuthor;
	}


	/**
	 * @return the bookId
	 */
	public long getBookId() {
		return bookId;
	}


	/**
	 * @param bookId the bookId to set
	 */
	public void setBookId(long bookId) {
		this.bookId = bookId;
	}


	/**
	 * @return the bookTitle
	 */
	public String getBookTitle() {
		return bookTitle;
	}


	/**
	 * @param bookTitle the bookTitle to set
	 */
	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}


	/**
	 * @return the bookAuthor
	 */
	public String getBookAuthor() {
		return bookAuthor;
	}


	/**
	 * @param bookAuthor the bookAuthor to set
	 */
	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}


	/**
	 * @return the available
	 */
	public boolean isAvailable() {
		return available;
	}


	/**
	 * @param available the available to set
	 */
	public void setAvailable(boolean available) {
		this.available = available;
	}


	/**
	 * @return the checkoutDate
	 */
	public Date getCheckoutDate() {
		return checkoutDate;
	}


	/**
	 * @param date the checkoutDate to set
	 */
	public void setCheckoutDate(Date date) {
		this.checkoutDate = date;
	}


	/**
	 * @return the returnedDate
	 */
	public Date getReturnedDate() {
		return returnedDate;
	}


	/**
	 * @param date the returnedDate to set
	 */
	public void setReturnedDate(Date date) {
		this.returnedDate = date;
	}


	/**
	 * @return the memberId
	 */
	public long getMemberId() {
		return memberId;
	}


	/**
	 * @param memberId the memberId to set
	 */
	public void setMemberId(long memberId) {
		this.memberId = memberId;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (bookId ^ (bookId >>> 32));
		return result;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		if (bookId != other.bookId)
			return false;
		return true;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Book Id: " + bookId + 
				"\nBook Title: " + bookTitle + 
				"\nBook Author: " + bookAuthor + 
				"\nAvailable: " + available + 
				"\nCheckout Date: " + checkoutDate + 
				"\nReturned Date: " + returnedDate + 
				"\nMember Id: "+ memberId;
	}
	
	
}
