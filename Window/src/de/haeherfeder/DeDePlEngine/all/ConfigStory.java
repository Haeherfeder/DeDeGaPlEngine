package de.haeherfeder.DeDePlEngine.all;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigStory {
	private File StoryConfig = new File("Story/StoryConfig.xml");
	private File StoryFolder = new File("Story");
	private Properties p = new Properties();
	
	public ConfigStory() throws IOException {
//		System.out.println("Storyconfgen");
		if(!StoryFolder.exists()) {StoryFolder.mkdirs();}
//		if(!StoryConfig.exists()) {new CreateConfigStory(StoryConfig,p);
		new CreateConfigStory(p);
//		System.out.println("Storyconf "+p);
		FileInputStream read = new FileInputStream(StoryConfig);
		p.loadFromXML(read);
		read.close();
//		System.out.println("Storyconf "+p);
		return;
	}
	public String getText(String key){
		String vel = p.getProperty(key);
		return vel;
	}
	public int getLen(String key){
//		System.out.println(key);
		String vel = p.getProperty(key);
		if(vel==null) {return 5;}
//		System.out.println(vel);
		int h = Integer.parseInt(vel);
		return h;
	}
}