package com.example.boilerapp;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import com.parse.ParseAnalytics;
import com.parse.ParseObject;
import com.parse.ParseQueryAdapter;




public class HomeListActivity extends Activity {
	
	public void onCreate(Bundle savedInstancesState){
		super.onCreate(savedInstancesState);
		setContentView(R.layout.home_activity);
		
		ParseAnalytics.trackAppOpened(getIntent());
		
		//Fill in the ListView
		ParseQueryAdapter<ParseObject> adapter = new ParseQueryAdapter<ParseObject>(this, "TestObject");
		adapter.setTextKey("foo");
		adapter.setImageKey("image");
		//Limit 10 objects per page
		adapter.setObjectsPerPage(10);
		
		ListView listView = (ListView) findViewById(R.id.HomeListView);
		listView.setAdapter(adapter);
	}

	
}
