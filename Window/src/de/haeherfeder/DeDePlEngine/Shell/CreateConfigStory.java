package de.haeherfeder.DeDePlEngine.Shell;
import java.util.Properties;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class CreateConfigStory {
	private File config = new File("config/config.xml");
	private File configFolder = new File("config");
	
	private void props(Properties p) {
		setPr("hight","200",p);
		setPr("width","800",p);
		setPr("BuchstabeBestätigung","J",p);
		setPr("","",p);
		setPr("timesleep","8",p);
	}
	
	
	public CreateConfigStory(Properties p) throws IOException{
		if(!configFolder.exists()) 	{configFolder.mkdirs();}
		if(config.exists()) 	{
			if(config.length()==0) { return;}
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