

import org.junit.Assert;

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
		Assert.assertArrayEquals(filesNameExpected, filesName);	
	}

	/**
	 * Test que comprueba que un objeto de la clase LoadFiles se ha creado correctamente
	 */
	public void testCreateObject(){
		assertNotNull("El objeto se creó correctamente", new LoadFiles());
	}	
}