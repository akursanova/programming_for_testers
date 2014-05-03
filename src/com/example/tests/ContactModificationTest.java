package com.example.tests;
import java.util.Random;
import org.testng.annotations.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.*;

import com.example.utils.SortedListOf;

public class ContactModificationTest extends TestBase {
	
	@Test(dataProvider = "randomValidContactGenerator")
	public void modifySomeContact(ContactParameters contact) {
		
	//save old state
	SortedListOf<ContactParameters> oldList =  app.getContactHelper().getUiContacts();
		
	Random rnd = new Random();
	int index = rnd.nextInt(oldList.size());
		
	app.getContactHelper().modifyContact(contact, index);
    
    // save new state  
	SortedListOf<ContactParameters> newList =  app.getContactHelper().getUiContacts();
    
    // compare states 
    assertThat(newList,equalTo(oldList.without(index).withAdded(contact)));
		
    assertThat(app.getModel().getContacts(), equalTo(app.getHibernateHelper().listContacts()));
    //assertThat(app.getModel().getContacts(), equalTo(app.getContactHelper().getUiContacts()));
    
	}
}
