package app;
import java.io.File;

/**
 * Clase que carga los nombres de los ficheros .txt existentes en el directorio inputFiles/
 * @author Bianney
 *
 */
public class LoadFiles {

    /**
     * Constructor privado vacio
     */
    private LoadFiles(){
    }

    /**
     * Funcion que devuelve un array con los nombres de los ficheros contenidos en el directorio 
     * inputFiles
     * @return Array con los nombres de los ficheros .txt
     */
    public static String[] load(){
        String path = "inputFiles/";//Ruta que contiene los archivos de entrada
        String files;
        File folder = new File(path);//Objeto de tipo File que se refiere al directorio inputFiles/
        File[] listOfFiles = folder.listFiles();//Array de File que almacena los ficheros del directorio
        String[] filesName = new String[listOfFiles.length];//Array de String que almacena el nombre de los ficheros
        
        for (int i = 0; i < listOfFiles.length; i++){
            if (listOfFiles[i].isFile()){
                files = listOfFiles[i].getName();

                if (files.endsWith(".txt") || files.endsWith(".TXT")){
                    filesName[i] = listOfFiles[i].getName();
                }
            }
        }
        return filesName;
    }
}