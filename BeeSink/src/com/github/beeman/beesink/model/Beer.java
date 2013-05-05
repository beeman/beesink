package com.github.beeman.beesink.model;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

@Table(name = "Beers")
public class Beer extends Model {

	@Column(name = "Name")
	String name;
	@Column(name = "Type")
	String type;
	@Column(name = "Description")
	String description;
	@Column(name = "Homepage")
	String homepage;
	@Column(name = "Country")
	Country country;

	public Beer() {
		super();
	}

	public Beer(String name, String type, String description, String homepage, Country country) {
		super();
		this.name = name;
		this.type = type;
		this.description = description;
		this.homepage = homepage;
		this.country = country;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getHomepage() {
		return homepage;
	}

	public void setHomepage(String homepage) {
		this.homepage = homepage;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return name;
	}

}
