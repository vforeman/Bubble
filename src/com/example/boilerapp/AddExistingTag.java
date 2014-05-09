package com.example.boilerapp;

import android.app.Activity;
import android.os.Bundle;

public class AddExistingTag extends Activity {
	public void onCreate(Bundle savedInstancesState){
		super.onCreate(savedInstancesState);
		setContentView(R.layout.add_tag_activity);
	
		
		/* TODO
		 * 1. Create an ArrayList of type string of tag names 
		 * (you might have to add an element, so it won't be null. We have to make the FRIENDS TAG in here anyway so we can insert that in the arraylist)
		 * 2. Make a ListFragment, that displays each element of the arraylist
		 * 3. Selecting an item from the ListFragment sets the current BubbleObject's tag attribute equal to the item. 
		 * 4. Send a Toast, "Added to (string) [item from arraylist] Tag"
		 * 5. Create an Intent that sends the user back to just Viewing the Article. (This will be just the shareactivity with the actionbar hidden)
		 * NOTE:
		 * Make sure the HomeList Gets updated
		 * Result:
		 * The Article will be placed and categorized within an existing activity
		 */
		
		
	}

}
