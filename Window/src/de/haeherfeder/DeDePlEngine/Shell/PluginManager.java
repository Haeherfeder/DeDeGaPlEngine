package de.haeherfeder.DeDePlEngine.Shell;

import java.io.IOException;

public class PluginManager implements IPluginManager {
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
			new GameWindow(Position);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.exit(1);
		}
	}
}