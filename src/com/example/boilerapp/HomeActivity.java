package com.example.boilerapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;
public class HomeActivity extends Activity {
	ListAdapter homeListAdapter;
	ListView homeList;
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
		
		//homelist is dependent on listadapter being instanciated first
		
		//configure adapter for loading content to home listview
		//custom homelistview automatically grabs the listadapter in this context
		homeList = new HomeListView(getApplicationContext());
	}
	
	public void RetrieveContent(){
		Toast.makeText(getApplicationContext(), "retrieving content from cloud made entirely of bubbles", Toast.LENGTH_LONG).show();
	}
	

}
