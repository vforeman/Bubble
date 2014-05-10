package com.bubble;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.parse.FindCallback;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseQueryAdapter;

import java.util.List;


public class FavoritesActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Parse.initialize(this, "Vk63gfxJygySxzXaSs425z07iltOhB6BcgsMqbIM", "apBP4k0CA9H0O1VjyF61RaDU2xiqiVTob7pElAsh");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorites);



        ParseQuery<ParseObject> query = ParseQuery.getQuery("articleObject");
        query.findInBackground(new FindCallback<ParseObject>() {


            @Override
            public void done(List<ParseObject> parseObjects, ParseException e) {
                if (e == null){
                    String[] urls = new String[parseObjects.size()];
                    for (int i = 0; i< parseObjects.size(); i++)
                    {
                        urls[i] = parseObjects.get(i).getString("title");

                    }

                    ArrayAdapter adapter = new ArrayAdapter<String>(getApplicationContext(),
                                android.R.layout.simple_list_item_1, urls);

                    ListView listView = (ListView) findViewById(R.id.FavoritesListView);
                    listView.setAdapter(adapter);
                }
                else{
                   Toast.makeText(FavoritesActivity.this,"ughhhh", Toast.LENGTH_LONG).show();
                }
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.favorites, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
