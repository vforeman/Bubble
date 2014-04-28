package com.example.boilerapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback; 

public class LoginSignupActivity extends Activity{
	
	private final String TAG = "Main Activity";
	Button loginButton;
	Button signupButton;
	String usernameStr;
	String passwordStr;
	EditText passwordField;
	EditText usernameField;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login_signup);
		Log.i(TAG, "onCreate");
		
		
		
		//get fields from xml
		usernameField = (EditText) findViewById(R.id.email);
		passwordField = (EditText) findViewById(R.id.password);
		
		//get buttons from xml
		loginButton = (Button) findViewById(R.id.login_button);
		signupButton = (Button) findViewById(R.id.new_account_button);
		
		//login button click listener
		loginButton.setOnClickListener( new OnClickListener(){
			public void onClick(View arg0){
				//get text from fields
				usernameStr = usernameField.getText().toString();
				passwordStr = passwordField.getText().toString();
				
				//send data to parse for verification
				ParseUser.logInInBackground(usernameStr, passwordStr, 
						new LogInCallback(){
							public void done(ParseUser user, ParseException e){
								if(user != null){
									Intent homeActivity = new Intent(LoginSignupActivity.this,HomeActivity.class);
									startActivity(homeActivity);
									Toast.makeText(getApplicationContext(), "logged in", Toast.LENGTH_LONG).show();
									finish();
								}else{
									Toast.makeText(getApplicationContext(), "not bubblin'", Toast.LENGTH_LONG).show();
								}
							}
						});
				}
		});//end of login button listener
		
		//signup button listener
		signupButton.setOnClickListener(new OnClickListener(){
			public void onClick(View arg0) {
				//get text from fields
				usernameStr = usernameField.getText().toString();
				passwordStr = passwordField.getText().toString();
				
				//force user to fill fields
				if(usernameStr.equals("") && passwordStr.equals("")){
					Toast.makeText(getApplicationContext(), "fill the shit", Toast.LENGTH_LONG).show();
				}else{
					//save user info to Parse
					ParseUser user = new ParseUser();
					user.setUsername(usernameStr);
					user.setPassword(passwordStr);
					user.signUpInBackground(new SignUpCallback(){
						public void done(ParseException e){
							if(e == null){
								// Show a simple Toast message upon successful registration
                                Toast.makeText(getApplicationContext(),
                                        "Successfully Signed up, please log in.",
                                        Toast.LENGTH_LONG).show();
                            } else {
                                Toast.makeText(getApplicationContext(),
                                        "Sign up Error", Toast.LENGTH_LONG)
                                        .show();
                            }
						}
					});
				}
			}
			
		});
		
		
		
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	 
	@Override
	public void onStart()
	{
		super.onStart();
		Log.i(TAG, "onStart");
	}
	
	@Override
	public void onResume()
	{
		super.onResume();
		Log.i(TAG, "onResume");
	}
	
	//Activity is visible and Being used
	
	@Override
	public void onPause()
	{
		super.onPause();
		Log.i(TAG, "onPause");
	}
	
	@Override
	public void onStop()
	{
		super.onStop();
		Log.i(TAG, "onStop");
	}
	
	@Override
	public void onDestroy()
	{
		super.onDestroy();
		Log.i(TAG, "onDestroy");
	}
	
	public void buttonClick (View v)
	{
		Log.i(TAG, "Starting new Activity");
		Intent intent = new Intent(this, HomeActivity.class);
		intent.putExtra("screenText", "Hello World!");
		startActivity(intent);
		
		
	}
	
	

}
