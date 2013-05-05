package com.github.beeman.beesink.activity;

import java.util.List;

import roboguice.activity.RoboListActivity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TwoLineListItem;

import com.github.beeman.beesink.R;
import com.github.beeman.beesink.model.Beer;
import com.github.beeman.beesink.model.dao.BeerDAO;
import com.google.inject.Inject;

public class BeerActivity extends RoboListActivity {

	@Inject
	BeerDAO beerDAO;

	List<Beer> beerList;
	Beer currentBeer;

	public void loadBeers() {
		beerList = beerDAO.getBeers();
		ArrayAdapter<Beer> adapter = getBeerAdapter();
		setListAdapter(adapter);

	}

	private ArrayAdapter<Beer> getBeerAdapter() {
		ArrayAdapter<Beer> adapter = new ArrayAdapter<Beer>(this, android.R.layout.simple_list_item_2, beerList) {
			@Override
			public View getView(int position, View convertView, ViewGroup parent) {
				TwoLineListItem row;
				if (convertView == null) {
					LayoutInflater inflater = (LayoutInflater) getApplicationContext().getSystemService(
							Context.LAYOUT_INFLATER_SERVICE);
					row = (TwoLineListItem) inflater.inflate(android.R.layout.simple_list_item_2, null);
				} else {
					row = (TwoLineListItem) convertView;
				}
				Beer data = beerList.get(position);
				row.getText1().setText(data.getName());
				row.getText2().setText(data.getDescription());
				return row;
			}
		};
		return adapter;
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setupActionBar();
		loadBeers();
	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		super.onListItemClick(l, v, position, id);

		currentBeer = (Beer) beerList.get(position);

		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setTitle("Are you sure?").setMessage("Do you really want to delete " + currentBeer.getName())
				.setPositiveButton("Yes", dialogClickListener).setNegativeButton("No", dialogClickListener).show();

	}

	DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
		@Override
		public void onClick(DialogInterface dialog, int which) {
			switch (which) {
			case DialogInterface.BUTTON_POSITIVE:
				Log.i("ja hoor", "Deleting: " + currentBeer.getName());
				beerDAO.delete(currentBeer.getId());
				loadBeers();
				break;
			case DialogInterface.BUTTON_NEGATIVE:
				Log.i("nee hoor", "Not deleting: " + currentBeer.getName());
				break;
			}
		}
	};

	private void setupActionBar() {
		getActionBar().setDisplayHomeAsUpEnabled(true);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.beer, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			NavUtils.navigateUpFromSameTask(this);
			return true;
		default:
			Intent intent = new Intent(this, BeerAddActivity.class);
			startActivity(intent);
			Log.i("Menu item: ", item.toString());
		}
		return super.onOptionsItemSelected(item);
	}

}
