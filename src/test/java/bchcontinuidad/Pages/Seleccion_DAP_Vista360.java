package bchcontinuidad.Pages;

import org.apache.log4j.Logger;
import bchcontinuidad.Properties.DatosSistema;
import bchcontinuidad.Utils.Functions;


public class Seleccion_DAP_Vista360 extends Launcher{
	
	public String SDap = DatosSistema.getDatoProperties("SDap");
	public String V360 = DatosSistema.getDatoProperties("V360");
	public String TDap = DatosSistema.getDatoProperties("TDAP");
	
	//Instanciando utilidades
	Functions funcionalidades = new Functions();	
	
	public void DAP() throws Exception{
		funcionalidades.loggerConsole("Esperamos que aparesca Vista 360");
		funcionalidades.EsperaSinClick(V360);
		funcionalidades.capturarPantalla(driver, "05");
		funcionalidades.EsperaSinClick(SDap);
		funcionalidades.loggerConsole("Seleccionamos la Opcion Dap de Vista 360");
		funcionalidades.capturarPantalla(driver, "06");
		funcionalidades.Espera(SDap);
		funcionalidades.loggerConsole("Espera");
		funcionalidades.EsperaSinClick(TDap);
		funcionalidades.capturarPantalla(driver, "07");
		funcionalidades.Espera(TDap);
	}
	
}
