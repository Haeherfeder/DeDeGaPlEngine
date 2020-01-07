package de.haeherfeder.DeDePlEngine.all;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class Plugin {
	List<IPlugin> plugins = PluginLoader.loadPlugins(new File("./plugin"));
    PluginManager manager;
	public  Plugin(PluginManager manager) throws IOException {
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
    public void GameWindowStart(String Position) {
    	for (IPlugin p : plugins) {
    		p.gameWindowStart(Position);
    	}
    }
    public void setEngineVersion(String Version) {
    	for (IPlugin p : plugins) {
    		p.setEngineVersion(Version);
    	}
    }
    public void  PlayerInput(String Input, String position) {
    	for (IPlugin p : plugins) {
    		p. playerInput(Input,position);
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