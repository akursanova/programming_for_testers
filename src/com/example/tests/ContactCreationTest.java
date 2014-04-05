package com.example.tests;
import org.testng.annotations.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.*;

import com.example.utils.SortedListOf;

@Test(dataProvider = "randomValidContactGenerator")
public class ContactCreationTest extends TestBase {

  public void testContactCreation(ContactParameters contact) throws Exception {
	  
	 //save old state
	 SortedListOf<ContactParameters> oldList =  app.getContactHelper().getContacts();
	
	 // actions
    app.getContactHelper().createContact(contact);
        
    // save new state  
    SortedListOf<ContactParameters> newList =  app.getContactHelper().getContacts();
    
    // compare states 
    assertThat(newList,equalTo(oldList.withAdded(contact)));
  }
  
}
