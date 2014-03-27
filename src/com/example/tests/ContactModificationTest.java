package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.testng.annotations.Test;

public class ContactModificationTest extends TestBase {
	
	@Test(dataProvider = "randomValidContactGenerator")
	public void modifySomeContact(ContactParameters contact) {
	app.getNavigationHelper().openMainPage();
	
	 //save old state
		List<ContactParameters> oldList =  app.getContactHelper().getContacts();
		
		Random rnd = new Random();
	    int index = rnd.nextInt(oldList.size());
		
	app.getContactHelper().initContactModification(index+1);
	app.getContactHelper().fillFormContact(contact);
	app.getContactHelper().submitContactModification();
    app.getNavigationHelper().returnToHomePage();
    
    // save new state  
    List<ContactParameters> newList =  app.getContactHelper().getContacts();
    
    // compare states 
    oldList.remove(index);
    oldList.add(contact);
    Collections.sort(oldList);
    assertEquals(newList, oldList);
		
	}
	
}
