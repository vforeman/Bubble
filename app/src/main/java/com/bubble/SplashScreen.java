package com.bubble;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

import com.parse.Parse;
import com.parse.ParseACL;
import com.parse.ParseAnalytics;
import com.parse.ParseObject;

public class SplashScreen extends Activity {
	private static int SPLASH_TIME_OUT = 1000;
	private static String TAG = "STARTING INTENT";
			
	@Override 
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		//setup the splash layout resource
		setContentView(R.layout.splash_activity);
        //register subclass
        ParseObject.registerSubclass(BubbleObject.class);

        final Intent loginIntent = new Intent(SplashScreen.this, LoginSignupActivity.class);
        final Intent shareIntent = new Intent(SplashScreen.this, ShareActivity.class);
        Intent startingIntent = getIntent();

        Log.i(TAG,startingIntent.toString());


		//Initialize parse
		Parse.initialize(this, "Vk63gfxJygySxzXaSs425z07iltOhB6BcgsMqbIM", "apBP4k0CA9H0O1VjyF61RaDU2xiqiVTob7pElAsh");
		//enable parse analytics
		ParseAnalytics.trackAppOpened(getIntent());
        ParseACL defaultACL = new ParseACL();
 
        // If you would like all objects to be private by default, remove this line.
        defaultACL.setPublicReadAccess(true);
 
        ParseACL.setDefaultACL(defaultACL, true);		






		//new command to open main activity in another thread
		new Handler().postDelayed(new Runnable(){

			@Override
			public void run() {
				//call the main activity and close this activty after a set amount of time
				startActivity(loginIntent);
				//close this activity
				finish();
			}
		}, SPLASH_TIME_OUT);	
	}
}






