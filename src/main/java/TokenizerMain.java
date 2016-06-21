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
 * Clase que contiene el código "tokenizador"
 * @author Bianney
 *
 */
public class TokenizerMain {
	
	/**
	 * Función que ejecuta el tokenizador
	 * @param input Archivo de entrada con la unión del texto de los distintos ficheros de entrada.
	 * @param output Archivo de salida, contendrá el texto separado en tokens.
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
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Fichero no encontrado", "ERROR", JOptionPane.ERROR_MESSAGE);
		} catch (InvalidFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Formato inválido", "ERROR", JOptionPane.ERROR_MESSAGE);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Error en operación de E/S", "ERROR", JOptionPane.ERROR_MESSAGE);
		}
	} 
}