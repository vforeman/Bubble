package com.example.boilerapp;

import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.parse.FindCallback;
import com.parse.ParseACL;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;



public class HomeActivity extends Activity {
	ListAdapter homeListAdapter;
	ListView homeList;
	Toast toast;
	
	@Override
	public void onCreate (Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.home_activity);
		final Intent ListIntent = new Intent(this, HomeListActivity.class);
		//setup toast for debugging
		toast = new Toast(getApplicationContext());
		toast.setGravity(Gravity.CENTER_HORIZONTAL|Gravity.TOP, 0, 0);
		toast.setDuration(Toast.LENGTH_LONG);
		
		RetrieveContent();
		
		
		//homelist is dependent on listadapter being instanciated first
		
		//configure adapter for loading content to home listview
		//custom homelistview automatically grabs the listadapter in this context
		
		
		//====Parse Experimenting ===//
		ParseACL defaultACL = new ParseACL();
		//all objects public by default
		defaultACL.setPublicReadAccess(true);
		ParseACL.setDefaultACL(defaultACL, true);
		
		ParseObject testObject = new ParseObject("TestObject");
		testObject.put("foo", "BOUND");
		testObject.saveInBackground();
		
		//Setting Up the Adapter to Fetch Queries 
		ParseQuery<ParseObject> query = new ParseQuery<ParseObject>("TestObject");
		//Find All Test Objects that we have
		query.findInBackground(new FindCallback<ParseObject>( ){
			@Override 
			public void done(List<ParseObject> parseObjects, ParseException e){
				Toast.makeText(HomeActivity.this, String.format("Done %d", parseObjects.size()), Toast.LENGTH_LONG).show();
				startActivity(ListIntent);
			}
		});
		
		
		
	}
	
	public void RetrieveContent(){
		Toast.makeText(getApplicationContext(), "retrieving content from cloud made entirely of bubbles", Toast.LENGTH_LONG).show();
	}
	

}
