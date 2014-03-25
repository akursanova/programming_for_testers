package com.example.tests;

import static org.testng.Assert.assertEquals;
import java.util.Collections;
import java.util.List;
import org.testng.annotations.Test;

public class EmptyGroupCreationTest extends TestBase {
  
  @Test
  public void testEmptyGroupCreation() throws Exception {
    app.getNavigationHelper().openMainPage();
    app.getGroupHelper().gotoGroupsPage();
    
    //save old state
    List<GroupParameters> oldList =  app.getGroupHelper().getGroups();
    
    //actions
    GroupParameters group = new GroupParameters("", "", "");
    app.getGroupHelper().initGroupCreation();

	app.getGroupHelper().fillGroupForm(group);
    app.getGroupHelper().submitGroupCreation();
    app.getGroupHelper().returnToGroupsPage();
    
    // save new state     
    List<GroupParameters> newList =  app.getGroupHelper().getGroups();
    
    // compare states  
    oldList.add(group);
    Collections.sort(oldList);
    assertEquals(newList, oldList);
    
  }
}
