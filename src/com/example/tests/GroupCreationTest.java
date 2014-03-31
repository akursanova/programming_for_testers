package com.example.tests;

import java.util.Collections;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

public class GroupCreationTest extends TestBase {
	

	@Test(dataProvider = "randomValidGroupGenerator")
    public void testGroupCreationWithValidData(GroupParameters group) throws Exception {
    
    //save old state
    List<GroupParameters> oldList =  app.getGroupHelper().getGroups();
    
    // actions
    app.getGroupHelper().createGroup(group);

    
    // save new state     
    List<GroupParameters> newList =  app.getGroupHelper().getGroups();
    
    // compare states  
    oldList.add(group);
    Collections.sort(oldList);
    assertEquals(newList, oldList);
    
  }
  
}
