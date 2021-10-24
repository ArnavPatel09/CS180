package project_2;
/**
* Project 2 - LabManager
* 
* the LabManager class manages 3 labs as well as various methods.
* This includes getters and setters, toString, calculateTotalCapacity,
* calculateTotalUtilization, and calculateAvailableSeats
*
* Purdue University -- CS18000 -- Fall 2021 -- Project 02
*
* @author Arnav Patel L12
* @version October 16, 2021
*/
public class LabManager {
	//fields
	private Lab labOne;
	private Lab labTwo;
	private Lab labThree;
	
	//constructor
	public LabManager(Lab labOne, Lab labTwo, Lab labThree) { 
		this.labOne = labOne;
		this.labTwo = labTwo;
		this.labThree = labThree;
	}
	
	//methods
	public Lab getLabOne() {
		return labOne;
	}
	
	public Lab getLabTwo() { 
		return labTwo;
	}
	
	public Lab getLabThree() { 
		return labThree;
	}
	
	public void setLabOne(Lab labOne) { 
		this.labOne = labOne;
	}
	
	public void setLabTwo(Lab labTwo) {
		this.labTwo = labTwo;
	}
	
	public void setLabThree(Lab labThree) { 
		this.labThree = labThree;
	}
	
	public int calculateTotalCapacity() { 
		return (labOne.getCapacity() * 2) + (labTwo.getCapacity() * 2) + (labThree.getCapacity() * 2);
	}
	
	public double calculateTotalUtilization() { 
		double numerator = labOne.getMorning().getEnrollment() + labOne.getAfternoon().getEnrollment();
		numerator += labTwo.getMorning().getEnrollment() + labTwo.getAfternoon().getEnrollment();
		numerator += labThree.getMorning().getEnrollment() + labThree.getAfternoon().getEnrollment();
		return numerator / calculateTotalCapacity();
	}
	
	public int calculateAvailableSeats() { 
		int seats = labOne.getMorning().getEnrollment() + labOne.getAfternoon().getEnrollment();
		seats +=  labTwo.getMorning().getEnrollment() + labTwo.getAfternoon().getEnrollment();
		seats +=  labThree.getMorning().getEnrollment() + labThree.getAfternoon().getEnrollment();
		seats -= calculateTotalCapacity();
		seats *= -1;
		
		return seats;
	}
	
	public String listReservedLabs() { 
		String s = "Lab One\n";
		s += labOne.listReservations();
		if (s.substring(s.length() - 15).equals("No Reservations")) 
			s += "\n";
		s += "Lab Two \n";
		s += labTwo.listReservations();
		if (s.substring(s.length() - 15).equals("No Reservations")) 
			s += "\n";
		s += "Lab Three \n";
		s += labThree.listReservations();
		if (!(s.substring(s.length() - 15).equals("No Reservations"))) 
			s = s.substring(0, s.length() - 1);
		
		return s;
		
		
	}
	
	public String listAvailableLabs() { 
		String s = "Lab One\n";
		s += labOne.listAvailabilities();
		if (s.substring(s.length() - 15).equals("No Availabilities")) 
			s += "\n";
		s += "Lab Two \n";
		s += labTwo.listAvailabilities();
		if (s.substring(s.length() - 15).equals("No Availabilities")) 
			s += "\n";
		s += "Lab Three \n";
		s += labThree.listAvailabilities();
		if (!(s.substring(s.length() - 15).equals("No Availabilities"))) 
			s = s.substring(0, s.length() - 1);
		
		return s;
	}
	
