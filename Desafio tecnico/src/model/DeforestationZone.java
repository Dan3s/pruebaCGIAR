package model;

import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;

public class DeforestationZone extends Georeference{
	
	private double deforestationArea;
	private Rectangle area;

	public DeforestationZone(long longitude, long latitude, double deforestationArea) {
		super(longitude, latitude);
		this.deforestationArea = deforestationArea;
		area = new Rectangle((int)longitude, (int)latitude, (int)deforestationArea, (int)deforestationArea);
		
	}

	public Rectangle getArea() {
		return area;
	}
	
	

}
