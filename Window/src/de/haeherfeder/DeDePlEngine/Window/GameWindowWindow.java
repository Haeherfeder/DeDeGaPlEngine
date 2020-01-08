package de.haeherfeder.DeDePlEngine.Window;

import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import de.haeherfeder.DeDePlEngine.all.*;

public class GameWindowWindow extends GameWindow {
		private boolean end,running;
		protected static GameWindow game;
	public GameWindowWindow() throws IOException {
		f = new Frame();
		story = new Story();
		confStory= new ConfigStory();
		GameWindowWindow.game = this;
	}
	public String gameWindow(String position) throws IOException{
		tf1Text = Story.getText(position + "tf1Text");
		tf2Text = Story.getText(position + "tf2Text");
		tf3Text = Story.getText(position + "tf3Text");
		tf1Fieldtext = Story.getText(position + "tf1Fieldtext");
		tf2Fieldtext = Story.getText(position + "tf2Fieldtext");
		tf3Fieldtext = Story.getText(position + "tf3Fieldtext");
		panelName = Story.getText(position+"PanelName");
		tf1Fieldlen = 10;
		tf2Fieldlen = 1;
		tf3Fieldlen = 1;
		n = confStory.getLen(position+"nField");
		int b,h;
		b = Config.getInt("width");
		h = Config.getInt("hight");
		if(position!=null) {
			pl.sendPosition(position);
		}else {
			pl.sendPosition("null");
		}
		/*
		b = 800;
		h = 400;*/
		tf1 = textField(tf1Fieldtext,tf1Fieldlen);
		tf2 = textField(tf2Fieldtext,tf2Fieldlen);
		tf3 = textField(tf3Fieldtext,tf3Fieldlen);
		p1 = panel(tf1);
		p2 = panel(tf2);
		p3 = panel(tf3);
		l1 = label(tf1Text);
		l2 = label(tf2Text);
		l3 = label(tf3Text);
		switch(position) {
		case "Ende":
		case "ende":
			return "Ende";
		default:
			break;}
		f = FrameManager.setFrame(f,panelName, h, b, n, p1, l1, p2, l2, p3, l3);
//			f.remove(p1);
//			TextField tf2 = new TextField(Text);
//		System.out.println("f");
//		int timesleep = Config.getInt("timesleep");
//			f.add(p1);
		running = true;
		pl.waitForInput(position);
		while(running) {
				System.out.println("Gelesen: " + tf2.getText());
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if(tf2.getText().matches(Config.getProp("BuchstabeBestätigung"))) {
				System.out.println("Ende, J gelesen.");
				break;
			}
		}
		if(!tf2.getText().matches(Config.getProp("BuchstabeBestätigung"))) {
			pl.PlayerInput(null,position);
			position = Story.getText(position+"Default"+"Next");
			return position;
		}
		text = tf1.getText();
		pl.PlayerInput(text,position);
		
		System.out.println("Text: " + text);
		System.out.println("Position: "+position);
		System.out.println(position+"Next"+text);
		System.out.println(Story.getText(position+"Next"+text));
		
		if (Story.getText(position+"Next"+text)==null) {
			tf1.setText("Way not defined");
			
			System.out.println("Way not defined");
			f.removeAll();
			f.setVisible(false);
			return position;
		}else {
			f.removeAll();
			f.setVisible(false);
			position = Story.getText(position+"Next"+text);
			return position;
		}
	}
	public TextArea label(String namela) {
		TextArea la = new TextArea(namela);
		la.setEditable(false);
		la.setFocusable(false);
		return la;
	}
	public Panel panel(TextField tf) {
		Panel p = new Panel();
		p.add(tf);
		return p;
	}
	public TextField textField(String text, int len) {
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
	public void setPanelName(String panelName) {
		this.panelName = panelName;
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
	@Override
	public void setEnd(boolean end) {
		this.end=false;
	}
	protected boolean getEnd() {
		return end;
	}
	@Override
	public void stopPosition() {
		running = false;
	}
}