package de.haeherfeder.DeDePlEngine.Shell;

import java.io.IOException;
import java.util.Scanner;

import de.haeherfeder.DeDePlEngine.all.*;

public class GameWindow {
		Plugin pl;
		Config conf = new Config();
		String Text, tf1Text,tf2Text,tf3Text,tf1Fieldtext,tf2Fieldtext,tf3Fieldtext,PanelName,tf1Text2,tf2Text2,tf3Text2 = null;
		int tf1Fieldlen,tf2Fieldlen,tf3Fieldlen,n;
		Story story = new Story();
		ConfigStory confStory = new ConfigStory();
		boolean fals = false;
		
	public GameWindow(String Position) throws IOException {}
	public GameWindow() throws IOException{}
	public String GameWindo(String Position) throws IOException {
		pl = new Plugin("null");
		tf1Text = story.getText(Position + "tf1"+"Text");
		tf2Text = story.getText(Position + "tf2"+"Text");
		tf3Text = story.getText(Position + "tf3"+"Text");
		tf1Fieldtext = story.getText(Position + "tf1"+"Fieldtext");
		tf2Fieldtext = story.getText(Position + "tf2"+"Fieldtext");
		tf3Fieldtext = story.getText(Position + "tf3"+"Fieldtext");
		PanelName = story.getText(Position+"Panel"+"Name");
		tf1Fieldlen = 10;
		tf2Fieldlen = 1;
		tf3Fieldlen = 1;
		n = confStory.getLen(Position+"nField");
		//Plugin pl = new Plugin();
		pl.sendPosition(Position);
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
			return "Ende";
		default:
			/*
			 * 
			 */
			if(fals) 
			{
				return "Ende";
			}
			FrameG(PanelName, n, tf1Fieldtext, tf1Text, tf2Fieldtext, tf2Text, tf3Fieldtext, tf3Text);
//			f.remove(p1);
//			TextField tf2 = new TextField(Text);
//		System.out.println("f");
			Scanner scanner = new Scanner(System.in);
			String Text = scanner.next();
			System.out.println("Input :"+Text);
			pl.PlayerInput(Text, Position);
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
				return Position;
			}else {
				Position = story.getText(Position+"Next"+Text);
				return Position;
			}	
		}
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
				System.out.print(la1);
//				f.add(p1);
				System.out.println(p1);
//				System.out.println("case 1");
			break;
			case 2:
//				f.add(la2);
				System.out.print(la2);
//				f.add(p2);
				System.out.println(p2);
//				System.out.println("case 2");
			break;
			case 3:
//				f.add(la3);
				System.out.print(la3);
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
	public void setEnd(boolean End) {
		fals = End;
	}
	public void settf1Text(String tf1Text) {
		this.tf1Text = tf1Text;
	}
	public void settf2Text(String tf2Text) {
		this.tf2Text = tf2Text;
	}
	public void settf3Text(String tf3Text) {
		this.tf3Text = tf3Text;
	}
	public void settf1Fieldtext(String tf1Fieldtext) {
		this.tf1Fieldtext = tf1Fieldtext;
	}
	public void settf2Fieldtext(String tf2Fieldtext) {
		this.tf2Fieldtext = tf2Fieldtext;
	}
	public void settf3Fieldtext(String tf3Fieldtext) {
		this.tf3Fieldtext = tf3Fieldtext;
	}
	public void setPanelName(String PanelName) {
		this.PanelName = PanelName;
	}
	public void settf1Fieldlen(int len) {
		this.tf1Fieldlen = len;
	}
	public void settf2Fieldlen(int len) {
		this.tf2Fieldlen = len;
	}
	public void settf3Fieldlen(int len) {
		this.tf3Fieldlen = len;
	}
	public void setFields(int len) {
		this.n = len;
	}
}