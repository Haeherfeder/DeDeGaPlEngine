package de.haeherfeder.ZerstöreDieDemokratieSpiel;

import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class GameWindow {
		configFR conf = new configFR();
		TextField tf1,tf2,tf3 = null;
		Label l1,l2,l3 = null; 
		Panel p1,p2,p3 = null;
		Frame f = null;
		String Text = null;
		String tf1Text,tf2Text,tf3Text,tf1Fieldtext,tf2Fieldtext,tf3Fieldtext,PanelName,tf1Text2,tf2Text2,tf3Text2 = null;
		int tf1Fieldlen,tf2Fieldlen,tf3Fieldlen,n;
		Story story = new Story();
		ConfigStory confStory = new ConfigStory();
	public GameWindow(String tet) throws IOException {
		System.out.println("TetStart: "+tet);
		if(tet==null) {tet = story.getText("FirstP");}
		System.out.println("Tet: "+tet);
		tf1Text = story.getText(tet + "tf1Text");
		tf2Text = story.getText(tet + "tf2Text");
		tf3Text = story.getText(tet + "tf3Text");
		tf1Text2 = story.getText(tet + "tf1Text2");
		tf2Text2 = story.getText(tet + "tf2Text2");
		tf3Text2 = story.getText(tet + "tf3Text2");
		tf1Fieldtext = story.getText(tet + "tf1Fieldtext");
		System.out.println("TfTextKey: "+tet + "tf1Fieldtext");
		System.out.println("TfText: "+tf1Fieldtext);
		tf2Fieldtext = story.getText(tet + "tf2Fieldtext");
		tf3Fieldtext = story.getText(tet + "tf3Fieldtext");
//		tf3Fieldtext = "hi \n sdfhal";
		PanelName = story.getText(tet+"PanelName");
		tf1Fieldlen = confStory.getLen(tet + "tf1Fieldlen");
		tf2Fieldlen = confStory.getLen(tet + "tf2Fieldlen");
		tf3Fieldlen = confStory.getLen(tet + "tf3Fieldlen");
		n = confStory.getLen(tet+"nField");
		System.out.println(Inhalt.values());
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
		l1 = LabelG(tf1Text,null);
		l2 = LabelG(tf2Text,null);
		l3 = LabelG(tf3Text,null);
		switch(tet) {
		case "Register":
			new login(h,b,n,p1,l1,p2,l2,p3,l3,tf1,tf2,tf3);
			return;
		case "Ende":
			return;
		default:
			break;}
		f = FrameG(PanelName, h, b, n, p1, l1, p2, l2, p3, l3);
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
		String Inhalt2 = Inhalt.Start.getText();
		System.out.println(Inhalt2);
		try {
			TimeUnit.SECONDS.sleep(8);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		f.removeAll();
		f.setVisible(false);
		boolean hi = false;
		if(!tet.matches("Start")) {
			hi = true;
		}
		System.out.println("Tet: "+tet+" hi: "+hi);
//		boolean hi = tet!="Start";
		System.out.println(tet+"Next"+Text);
		System.out.println(story.getText(tet+"Next"+Text));
		if (story.getText(tet+"Next"+Text)==null) {
			System.out.println("Weg nicht defined");
			String NotDefined = story.getText("NotDefined");
			if(NotDefined==null) {
				if(!(story.getText(tet+"Next"+"Default")==null)) {
					tet = story.getText(tet+"Next"+"Default");
					if(hi) {
						String Name = conf.getProp("CurrentPlayer");
						PlayerConfig c = new PlayerConfig(Name);
						conf.setPr("CurrentPlayer", Name);
						c.setCurrentWindow(tet,Name);
					}
					new GameWindow(tet);
				}
				return;
			}
			if(NotDefined.matches("back")) {
				if(hi) {
					String Name = conf.getProp("CurrentPlayer");
					PlayerConfig c = new PlayerConfig(Name);
					conf.setPr("CurrentPlayer", Name);
					c.setCurrentWindow(tet,Name);
				}
				new GameWindow(tet);
				return;
			}
			if(!(story.getText(tet+"Next"+"Default")==null)) {
				if(hi) {
					String Name = conf.getProp("CurrentPlayer");
					PlayerConfig c = new PlayerConfig(Name);
					conf.setPr("CurrentPlayer", tet);
					c.setCurrentWindow(tet,Name);
				}
				new GameWindow(story.getText(tet+"Next"+"Default"));
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
		tet = story.getText(tet+"Next"+Text);
		if(hi) {
			String Name = conf.getProp("CurrentPlayer");
			PlayerConfig c = new PlayerConfig(Name);
			conf.setPr("CurrentPlayer", tet);
			c.setCurrentWindow(tet,Name);	
		}
		new GameWindow(tet);
		return;
	}
	public Label LabelG(String Namela,String NextLine) {
		if(NextLine!=null) {
			Label la = new Label(Namela);
			return la;
		}
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
	public Frame FrameG(String Name,int h, int b,int n, Panel p1, Label la1,Panel p2,Label la2,Panel p3, Label la3) {
		Frame f = new Frame(Name);
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
		f.setVisible(true);
		return f;
	}
}