package de.haeherfeder.DeDePlEngine.all;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public abstract class MainManager {
	public static boolean end = true;
	protected String position;
	public void setEnd(boolean end) {
		MainManager.end = end;
	}
	public void init() throws IOException {
		if(!new File("./plugin").exists()) {new File("./plugin").mkdir();}
		PluginManager pluginManager = new PluginManager(gamewindow, this);
		Plugin pl = new Plugin(pluginManager);
		gamewindow.setPlugin(pl);
		Config conf = new Config();
		conf.configFRSt();
		Config.setPr("CurrentMode", "Shell");
		new Story();
		position = Story.getText("FirstP");
		pl.GameWindowStart(position);
		pl.setEngineVersion("Shell");

		while(!("Ende".equalsIgnoreCase(position))) {
			position = gamewindow.gameWindow(position);	
		}
		
		System.out.println("Exit");
		pl.stop();
		while(true) {
			if(end) {
				System.exit(0);
			}
			try {
				TimeUnit.SECONDS.sleep(60);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	public GameWindow gamewindow;
	public void setStartPosition(String newPos) {
		position = newPos;
	}
}
