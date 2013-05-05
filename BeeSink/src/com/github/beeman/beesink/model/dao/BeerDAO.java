package com.github.beeman.beesink.model.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.util.Log;

import com.activeandroid.query.Select;
import com.github.beeman.beesink.model.Beer;
import com.github.beeman.beesink.model.Country;

public class BeerDAO {

	public static List<Beer> ITEMS = new ArrayList<Beer>();

	public static Map<String, Beer> ITEM_MAP = new HashMap<String, Beer>();

	static {

		addItem(new Beer("Weihenstephaner", "Weizen", "Beste bier", "http://weihenstephaner.de/", new Country("Duitsland", "DE")));
		addItem(new Beer("Davo", "Pils", "Lokaal hiertje", "http://", new Country("Nederland", "NL")));
		addItem(new Beer("Duvel", "Speciaalbier", "Bekende belg", "http://", new Country("Belgie", "BE")));
		addItem(new Beer("Leffe Blond", "Speciaalbier", "Blonde belg", "http://", new Country("Belgie", "BE")));

	}

	private static void addItem(Beer item) {
		ITEMS.add(item);
		ITEM_MAP.put(item.getName(), item);
	}

	public void createBeers() {

		Country de = new Country("Duitsland", "DE");
		Country nl = new Country("Nederland", "NL");
		Country be = new Country("Belgie", "BE");
		de.save();
		nl.save();
		be.save();

		Beer b1 = new Beer("Weihenstephaner", "Weizen", "älteste Brauerei der Welt", "http://weihenstephaner.de/", de);
		Beer b2 = new Beer("Davo Tripel", "Tripel", "Een mooie ronde tripel met 8,5% alcohol.", "http://www.davobieren.nl/", nl);
		Beer b3 = new Beer("Duvel", "Blond Speciaalbier", "Bier met hoge gisting", "http://duvel.com", be);
		Beer b4 = new Beer("Leffe Blond", "Blond Speciaalbier", "Blonde biertje uit Belgie", "http://leffe.com", be);

		b1.save();
		b2.save();
		b3.save();
		b4.save();

	}

	public List<Beer> getBeers() {
		return new Select().from(Beer.class).execute();
	}

	public void delete(Long id) {
		Beer beer = Beer.load(Beer.class, id);
		beer.delete();

		Log.i("Success", "Deleted Beer with ID " + id);

	}
}
