package de.haeherfeder.DeDePlEngine.all;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.InvalidPropertiesFormatException;
import java.util.Properties;

public class Config {
	private static Properties p = new Properties();
//	Files
	private static File config = new File("config/config.xml");
	private static File story = new File("Story/config.txt");

	public Config() {
		return;
	}
	public void configFRSt() throws IOException {
		File configFolder = new File("config");
		File storyFolder = new File("Story");
		File playerFolder = new File("config/players");
		
		if(!configFolder.exists()) 	{configFolder.mkdirs();}
		if(!storyFolder.exists()) 	{storyFolder.mkdirs();}
		if(!playerFolder.exists()) 	{playerFolder.mkdirs();}
	
//		Proof if exist
		if(!config.exists()) 	{new CreateConfig(p);}
		if(!story.exists()) 	{
			story.createNewFile();
			new Story();
		}
		FileInputStream read = new FileInputStream(config);
		p.loadFromXML(read);
		read.close();
		return;
	}
	public static void setPr(String key,String vel) throws IOException {
		try {
			FileInputStream reader = new FileInputStream(config);
			p.loadFromXML(reader);
			reader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		FileOutputStream write = new FileOutputStream(config);
		p.setProperty(key, vel);
		p.storeToXML(write, "neu value: "+vel);
		write.close();
		return;
	}
	public static String getProp(String key) {
		try {
			FileInputStream read = new FileInputStream(config);
			p.loadFromXML(read);
			read.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (InvalidPropertiesFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(key);
		System.out.println(p.getProperty(key));
		if(p.getProperty(key)==null) {return "not defined";}
		return p.getProperty(key);
	}
	public static int getInt(String key){
		String vel = getProp(key);
		if(vel=="not defined") {
			if (key=="default") {
				return 5;
			}
		return getInt("default");
		}
		int h = Integer.parseInt(vel);
		return h;
	}
}