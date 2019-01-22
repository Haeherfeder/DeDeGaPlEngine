package de.haeherfeder.DeDePlEngine.Window;

import java.io.File;
import java.io.IOException;

import de.haeherfeder.DeDePlEngine.all.*;

public class Main {
	
	static String Position = null;
	public static void main(String[] args) throws IOException {
		if(!new File("./plugin").exists()) {new File("./plugin").mkdir();}
		Plugin pl = new Plugin();
		Config conf = new Config();
		conf.configFRSt();
		conf.setPr("CurrentMode", "Window");
		Position = new Story().getText("FirstP");
		pl.GameWindowStart(Position);
		pl.setEngineVersion("Window");
		GameWindow gamewindow = new GameWindow(Position);
		while(!("Ende".equalsIgnoreCase(Position))) {
			Position = gamewindow.GameWindo(Position);
		}
		pl.stop();
		System.exit(0);
	}
	public void setPosition(String NewPos) {
		Position = NewPos;
	}
}