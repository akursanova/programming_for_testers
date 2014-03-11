package com.example.tests;

import org.testng.annotations.Test;

public class AlsoGroupCreationTests extends TestBase {
  @Test
  public void testNonEmptyGroup—reation() throws Exception {
    openMainPage();
    gotoGroupsPage();
    initGroupCreation();
    GroupData group = new GroupData();
    group.name = "group name 12";
    group.header = "group header 21";
    group.footer = "group footer 12";
	fillGroupForm(group);
    submitGroupCreation();
    returnToGroupsPage();
  }
  
  @Test
  public void testEmptyGroup—reation() throws Exception {
    openMainPage();
    gotoGroupsPage();
    initGroupCreation();
    fillGroupForm(new GroupData("", "", ""));
    submitGroupCreation();
    returnToGroupsPage();
  }
}
