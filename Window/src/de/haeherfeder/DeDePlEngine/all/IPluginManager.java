package de.haeherfeder.DeDePlEngine.all;

public interface IPluginManager {
	void showVisualMessage(String message);
	void DisableGameWindow();
	void setPosition(String Position);
	void setStartPosition(String Position);
	public String SinglePosition(String Position);
	public String getconf(String key);
	public String getStory(String key);
}