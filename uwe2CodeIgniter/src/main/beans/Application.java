package main.beans;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import services.CodeigniterInputPaths;
import services.FileReader;

public class Application {
	//Hace falta una clase de Paths? Cada path pertenece a un "concern" y quiza pueda asignarse en la clase correspondiente.
	//Lo vamos a hacer así porque en caso de que sea ncesario cambiar las rutas por un cambio de versión de Laravel podemos decir que usamos el principio de responsasbilidad simple
	
   //public String AppType = "web"; lo vamos a descartar por ahora porque no queda comprendido dentro del caso de estudio

   public String locale = "es-ES";
   private FileReader fr = new FileReader();
   private CodeigniterInputPaths cip = new CodeigniterInputPaths();
   private String defaultAppName;
   
   public String getDefaultAppName(String framework) {
	   switch(framework) {
	      case "Laravel": 
	    	  return "App";
	      case "Yii2":
	    	  return "";
	      case "CI": case "CodeIgniter":
	    	  return "Application";
	      default:
	    	  return "";
	   }
   }
   
	public String getAppConfigLines(String keyword) {
      return fr.getFile(cip.getConfigAppPath(), keyword);
    }

	public String getConfig() {
	      return fr.getFile(cip.getBaseDir() + cip.getConfigPath());
	    }
	
	public String getAppConfig() {
		return fr.getFile(cip.getBaseDir() + cip.getConfigAppPath());
	}
	
	public String getRoutes(){
		return fr.getFile(cip.getBaseDir() + cip.getRoutesPath());
	}
		 
	public String getLocale() {
		return locale;
	}
	
	public String getFQN() {
		return this.getClass().getCanonicalName();
	}
	
	public void setLocale(String locale) {
		this.locale = locale;
	}
	
	public void setAppName(String pathFramework, String appName) {
		Runtime r = Runtime.getRuntime();
		Process p;
		try {
			p = r.exec("php " + pathFramework + "/artisan app:name " + appName);
			p.waitFor();
			BufferedReader b = new BufferedReader(new InputStreamReader(p.getInputStream()));
			String line = "";
			
			while ((line = b.readLine()) != null) {
				  System.out.println(line);
			}
			
			b.close();
			
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}

		
	}
	
}
