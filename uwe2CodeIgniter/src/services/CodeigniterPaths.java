package services;

import org.apache.commons.lang3.SystemUtils;

public class CodeigniterPaths {
	String baseDir = SystemUtils.IS_OS_LINUX ? 
			"/var/www/html/" : 
				"C:/xampp/htdocs/";
	

   public String getBaseDir() {
      return baseDir;
   }

   public void setBaseDir(String baseDir) {
      this.baseDir = baseDir;
   }
   
   public String getFQN() {
		return this.getClass().getCanonicalName();
	}

}
