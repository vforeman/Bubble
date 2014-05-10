package com.bubble;


import com.parse.ParseObject;
import com.parse.ParseClassName;


/**
 * Created by V on 5/7/14.
 */
@ParseClassName("BubbleObject")
public class BubbleObject extends ParseObject {
//CONTENT
    //getter and setter function for html
    public String getURL(){
        return getString("url");
    }
    public void setURL(String val){
        put("url", val);
    }

    //getter and setter function for html title
    public String getTitle(){
        return getString("title");
    }
    public void setTitle(String val){
        put("title", val);
    }

    //getter and adder function for tags
    //ALREADY IMPLEMENTED


//IMAGE
    //getter and setter functions for image source
    public String getImageSource(){
        return getString("source");
    }
    public void setImageSource(String val){
        put("source", val);
    }
    //getter and setter functions for image caption
    public String getImageCaption(){
        return getString("caption");
    }
    public void setImageCaption(String val){
        put("caption", val);
    }
//TEXT
    //getter and setter functions for image source
    public String getText(){
        return getString("source");
    }
    public void setText(String val){
        put("source", val);
    }
    //getter and setter functions for image caption
    public String getTextHeader(){
        return getString("header");
    }
    public void setTextHeaderString(String val){
        put("header", val);
    }

}


