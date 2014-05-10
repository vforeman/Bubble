package com.bubble;

import android.content.Context;
import android.webkit.JavascriptInterface;
import android.widget.Toast;

/**
 * Created by V on 5/8/14.
 */
public class WebBubbleInterface {
    Context mContext;

    /** Instantiate the interface and set the context */
    WebBubbleInterface(Context c) {
        mContext = c;
    }

    /** Show a toast from the web page */
    @JavascriptInterface
    public void showToast(String toast) {
        Toast.makeText(mContext, toast, Toast.LENGTH_SHORT).show();
    }
    @JavascriptInterface
    public void showPos(String pos){
        Toast.makeText(mContext, pos, Toast.LENGTH_SHORT).show();

    }
}
