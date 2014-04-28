package com.example.boilerapp;
import android.content.Context;
import android.widget.ListView;
public class HomeListView extends ListView{

	public HomeListView(Context context) {
		super(context);
		this.setAdapter(getAdapter());
	}

}

