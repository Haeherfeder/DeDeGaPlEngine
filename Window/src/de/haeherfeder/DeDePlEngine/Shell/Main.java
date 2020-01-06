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
public class Main {
	static boolean end = true;
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
		Config.setPr("CurrentMode", "Shell");
		new Story();
		Position = Story.getText("FirstP");
		pl.GameWindowStart(Position);
		pl.setEngineVersion("Shell");

		new Main(Position);
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
	public static void setPosition(String NewPos) {
		Position = NewPos;
	}
	public Main(String Position) throws IOException {
		GameWindow gamewindow = new GameWindow(Position);
		while(!("Ende".equalsIgnoreCase(Position))) {
			Position = gamewindow.GameWindo(Position);	
		}
	}
	public Main() {
		
	}
	public static void setEnd(boolean end) {
		Main.end = end;
	}
}