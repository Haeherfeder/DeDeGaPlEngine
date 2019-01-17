package de.haeherfeder.DeDePlEngine.Shell;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
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
		FileInputStream reader = new FileInputStream(config);
		p.loadFromXML(reader);
		p.setProperty(key, vel);
//			System.out.println(key + " wurde erstellt");
		p.storeToXML(write, "neu value: "+vel);
		write.close();
		reader.close();
		return;
	}
	public String getProp(String key) throws IOException {
		FileInputStream read = new FileInputStream(config);
		p.load(read);
		read.close();
//		System.out.println(key);
//		System.out.println(p.getProperty(key));
		if(p.getProperty(key)==null) {return "not defined";}
		return p.getProperty(key);
	}
	public int getInt(String key){
		String vel = p.getProperty(key);
		if(vel==null) {
			if (key=="default") {
				return 20;
			}
		return getInt("default");
		}
		int h = Integer.parseInt(vel);
		return h;
	}
}