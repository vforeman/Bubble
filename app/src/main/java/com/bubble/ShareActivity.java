package com.bubble;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.AsyncTask;
import android.os.Bundle;



import android.app.ActionBar;
import android.os.StrictMode;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.method.ScrollingMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.RelativeSizeSpan;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.Parse;
import com.parse.ParseObject;
import com.parse.ParseQueryAdapter;

import org.jsoup.nodes.Document;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.io.InputStream;
import java.lang.*;

import static android.util.Log.wtf;
import static com.bubble.R.id.action_comment;
import static com.bubble.R.id.action_favorite;
import static com.bubble.R.id.action_tag;
import java.io.Serializable;

public class ShareActivity extends Activity {



    private final String EXCEPTION ="EXCEPTION";
    private final String HMTL = "HTML";
    private final String PARSING = "PARSING";
    private final String CLICKLISTENER = "CLICKLISTENER";
    private final String TEXTVIEW = "TEXTVIEW";
    private final String WEBVIEW = "WEBVIEW";
    protected  String scriptIncludes = "<script src=\"file:///android_asset/jquery.min.js\" type=\"text/javascript\"></script>"
            +   "<script src =\"file:///android_asset/bubblescript.js\" type=\"text/javascript\"></script>";
    protected  String jqueryCheck = "<script> if (typeof jQuery != 'undefined') {alert(\"jQuery library is loaded!\");}else{ alert(\"jQuery library is not found!\");}</script>"+
            "<input type=\"button\" value=\"Say hello\" onClick=\"showAndroidToast('Hello Android!')\" />\n";
    protected  String insertComment = "<p class='errol' style=\"background:-webkit-gradient(linear, 0 0, 0 100%, from(#075698), to(#2e88c4)); background:linear-gradient(#075698, #2e88c4); \">I\"m bubblin'.</p>";
    protected String highlight = "<style type=\"text/css\">\n" +
            ".highlight{\n" +
            "   background-color: black;\n" +
            "   color: white;\n" +
            "}\n" +
            "</style>\n" +
            "<script type=\"text/javascript\">\n" +
            "function createListener(){\n" +
            "   document.addEventListener('click', function(event){\n" +
            "      var element=event.target;\n" +
            "      if(element!==document.body){\n" +
            "Bubble.showPos(\"found it\");"+
            "         if(element.className===''){\n" +
            "            element.className='highlight';\n" +
            "         } else {\n" +
            "            element.className='';\n" +
            "         }\n" +
            "      }\n" +
            "   }, false);\n" +
            "}\n" +
            "</script>";
    BubbleObject article;
    public void onCreate(Bundle savedInstanceState){



        super.onCreate(savedInstanceState);
        Parse.initialize(this, "Vk63gfxJygySxzXaSs425z07iltOhB6BcgsMqbIM", "apBP4k0CA9H0O1VjyF61RaDU2xiqiVTob7pElAsh");


        ParseObject.registerSubclass(BubbleObject.class);
        article = new BubbleObject();
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        //=====create the actionbar for sharing activity=====
        ActionBar actionBar = getActionBar();
        setContentView(R.layout.share_activity);
        WebView web = (WebView) findViewById(R.id.webView);
        TextView htmlView = (TextView) findViewById(R.id.textView);
        //===Getting Information from Intent Filter =====
        Intent intent = getIntent();
        //convert intent to string uri representation
        String action = intent.getAction();
        String url="";



        //Check for webpage share intent and
        if (action.equalsIgnoreCase(Intent.ACTION_SEND) && intent.hasExtra(Intent.EXTRA_TEXT)) {
            url = intent.getStringExtra(Intent.EXTRA_TEXT);
        }
        Document doc = new Document(" ");
        try{wtf(PARSING,"START");
            doc = Jsoup.connect(url).get();
        }
        catch(IOException e){
            wtf(EXCEPTION,"EXCEPTION FROM PARSING");
            Log.i(EXCEPTION,e.toString());
//                finish();
        }
        String htmlText= doc.body().text();
        doc.head().append(scriptIncludes);
        doc.body().append(insertComment);
        doc.body().append(jqueryCheck);
        doc.body().append(highlight);
        String htmlData = doc.html();
        SpannableStringBuilder spanBuilder = new SpannableStringBuilder();
        Elements els = doc.body().children();
        int index = 0;
        //iterate through all the children of the body
        for(Element el : els){
            //get the raw html for this element
            String elStr = el.html();
            //add the raw html to the span Builder and set Clickable Atttribute
            spanBuilder.append(elStr);
            spanBuilder.setSpan(new ClickableSpan() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(getApplicationContext(), ((Integer) view.getTop()).toString(), Toast.LENGTH_LONG).show();
                }
                //define the span as the length of elStr
            }, index, index + elStr.length(), 0);
            //increment index for the next iteration
            index = index + elStr.length();
        }


        wtf(TEXTVIEW,"START");
        //====Setting up TextView====
        htmlView.setVerticalScrollBarEnabled(true);
        htmlView.setMovementMethod(new ScrollingMovementMethod());
        htmlView.setText(spanBuilder.toString());

        wtf(TEXTVIEW, "DONE");
        wtf(WEBVIEW,"START");
        //====Setting up Webview====
        web.getSettings().setJavaScriptEnabled(true);
        web.setWebChromeClient(new WebChromeClient());
        web.setWebViewClient(new WebViewClient());
        web.addJavascriptInterface(new WebBubbleInterface(this), "Bubble");
        web.setLongClickable(true);
        web.loadDataWithBaseURL("file:///android_asset/", htmlData, "text/html", "utf-8", null);
        wtf(WEBVIEW,"DONE");

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.share, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
//        ParseQueryAdapter<ParseObject> adapter = new ParseQueryAdapter<ParseObject>(this,"articleObject");
        if (id == action_favorite) {
            if((article.get("favorites") == null) ||(article.getBoolean("favorites")) == false){
                article.put("favorites",true);
                article.saveInBackground();
                Intent favIntent = new Intent(this,FavoritesActivity.class);
                startActivity(favIntent);
                Toast.makeText(getApplicationContext(), "FAVORITES ==false", Toast.LENGTH_LONG).show();
            }else{
                article.put("favorites",false);
                Toast.makeText(getApplicationContext(), "FAVORITES ==true" , Toast.LENGTH_LONG).show();
            }
            return true;
        }
        if (id == action_tag) {
            Toast.makeText(getApplicationContext(), "ACTION TAG", Toast.LENGTH_LONG).show();
//            Intent tagIntent = new Intent(this,Tag.class);
//            tagIntent.putExtra("articleObject",article);
//            startActivity(tagIntent);
            return true;
        }
        if (id == action_comment) {
            Toast.makeText(getApplicationContext(), "ACTION COMMENT", Toast.LENGTH_LONG).show();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}

