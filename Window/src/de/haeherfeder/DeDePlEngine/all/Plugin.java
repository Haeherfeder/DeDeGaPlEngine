package de.haeherfeder.DeDePlEngine.all;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class Plugin {
	List<IPlugin> plugins = PluginLoader.loadPlugins(new File("./plugin"));
    PluginManager manager = new PluginManager();
	public  Plugin() throws IOException {
	    for (IPlugin p : plugins) {
	      p.setPluginManager(manager);
	    }
	    for (IPlugin p : plugins) {
	      p.start();
	    }
	}
    public void GameWindowStart(String Position) {
    	for (IPlugin p : plugins) {
    		p.GameWindowStart(Position);
    	}
    }
    public void setEngineVersion(String Version) {
    	for (IPlugin p : plugins) {
    		p.setEngineVersion(Version);
    	}
    }
    public void  PlayerInput(String Input, String position) {
    	for (IPlugin p : plugins) {
    		p. PlayerInput(Input,position);
    	}
    }
    public void stop() {
    	for (IPlugin p : plugins) {
    		p.stop();
    	}
    }
	public void sendPosition(String position) {
		// TODO Auto-generated method stub
		for (IPlugin p : plugins) {
    		p.sendPosition(position);
    	} 
	}
}