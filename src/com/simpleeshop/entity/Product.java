package com.simpleeshop.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="products")
public class Product {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@OneToOne
	@JoinColumn(name = "categoryId", foreignKey = @ForeignKey(name = "CATEGORY_FK") )
	private Category category;
	
	@Column (name="name", columnDefinition="VARCHAR(250) DEFAULT 'New product'")
	private String name;
	/*
	@Column (name="manufacturer", columnDefinition="VARCHAR(250)")
	private String mamufacturer;
	*/
	@Column (name="_show", columnDefinition="BOOLEAN DEFAULT 0")
	private boolean show;
	
	@Column (name="description")
	private String description;
	
	@Column (name="price")
	private BigDecimal price;
	
	@Column (name="unit_in_stock")
	private long unitsInStock;
	
	@Column (name="image", columnDefinition="VARCHAR(250)")
	private String image;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
/*
	public String getMamufacturer() {
		return mamufacturer;
	}

	public void setMamufacturer(String mamufacturer) {
		this.mamufacturer = mamufacturer;
	}
*/
	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public boolean isShow() {
		return show;
	}

	public void setShow(boolean show) {
		this.show = show;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public long getUnitsInStock() {
		return unitsInStock;
	}

	public void setUnitsInStock(long unitsInStock) {
		this.unitsInStock = unitsInStock;
	}
}
