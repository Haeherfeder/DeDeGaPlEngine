package de.haeherfeder.DeDeGaPlEngine;
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
    public void stop() {
    	for (IPlugin p : plugins) {
    		p.stop();
    	}
    }
}