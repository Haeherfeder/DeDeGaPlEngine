package de.haeherfeder.ZerstöreDieDemokratieSpiel;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

public class CreateStory {
	public CreateStory(File Story,File StoryFolder,Properties p) throws IOException {
		if(Story.exists()) {
			return;
		}
		FileReader read = new FileReader(Story);
		p.load(read);
		read.close();
		setPr("FirstP","Start",p);
		setPr("Start"+"tf1"+"Text","Hallo, Herzlich Willkommen.",p);
		setPr("Start"+"tf2"+"Text","Hallo, Feld2",p);
		setPr("Start"+"tf3"+"Text","Hallo, Feld3",p);
		setPr("Start"+"tf1"+"Fieldtext","Hier Antwort eintragen",p);
		setPr("Start"+"tf2"+"Fieldtext","",p);
		setPr("Start"+"tf3"+"Fieldtext","",p);
		setPr("Start"+"Next"+"A","Register",p);
		setPr("Start"+"Next"+"default","Register",p);
		setPr("Start"+"tf3"+"Text","hi",p);
		
		FileWriter out = new FileWriter(Story);
		p.store(out, "comments");
		out.close();
	}
	private void setPr(String key,String vel,Properties p) {
		new setPr(key,vel,p);
		return;
	}
}