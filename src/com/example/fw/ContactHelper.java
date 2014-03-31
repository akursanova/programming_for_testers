package com.example.fw;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import com.example.tests.ContactParameters;

public class ContactHelper extends HelperBase  {
	
	public static boolean CREATION = true;
	public static boolean MODIFICATION = false;

	public ContactHelper(ApplicationManager manager) {
		super(manager);
			}

	public void fillFormContact(ContactParameters contact, boolean formType) {
		type(By.name("firstname"),contact.firstname);
		type(By.name("lastname"),contact.lastname);
	    type(By.name("address"),contact.address);
	    type(By.name("home"),contact.homePhone);
  	    type(By.name("mobile"),contact.mobile);
	    type(By.name("work"),contact.work);    
	    type(By.name("home"),contact.second_home);    
	    type(By.name("email"),contact.email);	    
	    type(By.name("email2"),contact.email2);	    
	    selectByText(By.name("bday"), contact.birthday);		   
	    selectByText(By.name("bmonth"), contact.bmonth);	        
	    type(By.name("byear"),contact.byear);
	    if (formType == CREATION) {
	    //selectByText(By.name("new_group"), contact.some_group);	 
	    } else {
	    	if (driver.findElements(By.name("new_group")).size() !=0) {
	    		throw new Error("Group selector exists in contact modification form");
	    	}
	    }
	    
	    
	    type(By.name("address2"),contact.address2);   
	    type(By.name("phone2"),contact.phone2);

	   	}

		public void submitContactCreation() {
		click(By.name("submit"));
	}

		public void initNewContactCreation() {
		click(By.linkText("add new"));
	}
		
		public void initContactModification(int index) {
			
			click(By.xpath("//tr["+ (index+1) +"]//a[contains(@href,'edit')]"));

		}
		
		public void submitContactModification() {
			click(By.xpath("//input[@value='Update']"));
			
		}
		
		public void deleteContact() {
			click(By.xpath("//input[@value='Delete']"));

		}

		public List<ContactParameters> getContacts() {
			List<ContactParameters> contacts = new ArrayList<ContactParameters>();
			List<WebElement> lines = driver.findElements(By.xpath("//tr[@name='entry']"));
			for (WebElement line : lines) {
				ContactParameters contact = new ContactParameters();
				
				WebElement lastName = line.findElement(By.xpath("./td[2]"));
				contact.lastname = lastName.getText();

				WebElement firstName = line.findElement(By.xpath("./td[3]"));
				contact.firstname = firstName.getText();
								
				contacts.add(contact);
			} 
				return contacts;
		}

}
