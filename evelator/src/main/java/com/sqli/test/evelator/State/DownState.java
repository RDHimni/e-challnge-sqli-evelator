package com.sqli.test.evelator.State;

/**
 * @author rout
 *
 * Nov 19, 2019
 *
 * @project evelator
 */

public class DownState extends StateEvelator{


	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "down";
	}

	@Override
	public void UP() {
		// TODO Auto-generated method stub
	}

	@Override
	public void DOWN() {
		// TODO Auto-generated method stub
	}

	@Override
	public void STOPE() {
		// TODO Auto-generated method stub
       evlator.setState(new DownState());
}

}
