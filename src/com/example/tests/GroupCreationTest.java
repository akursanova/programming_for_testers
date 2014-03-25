package com.example.tests;

import java.util.Collections;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

public class GroupCreationTest extends TestBase {
  @Test
  public void testNonEmptyGroupCreation() throws Exception {
    app.getNavigationHelper().openMainPage();
    app.getGroupHelper().gotoGroupsPage();
    
    //save old state
    List<GroupParameters> oldList =  app.getGroupHelper().getGroups();
    
    // actions
    app.getGroupHelper().initGroupCreation();
    GroupParameters group = new GroupParameters();
    group.name = "group name 1";
    group.header = "group header 1";
    group.footer = "group footer 1";
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
