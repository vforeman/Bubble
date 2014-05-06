package com.example.boilerapp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.StrictMode;
import android.widget.TextView;

public class ShareActivity extends Activity {
	
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		
		//Allow Network access, in user interface thread
		StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
		StrictMode.setThreadPolicy(policy);
		
		setContentView(R.layout.share_activity);
		Intent intent = getIntent();
		TextView text = (TextView) findViewById(R.id.textView);
		//Getting the action of the intent
		String action = intent.getAction();
		if (!action.equals(Intent.ACTION_VIEW)){
			throw new RuntimeException("Sommin Wrong");
		}
		//To Get Data
		Uri data = intent.getData();
		URL url;
		try {
			url = new URL(data.getScheme(), data.getHost(), data.getPath());
			BufferedReader rd = new BufferedReader(new InputStreamReader(url.openStream()));
			String line = "";
			while((line = rd.readLine()) != null){
				text.append(line);
			}
			
		} catch (Exception e){
			e.printStackTrace();
		}
		
	}
	

}
