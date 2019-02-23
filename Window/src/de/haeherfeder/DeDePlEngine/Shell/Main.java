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
		conf.setPr("CurrentMode", "Shell");
		Position = new Story().getText("FirstP");
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
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public void setPosition(String NewPos) {
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
	public void setEnd(boolean end) {
		Main.end = end;
	}
}