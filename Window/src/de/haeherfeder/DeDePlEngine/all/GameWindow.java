package de.haeherfeder.DeDePlEngine.all;

import java.io.IOException;

public abstract class GameWindow {
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
