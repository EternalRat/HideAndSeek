package fr.eter.hideandseek.utils;

import fr.eter.hideandseek.GStates;

public class StateManager {

	/**
	 * Game states
	 */
	private static GStates states;
	
	/**
	 * Set a new state to the game
	 * 
	 * @param states	States contained by GStates enum
	 */
	public static void setState(GStates newStates) {
		states = newStates;
	}
	
	/**
	 * Compare the two states
	 * 
	 * @param states	States which need to be check
	 * @return	boolean type : true/false
	 */
	public static boolean isState(GStates isStates) {
		return states == isStates;
	}
}
