package com.example.tests;

import static org.testng.Assert.assertEquals;
import java.util.Collections;
import java.util.List;
import org.testng.annotations.Test;
import static com.example.fw.ContactHelper.CREATION;

@Test(dataProvider = "randomValidContactGenerator")
public class ContactCreationTest extends TestBase {

  public void testContactCreation(ContactParameters contact) throws Exception {
	  
	app.navigateTo().mainPage();
	
	 //save old state
	List<ContactParameters> oldList =  app.getContactHelper().getContacts();
	
	 // actions
	app.getContactHelper().initNewContactCreation();
	
    app.getContactHelper().fillFormContact(contact, CREATION);
    
    app.getContactHelper().submitContactCreation();
    
    app.navigateTo().returnToHomePage();
    
    // save new state  
    List<ContactParameters> newList =  app.getContactHelper().getContacts();
    
    // compare states 
    oldList.add(contact);
    Collections.sort(oldList);
    assertEquals(newList, oldList);
    
  }
  
}
