package de.haeherfeder.DeDeGaPlEngine;
import de.haeherfeder.DeDeGaPlEngine.PluginManager;;

public interface IPlugin {
	boolean start();
	boolean stop();
	void setPluginManager(PluginManager manager);
	void GameWindowStart(String Position);
	void PlayerInput(String Input);
	void GameStart();
}
