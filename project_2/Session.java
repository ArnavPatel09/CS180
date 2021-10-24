package project_2;
/**
* Project 2 - Session
* The Session class represents an individual session
* in a lab. This includes fields like name and enrollment.
* And methods like getters, setters, and toString.
*
* Purdue University -- CS18000 -- Fall 2021 -- Project 02
*
* @author Arnav Patel L12
* @version October 16, 2021
*/


/* 
 * calculateTotalUtil is wrong
 * listReserved wrong (had an extra /n)
 *   - last letter gets cut off
 * listAvailable wrong (had an extra /n)
 *   - last letter gets cut off for listAvailable
 *   
 *   
 * calculateTotalAvailable seats gave -55 instead of 55
 * remove reservation --> invalid time does not work... always says reservation removed
 * check listReservations (says no reservations when there are reservations
*/
public class Session {
	//fields
	private String name;
	private int enrollment;
	
	//constructor
	public Session() { 
		name = "";
		enrollment = 0;
	}
	
	public Session(String name, int enrollment) { 
		this.name = name;
		this.enrollment = enrollment;
	}
	
	//methods
	public String getName() { 
		return name;
	}
	
	public int getEnrollment() { 
		return enrollment;
	}
	
	public void setName(String name) { 
		this.name = name;
	}
	
	public void setEnrollment(int enrollment) { 
		this.enrollment = enrollment;
	}
	
	public String toString() { 
		return String.format("Session{Name - %s, Enrollment - %d}", name, enrollment);
	}
}
