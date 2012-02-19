package com.askme;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;

public class TwitterAgent {
	
	private final static String CONSUMER_KEY = "97c15fXjFMLAFo5MluRtKg";
	private final static String CONSUMER_KEY_SECRET = "6gEN9mBz3J7oVL1GuueekLbB5gUq9EnkDEtsVV1IlA";
	private final static String ACCESS_TOKEN = "496127046-h2hVXzcd08MDvHDXwYKVOUcO1K7OuzyBfm1mr5ua";
	private final static String ACCESS_TOKEN_SECRET = "8lZ8FqdKjcxudoAjgq3RCUg3NfnKLVJid2OmcORMQ";
	
	Timer m_timer;
	List<Integer> m_statuses_hashes;
	Twitter m_twitter;
	
	protected void init() throws TwitterException {
		
		m_twitter = new TwitterFactory().getInstance();
		m_twitter.setOAuthConsumer(CONSUMER_KEY, CONSUMER_KEY_SECRET);
		m_twitter.setOAuthAccessToken(new AccessToken(ACCESS_TOKEN, ACCESS_TOKEN_SECRET));
	    
		m_statuses_hashes = new ArrayList<Integer>();
		
		m_timer = new Timer();
		m_timer.scheduleAtFixedRate(new TimerTask() {
			
			@Override
			public void run() {
				try {
					List<Status> statuses = m_twitter.getFriendsTimeline();
					
					for (Status status: statuses)	{
						if (!m_statuses_hashes.contains(status.hashCode()))	{
							
							
							
							System.out.println("@" + status.getUser().getScreenName() + " - " + status.getText());
							
							if (m_statuses_hashes.size() > 50) {
								m_statuses_hashes.remove(0);
							}
							m_statuses_hashes.add(status.hashCode());
						}
					}
					
				} catch (TwitterException e) {
					System.out.println(e.getMessage());
				}
				
			}
		}, 0, 5000);
		
		System.out.println("twitter agend started");
	}
	
	public void start() throws TwitterException {
		init();
	}
}
