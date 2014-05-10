package com.bubble;

import android.app.Activity;
import android.os.Bundle;

public class CreateTag extends Activity {
	
	public void onCreate(Bundle savedInstancesState){
		super.onCreate(savedInstancesState);
		setContentView(R.layout.create_tag_activity);
		
		
		/* TODO
		 * 1. Create a Text Field with submit button
		 * 2. Set The string result of the text field equal to the value of the tag attribute of the BubbleObject 
		 * 3. Add The result to the ArrayList of Tag Names.
		 * 4. Programatically create a new Activity of the string result. 
		 * 5. Send a Toast, "Added to (string) Tag"
		 * 6. Create an Intent that sends the user back to just Viewing the Article. (This will be just the shareactivity with the actionbar hidden)
		 * NOTE:
		 * Make sure the HomeList Gets updated
		 * Result:
		 * The new Activity created should be a child of the Bubbles Activity (in terms of navigation), so it will be added to the list view under the Bubbles activity (listadapter)
		 */
		
	}

}
