package com.example.boilerapp;
import android.content.Context;
import android.view.Gravity;
import android.widget.Toast;
public class BubbleLogger extends Toast{
	Context ctx;
	public BubbleLogger(Context context) {
		super(context);
		ctx = context;
		this.setGravity(Gravity.CENTER_HORIZONTAL|Gravity.TOP, 0, 0);
		
	}
	
	
	@SuppressWarnings("static-access")
	public void show(String str){
		this.setText(str);
		this.makeText(ctx,str,Toast.LENGTH_LONG).show();
	}

}
