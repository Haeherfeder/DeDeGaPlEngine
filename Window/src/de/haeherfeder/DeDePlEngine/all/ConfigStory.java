package de.haeherfeder.DeDePlEngine.all;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigStory {
	private File storyConfig = new File("Story/StoryConfig.xml");
	private File storyFolder = new File("Story");
	private Properties p = new Properties();
	
	public ConfigStory() throws IOException {
		if(!storyFolder.exists()) {storyFolder.mkdirs();}
		new CreateConfigStory(p);
		FileInputStream read = new FileInputStream(storyConfig);
		p.loadFromXML(read);
		read.close();
		return;
	}
	public String getText(String key){
		String vel = p.getProperty(key);
		return vel;
	}
	public int getLen(String key){
		String vel = p.getProperty(key);
		if(vel==null) {return 5;}
		int h = Integer.parseInt(vel);
		return h;
	}
}