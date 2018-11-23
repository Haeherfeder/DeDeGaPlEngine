package de.haeherfeder.DeDeGaPlEngine;

import java.io.File;
import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		if(!new File("./plugin").exists()) {new File("./plugin").mkdir();}
		Plugin pl = new Plugin();
		new Story();
		Config conf = new Config();
		conf.configFRSt();
//		Config p = new Config();
//		String FirstPosition = p.getProp("FirstPosition");
		new GameWindow(null);
		pl.stop();
		System.exit(0);
	}

}
