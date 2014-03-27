package com.example.tests;

import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

public class GroupRemovalTest extends TestBase {
	
	@Test
	public void deleteSomeGroup() {
	    app.getNavigationHelper().openMainPage();
	    app.getGroupHelper().gotoGroupsPage();
	    
	    //save old state
	    List<GroupParameters> oldList =  app.getGroupHelper().getGroups();
	    
	    Random rnd = new Random();
	    int index = rnd.nextInt(oldList.size());
	    
	    //actions
		app.getGroupHelper().deleteGroup(index);
	    app.getGroupHelper().returnToGroupsPage();
	    
	    // save new state     
	    List<GroupParameters> newList =  app.getGroupHelper().getGroups();
	    
	    // compare states  
	    oldList.remove(index);
	    Collections.sort(oldList);
	    assertEquals(newList, oldList);	 
		
	}
}
