package com.example.tests;

import org.testng.annotations.Test;

public class GroupModificationTest extends TestBase {

	@Test
	public void modifySomeGroup() {
	    app.getNavigationHelper().openMainPage();
	    app.getGroupHelper().gotoGroupsPage();
		app.getGroupHelper().initGroupModification(1);
		GroupParameters group = new GroupParameters();
		group.name="new group name";
		app.getGroupHelper().fillGroupForm(group);
		app.getGroupHelper().submitGroupModification();
	    app.getGroupHelper().returnToGroupsPage();	
	
	}

}