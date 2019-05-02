package de.haeherfeder.DeDePlEngine.all;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class FileHandler {
	List<IFileHandler> fileManagers = FileHandlerLoader.loadFileHandlers(new File("./"));
 //   FileManagerManager manager;
	public  FileHandler() throws IOException {
	    for (IFileHandler p : fileManagers) {
	      p.init();
	    }
	}
	public FileHandler(String string)throws IOException{
		for (IFileHandler p : fileManagers) {
			p.init();
		}
	}
	public String getConfigStoryText(String key) {
		for (IFileHandler p : fileManagers) {
			return p.getConfigStoryText(key);
		}
		return null;
	}
	public int getConfigStoryInt(String key) {
		for (IFileHandler p : fileManagers) {
			return p.getConfigStoryInt(key);
		}
		return 0;
	}
	public String getStoryText(String key) {
		for (IFileHandler p : fileManagers) {
			return p.getStoryText(key);
		}
		return null;
	}
	public int getStoryInt(String key) {
		for (IFileHandler p : fileManagers) {
			return p.getStoryInt(key);
		}
		return 0;
	}
	public void setPr(String key,String vel) {
		for (IFileHandler p : fileManagers) {
			p.setPr(key,vel);
		}
	}
	public String getConfigText(String key) {
		for (IFileHandler p : fileManagers) {
			return p.getConfigText(key);
		}
		return null;
	}
	public int getConfigInt(String key) {
		for (IFileHandler p : fileManagers) {
			return p.getConfigInt(key);
		}
		return 0;
	}
}