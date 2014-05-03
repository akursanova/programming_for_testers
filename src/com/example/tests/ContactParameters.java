package com.example.tests;

public class ContactParameters implements Comparable<ContactParameters> {
	private String id;
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
		return "ContactParameters [lastname=" + lastname + "]";
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
		
		  if (lastname == null) {
			   if (other.lastname != null)
			    return false;
			  } else if (!lastname.equals(other.lastname))
			   return false;
		
		return true;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}


	public String getFirstname() {
		return firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public String getAddress() {
		return address;
	}

	public String getHomePhone() {
		return homePhone;
	}

	public String getMobile() {
		return mobile;
	}

	public String getWork() {
		return work;
	}

	public String getSecond_home() {
		return second_home;
	}

	public String getEmail() {
		return email;
	}

	public String getEmail2() {
		return email2;
	}

	public String getBirthday() {
		return birthday;
	}

	public String getBmonth() {
		return bmonth;
	}

	public String getByear() {
		return byear;
	}

	public String getAddress2() {
		return address2;
	}

	public String getPhone2() {
		return phone2;
	}		
	

	@Override
	public int compareTo(ContactParameters other) {
				return this.lastname.toLowerCase().compareTo(other.lastname.toLowerCase());
						 
	}
	
	public ContactParameters withFirstname(String firstname) {
		this.firstname = firstname;
		return this;
	}
	
	public ContactParameters withLastname(String lastname) {
		this.lastname = lastname;
		return this;
	}
	
	public ContactParameters withAddress(String address) {
		this.address = address;
		return this;
	}

	public ContactParameters withHomePhone(String homePhone) {
		this.homePhone = homePhone;
		return this;
	}

	public ContactParameters withMobile(String mobile) {
		this.mobile = mobile;
		return this;
	}

	public ContactParameters withWork(String work) {
		this.work = work;
		return this;
	}
	
	public ContactParameters withSecond_home(String second_home) {
		this.second_home = second_home;
		return this;
	}

	public ContactParameters withEmail(String email) {
		this.email = email;
		return this;
	}

	public ContactParameters withEmail2(String email2) {
		this.email2 = email2;
		return this;
	}

	public ContactParameters withBirthday(String birthday) {
		this.birthday = birthday;
		return this;
	}

	public ContactParameters withBmonth(String bmonth) {
		this.bmonth = bmonth;
		return this;
	}

	public ContactParameters withByear(String byear) {
		this.byear = byear;
		return this;
	}

	public ContactParameters withAddress2(String address2) {
		this.address2 = address2;
		return this;
	}

	public ContactParameters withPhone2(String phone2) {
		this.phone2 = phone2;
		return this;
	}	
	
	public ContactParameters withId(String id) {
		this.id = id;
		return this;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setHomePhone(String homePhone) {
		this.homePhone = homePhone;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public void setWork(String work) {
		this.work = work;
	}

	public void setSecond_home(String second_home) {
		this.second_home = second_home;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setEmail2(String email2) {
		this.email2 = email2;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public void setBmonth(String bmonth) {
		this.bmonth = bmonth;
	}

	public void setByear(String byear) {
		this.byear = byear;
	}

	public void setSome_group(String some_group) {
		this.some_group = some_group;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public void setPhone2(String phone2) {
		this.phone2 = phone2;
	}
	
}