	public String addReservation(String location, String time, String name, int enrollment) { 
		//returns a message based on outcome
		//check for enrollment and capacity
		// time invalid
		// location invalid
		
		//check for labOne location
		if (labOne.getLocation().equalsIgnoreCase(location)) { 
			if (time.equalsIgnoreCase("morning")) { 
				if (labOne.getMorning().getEnrollment() == 0) { 
					if (enrollment <= labOne.getCapacity()) { 
						labOne.getMorning().setEnrollment(enrollment);
						labOne.getMorning().setName(name);
						return "Reservation added!";
					} else { 
						return "Error. Capacity exceeded";
						// invalid enrollment
					}
				}
			} else if (time.equalsIgnoreCase("afternoon")) { 
				if (labOne.getAfternoon().getEnrollment() == 0) { 
					if (enrollment <= labOne.getCapacity()) { 
						labOne.getAfternoon().setEnrollment(enrollment);
						labOne.getAfternoon().setName(name);
						return "Reservation added!";
					} else { 
						return "Error. Capacity exceeded";
						// invalid enrollment
					}
				}
			} else {
				return "Error. Invalid time.";
				//invalid time
			}
		} else if (labTwo.getLocation().equalsIgnoreCase(location)) { 
			if (time.equalsIgnoreCase("morning")) { 
				if (labTwo.getMorning().getEnrollment() == 0) { 
					if (enrollment <= labTwo.getCapacity()) { 
						labTwo.getMorning().setEnrollment(enrollment);
						labTwo.getMorning().setName(name);
						return "Reservation added!";
					} else { 
						return "Error. Capacity exceeded";
						// invalid enrollment
					}
				}
			} else if (time.equalsIgnoreCase("afternoon")) { 
				if (labTwo.getAfternoon().getEnrollment() == 0) { 
					if (enrollment <= labTwo.getCapacity()) { 
						labTwo.getAfternoon().setEnrollment(enrollment);
						labTwo.getAfternoon().setName(name);
						return "Reservation added!";
					} else { 
						return "Error. Capacity exceeded";
						// invalid enrollment
					}
				}
			} else {
				return "Error. Invalid time.";
				//invalid time
			}
		} else if (labThree.getLocation().equalsIgnoreCase(location)) { 
			if (time.equalsIgnoreCase("morning")) { 
				if (labThree.getMorning().getEnrollment() == 0) { 
					if (enrollment <= labThree.getCapacity()) { 
						labThree.getMorning().setEnrollment(enrollment);
						labThree.getMorning().setName(name);
						return "Reservation added!";
					} else { 
						return "Error. Capacity exceeded";
						// invalid enrollment
					}
				}
			} else if (time.equalsIgnoreCase("afternoon")) { 
				if (labThree.getAfternoon().getEnrollment() == 0) { 
					if (enrollment <= labThree.getCapacity()) { 
						labThree.getAfternoon().setEnrollment(enrollment);
						labThree.getAfternoon().setName(name);
						return "Reservation added!";
					} else { 
						return "Error. Capacity exceeded";
						// invalid enrollment
					}
				}
			} else {
				return "Error. Invalid time.";
				//invalid time
			}
		}
		return "Error. Invalid location";
		//invalid location
	}
	
	public String removeReservation(String location, String time) { 
		//check each lab morning and afternoon and then set everything in that sesh to 0
		
		if (labOne.getLocation().equalsIgnoreCase(location)) { 
			if (time.equalsIgnoreCase("morning")) {
				if (labOne.getMorning().getEnrollment() != 0) {
					labOne.getMorning().setName("");
					labOne.getMorning().setEnrollment(0);
					return "Reservation removed!";
				} else {
					return "Error. Invalid time.";
				}
				
			} else if (time.equalsIgnoreCase("afternoon")) {
				//remove
				if (labOne.getAfternoon().getEnrollment() != 0) {
					labOne.getAfternoon().setName("");
					labOne.getAfternoon().setEnrollment(0);
					return "Reservation removed!";
				} else {
					return "Error. Invalid time.";
				}
			} else { 
				//wrong time Error. Time invalid
				return "Error. Invalid time.";
			}
		} else if (labTwo.getLocation().equalsIgnoreCase(location)) { 
			if (time.equalsIgnoreCase("morning")) {
				//remove
				if (labTwo.getMorning().getEnrollment() != 0) {
					labTwo.getMorning().setName("");
					labTwo.getMorning().setEnrollment(0);
					return "Reservation removed!";
				} else {
					return "Error. Invalid time.";
				}
			} else if (time.equalsIgnoreCase("afternoon")) {
				//remove
				if (labTwo.getAfternoon().getEnrollment() != 0) {
					labTwo.getAfternoon().setName("");
					labTwo.getAfternoon().setEnrollment(0);
					return "Reservation removed!";
				} else {
					return "Error. Invalid time.";
				}
			} else { 
				//wrong time Error. Time invalid
				return "Error. Invalid time.";
			}
		} else if (labThree.getLocation().equalsIgnoreCase(location)) { 
			if (time.equalsIgnoreCase("morning")) {
				//remove
				if (labThree.getMorning().getEnrollment() != 0) {
					labThree.getMorning().setName("");
					labThree.getMorning().setEnrollment(0);
					return "Reservation removed!";
				} else {
					return "Error. Invalid time.";
				}
			} else if (time.equalsIgnoreCase("afternoon")) {
				//remove
				if (labThree.getAfternoon().getEnrollment() != 0) {
					labThree.getAfternoon().setName("");
					labThree.getAfternoon().setEnrollment(0);
					return "Reservation removed!";
				} else {
					return "Error. Invalid time.";
				}
			} else { 
				//wrong time Error. Time invalid
				return "Error. Invalid time.";
			}
		} else {
			//wrong location; Error. Invalid location
			return "Error. Invalid location";
		}
	}
	
