package com.github.beeman.beesink.activity;

import java.util.List;

import roboguice.activity.RoboActivity;
import roboguice.inject.ContentView;
import roboguice.inject.InjectView;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import com.github.beeman.beesink.R;
import com.github.beeman.beesink.controller.AppController;
import com.github.beeman.beesink.model.Beer;
import com.github.beeman.beesink.model.dao.BeerDAO;
import com.google.inject.Inject;

@ContentView(R.layout.activity_main)
public class MainActivity extends RoboActivity {

	@Inject
	AppController ac;

	@Inject
	BeerDAO beerDAO;

	@InjectView(R.id.buttonBeers)
	Button buttonBeers;
	@InjectView(R.id.buttonCount)
	Button buttonCount;
	@InjectView(R.id.buttonTest)
	Button buttonTest;
	@InjectView(R.id.buttonLoadBeers)
	Button buttonLoadBeers;
	@InjectView(R.id.mainText)
	TextView mainText;

	int counter = 0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		buttonBeers.setOnClickListener(buttonBeersListener());
		buttonCount.setOnClickListener(buttonCountListener());
		buttonTest.setOnClickListener(buttonTestListener());
		buttonLoadBeers.setOnClickListener(buttonLoadBeersListener());
	}

	private OnClickListener buttonLoadBeersListener() {

		return new OnClickListener() {
			@Override
			public void onClick(View v) {

				List<Beer> beerList = beerDAO.getBeers();

				if (beerList.size() < 1) {
					ac.i("Creating some beers!");
					beerDAO.createBeers();
				} else {
					for (Beer b : beerList) {
						Log.i(b.getName(), b.getDescription());
					}
				}

				Intent intent = new Intent(v.getContext(), BeerActivity.class);
				startActivity(intent);
			}
		};

	}

	private OnClickListener buttonBeersListener() {

		return new OnClickListener() {

			@Override
			public void onClick(View v) {
				ac.d("Loading Beer List");
				Intent intent = new Intent(v.getContext(), BeerListActivity.class);
				startActivity(intent);

			}
		};
	}

	private OnClickListener buttonCountListener() {
		return new OnClickListener() {

			@Override
			public void onClick(View v) {
				ac.d("Counting!");
				counter++;
				mainText.setText("Counter: " + counter);

			}
		};
	}

	private OnClickListener buttonTestListener() {
		return new OnClickListener() {

			@Override
			public void onClick(View v) {
				ac.d("Loading Simple Activity");
				Intent intent = new Intent(v.getContext(), SimpleActivity.class);
				startActivity(intent);

			}
		};
	}

}
