package com.example.boilerapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class HomeActivity extends Activity {
	
	TextView nameOut; /*global*/
	
	@Override
	public void onCreate (Bundle savedInstanceState)
	{
		
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.home_activity);
		
		Intent intent = getIntent();
		
		String text = intent.getStringExtra("screenText");
		
		Log.i("New Activity", "Intent Text = " +text);
		if(text!=null)
		{
		nameOut = (TextView) findViewById (R.id.name);
		nameOut.setText(text);
		}
		
	}
	
	public void addComment (View v)
	{
		String name,comment,other;
		
		EditText nameIn = (EditText) findViewById (R.id.user_nameIn);
		EditText commentIn = (EditText) findViewById (R.id.user_passIn);
		EditText otherIn = (EditText) findViewById (R.id.user_emailIn);
		
		name = nameIn.getText().toString();
		comment = commentIn.getText().toString();
		other = otherIn.getText().toString();
		
		TextView commentOut = (TextView) findViewById (R.id.comment);
		TextView otherOut = (TextView) findViewById (R.id.other);
		
		nameOut.setText(name);
		commentOut.setText(comment);
		otherOut.setText(other);
		
	}

}
