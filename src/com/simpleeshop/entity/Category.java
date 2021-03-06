package com.simpleeshop.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="category")
public class Category {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column (name="name", columnDefinition="VARCHAR(40) DEFAULT 'New category'")
	private String name;
	
	@Column (name="_show", columnDefinition="BOOLEAN DEFAULT 0")
	private boolean show;
	
	public Category(){};
	
	public Category(Long id, String name, boolean show) {
		this.id = id;
		this.name = name;
		this.show = show;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isShow() {
		return show;
	}

	public void setShow(boolean show) {
		this.show = show;
	}
}
