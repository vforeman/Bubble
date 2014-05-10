package com.bubble;

import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.ListView;
import android.widget.Toast;

import com.parse.FindCallback;
import com.parse.ParseACL;
import com.parse.ParseAnalytics;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseQueryAdapter;

import java.util.List;


public class HomeActivity extends Activity {

	Toast toast;
	
	@Override
	public void onCreate (Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.home_activity);
		//setup toast for debugging
		toast = new Toast(getApplicationContext());
		toast.setGravity(Gravity.CENTER_HORIZONTAL|Gravity.TOP, 0, 0);
		toast.setDuration(Toast.LENGTH_LONG);
		
		RetrieveContent();
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
        query.findInBackground(new FindCallback<ParseObject>() {
            @Override
            public void done(List<ParseObject> parseObjects, ParseException e) {
                Toast.makeText(HomeActivity.this, String.format("Done %d", parseObjects.size()), Toast.LENGTH_LONG).show();
                fillListView();
            }
        });
	}
	
	public void RetrieveContent(){
		Toast.makeText(getApplicationContext(), "retrieving content from cloud made entirely of bubbles", Toast.LENGTH_LONG).show();
	}


    public void fillListView(){
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
