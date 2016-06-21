import javax.swing.JComboBox;
 /**
  * Clase utilizada para hacer comprobaciones en los JComboBox
  * @author Bianney
  *
  */
public class CheckEmpty {
	
	/**
	 * M�todo que comprueba si un JComboBox tiene seleccionado alg�n elemento
	 * @param input JComboBox a comprobar
	 * @return Booleano que representa si el comboBox est� o no vac�o
	 */
	public static boolean check (JComboBox<String> input){
		if (input.getSelectedIndex() < 0){
			return true;
		}
		return false;
	}
}
