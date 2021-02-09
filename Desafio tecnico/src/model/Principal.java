package model;

import java.util.ArrayList;
/**
 * This class works as an intermediary 
 */

public class Principal {
	
	private ArrayList<Animal> animals;
	private ArrayList< DeforestationZone> deforestationZones;
	
	public Principal() {
		super();
		this.animals = new ArrayList();
		this.deforestationZones = new ArrayList();
	}

	public ArrayList<Animal> getAnimals() {
		return animals;
	}

	public ArrayList<DeforestationZone> getDeforestationZone() {
		return deforestationZones;
	}
	
	public void addAnimal(String owner, long longitude, long latitude) {
		animals.add(new Animal(owner, longitude, latitude));
	}
	
	public void addDeforestatioZone(long longitude, long latitude, double deforestationArea) {
		deforestationZones.add(new DeforestationZone(longitude, latitude, deforestationArea));
	}
	
	public void cattleDangerCheck() {
		for (int i = 0; i < deforestationZones.size(); i++) {
			for (int j = 0; j < animals.size(); j++) {
				if(deforestationZones.get(i).getArea().contains(animals.get(j).getLongitude(), animals.get(j).getLatitude())) {
					animals.get(j).setInDanger(true);
				}
				else {
					//animals.get(j).setInDanger(false);
				}
			}
		}
		
	}

}

