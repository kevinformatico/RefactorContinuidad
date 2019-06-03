package bchcontinuidad.Properties;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
//import java.util.HashMap;
//import java.util.Map;
import java.util.Properties;

import org.apache.log4j.Logger;

public class DatosSistema {
	private static final Logger LOGGER = Logger.getLogger(DatosSistema.class);
	public static final String ARCHIVO_PROPIEDADES = "test.properties";
	private static Properties properties;

	static {

		InputStream input;

		try {
			LOGGER.info("Obtener Propiedades - init");
			properties = new Properties();
			ClassLoader loader = Thread.currentThread().getContextClassLoader();
			input = loader.getResourceAsStream(ARCHIVO_PROPIEDADES);
			properties.load(input);

			LOGGER.info("Cargar Propiedades - end");
		} catch (FileNotFoundException e) {
			throw new RuntimeException("Excepcion EMT- Archivo " + ARCHIVO_PROPIEDADES + " no encontrado.", e);
		} catch (IOException e) {
			throw new RuntimeException("Excepcion EMT- Archivo " + ARCHIVO_PROPIEDADES + " no pudo ser cargado.", e);
		}
	}

	public static String getDatoProperties(String value) {
		LOGGER.info("Obtener Propiedades - end");
		return properties.getProperty(value);
	}
	
	public static Integer getDatoPropertiesInt(String value) {
		LOGGER.info("Obtener Propiedades - end");
		return Integer.parseInt(properties.getProperty(value));
	}
}
