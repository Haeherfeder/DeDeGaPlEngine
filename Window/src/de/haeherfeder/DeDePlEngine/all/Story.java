
package de.haeherfeder.DeDePlEngine.all;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/**
 * @author benjamin
 *
 */
public class Story {
	private static File story = new File("Story/config.txt");
	private File storyFolder = new File("Story");
	
	private static Properties p = new Properties();
	public Story() throws IOException {
		if(!storyFolder.exists()) {storyFolder.mkdirs();}
		if(!story.exists()) {story.createNewFile();}
//		if(!Story.exists()) {
			new CreateStory(story,storyFolder,p);
//			System.out.println("Story wurde erstellt.");
//		}
		FileReader read = new FileReader(story);
		p.load(read);
		read.close();
	}
	public static String getText(String key) throws IOException{
		FileReader read = new FileReader(story);
		p.load(read);
		read.close();
		String vel = p.getProperty(key);
		return vel;
	}
	public static int getLen(String key) throws IOException{
		FileReader read = new FileReader(story);
		p.load(read);
		read.close();
		String vel = p.getProperty(key);
		if(vel==null) {
			if (key=="default") {
				return 5;
			}
		return getLen("default");
		}
		int h = Integer.parseInt(vel);
		return h;
	}
}