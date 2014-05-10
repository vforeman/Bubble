package com.bubble;

import android.content.Context;
import android.view.MotionEvent;
import android.webkit.WebView;
import android.widget.Toast;

/**
 * Created by V on 5/8/14.
 */
public class WebBubbleView extends WebView {
    Context mContext;
    public WebBubbleView(Context ctx){
        super(ctx);
        mContext = ctx;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        Toast.makeText(mContext, "ACTION FAVORITES", Toast.LENGTH_LONG).show();

        return super.onTouchEvent(event);
    }
}
