package com.github.beeman.beesink.model;

import java.util.List;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

@Table(name = "Countries")
public class Country extends Model {

	@Column(name = "Name")
	String name;
	@Column(name = "Code")
	String code;

	public Country() {
		super();
	}

	public Country(String name, String code) {
		super();
		this.name = name;
		this.code = code;
	}

	public List<Beer> beers() {
		return getMany(Beer.class, "Country");
	}

}
