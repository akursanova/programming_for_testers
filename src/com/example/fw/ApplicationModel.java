package com.example.fw;

import java.util.List;

import com.example.tests.ContactParameters;
import com.example.tests.GroupParameters;
import com.example.utils.SortedListOf;

public class ApplicationModel {

	private SortedListOf<GroupParameters> groups;
	private SortedListOf<ContactParameters> contacts;
	
	public SortedListOf<GroupParameters> getGroups() {
		return groups;
	}
	
	public void setGroups(List<GroupParameters> groups) {
		this.groups = new SortedListOf<GroupParameters> (groups);
	}

	public ApplicationModel addGroup(GroupParameters group) {
		groups.add(group);
		return this;
		
	}

	public ApplicationModel removeGroup(int index) {
		groups.remove(index);
		return this;
		
	}
	
	public SortedListOf<ContactParameters> getContacts() {
		return contacts;
	}
	
	public void setContacts(List<ContactParameters> contacts) {
		this.contacts = new SortedListOf<ContactParameters> (contacts);
	}

	public ApplicationModel addContact(ContactParameters contact) {
		contacts.add(contact);
		return this;
	}

	public ApplicationModel removeContact(int index) {
		contacts.remove(index);
		return this;
		
	}


}
