package tests;
import java.io.File;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import app.FileController;

/**
 * Clase que implementa un test para la clase FileController
 * @author Bianney
 *
 */
public class FileControllerTest {
	FileController fileController;
	
	/**
	 * Función que se ejecuta antes de testFileController(). Crea el objeto con el que se harán las pruebas
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		fileController = new FileController();
	}

	/**
	 * Función que se ejecuta después de testFileController. Establece fileController como Null
	 * @throws Exception
	 */
	@After
	public void tearDown() throws Exception {
		fileController = null;
	}
	
    /**
     * Test que comprueba que la funcion fileToString(File) devuelve el valor 
     * esperado.
     */
    @Test
    public void testFileController() {
        Assert.assertNotNull(fileController);
        
        String expectedText = "This is the file number one ";
        File file = new File("inputFiles/file1.txt");
        Assert.assertNotNull(file);
        String text = fileController.fileToString(file);
        Assert.assertEquals(expectedText, text);
    }
}