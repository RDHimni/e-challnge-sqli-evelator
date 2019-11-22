package com.sqli.test.evelator.factory;

import com.sqli.test.evelator.entities.Evelator;

/**
 * @author rout
 *
 * Nov 19, 2019
 *
 * @project evelator
 */

public class FactoryEvelator {
	
	public Evelator getInstance(String id) {
		return new Evelator(id);
	}

}
