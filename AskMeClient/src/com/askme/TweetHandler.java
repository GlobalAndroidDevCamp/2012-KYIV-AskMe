package com.askme;

import java.io.IOException;

import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;
import twitter4j.auth.RequestToken;

public class TweetHandler {
 
 private final static String CONSUMER_KEY = "97c15fXjFMLAFo5MluRtKg";
  private final static String CONSUMER_KEY_SECRET = "6gEN9mBz3J7oVL1GuueekLbB5gUq9EnkDEtsVV1IlA";
 
 public static void sendTweet(String msg) throws TwitterException, IOException {
     String token = getSavedAccessToken();
     String secret = getSavedAccessTokenSecret();

     AccessToken a = new AccessToken(token,secret);
     Twitter twitter = new TwitterFactory().getInstance();
     twitter.setOAuthConsumer(CONSUMER_KEY, CONSUMER_KEY_SECRET);
     RequestToken requestToken = twitter.getOAuthRequestToken();  
    
     twitter.setOAuthAccessToken(a);
     twitter.updateStatus(msg);
 }
 
 private static String getSavedAccessToken() {
  return "496129345-nGd6kFxjKNVGebbcaquS6FfEihd7iGTQihMUy7as";
 }
 
 private static String getSavedAccessTokenSecret() {
  return "ewypqQDRXrVMVfIvdLS3VcZPStWuQou3vzUIqCdiko";
 }

}
