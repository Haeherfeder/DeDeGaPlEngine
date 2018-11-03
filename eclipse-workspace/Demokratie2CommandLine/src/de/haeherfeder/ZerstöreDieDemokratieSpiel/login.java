package de.haeherfeder.ZerstöreDieDemokratieSpiel;

import java.awt.Color;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class login {

	public login(int h, int b,int n, Panel p1, Label la1,Panel p2,Label la2,Panel p3, Label la3,TextField tf1,TextField tf2,TextField tf3) throws IOException {
		Frame f = new Frame("Register");
		f.setLayout(new GridLayout());
		for(int i = 0;i<n;i++) {
			System.out.println("for");
			switch(i) {
			case 0:
				System.out.println("case 0");
			case 1:	
				f.add(la1);
				f.add(p1);
				System.out.println("case 1");
				break;
			case 2:
				f.add(la2);
				f.add(p2);
				System.out.println("case 2");
				break;
			case 3:
				f.add(la3);
				f.add(p3);
				System.out.println("case 3");
				break;
			default:
				System.out.println("cas def");
				break;
			}
		}
		f.pack();
		f.setSize(b, h);
//		Image d = new Image("fde.png");
//		f.setBackground(Color.green);
//		f.setIconImage(d);
		f.setBackground(Color.GREEN);
		f.setVisible(true);
		configFR conf = new configFR();
		int timesleep = conf.getInt("timesleep");
		String BuchstabeBestätigung = conf.getProp("BuchstabeBestätigung");
		while(true) {
		System.out.println("Gelesen: " + tf2.getText());
		try {
			TimeUnit.SECONDS.sleep(timesleep);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if(tf2.getText().matches(BuchstabeBestätigung)) {
				System.out.println("Ende, "+BuchstabeBestätigung+" gelesen.");
				break;
			}	
		}	
		Properties p = new Properties();
		FileReader reader= new FileReader("config/config.xml");
		p.load(reader);
		reader.close();
		String Name = tf1.getText();
		conf.setPr("CurrentPlayer", Name);
		
		if(p.getProperty(Name)!="true") {
			new register(Name);
			
		}
		Properties confpl = new Properties();
		FileReader readerconfpl= new FileReader("config/players/"+Name+".txt");
		System.out.println("Name: "+Name);
		confpl.load(readerconfpl);
		readerconfpl.close();
		
		String CurrentWindow = confpl.getProperty("CurrentWindow");
		f.removeAll();
		f.setVisible(false);
		new GameWindow(CurrentWindow);
		return;
//		String Time = confpl.getProperty("Time");
//		int time = Integer.parseInt(Time);
//		ConfigStory story = new ConfigStory();
//		String tet = story.getText("Register"+"Next");
//		String tet = confpl.getProperty(Name);
	}
}