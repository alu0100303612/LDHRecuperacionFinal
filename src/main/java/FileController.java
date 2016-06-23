import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.Scanner;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

/**
 * Clase que se encarga de todas las acciones relativas a los ficheros de entrada y salida
 * @author Bianney
 *
 */
public class FileController{
	public String finalText = "";//String que almacena el texto de los distintos archivos de entrada
	private Scanner scanner;//Objeto de la clase Scanner. Utilizado para leer ficheros
	
	/**
	 * Funcion que borra el contenido del fichero que se le pasa por parametro
	 * @param file Fichero al cual se le borra el contenido
	 */
	public void deleteFile(File file){
		PrintWriter writer;
		Logger logger = null;
		try {
			writer = new PrintWriter(file);
			writer.print("");
			writer.close();
		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null, "Fichero no encontrado", "ERROR", JOptionPane.ERROR_MESSAGE);
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * Funcion que aniade el texto de un fichero de entrada a la variable estatica finalText
	 * @param input Fichero de entrada
	 */
	public void addText(File input){
		String text = "";
		//Se recorre el fichero input y se va aniadiendo el contenido a la variable text
		try {
			scanner = new Scanner(input);
			while (scanner.hasNext()){
				text = text + scanner.next() + " ";
			}
		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null, "Fichero no encontrado", "ERROR", JOptionPane.ERROR_MESSAGE);
			throw new RuntimeException(e);
		}
		finalText = finalText + text;
	}
	
	/**
	 * Funcion que aniade al archivo que se le pasa por parametro el contenido de la variable estatica finalText
	 * @param output Archivo en el cual se escribira el contenido de finalText
	 */
	public void add(File output){
		try {
			scanner = new Scanner(finalText);
			FileWriter writer = new FileWriter(output);
			String text = "";
			
			while (scanner.hasNext()){
				text = scanner.next();
				writer.write(text);
				if (scanner.hasNext()){
					writer.write(" ");
				}
			}	
			writer.close();
		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null, "Fichero no encontrado", "ERROR", JOptionPane.ERROR_MESSAGE);
			throw new RuntimeException(e);
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Error en operacion de E/S", "ERROR", JOptionPane.ERROR_MESSAGE);
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * Funcion que devuelve en un String el contenido de un fichero de texto
	 * @param input 
	 * @return
	 */
	public String fileToString (File input){
		String text = "";
		Scanner scanner;
		try {
			scanner = new Scanner(input);
			while (scanner.hasNext()){
				text = text + scanner.next() + " ";
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null, "Fichero no encontrado", "ERROR", JOptionPane.ERROR_MESSAGE);
			throw new RuntimeException(e);
		}
		return text;
	}
	
	/**
	 * Funcion que establece el valor de la variable finalText
	 * @param input Valor que tomara finalText
	 */
	public void setFinalText(String input){
		finalText = input;
	}
}
