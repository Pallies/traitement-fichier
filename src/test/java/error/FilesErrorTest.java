package error;

import static org.junit.Assert.assertEquals;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.Test;

public class FilesErrorTest {

	private static final Path path = Paths.get("C:/Users/open-food-facts.csv");
	@Test
	(expected=Exception.class)
	public final void testFilesErrorExceptionTrue()throws Exception {
		 new FilesError(true, path);
	}
	@Test
	(expected=Exception.class)
	public final void testFilesErrorExceptionFalse()throws Exception {
		 new FilesError(false, path);
	}
	@Test
	(expected=FilesError.class)
	public final void testExceptionFilesErrorTrue()throws FilesError {
		new FilesError(true, path);
	}
	@Test
	(expected=FilesError.class)
	public final void testExceptionFilesErrorFalse()throws FilesError {
		new FilesError(false, path);
	}
	@Test
	public final void testMessageTrue() {
		StringBuilder msgError = new StringBuilder();
		msgError.append("Le fichier ").append(path.getFileName())
		.append(" n'est pas présent dans le répertoire :\n")
		.append(path.getParent());
	assertEquals(msgError.toString(),FilesError.message(true, path));
	}
	@Test
	public final void testMessageFalse() {
		StringBuilder msgError = new StringBuilder();
		msgError.append("Le fichier ").append(path.getFileName())
		.append(" n'est pas accessible en mode lecture\n");
	assertEquals(msgError.toString(),FilesError.message(false, path));
	}
}
