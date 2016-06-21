

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Clase que contiene la ventana de la interfaz grafica del programa
 * @author Bianney
 *
 */
public class Frame extends JFrame{

	private static final long serialVersionUID = 1L;

	/**
	 * Constructor de la clase. Establece las caracteristicas de la ventana.
	 * @param panel Panel que recoge el contenido de la ventana
	 * @param title Titulo que se mostrara en la ventana
	 */
	public Frame(JPanel panel, String title){
		setTitle (title);
		setSize(320, 290);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		getContentPane().add(panel);
		setVisible(true);
	}	
}