/**
 * 
 */
package de.haeherfeder.DeDePlEngine.Shell;

import java.io.File;
import java.io.IOException;

import de.haeherfeder.DeDePlEngine.all.Config;
import de.haeherfeder.DeDePlEngine.all.Plugin;
import de.haeherfeder.DeDePlEngine.all.Story;

/**
 * @author benjamin
 *
 */
public class Main {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		if(!new File("./plugin").exists()) {new File("./plugin").mkdir();}
		Plugin pl = new Plugin();
		Config conf = new Config();
		conf.configFRSt();
		conf.setPr("CurrentMode", "Shell");
		String Position = new Story().getText("FirstP");
		pl.GameWindowStart(Position);
		pl.setEngineVersion("Shell");
		new GameWindow(Position);
		System.out.println("Exit");
		pl.stop();
		System.exit(0);
	}
}