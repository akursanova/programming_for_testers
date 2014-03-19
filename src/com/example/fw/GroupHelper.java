package com.example.fw;
import org.openqa.selenium.By;
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

	public void deleteGroup(int index) {
		selectGroupByIndex(index);
		click(By.name("delete"));
				
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

}
