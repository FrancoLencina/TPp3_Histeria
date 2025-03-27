package Interface;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridLayout;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.awt.event.ActionEvent;
import java.awt.Component;

public class View {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					View window = new View();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public View() {
		initialize(5);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(int i) { // i = número de filas y columnas
		
		//Creo un diccionario con los JButtons
		//HashMap <String,JButton> jButtonMap = new HashMap<String, JButton>();
		JButton[][] JButtonMatrix = new JButton[i][i];
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(60, 60, 60));
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new GridLayout(i, i, 1, 1));
		
	
		//Creamos un presentador
		ButtonController buttonController = new ButtonController(i);
		
		//Creamos todos los botones y los agregamos al diccionario jButtonMap
		for(int row = 0; row < JButtonMatrix.length; row++) {
			for(int column = 0; column < JButtonMatrix[0].length; column++) {
			JButton button = new JButton("");
			button.setBackground(new Color(50,50,50));
			frame.getContentPane().add(button);
			JButtonMatrix[row][column] = button;
			//jButtonMap.put(button.getName(), button);
		//Creamos el objeto Button asociado al JButton
			buttonController.addNewButton(row,column);
			}
		}
		
		/*
		//Recorremos los JButtons informando al buttonController cuando uno esté activo
		for(JButton button : jButtonMap.values()) {
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					buttonController.activeButton(button.getName());
				}
			});
		}	
		*/
		
		for(int row = 0; row < JButtonMatrix.length; row++) {
			for(int column = 0; column < JButtonMatrix[0].length; column++) {
				int r = row;
				int c = column;
				JButtonMatrix[row][column].addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						buttonController.activeButton(r, c);
					}
				});
				
			}
		}
		//Tenemor q ver como saber q jbutton se activa y pasarle esas coordenadas al buttoncontroller.
		//buttoncontroller tiene que encontrar el button conj esass coordenadas y decirle a button q cambie de color.	
		//buttoncontroller tiene q informar a view q ya se cambió el color
		//las vistas tiene q actualizarse 
	}
}
