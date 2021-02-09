package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import model.Animal;
import model.DeforestationZone;

public class PanelVentanaPrin extends JPanel implements MouseListener {
	
	private View view;
	
	
	public PanelVentanaPrin(View view) {
		

		
		setLayout(new BorderLayout());
		addMouseListener(this);
		setFocusable(true);
		this.view = view;
		//add(panelBotones, BorderLayout.SOUTH);

	}

	public void paintComponent(Graphics g) {
		ArrayList<DeforestationZone> zones = view.getDeforestationZones();
		ArrayList<Animal> animals = view.getAnimals();
		//view.addDeforestationZone(190, 280, 20);
		for (int i = 0; i <  zones.size(); i++) {
			g.setColor(Color.BLACK);
			DeforestationZone actualZone = zones.get(i);
			g.drawRect((int)actualZone.getLongitude(), (int)actualZone.getLatitude(), actualZone.getArea().width, actualZone.getArea().height);
			
			
		}
		
		for (int j = 0; j < animals.size(); j++) {
			Animal actualAnimal = animals.get(j);
			if(actualAnimal.isInDanger()) {
				g.setColor(Color.RED);
				g.fillOval((int)actualAnimal.getLongitude(), (int)actualAnimal.getLatitude(), 5, 5);
				System.out.println(actualAnimal.isInDanger());
				
			}
			else {
				g.setColor(Color.BLUE);
				g.fillOval((int)actualAnimal.getLongitude(), (int)actualAnimal.getLatitude(), 5, 5);
				System.out.println(actualAnimal.isInDanger());
			}
			
		}
		

//		Dimension height = getSize();
//		super.paintComponent(grafico);
//		ImageIcon Img = new ImageIcon("./recursos/Imagenes/Intro destroyer 2.png");// Pintar el fondo del inicio.
//		grafico.drawImage(Img.getImage(), 0, 0, height.width, height.height, null);
 
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		view.setLabX(""+e.getX());
		view.setLabY(""+e.getY());
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	
	
}
