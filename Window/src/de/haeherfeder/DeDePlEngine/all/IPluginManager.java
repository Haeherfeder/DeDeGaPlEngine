package de.haeherfeder.DeDePlEngine.all;

public interface IPluginManager {
	void showVisualMessage(String message);
	void disableGameWindow();
	void setPosition(String position);
	void setStartPosition(String position);
	public String singlePosition(String position);
	public String getconf(String key);
	public String getStory(String key);
	public void setText(String whichText,String Text);
	public void setInt(String which, int vel);
}