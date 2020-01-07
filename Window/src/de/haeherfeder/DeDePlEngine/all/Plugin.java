package de.haeherfeder.DeDePlEngine.all;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class Plugin {
	List<IPlugin> plugins = PluginLoader.loadPlugins(new File("./plugin"));
    PluginManager manager;
	public Plugin(PluginManager manager) throws IOException {
		this.manager = manager;
	    for (IPlugin p : plugins) {
	      p.setPluginManager(manager);
	    }
	    for (IPlugin p : plugins) {
	      p.start();
	    }
	}
//	public Plugin(String string)throws IOException{
//		manager = new PluginManager();
//		for (IPlugin p : plugins) {
//			p.setPluginManager(manager);
//		}
//	}
    public void GameWindowStart(String position) {
    	for (IPlugin p : plugins) {
    		p.gameWindowStart(position);
    	}
    }
    public void setEngineVersion(String version) {
    	for (IPlugin p : plugins) {
    		p.setEngineVersion(version);
    	}
    }
    public void  PlayerInput(String input, String position) {
    	for (IPlugin p : plugins) {
    		p.playerInput(input,position);
    	}
    }
    public void stop() {
    	for (IPlugin p : plugins) {
    		p.stop();
    	}
    }
	public void sendPosition(String position) {
		for (IPlugin p : plugins) {
    		p.sendPosition(position);
    	} 
	}
	public void waitForInput(String position) {
		for (IPlugin p : plugins) {
    		p.waitForInput(position);
    	}
	}
}