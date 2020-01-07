package de.haeherfeder.DeDePlEngine.all;

public interface IPlugin {
	boolean start();
	boolean stop();
	void setPluginManager(PluginManager manager);
	void gameWindowStart(String position);
	/*
	 * @args input can be null;
	 */
	void playerInput(String input, String position);
	void gameStart();
	boolean setEngineVersion(String version);
	void sendPosition(String position);
	void waitForInput(String position);
}
