package bchcontinuidad.Pages;

import static org.junit.Assert.fail;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import bchcontinuidad.Properties.DatosSistema;
import bchcontinuidad.Utils.Functions;


public class Launcher {
	
	private static final String EXTENSION_IMAGEN = ".png";
	protected String url = DatosSistema.getDatoProperties("UrlBF");
	protected static WebDriver driver;
	protected StringBuffer verificationErrors = new StringBuffer();
	
	
	Functions funcionalidades = new Functions();
	
	@Before
	public void setUp() throws Exception {
		funcionalidades.loggerConsole("INICIANDO @BEFORE");
		String operationSystem = System.getProperty("os.name").toLowerCase();
		
		funcionalidades.loggerConsole("setUp():ES WINDOWS");
		//	System.setProperty("webdriver.chrome.driver", "./src/main/resources/Runners/chromedriver72.exe");
		//	System.setProperty("webdriver.chrome.driver", "./src/main/resources/Runners/chromedriver73.exe");
			System.setProperty("webdriver.chrome.driver", "./src/main/resources/Runners/chromedriver74.exe");
		//	System.setProperty("webdriver.chrome.driver", "./src/main/resources/Runners/chromedriver75.exe");
		//	ChromeOptions options = new ChromeOptions();
		//	options.addArguments("--start-maximized");
		//	driver = new ChromeDriver(options);
	
		//chrome Headless
		funcionalidades.loggerConsole("Abrimos chrome headless");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("headless");
		options.addArguments("--disable-features=VizDisplayCompositor");//para sacar fotos con jenkins
		options.addArguments("window-size=1280x1024");
		driver = new ChromeDriver(options);
		//*/

		driver.manage().window().maximize();
	}
	
	@After
	public void tearDown() throws Exception {
		funcionalidades.loggerConsole("INICIANDO @AFTER tearDown():" + this.getClass().getName());
		driver.quit();
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
			/*prueba*/
		}
	}
	
	protected boolean isElementPresent(By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}
	
	protected boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
			return false;
		}
	}
	
	protected void waitSleep(int second) {
		funcionalidades.loggerConsole("INICIO -----> ESPERA:" + second + " / SEGUNDOS");
		long millis = second * 1000;
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		funcionalidades.loggerConsole("FIN    -----> ESPERA:" + second + " / SEGUNDOS");
	}
	
	protected void cerrarSecion() {
		waitSleep(10);
		WebElement cerrarSecion = driver.findElement(By.id("logout"));
		cerrarSecion.click();
		funcionalidades.loggerConsole("Se dio Click En Logout");
		waitSleep(2);
		WebElement botonAceptar = driver.findElement(By.id("btn__aceptar"));
		funcionalidades.loggerConsole("Encontramos el boton Aceptar");
		botonAceptar.click();
		funcionalidades.loggerConsole("Se dio Click En Aceptar");
		waitSleep(3);
	}
}
