package de.haeherfeder.DeDePlEngine.Shell;
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
    public void  PlayerInput(String Input) {
    	for (IPlugin p : plugins) {
    		p. PlayerInput(Input);
    	}
    }
    public void stop() {
    	for (IPlugin p : plugins) {
    		p.stop();
    	}
    }
}