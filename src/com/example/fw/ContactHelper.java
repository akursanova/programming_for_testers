package com.example.fw;
import java.util.List;
import com.example.utils.SortedListOf;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import com.example.tests.ContactParameters;

public class ContactHelper extends WebDriverHelperBase  {
	
	public static boolean CREATION = true;
	public static boolean MODIFICATION = false;

	public ContactHelper(ApplicationManager manager) {
		super(manager);
			}
	
	private SortedListOf<ContactParameters> cachedContacts;
	
	public SortedListOf<ContactParameters> getContacts() {
		if (cachedContacts == null) {
			rebuildCache();
		}
		return cachedContacts;
	}
	
	public void rebuildCache() {
		
		cachedContacts = new SortedListOf<ContactParameters>();
		manager.navigateTo().mainPage();
		
		List<WebElement> lines = driver.findElements(By.xpath("//tr[@name='entry']"));
		for (WebElement line : lines) {
			ContactParameters contact = new ContactParameters();
			
			WebElement lastName = line.findElement(By.xpath("./td[2]"));
			contact.lastname = lastName.getText();

			WebElement firstName = line.findElement(By.xpath("./td[3]"));
			contact.firstname = firstName.getText();
							
			cachedContacts.add(new ContactParameters().withLastname(contact.lastname));
		} 
	}

	public ContactHelper createContact(ContactParameters contact) {
		manager.navigateTo().mainPage();
		initNewContactCreation();
		fillFormContact(contact, CREATION);
	    submitContactCreation();
	    returnToHomePage();
	    rebuildCache();
	    return this;
	}
	
	public ContactHelper modifyContact(ContactParameters contact, int index) {
		//manager.navigateTo().mainPage();
		initContactModification(index+1);
		fillFormContact(contact, MODIFICATION);
		submitContactModification();
		returnToHomePage();
		rebuildCache();
		return this;
	}
	
	public ContactHelper deleteContact(int index) {
		//manager.navigateTo().mainPage();
		initContactModification(index+1);	
		submitContactDeletion();
	    returnToHomePage();
	    rebuildCache();
		return this;
	}
	
	// ----------------------------------------------------------------------------------------------------
	
	public ContactHelper fillFormContact(ContactParameters contact, boolean formType) {
		
		type(By.name("firstname"),contact.getFirstname());
		type(By.name("lastname"),contact.getLastname());
	    type(By.name("address"),contact.getAddress());
	    type(By.name("home"),contact.getHomePhone());
  	    type(By.name("mobile"),contact.getMobile());
	    type(By.name("work"),contact.getWork());    
	    type(By.name("home"),contact.getSecond_home());    
	    type(By.name("email"),contact.getEmail());	    
	    type(By.name("email2"),contact.getEmail2());	    
	    //selectByText(By.name("bday"), contact.getBirthday());		   
	    //selectByText(By.name("bmonth"), contact.getBmonth());	        
	    type(By.name("byear"),contact.getByear());
	    if (formType == CREATION) {
	    //selectByText(By.name("new_group"), contact.some_group);	 
	    } else {
	    	if (driver.findElements(By.name("new_group")).size() !=0) {
	    		throw new Error("Group selector exists in contact modification form");
	    	}
	    	
	    }
	    	    
	    type(By.name("address2"),contact.getAddress2());   
	    type(By.name("phone2"),contact.getPhone2());
	    return this;
	    
	   	}

		public ContactHelper submitContactCreation() {
			click(By.name("submit"));
			cachedContacts = null;
			return this;
	}

		public ContactHelper initNewContactCreation() {
			click(By.linkText("add new"));
			return this;
	}
		
		public ContactHelper initContactModification(int index) {
			manager.navigateTo().mainPage();
			click(By.xpath("//tr["+ (index+1) +"]//a[contains(@href,'edit')]"));
			return this;
		}
		
		public ContactHelper submitContactModification() {
			click(By.xpath("//input[@value='Update']"));
			cachedContacts = null;
			return this;
		}
		
		public void submitContactDeletion() {
			click(By.xpath("//input[@value='Delete']"));
			cachedContacts = null;

		}

		public void returnToHomePage() {
			click(By.linkText("home"));
		}
		

}
