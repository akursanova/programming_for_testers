package com.example.tests;

import org.testng.annotations.Test;

public class GroupModificationTest extends TestBase {

	@Test
	public void modifySomeGroup() {
	    app.getNavigationHelper().openMainPage();
	    app.getGroupHelper().gotoGroupsPage();
		app.getGroupHelper().initGroupModification(1);
		GroupParameters group = new GroupParameters();
		app.getGroupHelper().fillGroupForm(group);
		group.name="new name";
		app.getGroupHelper().submitGroupModification();
	    app.getGroupHelper().returnToGroupsPage();	
	
	}

}