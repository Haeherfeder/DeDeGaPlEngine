package de.haeherfeder.DeDePlEngine.all;

public abstract class MainManager {
	public static boolean end = true;
	public abstract void setEnd(boolean end);
	public GameWindow gamewindow;
	public abstract void setStartPosition(String newPos);
}
