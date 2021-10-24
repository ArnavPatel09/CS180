package project_2;
/**
* Project 2 - Lab
* The lab class represents details on a lab's sessions
* This includes the morning and afternoon session
* the capacity and the location. The methods included
* in this class are getters, setters, toString, listAvailabilities
* (which returns a string of the Sessions that are available), and
* listReserved (which returns a string of the Sessions that are reserved)
*
* Purdue University -- CS18000 -- Fall 2021 -- Project 02
*
* @author Arnav Patel L12
* @version October 16, 2021
*/
public class Lab { 
	//fields
	private Session morning;
	private Session afternoon;
	private int capacity;
	private String location;
	
	//constructor
	public Lab(int capacity, String location) { 
		this.capacity = capacity;
		this.location = location;
		morning = new Session();
		afternoon = new Session();
	}
	
	public Lab(Session morning, Session afternoon, int capacity, String location) { 
		this.morning = morning;
		this.afternoon = afternoon;
		this.capacity = capacity;
		this.location = location;
	}
	
	//methods
	public Session getMorning() { 
		return morning;
	}
	
	public Session getAfternoon() { 
		return afternoon;
	}
	
	public int getCapacity() { 
		return capacity;
	}
	
	public String getLocation() { 
		return location;
	}
	
	public void setMorning(Session morning) { 
		this.morning = morning;
	}
	
	public void setAfternoon(Session afternoon) { 
		this.afternoon = afternoon;
	}
	
	public void setCapacity(int capacity) { 
		this.capacity = capacity;
	}
	
	public void setLocation(String location) { 
		this.location = location;
	}
	
	public String listAvailabilities() {
		String s = "";
		if (morning.getEnrollment() == 0) 
			s = "Morning: Available\n";
		if (afternoon.getEnrollment() == 0) 
			s += "Afternoon: Available\n";
		else if (morning.getEnrollment() != 0)
			s = "No Availabilities";
		
		return s;
	}
	
	public String listReservations() { 
		String s = "";
		if (morning.getEnrollment() > 0) 
			s = "Morning: Reserved\n";
		if (afternoon.getEnrollment() > 0) 
			s += "Afternoon: Reserved\n";
		else if (!(morning.getEnrollment() > 0))
			s = "No Reservations";
		
		return s;
	}
	
	public String toString() { 
		String s = String.format("Lab{Capacity - %d, Location - %s, Morning: ", capacity, location);
		if (morning.getEnrollment() == 0) { 
			s += "Available,";
		} else {
			s += morning.toString() + "}, ";
		}
		s += " Afternoon: ";
		if (afternoon.getEnrollment() == 0) { 
			s += "Available}";
		} else {
			s += afternoon.toString() + "}";
		}
		return s;
	}
	
}
