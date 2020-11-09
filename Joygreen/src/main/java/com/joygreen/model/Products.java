package com.joygreen.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Product")
public class Products {
	
	@Id
	private String id;
	private String name;
	private String describtion;
	private String url;
	private Double price;
	
	
	
     public Products (String id, String name, String describtion, String url, Double price){
		super();
		this.id = id;
		this.name = name;
		this.describtion = describtion;
		this.url = url;
		this.price = price;
		
	}

	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getDescribtion() {
		return describtion;
	}
	
	public void setDescribtion(String describtion) {
		this.describtion = describtion;
	}
	
	public String getUrl() {
		return url;
	}
	
	public void setUrl(String url) {
		this.url = url;
	}
	
	public Double getPrice() {
		return price;
	}
	
	public void setPrice(Double price) {
		this.price = price;
	}

	@Override
    public String toString() {
        return "Poultry [id=" + id + ", Name=" + name + ",Describtion =" + describtion + ", URL=" + url + ", Price="
                + price  +"]";
    }

}




