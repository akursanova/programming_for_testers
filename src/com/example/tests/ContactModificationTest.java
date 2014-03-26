package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;

import org.testng.annotations.Test;

public class ContactModificationTest extends TestBase {
	
	@Test
	public void modifySomeContact() {
	app.getNavigationHelper().openMainPage();
	
	 //save old state
		List<ContactParameters> oldList =  app.getContactHelper().getContacts();
		
	int index = 1;	
	app.getContactHelper().initContactModification(index);
	ContactParameters contact = new ContactParameters();
	contact.firstname = "1111";
	contact.lastname = "2222";
	app.getContactHelper().fillFormContact(contact);
	app.getContactHelper().submitContactModification();
    app.getNavigationHelper().returnToHomePage();
    
    // save new state  
    List<ContactParameters> newList =  app.getContactHelper().getContacts();
    
    // compare states 
    oldList.remove(index-1);
    oldList.add(index-1,contact);
    Collections.sort(oldList);
    assertEquals(newList, oldList);
		
	}
	
}
