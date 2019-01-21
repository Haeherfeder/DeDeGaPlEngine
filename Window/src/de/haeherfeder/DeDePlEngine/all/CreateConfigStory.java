package de.haeherfeder.DeDePlEngine.all;
import java.util.Properties;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class CreateConfigStory {
	private File config = new File("Story/StoryConfig.xml");
	private File configFolder = new File("Story");
	
	private void props(Properties p) {
		setPr("Start"+"tf1"+"Field"+"len","10",p);
		setPr("Start"+"tf2"+"Field"+"len","1",p);
		setPr("Start"+"tf3"+"Field"+"len","1",p);
		setPr("Start"+"nField","3",p);
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
	private void setPr(String key,String vel,Properties p){
		new SetPr(key,vel,p);
		return;
	}
}