package model;

public abstract class Georeference {
	
	private long latitude;
	private long longitude;
	
	public Georeference(long latitude, long longitude) {
		this.latitude = latitude;
		this.longitude = longitude;
	}

}
