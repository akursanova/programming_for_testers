package com.example.tests;


import org.testng.annotations.Test;

@Test
public class EmptyContactCreation extends TestBase  {
	  public void Empty—ontaÒt—reation() throws Exception {
		    openMainPage();
		    gotonewContact();
		    fillFormContact(new ContactParameters("", "", "", "", "", "", "", "", "", "-", "-", "", "[none]", "", ""));
		    gotoHomePage();
		  }

}
