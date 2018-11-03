package de.haeherfeder.ZerstöreDieDemokratieSpiel;

import java.io.File;
import java.io.FileWriter;
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
		
		FileWriter out = new FileWriter(config);
		p.store(out," comments");
		out.close();
	}
	private void setPr(String key,String vel,Properties p) {
		if(p.getProperty(key)==null) {
			p.setProperty(key, vel);
			System.out.println(key + " wurde erstellt");
			return;
		}
		System.out.println(key + " ist vorhanden " + p.getProperty(key));
		return;
	}
}