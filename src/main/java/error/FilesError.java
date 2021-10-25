package error;

import java.nio.file.Path;

/**
 * The Class FilesError.
 * Erreur de lecture de fichier
 * Erreur le fichier n'est pas accessible en mode lecture
 */
public class FilesError extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2514747614181276666L;
	

	public FilesError(boolean isExist,Path path) {
		super(message(isExist,path));
	}

	/**
	 * Message.
	 *
	 * @param isNotExist the is not exist
	 * @return the string
	 */
	public static String message(boolean isNotExist,Path path) {
		StringBuilder msgError = new StringBuilder();
		msgError.append("Le fichier ").append(path.getFileName());
		
		if(isNotExist)
			return msgError.append(" n'est pas présent dans le répertoire :\n")
					.append(path.getParent()).toString();
		return msgError.append(" n'est pas accessible en mode lecture\n").toString();
	}
	
}
