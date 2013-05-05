package com.github.beeman.beesink.activity;

import roboguice.inject.InjectView;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.github.beeman.beesink.R;
import com.github.beeman.beesink.model.Beer;
import com.github.beeman.beesink.model.dao.BeerDAO;

/**
 * A fragment representing a single Beer detail screen. This fragment is either
 * contained in a {@link BeerListActivity} in two-pane mode (on tablets) or a
 * {@link BeerDetailActivity} on handsets.
 */
public class BeerDetailFragment extends Fragment {
	@InjectView(R.id.beer_name)
	TextView beerName;
//	@InjectView(R.id.beer_type)
//	TextView beerType;
//	@InjectView(R.id.beer_description)
//	TextView beerDescription;
//	@InjectView(R.id.beer_homepage)
//	TextView beerHomepage;
//	@InjectView(R.id.beer_country)
//	TextView beerCountry;

	/**
	 * The fragment argument representing the item ID that this fragment
	 * represents.
	 */
	public static final String ARG_ITEM_ID = "item_id";

	/**
	 * The dummy content this fragment is presenting.
	 */
	private Beer mItem;

	/**
	 * Mandatory empty constructor for the fragment manager to instantiate the
	 * fragment (e.g. upon screen orientation changes).
	 */
	public BeerDetailFragment() {
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		if (getArguments().containsKey(ARG_ITEM_ID)) {
			mItem = BeerDAO.ITEM_MAP.get(getArguments().getString(ARG_ITEM_ID));
		}
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_beer_detail,
				container, false);

		// Show the dummy content as text in a TextView.
		if (mItem != null) {
			beerName.setText("Hoi");
//			beerType.setText(mItem.getType());
//			beerDescription.setText(mItem.getDescription());
//			beerHomepage.setText(mItem.getHomepage());
//			beerCountry.setText(mItem.getCountry());
		}

		return rootView;
	}
}
