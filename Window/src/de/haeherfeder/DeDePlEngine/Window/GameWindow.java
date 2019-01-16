package de.haeherfeder.DeDePlEngine.Window;

import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class GameWindow {
		Config conf = new Config();
		TextField tf1,tf2,tf3 = null;
		TextArea l1,l2,l3 = null; 
		Panel p1,p2,p3 = null;
		Frame f = null;
		String Text = null;
		String tf1Text,tf2Text,tf3Text,tf1Fieldtext,tf2Fieldtext,tf3Fieldtext,PanelName = null;
		int tf1Fieldlen,tf2Fieldlen,tf3Fieldlen,n;
		Story story = new Story();
		ConfigStory confStory = new ConfigStory();
		FrameManager Frame = new FrameManager();
	public GameWindow(String Position) throws IOException{
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
		int b,h;
		b = conf.getInt("width");
		h = conf.getInt("hight");
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
		case "Ende":
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
		try {
			TimeUnit.SECONDS.sleep(timesleep);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		f.removeAll();
		f.setVisible(false);
		System.out.println("Position: "+Position);
//		boolean hi = Position!="Start";
		System.out.println(Position+"Next"+Text);
		System.out.println(story.getText(Position+"Next"+Text));
		
		
		
		if (story.getText(Position+"Next"+Text)==null) {
			System.out.println("Way not defined");
			new GameWindow(Position);
		}else {
			Position = story.getText(Position+"Next"+Text);
			new GameWindow(Position);
		}
		
		return;
	}
	public TextArea LabelG(String Namela) {
		TextArea la = new TextArea(Namela);
		la.setEditable(false);
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