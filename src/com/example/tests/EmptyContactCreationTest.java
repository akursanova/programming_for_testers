package com.example.tests;


import org.testng.annotations.Test;

@Test
public class EmptyContactCreationTest extends TestBase  {
	
	  public void testEmptyConta�tCreation() throws Exception {
		    app.getNavigationHelper().openMainPage();
		    app.getContactHelper().initNewContactCreation();
		    app.getContactHelper().submitContactCreation();
		    app.getNavigationHelper().returnToHomePage();
		  }

}
