package de.haeherfeder.DeDePlEngine.Shell;

import java.io.IOException;
import java.util.Scanner;

import de.haeherfeder.DeDePlEngine.all.Config;
import de.haeherfeder.DeDePlEngine.all.ConfigStory;
import de.haeherfeder.DeDePlEngine.all.Story;

public class GameWindow {
		Config conf = new Config();
		String Text, tf1Text,tf2Text,tf3Text,tf1Fieldtext,tf2Fieldtext,tf3Fieldtext,PanelName,tf1Text2,tf2Text2,tf3Text2 = null;
		int tf1Fieldlen,tf2Fieldlen,tf3Fieldlen,n;
		Story story = new Story();
		ConfigStory confStory = new ConfigStory();
		
	public GameWindow(String Position) throws IOException {
		tf1Text = story.getText(Position + "tf1Text");
		tf2Text = story.getText(Position + "tf2Text");
		tf3Text = story.getText(Position + "tf3Text");
		tf1Fieldtext = story.getText(Position + "tf1Fieldtext");
		tf2Fieldtext = story.getText(Position + "tf2Fieldtext");
		tf3Fieldtext = story.getText(Position + "tf3Fieldtext");
		PanelName = story.getText(Position+"PanelName");
		tf1Fieldlen = confStory.getLen(Position + "tf1Fieldlen");
		tf2Fieldlen = confStory.getLen(Position + "tf2Fieldlen");
		tf3Fieldlen = confStory.getLen(Position + "tf3Fieldlen");
		n = confStory.getLen(Position+"nField");
//		System.out.println(Inhalt.values());
//		System.out.println(StB + "in Zahl");
		/*
		b = 800;
		h = 400;*/
//		tf1 = TextFieldG(tf1Fieldtext,tf1Fieldlen);
//		tf2 = TextFieldG(tf2Fieldtext,tf2Fieldlen);
//		tf3 = TextFieldG(tf3Fieldtext,tf3Fieldlen);
//		p1 = PanelG(tf1);
//		p2 = PanelG(tf2);
//		p3 = PanelG(tf3);
//		l1 = LabelG(tf1Text,null);
//		l2 = LabelG(tf2Text,null);
//		l3 = LabelG(tf3Text,null);
		
		switch(Position) {
		case "Ende":
		case "ende":
			return;
		default:
			FrameG(PanelName, n, tf1Fieldtext, tf1Text, tf2Fieldtext, tf2Text, tf3Fieldtext, tf3Text);
//			f.remove(p1);
//			TextField tf2 = new TextField(Text);
//		System.out.println("f");
			Scanner scanner = new Scanner(System.in);
			String Text = scanner.next();
			System.out.println("Input :"+Text);
			
//		scanner.close();
/*		
		int timesleep = conf.getInt("timesleep");
//			f.add(p1);
		while(true) {
//			System.out.println("Gelesen: " + tf2.getText());
			try {
				TimeUnit.SECONDS.sleep(timesleep);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}*/
		/*
*		if(tf2.getText().matches(conf.getProp("BuchstabeBestätigung"))) {
*			System.out.println("Ende, J gelesen.");
*			break;
*		}
*		}
*		Text = tf1.getText();
*		try {
*			TimeUnit.SECONDS.sleep(8);
*		} catch (InterruptedException e) {
*			e.printStackTrace();
*		}*/
		
			if (story.getText(Position+"Next"+Text)==null) {
				System.out.println("Way not defined");
				new GameWindow(Position);
			}else {
				Position = story.getText(Position+"Next"+Text);
				new GameWindow(Position);
			}
			scanner.close();
		break;}	
	}
	public void FrameG(String Name,int n, String p1, String la1,String p2,String la2,String p3, String la3) {
		for(int i = 0;i<n;i++) {
//			System.out.println("for");
			switch(i) {
			case 0:
//				System.out.println("case 0");
			break;
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
//				System.out.println("cas def");
			break;
			}
		}
		return;
	}
}