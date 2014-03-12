package com.example.tests;


import org.testng.annotations.Test;

@Test
public class EmptyContactCreation extends TestBase  {
	  public void Empty—ontaÒt—reation() throws Exception {
		    app.navigationHelper.openMainPage();
		    app.contactHelper.gotonewContact();
		    app.contactHelper.fillFormContact(new ContactParameters("", "", "", "", "", "", "", "", "", "-", "-", "", "[none]", "", ""));
		    app.navigationHelper.gotoHomePage();
		  }

}
