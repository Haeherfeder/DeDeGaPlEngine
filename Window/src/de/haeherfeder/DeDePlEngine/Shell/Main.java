/**
 * 
 */
package de.haeherfeder.DeDePlEngine.Shell;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import de.haeherfeder.DeDePlEngine.all.*;

/**
 * @author benjamin
 *
 */
public class Main extends MainManager {
	/**
	 * @param args
	 * @throws IOException 
	 */
	String position;
	public static void main(String[] args) throws IOException {
		new Main();
	}
	public void setStartPosition(String newPos) {
		position = newPos;
	}
	public Main() throws IOException {
		if(!new File("./plugin").exists()) {new File("./plugin").mkdir();}
		gamewindow = new GameWindowShell();
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
	public void setEnd(boolean end) {
		Main.end = end;
	}
}