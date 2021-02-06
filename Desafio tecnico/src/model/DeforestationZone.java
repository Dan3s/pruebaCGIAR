package model;

public class DeforestationZone extends Georeference{
	
	private String deforestationArea;

	public DeforestationZone(long latitude, long longitude, String deforestationArea) {
		super(latitude, longitude);
		this.deforestationArea = deforestationArea;
		
	}

}
