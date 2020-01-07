package de.haeherfeder.DeDePlEngine.Shell;

import java.io.IOException;
import java.util.Scanner;

import de.haeherfeder.DeDePlEngine.all.*;

public class GameWindowShell extends GameWindow {
	boolean doend = false;
	private boolean running;
	
	public GameWindowShell() throws IOException {
		story = new Story();
		confStory= new ConfigStory();
	}
	
	public String gameWindow(String position) throws IOException {
		tf1Text = Story.getText(position + "tf1"+"Text");
		tf2Text = Story.getText(position + "tf2"+"Text");
		tf3Text = Story.getText(position + "tf3"+"Text");
		tf1Fieldtext = Story.getText(position + "tf1"+"Fieldtext");
		tf2Fieldtext = Story.getText(position + "tf2"+"Fieldtext");
		tf3Fieldtext = Story.getText(position + "tf3"+"Fieldtext");
		panelName = Story.getText(position+"Panel"+"Name");
		tf1Fieldlen = 10;
		tf2Fieldlen = 1;
		tf3Fieldlen = 1;
		n = confStory.getLen(position+"nField");
		pl.sendPosition(position);
		
		switch(position) {
		case "Ende":
		case "ende":
			return "Ende";
		default:
			if(doend) 
			{
				return "Ende";
			}
			frame(panelName, n, tf1Fieldtext, tf1Text, tf2Fieldtext, tf2Text, tf3Fieldtext, tf3Text);
			Scanner scanner = new Scanner(System.in);
			running = true;
			pl.waitForInput(position);
			while(running && !scanner.hasNext()) {
				try {
					wait(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			if(scanner.hasNext()) {
				String text = scanner.next();
				System.out.println("Input :"+text);
				pl.PlayerInput(text, position);
				if (Story.getText(position+"Next"+text)==null) {
					System.out.println("Way not defined");
					return position;
				} else {
					position = Story.getText(position+"Next"+text);
					return position;
				}
			} else {
				pl.PlayerInput(null, position);
				position = Story.getText(position+"Default"+"Next");
				return position;
			}		
		}
	}
	public void frame(String name,int n, String p1, String la1,String p2,String la2,String p3, String la3) {
		System.out.println(name);
		for(int i = 0;i<n&&i<4;i++) {
			switch(i) {
			case 0:
				break;
			case 1:	
				System.out.print(la1);
				System.out.println(p1);
				break;
			case 2:
				System.out.print(la2);
				System.out.println(p2);
				break;
			case 3:
				System.out.print(la3);
				System.out.println(p3);
				break;
			default:
				break;
			}
		}
		return;
	}
	public void setEnd(boolean end) {
		doend = end;
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
	public void stopPosition() {
		this.running = false;
	}
}