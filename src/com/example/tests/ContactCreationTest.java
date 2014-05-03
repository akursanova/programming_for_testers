package com.example.tests;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static com.example.tests.ContactDataGenerator.loadContactsFromCsvFile;
import static com.example.tests.ContactDataGenerator.loadContactsFromXmlFile;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.*;
import com.example.utils.SortedListOf;


public class ContactCreationTest extends TestBase {
	
	@DataProvider
	public Iterator<Object[]> contactsFromFile() throws IOException {
		return wrapContactsForDataProvider(loadContactsFromCsvFile(new File("contact.csv"))).iterator();
	}
	
	@Test(dataProvider = "contactsFromFile")
	public void testContactCreation(ContactParameters contact) throws Exception {
	  
	 //save old state
	 SortedListOf<ContactParameters> oldList =  app.getContactHelper().getUiContacts();
	 
	 // actions
    app.getContactHelper().createContact(contact);
        
    // save new state  
    SortedListOf<ContactParameters> newList =  app.getContactHelper().getUiContacts();
    
    // compare states 
    assertThat(newList,equalTo(oldList.withAdded(contact)));
    
       
    assertThat(app.getModel().getContacts(), equalTo(app.getHibernateHelper().listContacts()));
    //assertThat(app.getModel().getContacts(), equalTo(app.getContactHelper().getUiContacts()));
    
  }
  
}
