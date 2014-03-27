package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;

import org.testng.annotations.Test;

public class ContactRemovalTest extends TestBase {
	
	@Test
	public void deleteSomeContact() {
		app.getNavigationHelper().openMainPage();
		
		 //save old state
			List<ContactParameters> oldList =  app.getContactHelper().getContacts();
			
		app.getContactHelper().initContactModification(0);
		app.getContactHelper().deleteContact();
	    app.getNavigationHelper().returnToHomePage();
	    
	    // save new state  
	    List<ContactParameters> newList =  app.getContactHelper().getContacts();
	    
	    // compare states 
	    oldList.remove(0);
	    Collections.sort(oldList);
	    assertEquals(newList, oldList);
	}
}