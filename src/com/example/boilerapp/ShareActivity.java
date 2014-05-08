package com.example.boilerapp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.webkit.WebView;
import android.widget.TextView;

public class ShareActivity extends Activity {
	static public final String TAG = "db!!!!";
	private WebView shareWebView;
	public TextView text = (TextView) findViewById(R.id.textView);
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		
		//Allow Network access, in user interface thread
		StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
		StrictMode.setThreadPolicy(policy);
	
		//====Setting up Webview====
		WebView web = new WebView(this);
		setContentView(web);
		web.getSettings().setJavaScriptEnabled(true);
		
		
		//===Getting Information from Intent Filter ===
		Intent intent = getIntent();
		//convert intent to string uri representation
		String uriString = intent.toUri(0);				
		String action = intent.getAction();

		 
		if (action.equalsIgnoreCase(Intent.ACTION_SEND) && intent.hasExtra(Intent.EXTRA_TEXT)) { 
		    String url = intent.getStringExtra(Intent.EXTRA_TEXT); 
		    web.loadUrl(url);
		} 

		
		/* Steps:
		 * Download HTML (Cache), Load Downloaded HTML (Call for Resources when connected to internet),
		 * Share Intent, needs to ensure that user is logged into Bubble 
		 */
				
	}
	
	
		
		
	
}
	
	
