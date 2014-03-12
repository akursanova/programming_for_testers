package com.example.tests;

public class ContactParameters {
	public String firstname;
	public String lastname;
	public String address;
	public String home;
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

	public ContactParameters(String firstname, String lastname, String address,
			String home, String mobile, String work, String second_home,
			String email, String email2, String birthday, String bmonth,
			String byear, String some_group, String address2, String phone2) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.address = address;
		this.home = home;
		this.mobile = mobile;
		this.work = work;
		this.second_home = second_home;
		this.email = email;
		this.email2 = email2;
		this.birthday = birthday;
		this.bmonth = bmonth;
		this.byear = byear;
		this.some_group = some_group;
		this.address2 = address2;
		this.phone2 = phone2;
	}
	public ContactParameters() {
	
	}
}