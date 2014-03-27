package com.example.tests;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import com.example.fw.ApplicationManager;

public class TestBase {

	public static ApplicationManager app;

	@BeforeTest
	public void setUp() throws Exception {
		app = new ApplicationManager();

	}

	@AfterTest
	public void tearDown() throws Exception {
		app.stop();

	}
	@DataProvider
	public Iterator<Object[]> randomValidGroupGenerator() {
		List<Object[]> list = new ArrayList<Object[]>();
		for (int i = 0; i < 5; i++ ) {
			GroupParameters group = new GroupParameters();
			group.name = generateRandomString();
			group.header = generateRandomString();
			group.footer = generateRandomString();	
			list.add(new Object[]{group});
		}	
		return list.iterator();
	}
		
	public String generateRandomString() {
		Random rnd = new Random();
		if (rnd.nextInt(3) == 0 ) {
			return "";
		} else {
			return "test" +rnd.nextInt();
		}
		
	}
	
	
	@DataProvider
	public Iterator<Object[]> randomValidContactGenerator() {
		List<Object[]> list = new ArrayList<Object[]>();
		for (int i = 0; i < 1; i++ ) {
			ContactParameters contact = new ContactParameters();			
			contact.firstname = generateRandomString();
			contact.lastname = generateRandomString();
			contact.address = generateRandomString();	
			contact.homePhone = generateRandomString();
			contact.mobile = generateRandomString();
			contact.work = generateRandomString();	
			contact.second_home = generateRandomString();
			contact.email = generateRandomString();
			contact.email2 = generateRandomString();
			contact.birthday= generateRandomNumber(31);
			//public String bmonth;
			contact.byear= generateRandomNumber(2013);
			//public String some_group;
			contact.address2 = generateRandomString();
			contact.phone2 = generateRandomString();			
			list.add(new Object[]{contact});
		}	
		return list.iterator();
	}
	
	  
	  public String generateRandomNumber(int limit){
		  Random rnd = new Random();
		  int number = 1+rnd.nextInt(limit);
		  String num = ""+number+"";
		  return num;
	  }

}
