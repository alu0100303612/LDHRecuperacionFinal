import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * Clase que recoge el contenido que mostrar� la ventana y las funcionalidades de este
 * @author Bianney
 *
 */
public class Panel extends JPanel{
	private static final long serialVersionUID = 1L;
	//Variables est�ticas que establecen los textos de los botones del panel
	static final String loadFile = "Cargar";
	static final String go = "Tokenizar";
	static final String delete = "Borrar fichero";
	
	private String[] files = LoadFiles.load();//Array que guarda los nombres de los archivos de inputFiles/
	
	private JLabel loadFileLb = new JLabel("Cargar el achivo:");//Etiqueta del panel
	
	private JComboBox<String> filesCB = new JComboBox<String>(files);//ComboBox del panel
	
	//Declaraci�n de los botones
	public JButton loadButton = new JButton(loadFile);
	public JButton goButton = new JButton(go);
	public JButton deleteButton = new JButton(delete);
	
	FileController fileController = new FileController();
	File input = new File("files/input.txt");//Fichero de entrada
	File output = new File("files/output.txt");//Fichero de salida
	
	public Panel(){
		setLayout(null);
		
		loadFileLb.setBounds(30, 50, 150, 25);
		add(loadFileLb);
		
		filesCB.setSelectedIndex(-1);
		filesCB.setBounds(180, 50, 100, 25);
		add(filesCB);
		
		loadButton.setBounds(70,120, 170, 25);
		loadButton.addActionListener((ActionListener) new NewAction());
		add(loadButton);
		
		goButton.setBounds(70, 150, 170, 25);
		goButton.addActionListener((ActionListener) new NewAction());
		add(goButton);
		
		deleteButton.setBounds(70, 180, 170, 25);
		deleteButton.addActionListener((ActionListener) new NewAction());
		add(deleteButton);
		
        fileController.deleteFile(input);
        fileController.deleteFile(output);
	}
	
	/**
	 * Clase privada que establece las acciones que se deben ejecutar al pulsar los botones del panel
	 * @author Bianney
	 *
	 */
	private class NewAction implements ActionListener{
		
		/**
		 * Funci�n con la cual se carga el contenido de los archivos de entrada seleccionados en una variable. 
		 * Se ejecuta al pulsar el bot�n "Cargar"
		 */
		public void loadFile(){
			boolean emptyComboBox = CheckEmpty.check(filesCB);//Comprueba si se ha seleccionado algún fichero
			if (emptyComboBox == true){
				JOptionPane.showMessageDialog(null, "Escoja un archivo", "ERROR", JOptionPane.ERROR_MESSAGE);
			}else{
				String fileName = filesCB.getSelectedItem().toString();//Recoge el nombre del fichero
				File file = new File("inputFiles/" + fileName);//A�ade la ruta
				fileController.addText(file);//Llamada a la funci�n que a�ade el texto del fichero a la variable
			}
		}
		
		/**
		 * Funci�n que pone en marcha el proceso de "tokenizaci�n". Llama a la funci�n add(File) de FileController 
		 * y a la funci�n est�tica tokenizer(File, File) de TokenizerMain. Se ejecuta al pulsar el bot�n "Tokenizar"
		 */
		public void go(){
			fileController.add(input);
			TokenizerMain.tokenizer(input, output);
		}
		
		/**
		 * Funci�n que borra el contenido de la variable est�tica finalText, y de los ficheros input y output.
		 */
		public void delete(){
			FileController.finalText = "";
			fileController.deleteFile(input);
			fileController.deleteFile(output);
		}
		
		/**
		 * Funci�n que gestiona el funcionamiento de los botones
		 */
		public void actionPerformed(ActionEvent event){
			String nameEvent = event.getActionCommand(); 
			switch (nameEvent) {
		        case loadFile:
		        	loadFile();
		        break;
		        case go:
		        	go();
		        break;
		        case delete:
		        	delete();
		        break;
		        default :
		        	System.out.println("NewAction.ActionEvent. No entr� en ning�n lado");
		        break;
		    }	
		}		
	}
}