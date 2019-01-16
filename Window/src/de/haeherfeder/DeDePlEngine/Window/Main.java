package de.haeherfeder.DeDePlEngine.Window;

import java.io.File;
import java.io.IOException;

public class Main {

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
