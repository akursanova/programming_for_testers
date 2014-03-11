package com.example.tests;

import org.testng.annotations.Test;

public class EmptyGroupCreationTests extends TestBase {
  
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
