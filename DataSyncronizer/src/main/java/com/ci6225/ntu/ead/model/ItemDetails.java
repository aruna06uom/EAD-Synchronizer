package com.ci6225.ntu.ead.model;

import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Indexed;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Indexed
@Entity
public class ItemDetails {
	
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
	@Field
    private String itemId;
    @Field
    private String name;
    @Field
    private String category;
    @Field
    private String expireDate;
    @Field
    private String manufactureDate;
    @Field
    private String value;
    @Field
    private String numberOfItems;
    @Field
    private String usableYears;
    @Field
    private String branch;
    @Field
    private String status;
    
    public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getItemId() {
		return itemId;
	}
	public void setItemId(String itemId) {
		this.itemId = itemId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getExpireDate() {
		return expireDate;
	}
	public void setExpireDate(String expireDate) {
		this.expireDate = expireDate;
	}
	public String getManufactureDate() {
		return manufactureDate;
	}
	public void setManufactureDate(String manufactureDate) {
		this.manufactureDate = manufactureDate;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getNumberOfItems() {
		return numberOfItems;
	}
	public void setNumberOfItems(String numberOfItems) {
		this.numberOfItems = numberOfItems;
	}
	public String getUsableYears() {
		return usableYears;
	}
	public void setUsableYears(String usableYears) {
		this.usableYears = usableYears;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	


}
