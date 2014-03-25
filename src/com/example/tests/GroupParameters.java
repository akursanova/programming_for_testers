package com.example.tests;

public class GroupParameters implements Comparable<GroupParameters> {
	public String name;
	public String header;
	public String footer;


	public GroupParameters() {
			}

	@Override
	public String toString() {
		return "GroupParameters [name=" + name + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		//result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GroupParameters other = (GroupParameters) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}


	@Override
	public int compareTo(GroupParameters other) {
		return this.name.toLowerCase().compareTo(other.name.toLowerCase());
	}		
		
}