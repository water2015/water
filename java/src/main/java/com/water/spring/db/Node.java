package com.water.spring.db;

import java.util.ArrayList;
import java.util.List;

public class Node {

	private int id;
	private String name;
	private String idName;
	private String nameName;

	public Node parent;
	public List<Node> childs = new ArrayList<Node>();

	public Node(int id, String name, String idName, String nameName) {
		this.id = id;
		this.name = name;
		this.idName = idName;
		this.nameName = nameName;
	}

	@Override
	public String toString() {
		return "ID:" + id + ", Name:" + name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Node other = (Node) obj;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIdName() {
		return idName;
	}

	public void setIdName(String idName) {
		this.idName = idName;
	}

	public String getNameName() {
		return nameName;
	}

	public void setNameName(String nameName) {
		this.nameName = nameName;
	}
}
