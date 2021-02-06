package model;

import java.util.HashMap;

/**
 * This class works as an intermediary 
 */

public class Principal {
	
	private HashMap<String, Animal> animals;
	private HashMap<String, DeforestationZone> deforestationZone;
	
	public Principal(HashMap<String, Animal> animals, HashMap<String, DeforestationZone> deforestationZone) {
		super();
		this.animals = animals;
		this.deforestationZone = deforestationZone;
	}

	public HashMap<String, Animal> getAnimals() {
		return animals;
	}

	public HashMap<String, DeforestationZone> getDeforestationZone() {
		return deforestationZone;
	}
	
	
	
	

}

