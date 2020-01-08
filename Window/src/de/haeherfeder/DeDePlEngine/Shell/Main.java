/**
 * 
 */
package de.haeherfeder.DeDePlEngine.Shell;

import java.io.IOException;
import de.haeherfeder.DeDePlEngine.all.*;

/**
 * @author benjamin
 *
 */
public class Main extends MainManager {
	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		new Main();
	}
	public Main() throws IOException {
		gamewindow = new GameWindowShell();
		super.init();
	}
}