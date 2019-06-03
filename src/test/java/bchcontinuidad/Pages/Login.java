package bchcontinuidad.Pages;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import bchcontinuidad.Properties.DatosSistema;

import bchcontinuidad.Utils.Functions;




public class Login extends Launcher{
	
	public String usuario = DatosSistema.getDatoProperties("User");
	public String LoginName = DatosSistema.getDatoProperties("LoginName");
	public String LoginPass = DatosSistema.getDatoProperties("LoginPass");
	public String LoginBoton = DatosSistema.getDatoProperties("LoginBoton");
	public String Clave =  DatosSistema.getDatoProperties("Pass");
	public String rutCli = DatosSistema.getDatoProperties("rutCLiente");
	
	Functions funcionalidades = new Functions();
	
	public void Ingreso() throws IOException {
		funcionalidades.loggerConsole("Ingresamos a la URL " + url);
		driver.get(url);
		funcionalidades.capturarPantalla(driver, "01");
	}
	
	public void IngresarUsuario() throws IOException {
		
		funcionalidades.loggerConsole("Estamos poniendo el usuario");
		
		if (driver.findElement(By.xpath(LoginName)).isDisplayed()) {
			funcionalidades.loggerConsole("Se encontro el name");
			funcionalidades.EsperaSendKeys(LoginName, usuario);
			funcionalidades.capturarPantalla(driver,"02");
			funcionalidades.EsperaSendKeys(LoginPass,Clave);
			funcionalidades.capturarPantalla(driver,"03");
			funcionalidades.Espera(LoginBoton);
		}else {
			funcionalidades.loggerConsole("No se encontro el elementpo ");
		}
	}
	
	public void BusquedaRut() throws IOException {
	
		String URLActual = driver.getCurrentUrl();
		waitSleep(2);
		if (URLActual != url) {
			funcionalidades.loggerConsole("Estamos poniendo la clave");
			IngresarUsuario();
			
		}else {
					
		}
		
		funcionalidades.loggerConsole("Espera a que salga el cuadro pa ingresar rut");
		funcionalidades.Espera("/html/body/div[1]/header/div/div[3]/div/ng-buscar-cliente-escritorio/form/a");
		funcionalidades.loggerConsole(" Verificar - rut cliente");
		funcionalidades.EsperaIDSinClick("rut");
		WebElement rut = driver.findElement(By.id("rut"));
		rut.sendKeys(rutCli);
		funcionalidades.capturarPantalla(driver, "04");
		funcionalidades.Espera("/html/body/div[1]/header/div/div[3]/div/ng-buscar-cliente-escritorio/form/a");
	}
	
	public Login(){
		
	}

}
