package de.haeherfeder.DeDePlEngine.Window;

import java.io.IOException;
import de.haeherfeder.DeDePlEngine.all.*;

public class Main extends MainManager{
	
	public static void main(String[] args) throws IOException{
		new Main();
	}
	
	public Main() throws IOException {
		gamewindow = new GameWindowWindow();
		super.init();
	}
}