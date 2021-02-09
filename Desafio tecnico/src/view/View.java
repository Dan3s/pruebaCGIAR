package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.Controller;
import model.Animal;
import model.DeforestationZone;

public class View extends JFrame implements ActionListener{

	/**
	 * Constante que representa el nombre de la ventana
	 */

	public static final String NOMBRE = "Ubicación de ganado";
	/**
	 * Constante que representa la altura de la ventana
	 */
	public static final int ALTURA = 200;
	/**
	 * Constante que representa la anchura de la ventana
	 */
	public static final int ANCHO = 200;
	/**
	 * Constante que representa la escala de la ventana
	 */
	public static final int ESCALA = 4;
	
	/**
	 * Panel que contiene el fondo de la ventana
	 **/
	private PanelVentanaPrin panelFondo;
	
	private Controller controller;
	
	private JButton butDeforestation;
	private JTextField txtDeforestation;
	private JButton butAnimals;
	private JTextField txtAnimals;
	private JPanel panelCampos;
	
	private JLabel labIndicacion;
	private JLabel labX;
	private JLabel labY;
	private JPanel panelCoordenadas;
	
	private JButton butAyuda;


	public View(Controller contro) {
	
//		setMinimumSize(new Dimension(ANCHO * ESCALA, ALTURA * ESCALA));
//		setMaximumSize(new Dimension(ANCHO * ESCALA, ALTURA * ESCALA));
		//Dimension d = Toolkit.getDefaultToolkit().getScreenSize(); 
		setPreferredSize(new Dimension(ANCHO * ESCALA, ALTURA * ESCALA));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		setResizable(true);
		//setLocationRelativeTo(null);
		panelFondo = new PanelVentanaPrin(this);
		//setLocationRelativeTo(null);
		
		txtDeforestation = new JTextField();
		butDeforestation = new JButton("Agregar zona de deforestación");
		
		txtAnimals = new JTextField();
		butAnimals = new JButton("Agregar animal");
		
		butAyuda = new JButton("Ayuda");
		
		panelCampos = new JPanel();
		panelCampos.setLayout(new GridLayout(3, 2));
		panelCampos.add(txtDeforestation);
		panelCampos.add(butDeforestation);
		panelCampos.add(txtAnimals);
		panelCampos.add(butAnimals);
		panelCampos.add(butAyuda);
		
		butDeforestation.addActionListener(this);
		butAnimals.addActionListener(this);
		butAyuda.addActionListener(this);
		
		panelCoordenadas = new JPanel();
		panelCoordenadas.setLayout(new GridLayout(3,1));
		labIndicacion = new JLabel("Haz click para ver coordenadas");
		labX = new JLabel("Longitud (x): ");
		labY = new JLabel("Latitud (y): ");
		panelCoordenadas.add(labIndicacion);
		panelCoordenadas.add(labX);
		panelCoordenadas.add(labY);
		
		
		add(panelCampos, BorderLayout.SOUTH);
		add(panelFondo, BorderLayout.CENTER);
		add(panelCoordenadas, BorderLayout.NORTH);
		pack();
		setVisible(true);
				
		controller = contro;
		
	}
	
	public void addAnimal(String owner, long longitude, long latitude) {
		controller.getPrincipal().addAnimal(owner, longitude, latitude);
	}
	
	public void addDeforestationZone(long longitude, long latitude,  double deforestationArea) {
		controller.getPrincipal().addDeforestatioZone(longitude, latitude, deforestationArea);
	}
	
	public ArrayList<Animal> getAnimals(){
		return controller.getPrincipal().getAnimals();
	}
	
	public ArrayList<DeforestationZone> getDeforestationZones(){
		return controller.getPrincipal().getDeforestationZone();

	}
	
	public void setLabX(String labX) {
		this.labX.setText("Longitud (x): "+labX);
	}

	public void setLabY(String labY) {
		this.labY.setText("Latitud (y): "+labY);
	}

	public void addDeforestationZoneButton() {
		if(txtDeforestation.getText() != "") {
			String text = txtDeforestation.getText().replace(" ", "");
			String [] data = text.split("-");
			long latitude = Long.parseLong(data[0]);
			long longitude = Long.parseLong(data[1]);
			double area = Double.parseDouble(data[2]);
			addDeforestationZone(latitude,longitude, area);
			controller.cattleDangerCheck();
			panelFondo.repaint();
			pack();
			
		}
		else {
			JOptionPane.showMessageDialog(this, "Ingresa los datos separados por comas");
		}
		
	}
	
	public void addAnimalButton() {
		if(txtAnimals.getText() != "") {
			String text = txtAnimals.getText().replace(" ", "");
			String [] data = text.split("-");
			String owner = data[0];
			long latitude = Long.parseLong(data[1]);
			long longitude = Long.parseLong(data[2]);
			addAnimal(owner, latitude, longitude);
			controller.cattleDangerCheck();
			panelFondo.repaint();
			pack();
			
		}
		else {
			JOptionPane.showMessageDialog(this, "Ingresa los datos separados por comas");
		}
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==butDeforestation) {
			addDeforestationZoneButton();
		}
		else if(e.getSource()==butAnimals) {
			addAnimalButton();
		}
		
		else if(e.getSource()==butAyuda) {
			JOptionPane.showMessageDialog(this, "Para agregar una zona escribe los datos de la siguiente forma:\n longitud-latitud-area. \nPara agregar una animal: \n owner-longitude-latitud");
		}
		
	}
	
}
