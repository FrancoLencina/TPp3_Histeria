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
		HashMap <String,JButton> jButtonMap = new HashMap<String, JButton>();
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(60, 60, 60));
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new GridLayout(i, i, 1, 1));
		
	
		//Creamos un presentador
		ButtonController buttonController = new ButtonController(i);
		
		//Creamos todos los botones y los agregamos al diccionario jButtonMap
		for(int j = 0; j < i*i; j++) {
			JButton button = new JButton("");
			button.setBackground(new Color(50,50,50));
			frame.getContentPane().add(button);
			button.setName("" + j);
			jButtonMap.put(button.getName(), button);
		//Creamos el objeto Button asociado al JButton
			buttonController.addNewButton(button.getName(), button);
		}
		
		//Recorremos los JButtons informando al buttonController cuando uno esté activo
		for(JButton button : jButtonMap.values()) {
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					buttonController.activeButton(button.getName());
				}
			});
		}	
	}
}
