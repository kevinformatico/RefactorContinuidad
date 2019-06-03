package bchcontinuidad.Runnings;

//import java.io.IOException;

import org.junit.Test;


import org.apache.log4j.Logger;
import bchcontinuidad.Pages.Launcher;
import bchcontinuidad.Pages.Login;
import bchcontinuidad.Pages.DAP.Toma_DAP;
import bchcontinuidad.Pages.Seleccion_DAP_Vista360;

import bchcontinuidad.Utils.Functions;

public class Test_01_DAP_CLP extends Launcher {

	//Instanciando utilidades
	Functions funcionalidades = new Functions();

	@Test
	public void DAP_CLP() throws Exception {
		
		//Login
		Login login = new Login();
		login.Ingreso();
		funcionalidades.loggerConsole("Ingresaremos el usuario y sus datos");
		login.IngresarUsuario();
		funcionalidades.loggerConsole("Ingresaremos a buscar RUT");
		login.BusquedaRut();
		
		//Flujo DAP
		funcionalidades.scroll();
		Seleccion_DAP_Vista360 V360 = new Seleccion_DAP_Vista360();
		V360.DAP();
		Toma_DAP TDAP = new Toma_DAP();
		TDAP.Seleccion();
		TDAP.DPF();
	}
	
}