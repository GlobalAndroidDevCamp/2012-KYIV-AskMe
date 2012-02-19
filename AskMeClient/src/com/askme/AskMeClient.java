package com.askme;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class AskMeClient extends Activity implements OnClickListener  {
 
 Button bnOpenFilter;
 //Intent intent = new Intent(this, FilterActivity.class);
 
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        bnOpenFilter = (Button) findViewById(R.id.bnCreateFilter);
        bnOpenFilter.setOnClickListener( this);
    }
    
    //@Override
    public void onClick(View v) {
     switch (v.getId()) {
     case R.id.bnCreateFilter:
      Intent intent = new Intent(this, FilterActivity.class);
      startActivity(intent);
      break;
     default:
      break;
     } 
    }
}