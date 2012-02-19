package com.askme;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class TwitterActivity extends Activity {
 
 EditText textOut;
 TextView textIn;
 
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tweet);
        
        Button bnCreateTweet = (Button) findViewById(R.id.bnCreateTweet);
        final EditText etTweetMsg = (EditText) findViewById(R.id.etTweetMsg);
        
        bnCreateTweet.setOnClickListener(new OnClickListener() {
   
   public void onClick(View v) {
            try {
             TweetHandler.sendTweet(etTweetMsg.getText().toString());
      } catch (Exception ex) {
       ex.printStackTrace();
      }
   }
  });
        
        
    }
    
   
}