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

	public void initGroupCreation() {
		click(By.name("new"));
	}

	public void submitGroupCreation() {
		click(By.name("submit"));
	}

	public void fillGroupForm(GroupParameters group) {
		type(By.name("group_name"), group.name);
		type(By.name("group_header"), group.header);
		type(By.name("group_footer"), group.footer);
	}

	public void gotoGroupsPage() {
		click(By.linkText("groups"));
	}

	public void returnToGroupsPage() {
		click(By.linkText("group page"));
	}

	public int deleteGroup(int index) {
		selectGroupByIndex(index);
		click(By.name("delete"));
		return index;
				
	}

	public void initGroupModification(int index) {
		selectGroupByIndex(index);
		click(By.name("edit"));
	}

	private void selectGroupByIndex(int index) {
		click(By.xpath("//input[@name='selected[]']["+ index +"]"));
	}

	public void submitGroupModification() {
		click(By.name("update"));
		
	}

	public List<GroupParameters> getGroups() {
		List<GroupParameters> groups = new ArrayList<GroupParameters>();
		List<WebElement> checkboxes = driver.findElements(By.name("selected[]"));
		for (WebElement checkbox : checkboxes) {
			GroupParameters group =new GroupParameters();
			String title = checkbox.getAttribute("title");
			group.name = title.substring("Select (".length(), title.length()-")".length());
			groups.add(group);
		} 
		return groups;
	}

}
