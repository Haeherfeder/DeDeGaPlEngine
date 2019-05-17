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
		Config.setPr("CurrentMode", "Window");
		new Story();
		Position = Story.getText("FirstP");
		pl.GameWindowStart(Position);
		pl.setEngineVersion("Window");
		new Main(Position);
		pl.stop();
		System.exit(0);
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
}