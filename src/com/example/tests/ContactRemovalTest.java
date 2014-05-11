package com.example.tests;
import java.util.Random;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.*;

import com.example.utils.SortedListOf;
import org.testng.annotations.Test;

public class ContactRemovalTest extends TestBase {
	
	@Test(dataProvider = "randomValidContactGenerator")
	public void deleteSomeContact(ContactParameters contact) {
		app.navigateTo().mainPage();
		
		 //save old state
		SortedListOf<ContactParameters> oldList =  app.getModel().getContacts();
			
		Random rnd = new Random();
		int index = rnd.nextInt(oldList.size());
			
		app.getContactHelper().deleteContact(index);
	    
	    // save new state  
		SortedListOf<ContactParameters> newList =  app.getModel().getContacts();
	    
	    // compare states 
	    assertThat(newList,equalTo(oldList.without(index)));
	    
	    //assertThat(app.getModel().getContacts(), equalTo(app.getHibernateHelper().listContacts()));
	    //assertThat(app.getModel().getContacts(), equalTo(app.getContactHelper().getUiContacts()));
	    
	    assertThat(newList, equalTo(app.getHibernateHelper().listContacts()));
	    
	}
}