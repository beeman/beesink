package com.github.beeman.beesink.activity;

import roboguice.activity.RoboActivity;
import roboguice.inject.ContentView;
import roboguice.inject.InjectView;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

import com.github.beeman.beesink.R;
import com.github.beeman.beesink.model.Beer;
import com.github.beeman.beesink.model.dao.BeerDAO;
import com.github.beeman.beesink.util.Toaster;
import com.google.inject.Inject;

@ContentView(R.layout.activity_beer_add)
public class BeerAddActivity extends RoboActivity {

	@Inject
	Beer newBeer;

	@Inject
	BeerDAO beerDAO;

	@InjectView(R.id.add_beer_name)
	EditText beerName;
	@InjectView(R.id.add_beer_type)
	EditText beerType;
	@InjectView(R.id.add_beer_homepage)
	EditText beerHomepage;
	@InjectView(R.id.add_beer_description)
	EditText beerDescription;

	@InjectView(R.id.save_beer_button)
	Button saveBeer;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setupActionBar();

		saveBeer.setOnClickListener(saveBeerListener());
	}

	private OnClickListener saveBeerListener() {
		return new OnClickListener() {

			@Override
			public void onClick(View v) {
				newBeer.setName(beerType.getText().toString());
				newBeer.setType(beerName.getText().toString());
				newBeer.setDescription(beerDescription.getText().toString());
				newBeer.setHomepage(beerHomepage.getText().toString());

				newBeer.save();

				if (newBeer.getId() != null) {
					// v.getContext().
					// Toaster.showShort(BeerAddActivity.class, "Beer added: " +
					// newBeer.getName());
				} else {
					// Toaster.showShort(, "Error adding beer " +
					// newBeer.getName());
				}
			}
		};
	}

	private void setupActionBar() {
		getActionBar().setDisplayHomeAsUpEnabled(true);

	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			// This ID represents the Home or Up button. In the case of this
			// activity, the Up button is shown. Use NavUtils to allow users
			// to navigate up one level in the application structure. For
			// more details, see the Navigation pattern on Android Design:
			//
			// http://developer.android.com/design/patterns/navigation.html#up-vs-back
			//
			NavUtils.navigateUpFromSameTask(this);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

}
