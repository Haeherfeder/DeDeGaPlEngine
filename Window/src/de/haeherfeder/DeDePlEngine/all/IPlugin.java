package de.haeherfeder.DeDePlEngine.all;

public interface IPlugin {
	boolean start();
	boolean stop();
	void setPluginManager(PluginManager manager);
	void gameWindowStart(String Position);
	void playerInput(String Input, String position);
	void gameStart();
	boolean setEngineVersion(String Version);
	void sendPosition(String position);
}
