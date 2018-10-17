package org.q10viking.adapter;

public class App {

	public static void main(String[] args) {
		Captain captain = new Captain(new FishingBoatAdapter());
		captain.row();
		
	}

}
