package org.q10viking.adapter;

/*
 * Adapter class.Adapts the interface of the device({@link} FishingBoat) into {@link RowingBoat}
 * interface expected by the client(Captain)
 */
public class FishingBoatAdapter implements RowingBoat {
	private FishingBoat boat;
	
	public FishingBoatAdapter() {
		boat = new FishingBoat();
	}
	
	@Override
	public void row() {
		boat.sail();
	}

}
