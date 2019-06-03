package bchcontinuidad.Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.poi.util.Units;
import org.apache.poi.xwpf.usermodel.Document;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Functions {
	
	Functions funcionalidades = new Functions();
	
	//mensaje consola
	private final Logger LOGGER = Logger.getLogger(Functions.class);
	
	private static final String EXTENSION_IMAGEN = ".png";
	public static WebDriver driver;
	
	//.JAR para creacion de documento y captura pantalla
	static File dir = new File("./screenshots");
	static String[] ficheros = dir.list();
	
	//Captura de pantalla
	public void capturarPantalla(WebDriver driver, String nombreImagen) throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File("./screenshots/" + nombreImagen + EXTENSION_IMAGEN));
	}
	
	//Imprime mensaje por consola
	public void loggerConsole(String msn) {
		LOGGER.info(msn);
	}
	
	//Mueve la barra hacia abajo
	public void scroll() throws IOException {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		Calendar calendario = new GregorianCalendar();
	}
	
	//Espera (wait)
	public static void Espera(String xpath) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement Siguiente = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
		Siguiente.click();
	}
	
	//Espera que aparesca el campo para ingresar informacion
	public static void EsperaSendKeys(String xpath, String Keys) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement Siguiente = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
		Siguiente.sendKeys(Keys);
	}
	
	//Espera que el elemento este visible por xpath
	public static void EsperaSinClick(String xpath) {
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
	}
	
	//Espera que el elemento este visible por id
	public static void EsperaIDSinClick(String nombre) {
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(nombre)));
	}
	
	//Genera Documento de evidencia
	public void Documento(String filename, String fileContent) throws Exception {   
       XWPFDocument document = new XWPFDocument();   
       XWPFParagraph tmpParagraph = document.createParagraph();   
       XWPFRun tmpRun = tmpParagraph.createRun();   
       tmpRun.setText(fileContent);   
       tmpRun.setFontSize(18);   
       FileOutputStream fos = new FileOutputStream(new File("./Documento/"+filename + ".doc"));   
	    if (ficheros == null){
			System.out.println("No hay ficheros en el directorio especificado");
		}
		else{
			for (int x=0;x<ficheros.length;x++){					
				tmpRun.setFontSize(20);
				InputStream pic = new FileInputStream("./screenshots/"+ ficheros[x]);
				tmpRun.addPicture(pic, Document.PICTURE_TYPE_JPEG, "1", Units.toEMU(450), Units.toEMU(250));
			}
		}
       document.write(fos);   
       fos.close();   
    } 
	
	//Elimina la foto de evidencia
	public void eliminarFichero() {
		if (ficheros == null) {
			System.out.println("No hay ficheros en el directorio especificado");
		}else {
			for (int x=0;x<ficheros.length;x++) {
				funcionalidades.loggerConsole(ficheros[x]);
			}
		}
		
	}
}
