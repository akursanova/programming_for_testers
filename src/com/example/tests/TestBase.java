package com.example.tests;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Random;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import com.example.fw.ApplicationManager;
import static com.example.tests.GroupDataGenerator.generateRandomGroups;
import static com.example.tests.GroupDataGenerator.generateRandomString;

public class TestBase {

	protected static ApplicationManager app;

	@BeforeTest
	public void setUp() throws Exception {
		String configFile = System.getProperty("configFile","application.properties");
		Properties properties = new Properties();
		properties.load(new FileReader(new File(configFile)));
		app = new ApplicationManager(properties);

	}

	@AfterTest
	public void tearDown() throws Exception {
		app.stop();

	}
	@DataProvider
	public Iterator<Object[]> randomValidGroupGenerator() {
		return wrapGroupsForDataProvider(generateRandomGroups(5)).iterator();
	}
		
	public static List<Object[]> wrapGroupsForDataProvider(List<GroupParameters> groups) {
		List<Object[]> list = new ArrayList<Object[]>();
		for (GroupParameters group : groups) {
			list.add(new Object[]{group});
		}
		return list;
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
