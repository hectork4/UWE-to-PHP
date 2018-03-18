  package services;

  import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Paths;
import java.nio.file.attribute.PosixFilePermission;
import java.util.HashSet;
import java.util.Set;

import com.google.common.io.Files;

  public class FileReader {

  public String getFile(String path) {
     String ret = "";
     try {
        FileInputStream fStream = new FileInputStream(path);
        BufferedReader in = new BufferedReader(new InputStreamReader(fStream));
        while (in.ready()) {
           ret += in.readLine()+"\n";
         }
        in.close();
     }
     catch (IOException e) {
        System.out.println("File input error " + e.getMessage());
     }
  	return ret;
  }

  public String getFile(String path, String keyword) {
     String ret = "";
     try {
        FileInputStream fStream = new FileInputStream(path);
        BufferedReader in = new BufferedReader(new InputStreamReader(fStream));
        while (in.ready()) {
           if(in.readLine().contains(keyword)){
              ret += in.readLine()+"\n";   
           }         
         }
        in.close();
     }
     catch (IOException e) {
        System.out.println("File input error " + e.getMessage());
     }
     return ret;
  }

  public void makeFolder(String path){
     new File(path).mkdirs();
  }
  public String getFQN(){
  	return this.getClass().getCanonicalName();
  }

  public void renameFolder(String name, String path){
	  File old = new File(path);
	  File rootOld = new File(path + "../");
	  File newPath = new File(name);
	  System.out.println(old.getPath());
	  System.out.println(newPath.getPath());
	  System.out.println(rootOld.getPath());
	  old.setWritable(true, false);
	  old.setExecutable(true, false);
	  old.setReadable(true, false);
	  newPath.setWritable(true, false);
	  newPath.setExecutable(true, false);
	  newPath.setReadable(true, false);
	  try {
		Files.move(old, newPath);
	} catch (IOException e) {
		e.printStackTrace();
	}
    /*if ( dir.isDirectory() ) {
    	if (! dir.renameTo(newName)) {
    		System.out.println("Ha ocurrido un error al cambiar el nombre de una carpeta");
    	}
    }*/
  }

}
