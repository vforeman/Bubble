package com.example.boilerapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.parse.LogInCallback;
import com.parse.Parse;
import com.parse.ParseAnalytics;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.R.string;
import com.parse.SignUpCallback;


public class SplashScreen extends Activity {
	
	private static int SPLASH_TIME_OUT = 5000;
	private static String TAG = "signup";
			
	
	@Override 
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		//setup the splash layout resource
		setContentView(R.layout.splash_activity);
		//Initialize parse
		Parse.initialize(this, "Vk63gfxJygySxzXaSs425z07iltOhB6BcgsMqbIM", "apBP4k0CA9H0O1VjyF61RaDU2xiqiVTob7pElAsh");
		
		
		final Button newAccountButton = (Button) findViewById(R.id.new_account_button);		
		newAccountButton.setOnClickListener(new View.OnClickListener() {		
			@Override
			public void onClick (View v)
			{
				//create account
				ParseUser user = new ParseUser();
				user.setUsername(getResources().getString(R.string.user_name));
				user.setPassword(getResources().getString(R.string.user_pass));
				user.setEmail(getResources().getString(R.string.user_email));			
				user.signUpInBackground(new SignUpCallback(){

					@Override
					public void done(ParseException arg0) {
						if(arg0!=null){
						Log.i(TAG, "signup failed");}else{
							Log.i(TAG, "signup good");
						}
						new Handler().postDelayed(new Runnable(){

							@Override
							public void run() {
								//call the main activity and close this activty after a set amount of time
								Intent mainIntent = new Intent(SplashScreen.this, MainActivity.class);
								startActivity(mainIntent);
								//close this activity
								finish();
							}
						}, SPLASH_TIME_OUT);
					}
	
				});					
			}	
		});
		
		
		final Button loginButton = (Button) findViewById(R.id.login_button);		
		loginButton.setOnClickListener(new View.OnClickListener() {		
			@Override
			public void onClick (View v)
			{
				//login to existing account
				ParseUser.logInInBackground(getResources().getString(R.string.user_name), 
						getResources().getString(R.string.user_pass), new LogInCallback(){

							@Override
							public void done(ParseUser arg0, ParseException arg1) {
								// TODO Auto-generated method stub
								new Handler().postDelayed(new Runnable(){

									@Override
									public void run() {
										//call the main activity and close this activty after a set amount of time
										Intent mainIntent = new Intent(SplashScreen.this, MainActivity.class);
										startActivity(mainIntent);
										//close this activity
										finish();
									}
								}, SPLASH_TIME_OUT);
							}
					
				});
			}	
		});
		
		
		
		//new command to open main activity in another thread
//		new Handler().postDelayed(new Runnable(){
//
//			@Override
//			public void run() {
//				//call the main activity and close this activty after a set amount of time
//				Intent mainIntent = new Intent(SplashScreen.this, MainActivity.class);
//				startActivity(mainIntent);
//				//close this activity
//				finish();
//			}
//		}, SPLASH_TIME_OUT);
		
	}
	
	

}






