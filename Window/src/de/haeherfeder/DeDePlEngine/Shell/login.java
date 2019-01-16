package de.haeherfeder.DeDePlEngine.Shell;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class login {
	int timesleep;
	Config conf = new Config(); 

	public login(int n, String p1, String la1,String p2,String la2,String p3, String la3) throws IOException {
		for(int i = 0;i<n;i++) {
			timesleep = conf.getInt("timesleep");
//			System.out.println("for");
			switch(i) {
			case 0:
//				System.out.println("case 0");
			case 1:	
//				f.add(la1);
				System.out.println(la1);
//				f.add(p1);
				System.out.println(p1);
//				System.out.println("case 1");
				break;
			case 2:
//				f.add(la2);
				System.out.println(la2);
//				f.add(p2);
				System.out.println(p2);
//				System.out.println("case 2");
				break;
			case 3:
//				f.add(la3);
				System.out.println(la3);
//				f.add(p3);
				System.out.println(p3);
//				System.out.println("case 3");
			break;
			default:
				System.out.println("cas def");
				break;
			}
		}
		Scanner scanner = new Scanner(System.in);
		while(true) {
			try {
				TimeUnit.SECONDS.sleep(timesleep);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if(scanner.hasNextLine()) {
				break;
			}
		}
		String Name = scanner.nextLine();
		scanner.close();
//		f.pack();
//		f.setSize(b, h);
//		Image d = new Image("fde.png");
//		f.setBackground(Color.green);
//		f.setIconImage(d);
//		f.setBackground(Color.GREEN);
//		f.setVisible(true);
		Config conf = new Config();
/*		int timesleep = conf.getInt("timesleep");
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
		}*/	
		Properties p = new Properties();
		FileReader reader= new FileReader("config/config.xml");
		p.load(reader);
		reader.close();
		
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
		new GameWindow(CurrentWindow);
		return;
//		String Time = confpl.getProperty("Time");
//		int time = Integer.parseInt(Time);
//		ConfigStory story = new ConfigStory();
//		String tet = story.getText("Register"+"Next");
//		String tet = confpl.getProperty(Name);
	}
}