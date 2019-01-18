package de.haeherfeder.DeDePlEngine.Shell;
import java.util.Properties;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CreateConfigStory {
	public CreateConfigStory(File config,Properties p) throws IOException{
		if(config.exists()) {
			return;
		}
		config.createNewFile();
		FileInputStream read = new FileInputStream(config);
		try {
			p.loadFromXML(read);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		read.close();
		setPr("Start"+"tf1"+"Field"+"len","10",p);
		setPr("Start"+"tf2"+"Field"+"len","1",p);
		setPr("Start"+"tf3"+"Field"+"len","1",p);
		setPr("Start"+"nField","3",p);
		FileOutputStream out = new FileOutputStream(config);
		p.storeToXML(out, "comments");
		out.close();
	}
	private void setPr(String key,String vel,Properties p){
		new SetPr(key,vel,p);
		return;
	}
}