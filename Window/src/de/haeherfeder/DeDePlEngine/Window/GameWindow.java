package de.haeherfeder.DeDePlEngine.Window;

import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import de.haeherfeder.DeDePlEngine.all.*;

public class GameWindow {
		Plugin pl;
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
	public GameWindow(String Position) throws IOException{}
	public GameWindow() throws IOException{}
	public String GameWindo(String Position) throws IOException{
		pl = new Plugin("null");
		tf1Text = Story.getText(Position + "tf1Text");
		tf2Text = Story.getText(Position + "tf2Text");
		tf3Text = Story.getText(Position + "tf3Text");
		tf1Fieldtext = Story.getText(Position + "tf1Fieldtext");
		tf2Fieldtext = Story.getText(Position + "tf2Fieldtext");
		tf3Fieldtext = Story.getText(Position + "tf3Fieldtext");
		PanelName = Story.getText(Position+"PanelName");
		tf1Fieldlen = 10;
		tf2Fieldlen = 1;
		tf3Fieldlen = 1;
		n = confStory.getLen(Position+"nField");
		int b,h;
		b = Config.getInt("width");
		h = Config.getInt("hight");
		//Plugin pl = new Plugin();
		if(Position!=null) {
			System.out.println("Position not null."+Position);
			pl.sendPosition(Position);
		}else {
			pl.sendPosition("null");
		}
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
			return "Ende";
		default:
			break;}
		f = Frame.setFrame(PanelName, h, b, n, p1, l1, p2, l2, p3, l3);
//			f.remove(p1);
//			TextField tf2 = new TextField(Text);
		System.out.println("f");
		int timesleep = Config.getInt("timesleep");
//			f.add(p1);
		while(true) {
			System.out.println("Gelesen: " + tf2.getText());
		try {
			TimeUnit.SECONDS.sleep(timesleep);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		if(tf2.getText().matches(Config.getProp("BuchstabeBestätigung"))) {
			System.out.println("Ende, J gelesen.");
			break;
		}
		}
		Text = tf1.getText();
		pl.PlayerInput(Text,Position);
		
		System.out.println("Text: " + Text);
		try {
			TimeUnit.SECONDS.sleep(timesleep);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("Position: "+Position);
//		boolean hi = Position!="Start";
		System.out.println(Position+"Next"+Text);
		System.out.println(Story.getText(Position+"Next"+Text));
		
		
		
		if (Story.getText(Position+"Next"+Text)==null) {
			tf1.setText("Way not defined");
			
			System.out.println("Way not defined");
			f.removeAll();
			f.setVisible(false);
			return Position;
		}else {
			f.removeAll();
			f.setVisible(false);
			Position = Story.getText(Position+"Next"+Text);
			return(Position);
		}
	}
	public TextArea LabelG(String Namela) {
		TextArea la = new TextArea(Namela);
		la.setEditable(false);
		la.setFocusable(false);
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