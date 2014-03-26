package com.example.tests;

public class ContactParameters implements Comparable<ContactParameters> {
	public String firstname;
	public String lastname;
	public String address;
	public String homePhone;
	public String mobile;
	public String work;
	public String second_home;
	public String email;
	public String email2;
	public String birthday;
	public String bmonth;
	public String byear;
	public String some_group;
	public String address2;
	public String phone2;

	public ContactParameters() {
	
	}
	
	@Override
	public String toString() {
		return "ContactParameters [firstname=" + firstname + ",lastname=" + lastname + "]";
	}
	
	
	@Override
	public int hashCode() {
		//final int prime = 31;
		int result = 1;
		//result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ContactParameters other = (ContactParameters) obj;
		if (firstname == null) {
			if (other.firstname != null)
				return false;
		} else if (!firstname.equals(other.firstname))
			return false;
		return true;
	}


	@Override
	public int compareTo(ContactParameters other) {
		return this.firstname.toLowerCase().compareTo(other.firstname.toLowerCase());
	}		
	
}