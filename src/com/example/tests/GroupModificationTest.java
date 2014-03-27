package com.example.tests;

import java.util.Collections;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

public class GroupModificationTest extends TestBase {

	@Test
	public void modifySomeGroup() {
	    app.getNavigationHelper().openMainPage();
	    app.getGroupHelper().gotoGroupsPage();
	    
	    //save old state
	    List<GroupParameters> oldList =  app.getGroupHelper().getGroups();
	    
		
		app.getGroupHelper().initGroupModification(0);
		GroupParameters group = new GroupParameters();
		group.name="new group1111";
		app.getGroupHelper().fillGroupForm(group);
		app.getGroupHelper().submitGroupModification();
	    app.getGroupHelper().returnToGroupsPage();	
	    
	    // save new state     
	    List<GroupParameters> newList =  app.getGroupHelper().getGroups();
	    
	    // compare states  
	    oldList.remove(0);
	    oldList.add(0,group);
	    Collections.sort(oldList);
	    assertEquals(newList, oldList);	    
	    
	
	}

}