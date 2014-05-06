package com.example.boilerapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class ShareActivity extends Activity{
	
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.share_activity);
		Context ctx = getBaseContext();
		Intent shareIntent = getIntent();
		Uri uri = shareIntent.getData();		
		WebView web = new WebView(ctx);
		
		
//		if(!isNetworkAvailable()){
//			web.getSettings().setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
//		}
		
		
		
		
		
	}
	
	public boolean isNetworkAvailable(){
		ConnectivityManager connManager = (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);
		NetworkInfo activeNetworkInfo = connManager.getActiveNetworkInfo();
		return activeNetworkInfo != null;
	}
	
	

}
