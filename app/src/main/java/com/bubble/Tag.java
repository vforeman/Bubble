package com.bubble;

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Tag extends Activity {
	
	Button addTagButton;
	Button createTagButton;
	public void onCreate(Bundle savedInstancesState){
		super.onCreate(savedInstancesState);
		setContentView(R.layout.tag_activity);
		
		//get buttons from xml
		addTagButton = (Button) findViewById(R.id.add_tag);
		createTagButton = (Button) findViewById(R.id.create_tag);
		
		
	//Add Tag Listner	
	addTagButton.setOnClickListener( new OnClickListener(){
		public void onClick(View arg0){
				Intent AddExistingTag = new Intent(Tag.this,AddExistingTag.class);
				startActivity(AddExistingTag);
		}
		
	});
	
	// Create Tag Listner
	createTagButton.setOnClickListener( new OnClickListener(){
		public void onClick(View arg0){
				Intent CreateTag = new Intent(Tag.this,CreateTag.class);
				startActivity(CreateTag);
		}
		
	});
}
	
	
}
