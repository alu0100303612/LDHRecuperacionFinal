import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;

import javax.swing.JOptionPane;

import opennlp.tools.tokenize.Tokenizer; 
import opennlp.tools.tokenize.TokenizerME; 
import opennlp.tools.tokenize.TokenizerModel;
import opennlp.tools.util.InvalidFormatException; 

/**
 * Clase que contiene el codigo "tokenizador"
 * @author Bianney
 *
 */
public class TokenizerMain {
	
	/**
	 * Funcion que ejecuta el tokenizador
	 * @param input Archivo de entrada con la union del texto de los distintos ficheros de entrada.
	 * @param output Archivo de salida, contendra el texto separado en tokens.
	 */
	public static void tokenizer(File input, File output) {
		try {
			InputStream modelIn = new FileInputStream( "models/en-token.model" );
			TokenizerModel model = new TokenizerModel( modelIn ); 
			Tokenizer tokenizer = new TokenizerME(model);
			FileController fileController = new FileController();
			String text = "";
			text = fileController.fileToString(input);
			/* note what happens with the "three depending on which model you use */ 
			String[] tokens = tokenizer.tokenize(text);
			FileWriter writer = new FileWriter(output);
			if (tokens.length > 0){
				writer.write(tokens[0]);
				for (int i = 1; i < tokens.length; i ++){
					writer.write("\n");
					writer.write(tokens[i]);
				}
			}else{
				JOptionPane.showMessageDialog(null, "Escoja un archivo que tokenizar", "ERROR", JOptionPane.ERROR_MESSAGE);
			}
			writer.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "Fichero no encontrado", "ERROR", JOptionPane.ERROR_MESSAGE);
			throw new RuntimeException(e);
		} catch (InvalidFormatException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "Formato invalido", "ERROR", JOptionPane.ERROR_MESSAGE);
			throw new RuntimeException(e);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "Error en operacion de E/S", "ERROR", JOptionPane.ERROR_MESSAGE);
			throw new RuntimeException(e);
		}
	} 
}