package com.example.fw;
import com.example.utils.SortedListOf;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.example.tests.GroupParameters;

public class GroupHelper extends HelperBase  {

	public GroupHelper(ApplicationManager manager) {
		super(manager);
		}
	
	private SortedListOf<GroupParameters> cachedGroups;
	
	public SortedListOf<GroupParameters> getGroups() {
		if (cachedGroups == null) {
			rebuildCache();
		}
		return cachedGroups;
	}
			
	private void rebuildCache() {

		cachedGroups = new SortedListOf<GroupParameters>();
			
		manager.navigateTo().groupsPage();
		
		List<WebElement> checkboxes = driver.findElements(By.name("selected[]"));
		for (WebElement checkbox : checkboxes) {
			String title = checkbox.getAttribute("title");
			String name = title.substring("Select (".length(), title.length()-")".length());
			cachedGroups.add(new GroupParameters().withName(name));
			} 		
		}

	
	public GroupHelper createGroup(GroupParameters group) {
		manager.navigateTo().groupsPage();
		initGroupCreation();
	    fillGroupForm(group);
	    submitGroupCreation();
	    returnToGroupsPage();
	    rebuildCache();
	    return this;
	}
	
	public GroupHelper deleteGroup(int index) {
		//manager.navigateTo().groupsPage();
		selectGroupByIndex(index);
		submitGroupDeletion();
	    returnToGroupsPage();
	    rebuildCache();
		return this;
				
	}

	public GroupHelper modifyGroup(int index, GroupParameters group) {
		//manager.navigateTo().groupsPage();
		initGroupModification(index);
		fillGroupForm(group);
		submitGroupModification();
	    returnToGroupsPage();
	    rebuildCache();
	    return this;
	}
	
	// ----------------------------------------------------------------------------------------------------
	
	public GroupHelper initGroupCreation() {
		click(By.name("new"));
		return this;
	}

	public GroupHelper submitGroupCreation() {
		click(By.name("submit"));
		cachedGroups = null;
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
		cachedGroups = null;
		return this;
		
	}

	private void submitGroupDeletion() {
		click(By.name("delete"));
		cachedGroups = null;
	}
}
