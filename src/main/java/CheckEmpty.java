import javax.swing.JComboBox;
 /**
  * Clase utilizada para hacer comprobaciones en los JComboBox
  * @author Bianney
  *
  */
public class CheckEmpty {
	
	/**
	 * Metodo que comprueba si un JComboBox tiene seleccionado algun elemento
	 * @param input JComboBox a comprobar
	 * @return Booleano que representa si el comboBox esta o no vacio
	 */
	public static boolean check (JComboBox<String> input){
		if (input.getSelectedIndex() < 0){
			return true;
		}
		return false;
	}
}
