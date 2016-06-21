import javax.swing.JComboBox;
 /**
  * Clase utilizada para hacer comprobaciones en los JComboBox
  * @author Bianney
  *
  */
public class CheckEmpty {
	
	/**
	 * Método que comprueba si un JComboBox tiene seleccionado algún elemento
	 * @param input JComboBox a comprobar
	 * @return Booleano que representa si el comboBox está o no vacío
	 */
	public static boolean check (JComboBox<String> input){
		if (input.getSelectedIndex() < 0){
			return true;
		}
		return false;
	}
}
