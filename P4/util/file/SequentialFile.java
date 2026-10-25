package P4.util.file;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * 
 * SequentialFile
 * 
 * @param <T>
 */
public class SequentialFile<T extends SequentialFileReadable> {

	private File file;
	private Scanner scan;
	private String separator;

	/**
	 * constructor
	 * 
	 * @param fileName  nombre archivi
	 * @param separator separador
	 * @throws FileNotFoundException
	 */
	public SequentialFile(String fileName, String separator) throws FileNotFoundException {
		this.file = new File(fileName);
		this.scan = new Scanner(file);
		this.separator = separator;
	}

	/**
	 * metodo read
	 * 
	 * @param t
	 */
	public void read(T t) {
		String[] data = scan.nextLine().split(separator);
		t.readData(data);
	}

	/**
	 * salta una linea
	 */
	public void skip() {
		scan.nextLine();
	}

	/**
	 * cierra el archivi
	 */
	public void close() {
		scan.close();
	}

	/**
	 * devuelve si se ha llegado al final del archivo
	 * 
	 * @return true o false
	 */
	public boolean isEndOfFile() {
		return !scan.hasNextLine();
	}

}
