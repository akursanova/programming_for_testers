package com.example.tests;

import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

public class GroupModificationTest extends TestBase {

	@Test(dataProvider = "randomValidGroupGenerator")
	public void modifySomeGroup(GroupParameters group) {
	    
	    //save old state
	    List<GroupParameters> oldList =  app.getGroupHelper().getGroups();
	    
	    Random rnd = new Random();
	    int index = rnd.nextInt(oldList.size());
	    
	    app.getGroupHelper().modifyGroup(index, group);

	    
	    // save new state     
	    List<GroupParameters> newList =  app.getGroupHelper().getGroups();
	    
	    // compare states  
	    oldList.remove(index);
	    oldList.add(group);
	    Collections.sort(oldList);
	    assertEquals(newList, oldList);	    
	    
	
	}

}