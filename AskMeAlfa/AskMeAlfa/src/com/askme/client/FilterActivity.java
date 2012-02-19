package com.askme.client;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.Spinner;

public class FilterActivity extends Activity implements OnTouchListener {
	
	
	private final static int START_DRAGGING = 0;
	private final static int STOP_DRAGGING = 1;
	private int status;
	ImageView  image;
	
	Button bnSubj;
	Button bnPred;
	Button bnObj;
	Spinner lvSubj;
	Spinner lvPred;
	Spinner lvObj;
	
	LinearLayout layout;
	LayoutParams params;
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.filter);
        
        layout = (LinearLayout) findViewById(R.id.linearLayout2);

        bnSubj = (Button) findViewById(R.id.bnSubject);
        bnSubj.setDrawingCacheEnabled(true);
        bnSubj.setOnTouchListener(this);
        
        bnPred = (Button) findViewById(R.id.bnPredicate);
        bnPred.setDrawingCacheEnabled(true);
        bnPred.setOnTouchListener(this);   
        
        bnObj = (Button) findViewById(R.id.bnObject);
        bnObj.setDrawingCacheEnabled(true);
        bnObj.setOnTouchListener(this);
        
        /*lvSubj = new Spinner(null);
        lvPred = new Spinner(null);
        lvObj = new Spinner(null);*/
        
        params = new LayoutParams(LayoutParams.WRAP_CONTENT,
				LayoutParams.WRAP_CONTENT);
        
        
    }

	public boolean onTouch(View view, MotionEvent me) {
		
		if (me.getAction() == MotionEvent.ACTION_DOWN) {
			status = START_DRAGGING;
			System.out.println(me.getX());
			image = new ImageView(this);
			image.setImageBitmap(view.getDrawingCache());
		}
		if (me.getAction() == MotionEvent.ACTION_UP) {
			status = STOP_DRAGGING;
			Log.i("Drag", "Stopped Dragging");
		}
		else if (me.getAction() == MotionEvent.ACTION_MOVE) {
			if (status == START_DRAGGING) {
				switch (view.getId()) {
				case R.id.bnSubject:
					//layout.addView(lvSubj, params);
					break;
				case R.id.bnPredicate :
					//layout.addView(lvPred, params);
					break;
				case R.id.bnObject :
					//layout.addView(lvObj, params);
					break;
				}
				image.setPadding(0,0, 0, 0);
				image.invalidate();
			}
		}
		
		return false;
	}
}
