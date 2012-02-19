package com.askme;

import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;

public class SemanticModel {
	
	private Model m_model;
	
	public Model init()
	{
		m_model = ModelFactory.createDefaultModel();
		
		return m_model;
	}
}
