package com.example.tests;

import org.testng.annotations.Test;

public class GroupCreationTest extends TestBase {
  @Test
  public void testNonEmptyGroupCreation() throws Exception {
    app.navigationHelper.openMainPage();
    app.groupHelper.gotoGroupsPage();
    app.groupHelper.initGroupCreation();
    GroupData group = new GroupData();
    group.name = "group name 1";
    group.header = "group header 1";
    group.footer = "group footer 1";
	app.groupHelper.fillGroupForm(group);
    app.groupHelper.submitGroupCreation();
    app.groupHelper.returnToGroupsPage();
  }
  
}
