package de.haeherfeder.DeDePlEngine.all;

public interface IPlugin {
	boolean start();
	boolean stop();
	void setPluginManager(PluginManager manager);
	void GameWindowStart(String Position);
	void PlayerInput(String Input, String position);
	void GameStart();
	boolean setEngineVersion(String Version);
	void sendPosition(String position);
}
