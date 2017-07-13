/* POJO class for accessing the visitor table*
 * 
 */
package libraryDatabaseUtility.model;

import java.util.Date;

/**
 * @author Flavio Luis
 *
 */
public class Visitor {
	private long visitorId;
	private String firstName;
	private String lastName;
	private Date dateOfvisit;
	private Date timeIn;
	private Date timeout;
	
	public Visitor() {
		
	}

	/**
	 * @param firstName
	 * @param lastName
	 * @param dateOfvisit
	 * @param timeIn
	 */
	public Visitor(String firstName, String lastName, Date dateOfvisit, Date timeIn) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfvisit = dateOfvisit;
		this.timeIn = timeIn;
	}

	/**
	 * @return the visitorId
	 */
	public long getVisitorId() {
		return visitorId;
	}

	/**
	 * @param visitorId the visitorId to set
	 */
	public void setVisitorId(long visitorId) {
		this.visitorId = visitorId;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the dateOfvisit
	 */
	public Date getDateOfvisit() {
		return dateOfvisit;
	}

	/**
	 * @param dateOfvisit the dateOfvisit to set
	 */
	public void setDateOfvisit(Date dateOfvisit) {
		this.dateOfvisit = dateOfvisit;
	}

	/**
	 * @return the timeIn
	 */
	public Date getTimeIn() {
		return timeIn;
	}

	/**
	 * @param timeIn the timeIn to set
	 */
	public void setTimeIn(Date timeIn) {
		this.timeIn = timeIn;
	}

	/**
	 * @return the timeout
	 */
	public Date getTimeout() {
		return timeout;
	}

	/**
	 * @param timeout the timeout to set
	 */
	public void setTimeout(Date timeout) {
		this.timeout = timeout;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (visitorId ^ (visitorId >>> 32));
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
		Visitor other = (Visitor) obj;
		if (visitorId != other.visitorId)
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Visitor Id: " + visitorId + 
				"\nFirst Name: " + firstName + 
				"\nLast Name: " + lastName
				+ "\nDate of Visit: " + dateOfvisit + 
				"\nTime In: " + timeIn + 
				"\nTime Out: " + timeout;
	}
	
}
