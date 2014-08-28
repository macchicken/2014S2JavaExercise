package dto;

import java.util.Calendar;
import java.util.Date;

public class Person {
	
	private String firstname;
	private String surname;
	private Date dateOfBirth;
	
	public Person(String firstname,String surname,String dateOfBirth){
		this.firstname=firstname;
		this.surname=surname;
		String[] temp=dateOfBirth.split(",");
		Calendar instance=Calendar.getInstance();
		instance.set(Integer.parseInt(temp[2]), Integer.parseInt(temp[1].trim()),
			Integer.parseInt(temp[0].trim()), 0, 0, 0);
		this.dateOfBirth=instance.getTime();
	}
	
	public String getSurname() {
		return surname;
	}
	public String getFirstname() {
		return firstname;
	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}


}
