package org.q10viking.adapter;

public class Captain implements RowingBoat {
	private RowingBoat rowingBoat;
	public Captain(RowingBoat rowingBoat) {
		this.rowingBoat = rowingBoat;
	}
	
	@Override
	public void row() {
		rowingBoat.row();
	}

}
