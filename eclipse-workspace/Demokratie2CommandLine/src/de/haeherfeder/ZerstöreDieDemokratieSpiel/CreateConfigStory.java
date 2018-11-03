package de.haeherfeder.ZerstöreDieDemokratieSpiel;
import java.util.Properties;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CreateConfigStory {
	public CreateConfigStory(File config,Properties p) throws IOException{
		if(config.exists()) {
			return;
		}
		config.createNewFile();
		FileReader read = new FileReader(config);
		p.load(read);
		read.close();
		setPr("Start"+"tf1"+"Field"+"len","10",p);
		setPr("Start"+"tf2"+"Field"+"len","1",p);
		setPr("Start"+"tf3"+"Field"+"len","1",p);
		setPr("Start"+"nField","3",p);
		FileWriter out = new FileWriter(config);
		p.store(out, "comments");
		out.close();
	}
	private void setPr(String key,String vel,Properties p){
		new setPr(key,vel,p);
		return;
	}
}