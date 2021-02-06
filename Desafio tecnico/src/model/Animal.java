package model;

public class Animal extends Georeference{
	
	private String owner;

	public Animal(String owner, long latitude, long longitude) {
		super(latitude, longitude);
		
	}
	
	/**
	 * 
	 * @param latitude -  Deforestation zone latitude
	 * @param longitude - Deforestation zone longitude
	 * @return true if the animal is in the deforestation zone. False in other case
	 */
	public boolean isInDeforestationZone(long latitude, long longitude) {
		return false;
	}
	

}
