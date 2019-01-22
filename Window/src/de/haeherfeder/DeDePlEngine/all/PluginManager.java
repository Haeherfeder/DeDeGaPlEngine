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
				new de.haeherfeder.DeDePlEngine.Shell.Main(Position);
			case "Window":
				new de.haeherfeder.DeDePlEngine.Window.Main(Position);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.exit(1);
		}
		return;
	}
	public void setStartPosition(String Position) {
		switch(conf.getProp("CurrentMode")) {
		case "Shell":
			new de.haeherfeder.DeDePlEngine.Shell.Main().setPosition(Position);
			break;
		case "Window":
			new de.haeherfeder.DeDePlEngine.Window.Main().setPosition(Position);
			break;
		}
	}
	public String SinglePosition(String Position) {
		try {
			switch(conf.getProp("CurrentMode")) {
			case "Shell":
				return new de.haeherfeder.DeDePlEngine.Shell.GameWindow(Position).GameWindo(Position);
			case "Window":
				return new de.haeherfeder.DeDePlEngine.Window.GameWindow(Position).GameWindo(Position);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.exit(1);
		}
		return "";
	}
}