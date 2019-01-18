package de.haeherfeder.DeDePlEngine.Window;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

import de.haeherfeder.DeDePlEngine.Shell.SetPr;

public class CreateStory {
	public CreateStory(File Story,File StoryFolder,Properties p) throws IOException {
		System.out.println("Create Story startet.");
		if(!Story.exists()) {
//			System.out.println("Stroy exist"); 
//			return;
			System.out.println("Story file von CreateStory erstellt.");
//		}
		Story.createNewFile();}
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
		System.out.println("Story: " + p);
		FileWriter out = new FileWriter(Story);
		p.store(out, "comments");
		out.close();
		System.out.println("Geschrieben");
	}
	private void setPr(String key,String vel,Properties p) {
		new SetPr(key,vel,p);
		return;
	}
}