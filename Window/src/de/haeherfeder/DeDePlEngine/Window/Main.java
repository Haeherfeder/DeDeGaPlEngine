package de.haeherfeder.DeDePlEngine.Window;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import de.haeherfeder.DeDePlEngine.all.*;

public class Main extends MainManager{
	
	String position;
	GameWindow gamewindow;
	public static void main(String[] args){
		try {
			new Main();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public Main() throws IOException {
		if(!new File("./plugin").exists()) {new File("./plugin").mkdir();}
		gamewindow = new GameWindowWindow();
		Plugin pl = new Plugin(new PluginManager(gamewindow, this));
		Config conf = new Config();
		conf.configFRSt();
		Config.setPr("CurrentMode", "Window");
		new Story();
		position = Story.getText("FirstP");
		pl.GameWindowStart(position);
		pl.setEngineVersion("Window");
		GameWindow gamewindow = new GameWindowWindow();
		while(!("Ende".equalsIgnoreCase(position))) {
			position = gamewindow.gameWindow(position);	
		}
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
	@Override
	public void setEnd(boolean end) {
		Main.end = end;
	}
	@Override
	public void setStartPosition(String newPos) {
		position = newPos;
	}
}