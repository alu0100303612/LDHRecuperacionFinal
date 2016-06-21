import java.io.File;

import org.junit.Assert;
import org.junit.Test;

/**
 * Clase que implementa un test para la clase FileController
 * @author Bianney
 *
 */
public class FileControllerTest {

	/**
	 * Test que comprueba que la función fileToString(File) devuelve el valor 
	 * esperado.
	 */
	@Test
	public void testFileController() {
		FileController fileController = new FileController();
		String expectedText = "This is the file number one ";
		File file = new File("inputFiles/file1.txt");
		String text = fileController.fileToString(file);
		Assert.assertEquals(expectedText, text);
	}
}