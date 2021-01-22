package name.ostertag.test.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.invoke.MethodHandles;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FileHelper {
	private static Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass().getName());

	/**
	 * Create all parent Directories of a file given by filename
	 *
	 * @param filename
	 */
	public static void createParentTestDirectories(String filename) {
		final File directory = new File(filename).getParentFile();
		if (!directory.exists()) {
			directory.mkdirs();
		}
	}

	/**
	 * Read the file into a String(UTF-8).<BR>
	 * If we cannot find/read the file we log a warning and return <null>
	 *
	 * @param filename
	 * @return content of the File or <null>
	 */
	public static String readFile(String filename) {

//		LOGGER.debug("Result filename: " + filename);

		String content = "";
		try {
			final File file = new File(filename);
			if (!file.exists()) {
				LOGGER.warn("Cannot find File : " + filename);
				return null;
			}
			if (!file.canRead()) {
				LOGGER.warn("Cannot read File : " + filename);
				return null;
			}
			{
				final FileInputStream fis = new FileInputStream(file);
				final byte[] data = new byte[(int) file.length()];
				fis.read(data);
				fis.close();

				content = new String(data, "UTF-8");
			}

		} catch (final FileNotFoundException e) {
			LOGGER.error("An error occurred reading File: " + filename);
			LOGGER.error(JosExceptionUtils.CompactStackTrace(e));
		} catch (final IOException e) {
			LOGGER.error("An error occurred reading File: " + filename);
			LOGGER.error(JosExceptionUtils.CompactStackTrace(e));
		}
		return content;

	}

	/**
	 * Write content to File named filename.<br>
	 *
	 * If needed the parent directories are created
	 *
	 * @param filename
	 * @param content
	 */
	public static void writeFile(String filename, String content) {
		createParentTestDirectories(filename);
		try {
			final FileWriter myWriter = new FileWriter(filename);
			myWriter.write(content);
			myWriter.close();
		} catch (final IOException e) {
			LOGGER.error(JosExceptionUtils.CompactStackTrace(e));
		}
	}
}
