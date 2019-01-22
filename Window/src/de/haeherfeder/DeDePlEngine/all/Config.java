package de.haeherfeder.DeDePlEngine.all;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.InvalidPropertiesFormatException;
import java.util.Properties;

public class Config {
	private Properties p = new Properties();
//	Files
	private File config = new File("config/config.xml");
	private File player = new File("config/player.txt");
	private File Story = new File("Story/config.txt");

	public Config() {
		return;
	}
	public void configFRSt() throws IOException {
//		Ordner
		File configFolder = new File("config");
		File StoryFolder = new File("Story");
		File PlayerFolder = new File("config/players");
//		Proof if exist
		
		if(!configFolder.exists()) 	{configFolder.mkdirs();}
		if(!StoryFolder.exists()) 	{StoryFolder.mkdirs();}
		if(!PlayerFolder.exists()) 	{PlayerFolder.mkdirs();}
	
//		Proof if exist
		if(!config.exists()) 	{new CreateConfig(p);}
		if(!player.exists()) 	{player.createNewFile();}
		if(!Story.exists()) 	{
			Story.createNewFile();
			new Story();
		}
		
//		Properties 1
		FileInputStream read = new FileInputStream(config);
		p.loadFromXML(read);
		read.close();
		
//		if(!p.contains("e")) {p.setProperty("e", "1");
//			System.out.println("e nicht vorhanden.");}
//		System.out.println(p);
//		System.out.println(config);
		return;
	}
	/*public void setPr(String key,String vel,Properties p) throws IOException {
		FileReader reader = new FileReader(config);
		p.load(reader);
		FileWriter write = new FileWriter(config);
		p.setProperty(key, vel);
//			System.out.println(key + " wurde erstellt");
		p.store(write, "neu value: "+vel);
		write.close();
		reader.close();
		return;
	}*/
	public void setPr(String key,String vel) throws IOException {
		FileOutputStream write = new FileOutputStream(config);
		FileInputStream reader;
		try {
			reader = new FileInputStream(config);
			p.loadFromXML(reader);
			reader.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		p.setProperty(key, vel);
//			System.out.println(key + " wurde erstellt");
		p.storeToXML(write, "neu value: "+vel);
		write.close();
		return;
	}
	public String getProp(String key) {
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
	public int getInt(String key){
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