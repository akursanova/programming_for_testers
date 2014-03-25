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
	    
		int index = 0;
		app.getGroupHelper().initGroupModification(index+1);
		GroupParameters group = new GroupParameters();
		group.name="new group1111";
		app.getGroupHelper().fillGroupForm(group);
		app.getGroupHelper().submitGroupModification();
	    app.getGroupHelper().returnToGroupsPage();	
	    
	    // save new state     
	    List<GroupParameters> newList =  app.getGroupHelper().getGroups();
	    
	    // compare states  
	    oldList.remove(index);
	    oldList.add(index,group);
	    Collections.sort(oldList);
	    assertEquals(newList, oldList);	    
	    
	
	}

}