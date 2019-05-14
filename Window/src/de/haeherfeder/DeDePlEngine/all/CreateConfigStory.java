package de.haeherfeder.DeDePlEngine.all;
import java.util.Properties;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import de.haeherfeder.DeDePlEngine.all.Methoden;

public class CreateConfigStory {
	private File config = new File("Story/StoryConfig.xml");
	private File configFolder = new File("Story");
	private void props(Properties p) {
		Methoden.setPr("Start"+"tf1"+"Field"+"len","10",p);
		Methoden.setPr("Start"+"tf2"+"Field"+"len","1",p);
		Methoden.setPr("Start"+"tf3"+"Field"+"len","1",p);
		Methoden.setPr("Start"+"nField","3",p);
	}
	
	
	public CreateConfigStory(Properties p) throws IOException{
		if(!configFolder.exists()) 	{configFolder.mkdirs();}
		if(config.exists()) 	{
			if(config.length()!=0) { return;}
		}
		if(!config.exists()) 	{config.createNewFile();}
		props(p);
		FileOutputStream out = new FileOutputStream(config);
		p.storeToXML(out, "comments");
		out.close();
	}
}