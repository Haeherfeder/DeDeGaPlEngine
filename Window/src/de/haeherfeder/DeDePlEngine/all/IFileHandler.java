package de.haeherfeder.DeDePlEngine.all;

public interface IFileHandler {
	public void init();
	public String getConfigStoryText(String key);
	public int getConfigStoryInt(String key);
	public String getStoryText(String key);
	public int getStoryInt(String key);
	public void setPr(String key,String vel);
	public String getConfigText(String key);
	public int getConfigInt(String key);
}
