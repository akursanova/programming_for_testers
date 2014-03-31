package com.example.fw;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.example.tests.GroupParameters;

public class GroupHelper extends HelperBase  {

	public GroupHelper(ApplicationManager manager) {
		super(manager);
		}

	public List<GroupParameters> getGroups() {
		List<GroupParameters> groups = new ArrayList<GroupParameters>();
		
		manager.navigateTo().groupsPage();
		List<WebElement> checkboxes = driver.findElements(By.name("selected[]"));
		for (WebElement checkbox : checkboxes) {
			String title = checkbox.getAttribute("title");
			String name = title.substring("Select (".length(), title.length()-")".length());
			groups.add(new GroupParameters().withName(name));
		} 
		return groups;
	}
	
	public GroupHelper createGroup(GroupParameters group) {
		manager.navigateTo().groupsPage();
		initGroupCreation();
	    fillGroupForm(group);
	    submitGroupCreation();
	    returnToGroupsPage();
	    return this;
	}
	
	public GroupHelper deleteGroup(int index) {
		selectGroupByIndex(index);
		submitGroupDeletion();
	    returnToGroupsPage();
		return this;
				
	}

	public GroupHelper modifyGroup(int index, GroupParameters group) {
		initGroupModification(index);
		fillGroupForm(group);
		submitGroupModification();
	    returnToGroupsPage();	
	    return this;
	}
	
	// ----------------------------------------------------------------------------------------------------
	
	public GroupHelper initGroupCreation() {
		manager.navigateTo().groupsPage();
		click(By.name("new"));
		return this;
	}

	public GroupHelper submitGroupCreation() {
		click(By.name("submit"));
		return this;
	}

	public GroupHelper fillGroupForm(GroupParameters group) {
		type(By.name("group_name"), group.getName());
		type(By.name("group_header"), group.getHeader());
		type(By.name("group_footer"), group.getFooter());
		return this;
	}

	public GroupHelper returnToGroupsPage() {
		click(By.linkText("group page"));
		return this;
	}

	public GroupHelper initGroupModification(int index) {
		selectGroupByIndex(index);
		click(By.name("edit"));
		return this;
	}

	private GroupHelper selectGroupByIndex(int index) {
		click(By.xpath("//input[@name='selected[]']["+ (index+1) +"]"));
		return this;
	}

	public GroupHelper submitGroupModification() {
		click(By.name("update"));
		return this;
		
	}

	private void submitGroupDeletion() {
		click(By.name("delete"));
	}
	

}
