package bchcontinuidad.Pages.DAP;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import bchcontinuidad.Pages.Launcher;
import bchcontinuidad.Properties.DatosSistema;

import bchcontinuidad.Utils.Functions;


public class Toma_DAP extends Launcher{
	//WebDriver
	public static WebDriver driver;
	
	//
	public String Seleccion = DatosSistema.getDatoProperties("Seleccion");
	public String DPF = DatosSistema.getDatoProperties("DPF");
	public String DPIR = DatosSistema.getDatoProperties("DPIR");
	public String DPRA = DatosSistema.getDatoProperties("DPRA");
	
	//Instanciando utilidades
	Functions funcionalidades = new Functions();
	
	public void Seleccion() throws IOException {
		funcionalidades.loggerConsole("Presionamos tipo de documento ");
		funcionalidades.Espera(Seleccion);
		funcionalidades.capturarPantalla(driver, "09");
	}
	
	public void DPF() throws IOException {
		funcionalidades.loggerConsole("Vamos a seleccionar el tipo del DAP - DPF");
		funcionalidades.Espera(DPF);
		funcionalidades.capturarPantalla(driver, "10");
	}
	
	public void DPIR() throws IOException {
		waitSleep(1);
		funcionalidades.loggerConsole("Vamos a seleccionar el tipo del DAP - DPRI");
		funcionalidades.Espera(DPIR);
		funcionalidades.capturarPantalla(driver, "10");
	}
	
	public void DPRA() throws IOException {
		waitSleep(1);
		funcionalidades.loggerConsole("Vamos a seleccionar el tipo del DAP - DPRA");
		funcionalidades.Espera(DPRA);
		funcionalidades.capturarPantalla(driver, "10");
	}	
	
	public void pesos() {
		funcionalidades.Espera("//*[@id=\"vmInit\"]/div/ng-simulacion-dap-ingreso/section[1]/form/div/div/div[1]/div[1]/div/div[2]/div/div/span");
		funcionalidades.Espera("//*[@id=\"ui-select-choices-row-3-0\"]/a");
	}
	
	public void dolar() {
		driver.findElement(By.xpath("//*[@id=\"vmInit\"]/div/ng-simulacion-dap-ingreso/section[1]/form/div/div/div[1]/div[1]/div/div[2]/div/div/span")).click();
		waitSleep(1);
		driver.findElement(By.xpath("//*[@id=\"ui-select-choices-row-2-1\"]/a")).click();
	}
	
	public void UF() {
		driver.findElement(By.xpath("//*[@id=\"vmInit\"]/div/ng-simulacion-dap-ingreso/section[1]/form/div/div/div[1]/div[1]/div/div[2]/div/div/span")).click();
		waitSleep(1);
		driver.findElement(By.xpath("//*[@id=\"ui-select-choices-row-2-2\"]/a")).click();
	}
	
