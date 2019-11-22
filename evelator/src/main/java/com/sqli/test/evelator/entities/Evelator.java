package com.sqli.test.evelator.entities;

import com.sqli.test.evelator.State.StateEvelator;
import com.sqli.test.evelator.State.StopedState;
import com.sqli.test.evelator.State.UpState;

/**
 * @author rout
 *
 * Nov 19, 2019
 *
 * @project evelator
 */

public class Evelator {

	private String id;
	private StateEvelator state;
	private int flore;
	private int lasteflore;
	
	public void Up(int f) {
		if (this.flore <f) {
		this.lasteflore = flore;
		this.state.UP();
		this.flore = f;
		}
	}
	
	public void Down(int f) {
		if (this.flore > f) {
		this.state.DOWN();
		this.lasteflore = flore;
		this.flore = f;
		}
	}
	
	public void Stope() {
	   this.state.STOPE();
	}
	
	public Evelator(String id) {
		// TODO Auto-generated constructor stub
		this.id = id;
		this.flore = 0;
		this.lasteflore = flore;
		this.state = new StopedState();
		this.state.setEvelator(this);
				
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getFlore() {
		return flore;
	}

	public int getLastFlore() {
		return lasteflore;
	}
	public void setFlore(int flore) {
		this.lasteflore = this.flore;
		this.flore = flore;
	}

	public StateEvelator getState() {
		return state;
	}

	public void setState(StateEvelator state) {
		this.state = state;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.id+":"+this.flore+":"+this.state;
	}
	
	
}
