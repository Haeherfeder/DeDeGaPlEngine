package de.haeherfeder.DeDeGaPlEngine;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;


public class Register {
	Story Story = new Story();
	public Register(String Name) throws IOException {
		Properties p = new Properties();
		Properties p3 = new Properties();
		Properties p4 = new Properties();
		Properties listp = new Properties();
		File perslist = new File("config/player.txt");
		FileReader reader = new FileReader(perslist);
		listp.load(reader);
		reader.close();
		listp.setProperty(Name,"true");
		FileWriter writer = new FileWriter(perslist);
		listp.store(writer, "comments");
		writer.close();
		File persconf = new File("config/players/"+Name+".txt");
		if(!persconf.exists()){persconf.createNewFile();}
		File defconf = new File("config/players/default.txt");
		if(!defconf.exists()) {defconf.createNewFile();}
		File defconf2 = new File("config/players/default2.txt");
		if(!defconf2.exists()) {defconf2.createNewFile();}
		File defconf3 = new File("config/players/default3.txt");
		if(!defconf3.exists()) {defconf3.createNewFile();}
		if(defconf.exists()&&defconf2.exists()&&defconf3.exists()) {
			FileReader red = new FileReader(defconf);
			p.load(red);
			red.close();
			FileReader red3 = new FileReader(defconf3);
			p3.load(red3);
			red3.close();
//			int i=1;
//			boolean KeyIsEx = p.containsKey(i);
			String RegisterNext = Story.getText("RegisterNext");
			System.out.println(RegisterNext);
			p4.setProperty("CurrentWindow", RegisterNext);
/*			while(KeyIsEx){
				p.getProperty(String.valueOf(i));
				p3.getProperty(p.getProperty(String.valueOf(i)));
				p4.setProperty(p.getProperty(String.valueOf(i)),p3.getProperty(p.getProperty(String.valueOf(i))));
				i++;
				KeyIsEx = p.containsKey(i);
			}*/
			FileWriter writer2 = new FileWriter(persconf);
			p4.store(writer2,"Daten von "+Name);
			writer2.close();
		}else {
			System.out.println("Dateien nicht vorhanden");
			System.exit(2);
		}
		return;
	}	


}
