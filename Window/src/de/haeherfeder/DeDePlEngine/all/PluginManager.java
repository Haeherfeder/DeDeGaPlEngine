package de.haeherfeder.DeDePlEngine.all;

import java.io.IOException;

public class PluginManager implements IPluginManager {
	Config conf = new Config();
	
	public void showVisualMessage(String message) {
		System.out.println(message);
	}
/*	public void GameWindowStart(String Position) {
		
	}*/

	@Override
	public void DisableGameWindow() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setPosition(String Position) {
		// TODO Auto-generated method stub
		try {
			switch(conf.getProp("CurrentMode")) {
			case "Shell":
				new de.haeherfeder.DeDePlEngine.Shell.GameWindow(Position);
				break;
			case "Window":
				new de.haeherfeder.DeDePlEngine.Window.GameWindow(Position);
				break;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.exit(1);
		}
	}
}