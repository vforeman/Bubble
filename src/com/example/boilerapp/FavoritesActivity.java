package com.example.boilerapp;

import com.parse.ParseAnalytics;
import com.parse.ParseObject;
import com.parse.ParseQueryAdapter;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

public class FavoritesActivity extends Activity {
	
	public void onCreate(Bundle savedInstancesState){
		super.onCreate(savedInstancesState);
		setContentView(R.layout.favorites_activity);
		
		
		/* TODO
		 * 1. The BubbleObject should be passed to this activity via an intent when the star icon is clicked in the shareActiivity
		 * 2. Add favorited items to the listview adapter
		 * (If the favorites attribute of the bubble object is equal to true
		 * add the object to the listview adapter)
		 * 
		 * NOTE:
		 * Make sure the HomeList Gets updated
		 * RESULT:
		 * The Favorite Activity should be populated with favorited articles in a listview
		 */
		
		//Fill in the ListView
		ParseQueryAdapter<ParseObject> adapter = new ParseQueryAdapter<ParseObject>(this, "");
		adapter.setTextKey("foo");
		adapter.setImageKey("image");
		//Limit 10 objects per page
		adapter.setObjectsPerPage(10);
		
		ListView listView = (ListView) findViewById(R.id.FavoritesListView);
		listView.setAdapter(adapter);
	}
	
}

