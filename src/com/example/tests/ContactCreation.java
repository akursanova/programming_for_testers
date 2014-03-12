package com.example.tests;


import org.testng.annotations.Test;

@Test
public class ContactCreation extends TestBase {


  public void test—ontaÒt—reation() throws Exception {
    app.navigationHelper.openMainPage();
    app.contactHelper.gotonewContact();
    ContactParameters contact = new ContactParameters();
    contact.firstname = "firstname";
    contact.lastname = "lastname";
    contact.address = "address";
    contact.home = "home";
    contact.mobile = "mobile";
    contact.work = "work";
    contact.second_home = "second_home";
    contact.email = "email";
    contact.email2 = "email2";
    contact.birthday = "10";
    contact.bmonth = "June";
    contact.byear = "1988";
    contact.some_group = "test group";
    contact.address2 = "address2";
    contact.phone2 = "phone2";
    
    app.contactHelper.fillFormContact(contact);
    app.navigationHelper.gotoHomePage();
  }
  
}
