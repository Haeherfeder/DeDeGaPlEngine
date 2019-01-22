/**
 * 
 */
package de.haeherfeder.DeDePlEngine.Shell;

import java.io.File;
import java.io.IOException;

import de.haeherfeder.DeDePlEngine.all.*;

/**
 * @author benjamin
 *
 */
public class Main {

	/**
	 * @param args
	 * @throws IOException 
	 */
	static String Position;
	public static void main(String[] args) throws IOException {
		if(!new File("./plugin").exists()) {new File("./plugin").mkdir();}
		Plugin pl = new Plugin();
		Config conf = new Config();
		conf.configFRSt();
		conf.setPr("CurrentMode", "Shell");
		Position = new Story().getText("FirstP");
		pl.GameWindowStart(Position);
		pl.setEngineVersion("Shell");
		GameWindow gamewindow = new GameWindow(Position);
		while("Ende".equalsIgnoreCase(Position)) {
		
		Position = gamewindow.GameWindo(Position);
		
		}
		System.out.println("Exit");
		pl.stop();
		System.exit(0);
	}
	public void setPosition(String NewPos) {
		Position = NewPos;
	}
}