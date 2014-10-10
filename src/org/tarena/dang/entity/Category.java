package org.tarena.dang.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

public class Category implements Serializable {
	private int id;
	private int turn;
	private String name;
	private String enName;
	private String description;
	private int parentId;
	// 追加一个属性，用于存储当前类别的子类别
	private List<Category> subCats;
	// 追加一个属性，用于存储当前类别所包含的产品数量
	private int pnum;
	
	private Set<Product> pros;

	public int getId() {
		return id;
	}

	public int getPnum() {
		return pnum;
	}

	public void setPnum(int pnum) {
		this.pnum = pnum;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getTurn() {
		return turn;
	}

	public void setTurn(int turn) {
		this.turn = turn;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEnName() {
		return enName;
	}

	public void setEnName(String enName) {
		this.enName = enName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getParentId() {
		return parentId;
	}

	public void setParentId(int parentId) {
		this.parentId = parentId;
	}

	public List<Category> getSubCats() {
		return subCats;
	}

	public void setSubCats(List<Category> subCats) {
		this.subCats = subCats;
	}

	public void setPros(Set<Product> pros) {
		this.pros = pros;
	}

	public Set<Product> getPros() {
		return pros;
	}

}
