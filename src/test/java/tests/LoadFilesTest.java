package tests;


import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import app.LoadFiles;

/**
 * Clase que implementa tests para la clase LoadFiles
 * @author Bianney
 *
 */
public class LoadFilesTest{
	static String[] filesName;
	
	/**
	 * Función que se ejecuta antes de los tests. Carga en la variable filesName el nombre de los ficheros
	 * @throws Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		filesName = LoadFiles.load();
	}

	/**
	 * Función que se ejecuta después de los tests. Asigna el valor null a filesName
	 * @throws Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		filesName = null;
	}
	
	/**
     * Test que comprueba que se puede acceder a un método de la clase LoadFiles
     */
	@Test
    public void testAccessLoadFiles(){
        assertNotNull("No se puede acceder correctamente", filesName);
    }
	
	/**
     * Test que comprueba el buen funcionamiento de la funcion load()
     */
	@Test
    public void testLoadFiles(){
        //Array con los nombres esperados de los ficheros
        String[] filesNameExpected = new String[4];
        filesNameExpected[0] = "file1.txt";
        filesNameExpected[1] = "file2.txt";
        filesNameExpected[2] = "file3.txt";
        filesNameExpected[3] = "file4.txt";
        //Array con los nombres obtenidos con la funcion load()
        Arrays.sort(filesName);
        Assert.assertArrayEquals(filesNameExpected, filesName);
	}
}