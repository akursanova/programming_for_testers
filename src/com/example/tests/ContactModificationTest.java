package com.example.tests;

import org.testng.annotations.Test;

public class ContactModificationTest extends TestBase {
	
	@Test
	public void modifySomeContact() {
	app.getNavigationHelper().openMainPage();
	app.getContactHelper().initContactModification(15);
	ContactParameters contact = new ContactParameters();
	contact.firstname = "new firstname";
	app.getContactHelper().fillFormContact(contact);
	app.getContactHelper().submitContactModification();
    app.getNavigationHelper().returnToHomePage();
		
	}
	
}
