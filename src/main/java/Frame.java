

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Clase que contiene la ventana de la interfaz gr�fica del programa
 * @author Bianney
 *
 */
public class Frame extends JFrame{

	private static final long serialVersionUID = 1L;

	/**
	 * Constructor de la clase. Establece las caracter�sticas de la ventana.
	 * @param panel Panel que recoge el contenido de la ventana
	 * @param title T�tulo que se mostrar� en la ventana
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