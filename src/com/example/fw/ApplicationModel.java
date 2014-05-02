package com.example.fw;

import java.util.List;

import com.example.tests.GroupParameters;
import com.example.utils.SortedListOf;

public class ApplicationModel {

	private SortedListOf<GroupParameters> groups;
	
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
	
}
