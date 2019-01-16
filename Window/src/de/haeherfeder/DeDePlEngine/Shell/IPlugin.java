package de.haeherfeder.DeDePlEngine.Shell;

public interface IPlugin {
	boolean start();
	boolean stop();
	void setPluginManager(PluginManager manager);
	void GameWindowStart(String Position);
	void PlayerInput(String Input);
	void GameStart();
	boolean setEngineVersion(String Version);
}
