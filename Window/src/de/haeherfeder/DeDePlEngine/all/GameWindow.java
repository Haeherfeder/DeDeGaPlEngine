package de.haeherfeder.DeDePlEngine.all;

import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.io.IOException;

public abstract class GameWindow {
	protected TextField tf1,tf2,tf3 = null;
	protected TextArea l1,l2,l3 = null; 
	protected Panel p1,p2,p3 = null;
	protected Frame f = null;
	protected String text,tf1Text,tf2Text,tf3Text,tf1Fieldtext,tf2Fieldtext,tf3Fieldtext,panelName = null;
	protected int tf1Fieldlen,tf2Fieldlen,tf3Fieldlen,n;
	protected Story story ;
	protected ConfigStory confStory;
	public Plugin pl;
	public Config conf = new Config();
	public void setPlugin(Plugin pl) {
		this.pl = pl;
	}
	public abstract String gameWindow(String Position) throws IOException;
	public abstract void setEnd(boolean end);
	public abstract void stopPosition();
	public abstract void settf1Text(String tf1Text);
	public abstract void settf2Text(String tf2Text);
	public abstract void settf3Text(String tf3Text);
	public abstract void settf1Fieldtext(String tf1Fieldtext);
	public abstract void settf2Fieldtext(String tf2Fieldtext);
	public abstract void settf3Fieldtext(String tf3Fieldtext);
	public abstract void setPanelName(String PanelName);
	public abstract void settf1Fieldlen(int len);
	public abstract void settf2Fieldlen(int len);
	public abstract void settf3Fieldlen(int len);
	public abstract void setFields(int len);
}
