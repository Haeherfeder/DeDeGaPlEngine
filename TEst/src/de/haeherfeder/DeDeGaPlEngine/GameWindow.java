package de.haeherfeder.DeDeGaPlEngine;

import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class GameWindow {
	Config conf = new Config();
	TextField tf1,tf2,tf3 = null;
	Label l1,l2,l3 = null; 
	Panel p1,p2,p3 = null;
	Frame f = null;
	String Text = null;
	String tf1Text,tf2Text,tf3Text,tf1Fieldtext,tf2Fieldtext,tf3Fieldtext,PanelName = null;
	int tf1Fieldlen,tf2Fieldlen,tf3Fieldlen,n;
	Story story = new Story();
	ConfigStory confStory = new ConfigStory();
	FrameManager Frame = new FrameManager();
	
	public GameWindow(String Position) throws IOException{
		System.out.println("PositionStart: "+Position);
		if(Position==null) {
			Position = story.getText("FirstPosition");
			System.out.println("Position was == null");
			}
		System.out.println("Position: "+Position);
		tf1Text = story.getText(Position + "tf1Text");
		tf2Text = story.getText(Position + "tf2Text");
		tf3Text = story.getText(Position + "tf3Text");
		tf1Fieldtext = story.getText(Position + "tf1Fieldtext");
		System.out.println("TfTextKey: "+Position + "tf1Fieldtext");
		System.out.println("TfText: "+tf1Fieldtext);
		tf2Fieldtext = story.getText(Position + "tf2Fieldtext");
		tf3Fieldtext = story.getText(Position + "tf3Fieldtext");
		PanelName = story.getText(Position+"PanelName");
		tf1Fieldlen = confStory.getLen(Position + "tf1Fieldlen");
		tf2Fieldlen = confStory.getLen(Position + "tf2Fieldlen");
		tf3Fieldlen = confStory.getLen(Position + "tf3Fieldlen");
		n = confStory.getLen(Position+"nField");
//		System.out.println(Inhalt.values());
		int b,h;
		String StB = conf.getProp("width");
		System.out.println(StB + " hi");
		b = Integer.parseInt(StB);
		System.out.println(StB + "in Zahl");
		h = Integer.parseInt(conf.getProp("hight"));
		/*
		b = 800;
		h = 400;*/
		tf1 = TextFieldG(tf1Fieldtext,tf1Fieldlen);
		tf2 = TextFieldG(tf2Fieldtext,tf2Fieldlen);
		tf3 = TextFieldG(tf3Fieldtext,tf3Fieldlen);
		p1 = PanelG(tf1);
		p2 = PanelG(tf2);
		p3 = PanelG(tf3);
		l1 = LabelG(tf1Text);
		l2 = LabelG(tf2Text);
		l3 = LabelG(tf3Text);
		switch(Position) {
		case "Register":
			new Login(h,b,n,p1,l1,p2,l2,p3,l3,tf1,tf2,tf3);
			return;
		case "ende":
			return;
		default:
			break;}
		f = Frame.setFrame(PanelName, h, b, n, p1, l1, p2, l2, p3, l3);
//			f.remove(p1);
//			TextField tf2 = new TextField(Text);
		System.out.println("f");
		int timesleep = conf.getInt("timesleep");
//			f.add(p1);
		while(true) {
			System.out.println("Gelesen: " + tf2.getText());
		try {
			TimeUnit.SECONDS.sleep(timesleep);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		if(tf2.getText().matches(conf.getProp("BuchstabeBestätigung"))) {
			System.out.println("Ende, J gelesen.");
			break;
		}
		}
		Text = tf1.getText();
		System.out.println("Text: " + Text);
		conf.getProp("key");
//		String Inhalt2 = Inhalt.Start.getText();
//		System.out.println(Inhalt2);
		try {
			TimeUnit.SECONDS.sleep(timesleep);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		f.removeAll();
		f.setVisible(false);
		boolean hi = false;
		if(!Position.matches("Start")) {
			hi = true;
		}
		System.out.println("Position: "+Position+" hi: "+hi);
//		boolean hi = Position!="Start";
		System.out.println(Position+"Next"+Text);
		System.out.println(story.getText(Position+"Next"+Text));
		if (story.getText(Position+"Next"+Text)==null) {
			System.out.println("Weg nicht defined");
			String NotDefined = story.getText("NotDefined");
			if(NotDefined==null) {
				if(!(story.getText(Position+"Next"+"Default")==null)) {
					Position = story.getText(Position+"Next"+"Default");
					if(hi) {
						String Name = conf.getProp("CurrentPlayer");
						PlayerConfig c = new PlayerConfig(Name);
						conf.setPr("CurrentPlayer", Position);
						c.setCurrentWindow(Position,Name);
					}
					new GameWindow(Position);
				}
				return;
			}
			if(NotDefined.matches("back")) {
				if(hi) {
					String Name = conf.getProp("CurrentPlayer");
					PlayerConfig c = new PlayerConfig(Name);
					conf.setPr("CurrentPlayer", Position);
					c.setCurrentWindow(Position,Name);
				}
				new GameWindow(Position);
				return;
			}
			if(!(story.getText(Position+"Next"+"Default")==null)) {
				if(hi) {
					String Name = conf.getProp("CurrentPlayer");
					PlayerConfig c = new PlayerConfig(Name);
					conf.setPr("CurrentPlayer", Position);
					c.setCurrentWindow(Position,Name);
				}
				new GameWindow(story.getText(Position+"Next"+"Default"));
			}
			if(hi) {
				String Name = conf.getProp("CurrentPlayer");
				PlayerConfig c = new PlayerConfig(Name);
				conf.setPr("CurrentPlayer", Name);
				c.setCurrentWindow(NotDefined,Name);
			}
			new GameWindow(NotDefined);
			return;
		}
		System.out.println(hi);
		Position = story.getText(Position+"Next"+Text);
		if(hi) {
			String Name = conf.getProp("CurrentPlayer");
			PlayerConfig c = new PlayerConfig(Name);
			conf.setPr("CurrentPlayer", Position);
			c.setCurrentWindow(Position,Name);	
		}
		new GameWindow(Position);
		return;
	}
	public Label LabelG(String Namela) {
		Label la = new Label(Namela);
		return la;
	}
	public Panel PanelG(TextField tf) {
		Panel p = new Panel();
		p.add(tf);
		return p;
	}
	public TextField TextFieldG(String text, int len) {
		TextField tf = new TextField(text,len);
		return tf;
	}
}