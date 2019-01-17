package de.haeherfeder.DeDePlEngine.Window;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class CreateConfig {
	private File config = new File("config/config.xml");
	private File configFolder = new File("config");
	
	private void props(Properties p) {
		setPr("hight","200",p);
		setPr("width","800",p);
		setPr("BuchstabeBestätigung","J",p);
		setPr("","",p);
		setPr("timesleep","8",p);
	}
	
	
	public CreateConfig(Properties p) throws IOException {
		if(!configFolder.exists()) 	{configFolder.mkdirs();}
		if(config.exists()) 	{
			if(config.length()==0) { return;}
		}
		if(!config.exists()) 	{config.createNewFile();}
//		add Properties
		props(p);
		
		FileOutputStream out = new FileOutputStream(config);
		p.storeToXML(out, null);
		out.close();
	}
	private void setPr(String key,String vel,Properties p) {
		p.setProperty(key, vel);
		return;
	}
}