package tests;


import java.util.Arrays;

import org.junit.Assert;

import app.LoadFiles;
import junit.framework.TestCase;

/**
 * Clase que implementa tests para la clase LoadFiles
 * @author Bianney
 *
 */
public class LoadFilesTest extends TestCase {

   /**
     * Test que comprueba el buen funcionamiento de la funcion load()
     */
    public void testLoadFiles(){
        //Array con los nombres esperados de los ficheros
        String[] filesNameExpected = new String[4];
        filesNameExpected[0] = "file1.txt";
        filesNameExpected[1] = "file2.txt";
        filesNameExpected[2] = "file3.txt";
        filesNameExpected[3] = "file4.txt";
        //Array con los nombres obtenidos con la funcion load()
        String[] filesName = LoadFiles.load();
        Arrays.sort(filesName);
        Assert.assertArrayEquals(filesNameExpected, filesName);
    }

    /**
     * Test que comprueba que se puede acceder a un m�todo de la clase LoadFiles
     */
    public void testAccessLoadFiles(){
        assertNotNull("Se puede acceder correctamente", LoadFiles.load());
    }
}