	public String modifyReservation(String location, String time, String name, int enrollment) { 
		if (labOne.getLocation().equalsIgnoreCase(location)) { 
			if (time.equalsIgnoreCase("morning")) {
				if (labOne.getMorning().getEnrollment() > 0) {
					if (enrollment <= labOne.getCapacity()) {
						//reservation modify
						labOne.getMorning().setEnrollment(enrollment);
						labOne.getMorning().setName(name);
						return "Reservation modified!";
					} else {
						return "Error. Capacity exceeded";
					}
				} else {
					return "Error. Invalid Time";
				}
				
			} else if (time.equalsIgnoreCase("afternoon")) { 
				if (labOne.getAfternoon().getEnrollment() > 0) { 
					if (enrollment <= labOne.getCapacity()) { 
						labOne.getAfternoon().setEnrollment(enrollment);
						labOne.getAfternoon().setName(name);
						return "Reservation modified!";
					} else
						return "Error. Capacity exceeded";
				} else {
					return "Error. Invalid time.";
				}
			} else { 
				//wrong capacity. 
				return "Error. Invalid time."; 
			}
		} else if (labTwo.getLocation().equalsIgnoreCase(location)) { 
			if (time.equalsIgnoreCase("morning")) {
				if (labTwo.getMorning().getEnrollment() > 0) {
					if (enrollment <= labTwo.getCapacity()) {
						//reservation modify
						labTwo.getMorning().setEnrollment(enrollment);
						labTwo.getMorning().setName(name);
						return "Reservation modified!";
					} else {
						return "Error. Capacity exceeded";
					}
				} else {
					return "Error. Invalid Time";
				}
				
			} else if (time.equalsIgnoreCase("afternoon")) { 
				if (labTwo.getAfternoon().getEnrollment() > 0) { 
					if (enrollment <= labTwo.getCapacity()) { 
						labTwo.getAfternoon().setEnrollment(enrollment);
						labTwo.getAfternoon().setName(name);
						return "Reservation modified!";
					} else
						return "Error. Capacity exceeded";
				} else {
					return "Error. Invalid time.";
				}
			} else { 
				//wrong capacity. 
				return "Error. Invalid time."; 
			}
		} else if (labThree.getLocation().equalsIgnoreCase(location)) { 
			if (time.equalsIgnoreCase("morning")) {
				if (labThree.getMorning().getEnrollment() > 0) {
					if (enrollment <= labThree.getCapacity()) {
						//reservation modify
						labThree.getMorning().setEnrollment(enrollment);
						labThree.getMorning().setName(name);
						return "Reservation modified!";
					} else {
						return "Error. Capacity exceeded";
					}
				} else {
					return "Error. Invalid Time";
				}
				
			} else if (time.equalsIgnoreCase("afternoon")) { 
				if (labThree.getAfternoon().getEnrollment() > 0) { 
					if (enrollment <= labThree.getCapacity()) { 
						labThree.getAfternoon().setEnrollment(enrollment);
						labThree.getAfternoon().setName(name);
						return "Reservation modified!";
					} else
						return "Error. Capacity exceeded";
				} else {
					return "Error. Invalid time.";
				}
			} else { 
				//wrong capacity. 
				return "Error. Invalid time."; 
			}
		} else { 
			//wrong location
			return "Error. Invalid location";
		}
	}
	
	public String toString() { 
		return "LabManager{" + labOne.toString() + "," + labTwo.toString() + "," + labThree.toString() + "}";
	}
	
}
 