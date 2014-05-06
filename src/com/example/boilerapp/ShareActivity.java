package com.example.boilerapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.webkit.WebView;
import android.widget.TextView;

public class ShareActivity extends Activity {
	
	private WebView shareWebView;
	
	
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
		TextView text = (TextView) findViewById(R.id.textView);
		String action = intent.getAction();
		
		
		 
		if (action.equalsIgnoreCase(Intent.ACTION_SEND) && intent.hasExtra(Intent.EXTRA_TEXT)) { 
		    String url = intent.getStringExtra(Intent.EXTRA_TEXT); 
		    web.loadUrl(url);
		} 
		
		
				
	
		
//		URL url;
//		try {
//			url = new URL(data.getScheme(), data.getHost(), data.getPath());
//			BufferedReader rd = new BufferedReader(new InputStreamReader(url.openStream()));
//			String line = "";
//			while((line = rd.readLine()) != null){
//				text.append(line);
//			}
//			
//		} catch (Exception e){
//			e.printStackTrace();
//		}
	}
}
	
	