	public void SImularDAP() throws IOException{
		funcionalidades.loggerConsole("Vamos a simular");
		driver.findElement(By.xpath("//*[@id=\"vmInit\"]/div/ng-simulacion-dap-ingreso/section[1]/form/div/div/div[1]/div[1]/div/div[3]/div/input")).sendKeys("55000");
		funcionalidades.capturarPantalla(driver, "07");
		
		driver.findElement(By.xpath("//*[@id=\"vmInit\"]/div/ng-simulacion-dap-ingreso/section[1]/form/div/div/div[1]/div[1]/div/div[4]/div/input")).click();
		funcionalidades.loggerConsole("");
		waitSleep(2);
		driver.findElement(By.xpath("//*[@id=\"vmInit\"]/div/ng-simulacion-dap-ingreso/section[1]/form/div/div/div[1]/div[1]/div/div[7]/button")).click();
	}
	/*------------------------------------------------------------Flujo-----------------------------------------------------------------------*/
	public void siguienteEmul() throws IOException {
		waitSleep(2);
		funcionalidades.loggerConsole("Estamos esperando el Boton Siguiente");
		funcionalidades.Espera("//*[@id=\"vmInit\"]/div/ng-simulacion-dap-ingreso/section[1]/form/div/div/div[1]/div[1]/div/div[9]/button[2]");
		waitSleep(2);
		funcionalidades.capturarPantalla(driver, "08");
		funcionalidades.loggerConsole("Estamos esperando el boton simular");
		funcionalidades.Espera("//*[@id=\"vmInit\"]/div/ng-simulacion-dap-ingreso/section[1]/form/div/div/div[1]/div[2]/button[2]");
		funcionalidades.capturarPantalla(driver, "09");
		funcionalidades.loggerConsole("Seleccionaremos el tipo de cuenta ");
	}
	/*---------------------------------------------------Dap Siguiente Flujo-----------------------------------------------------*/
	public void TomDApCTACTE() throws IOException {
		funcionalidades.Espera("//*[@id=\"vmInit\"]/div/ng-simulacion-dap-ingreso/section[1]/form/div/div/ng-condiciones-dap-ingreso/div/section/fieldset/div/dap-formas-pago/div/div[1]/div[1]/div/div/span");
		funcionalidades.capturarPantalla(driver, "10");
		funcionalidades.Espera("//a[contains(span,'Corriente')]");
		funcionalidades.capturarPantalla(driver, "11");
		funcionalidades.Espera("//*[@id=\"vmInit\"]/div/ng-simulacion-dap-ingreso/section[1]/form/div/div/ng-condiciones-dap-ingreso/div/section/fieldset/div/dap-formas-pago/div/div[1]/div[6]/div/div/span");
		funcionalidades.capturarPantalla(driver, "12");
		funcionalidades.Espera("//a[contains(span,'004070093100')]");
		funcionalidades.capturarPantalla(driver, "13");
		driver.findElement(By.xpath("//*[@id=\"vmInit\"]/div/ng-simulacion-dap-ingreso/section[1]/form/div/div/ng-condiciones-dap-ingreso/div/section/fieldset/div/dap-formas-pago/div/div[1]/div[10]/input")).sendKeys("55000");
		funcionalidades.capturarPantalla(driver, "14");
		funcionalidades.Espera("//*[@id=\"vmInit\"]/div/ng-simulacion-dap-ingreso/section[1]/form/div/div/ng-condiciones-dap-ingreso/div/section/button");
		funcionalidades.capturarPantalla(driver, "15");
		WebElement sobrecupo = driver.findElement(By.xpath("/html/body/div[2]/div[2]/button[1]"));
		
	}
	public void TomaDAPChequeMismoBanco() {
		waitSleep(1);
		driver.findElement(By.xpath("//*[@id=\"vmInit\"]/div/ng-simulacion-dap-ingreso/section[1]/form/div/div/ng-condiciones-dap-ingreso/div/section/fieldset/div/dap-formas-pago/div/div[1]/div[1]/div/div/span")).click();
		waitSleep(1);
		driver.findElement(By.xpath("//*[@id=\"ui-select-choices-row-23-0\"]/a")).click();//Cehequera
	}
	
	public void TomaDAPChequeOtroBanco() {
		waitSleep(1);
		driver.findElement(By.xpath("//*[@id=\"vmInit\"]/div/ng-simulacion-dap-ingreso/section[1]/form/div/div/ng-condiciones-dap-ingreso/div/section/fieldset/div/dap-formas-pago/div/div[1]/div[1]/div/div/span")).click();
		waitSleep(1);
		driver.findElement(By.xpath("//*[@id=\"ui-select-choices-row-23-1\"]/a/span")).click();//documento otro banco
	}
	
	public void TomaDAPefectivo() {
		waitSleep(1);
		driver.findElement(By.xpath("//*[@id=\"vmInit\"]/div/ng-simulacion-dap-ingreso/section[1]/form/div/div/ng-condiciones-dap-ingreso/div/section/fieldset/div/dap-formas-pago/div/div[1]/div[1]/div/div/span")).click();
		waitSleep(1);
		driver.findElement(By.xpath("//*[@id=\"ui-select-choices-row-23-3\"]/a")).click();//Efectivo
	}
	
	public void BtnToma() throws IOException {
		funcionalidades.loggerConsole("Esperamos Boton ");
		funcionalidades.capturarPantalla(driver, "16");
		funcionalidades.Espera("/html/body/div[4]/div/div/div/div[4]/div[2]/button[3]");
		funcionalidades.capturarPantalla(driver, "17");
		waitSleep(5);
		funcionalidades.capturarPantalla(driver, "18");
		funcionalidades.Espera("//button[@class='btn default simulation-cards-edit focus-rut-cliente mr-15']");
		waitSleep(5);
		funcionalidades.capturarPantalla(driver, "19");
	}
	
	/**
	 * Verificacion de popat
	 * @throws IOException 
	 * 
	 * **/
	public void popa() throws IOException {
		waitSleep(2);
		if (driver.findElement(By.xpath("//button[@class='confirm']")).isSelected()) {
			funcionalidades.loggerConsole("Se encontro ellemnto");
			funcionalidades.Espera("/html/body/div[2]/div[2]/button[1]");
			waitSleep(1);
			//driver.findElement(By.xpath("")).click();
		}else {
			funcionalidades.loggerConsole("No se encontro ellemnto");
		}
		
	}
}
