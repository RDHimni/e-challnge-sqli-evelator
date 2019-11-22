package com.sqli.test.evelator.State;

import com.sqli.test.evelator.entities.Evelator;

/**
 * @author rout
 *
 * Nov 19, 2019
 *
 * @project evelator
 */

public abstract class StateEvelator {

	protected Evelator evlator;
	
	public abstract void UP();
	public abstract void DOWN();
	public abstract void STOPE();
	public abstract String toString();
	
   public void	setEvelator(Evelator evlator) {
	   this.evlator = evlator;
   }



	
}
