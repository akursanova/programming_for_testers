package com.example.tests;

import org.testng.annotations.Test;

public class ContactModificationTest extends TestBase {
	
	@Test
	public void modifySomeContact() {
	app.getNavigationHelper().openMainPage();
	app.getContactHelper().initContactModification(1);
	ContactParameters contact = new ContactParameters();
	contact.firstname = "new firstname alarm";
	app.getContactHelper().fillFormContact(contact);
	app.getContactHelper().submitContactModification();
    app.getNavigationHelper().returnToHomePage();
		
	}
	
}
