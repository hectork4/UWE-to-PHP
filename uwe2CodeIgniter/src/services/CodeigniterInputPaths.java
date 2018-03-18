package services;

public class CodeigniterInputPaths extends CodeigniterPaths{
	String configAppPath = "/CodeIgniter/index.php"; //ESto hay que hacerlo depender del BASE_DIR de Laravel
	String routesPath = "/CodeIgniter/application/config/routes.php";//NO
	String configPath = "/CodeIgniter/application/config/config.php";
	String pathModel = "/CodeIgniter/application/models/";
	String pathView = "/CodeIgniter/application/views/";
	
	public String getConfigAppPath() {
		return configAppPath;
   }
	
	public String getConfigPath() {
	      return configPath;
	   }

   public void setConfigAppPath(String configApp) {
      this.configAppPath = configApp;
   }

   public String getRoutesPath() {	   	
	    return routesPath;
   }

   public void setRoutesPath(String routes) {
	   this.routesPath = routes;
   }
     
   public String getPathModel() {
	      return pathModel;
   }

   public String getPathView() {
	      return pathView;
}
}
