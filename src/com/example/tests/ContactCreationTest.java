package com.example.tests;


import org.testng.annotations.Test;

@Test
public class ContactCreationTest extends TestBase {


  public void test—ontaÒt—reation() throws Exception {
	  
	app.getNavigationHelper().openMainPage();
	app.getContactHelper().initNewContactCreation();
	
    ContactParameters contact = new ContactParameters();
    contact.firstname = "firstname";
    contact.lastname = "lastname";
    contact.address = "address";
    contact.homePhone = "home";
    contact.mobile = "mobile";
    contact.work = "work";
    contact.second_home = "second_home";
    contact.email = "email";
    contact.email2 = "email2";
    contact.birthday = "10";
    contact.bmonth = "June";
    contact.byear = "1988";
    contact.some_group = "Rob";
    contact.address2 = "address2";
    contact.phone2 = "phone2";
    
    app.getContactHelper().fillFormContact(contact);
    app.getContactHelper().submitContactCreation();
    app.getNavigationHelper().returnToHomePage();
  }
  
}
