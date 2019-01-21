package de.haeherfeder.DeDePlEngine.Window;

import java.io.File;
import java.io.IOException;

import de.haeherfeder.DeDePlEngine.all.*;

public class Main {
	public static void main(String[] args) throws IOException {
		if(!new File("./plugin").exists()) {new File("./plugin").mkdir();}
		Plugin pl = new Plugin();
		Config conf = new Config();
		conf.configFRSt();
		conf.setPr("CurrentMode", "Window");
		String Position = new Story().getText("FirstP");
		pl.GameWindowStart(Position);
		pl.setEngineVersion("Window");
		new GameWindow(Position);
		pl.stop();
		System.exit(0);
	}
}