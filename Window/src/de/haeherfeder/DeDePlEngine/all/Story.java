
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
	private File Story = new File("Story/config.txt");
	private File StoryFolder = new File("Story");
	
	private Properties p = new Properties();
	public Story() throws IOException {
		if(!StoryFolder.exists()) {StoryFolder.mkdirs();}
		if(!Story.exists()) {Story.createNewFile();}
//		if(!Story.exists()) {
			new CreateStory(Story,StoryFolder,p);
//			System.out.println("Story wurde erstellt.");
//		}
		FileReader read = new FileReader(Story);
		p.load(read);
		read.close();
	}
	public String getText(String key) throws IOException{
		FileReader read = new FileReader(Story);
		p.load(read);
		read.close();
		String vel = p.getProperty(key);
		return vel;
	}
	public int getLen(String key) throws IOException{
		FileReader read = new FileReader(Story);
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