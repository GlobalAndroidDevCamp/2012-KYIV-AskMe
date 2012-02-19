package com.askme;

import twitter4j.TwitterException;

import com.hp.hpl.jena.rdf.model.Model;

public class Main {

	private Model m_model;
	
	public static void main(String[] args) throws TwitterException, Exception {
		new TwitterAgent().init();
		new QueryHandler().init();
		
		
	}
}
