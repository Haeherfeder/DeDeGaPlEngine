package de.haeherfeder.DeDePlEngine.Window;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

public class PlayerConfig {
	private Properties confpl = new Properties();
	public PlayerConfig(String Name,String t) {
		
	}
	public PlayerConfig(String Name) throws IOException {
		FileReader readerconfpl= new FileReader("config/players/"+Name+".txt");
		confpl.load(readerconfpl);
		readerconfpl.close();
//		String CurrentWindow = confpl.getProperty("CurrentWindow");
//		String Time = confpl.getProperty("Time");
//		int time = Integer.parseInt(Time);
	}
	public String getString(String key) {
		System.out.println(confpl);
		String Value = confpl.getProperty(key);
		if(Value==null) {
			return "Start";
		}
		return Value;
	}
	public void setCurrentWindow(String value, String Name) throws IOException {
		FileReader readerconfpl= new FileReader("config/players/"+Name+".txt");
		confpl.load(readerconfpl);
		readerconfpl.close();
		confpl.setProperty("CurrentWindow", value);
		FileWriter write = new FileWriter("config/players/"+Name+".txt");
		write.close();
		return;
	}
}
