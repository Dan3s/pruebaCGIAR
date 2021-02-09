package model;

public class Animal extends Georeference{
	
	private String owner;
	private boolean isInDanger;
	

	public Animal(String owner, long longitude, long latitude) {
		super(longitude, latitude);
		isInDanger = false;
		
	}


	public boolean isInDanger() {
		return isInDanger;
	}

	public void setInDanger(boolean isInDanger) {
		this.isInDanger = isInDanger;
	}

	public String getOwner() {
		return owner;
	}
	

}
