/**
 * 
 */
package de.haeherfeder.DeDePlEngine.Shell;

import java.io.File;
import java.io.IOException;

import de.haeherfeder.DeDePlEngine.Window.Config;
import de.haeherfeder.DeDePlEngine.Window.GameWindow;
import de.haeherfeder.DeDePlEngine.Window.Plugin;
import de.haeherfeder.DeDePlEngine.Window.Story;

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
		Story story = new Story();
		Config conf = new Config();
		conf.configFRSt();
		String Position = story.getText("FirstP");
		new GameWindow(Position);
		pl.stop();
		System.exit(0);

	}

}
