package de.haeherfeder.DeDePlEngine.all;

import java.io.IOException;

public class PluginManager implements IPluginManager {
	de.haeherfeder.DeDePlEngine.Shell.GameWindow Shell;
	de.haeherfeder.DeDePlEngine.Window.GameWindow Window;
	
	public PluginManager() {
		try {
			Shell = new de.haeherfeder.DeDePlEngine.Shell.GameWindow();
			Window = new de.haeherfeder.DeDePlEngine.Window.GameWindow();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	Config conf = new Config();
	public void showVisualMessage(String message) {
		System.out.println(message);
	}
/*	public void GameWindowStart(String Position) {
		
	}*/

	@Override
	public void DisableGameWindow() {
		
	}

	@Override
	public void setPosition(String Position) {
		// TODO Auto-generated method stub
		try {
			switch(Config.getProp("CurrentMode")) {
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
		switch(Config.getProp("CurrentMode")) {
		case "Shell":
			new de.haeherfeder.DeDePlEngine.Shell.Main().setPosition(Position);
			break;
		case "Window":
			de.haeherfeder.DeDePlEngine.Window.Main.setPosition(Position);
			break;
		}
	}
	public String SinglePosition(String Position) {
		try {
			switch(Config.getProp("CurrentMode")) {
			case "Shell":
				return Shell.GameWindo(Position);
			case "Window":
				return Window.GameWindo(Position);
			}
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
		return "";
	}
	public String getconf(String key) {
		return Config.getProp(key);
	}
	public String getStory(String key) {
		try {
			return Story.getText(key);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return null;
	}

	@Override
	public void setText(String WhichText, String Text) {
		switch(Config.getProp("CurrentMode")) 
		{
			case "Shell":
				switch(WhichText) 
				{
					case "tf1Text":
						Shell.settf1Text(Text);
						break;
					case "tf2Text":
						Shell.settf2Text(Text);
						break;
					case "tf3Text":
						Shell.settf3Text(Text);
						break;
					case "tf1Fieldtext":
						Shell.settf1Fieldtext(Text);
						break;
					case "tf2Fieldtext":
						Shell.settf2Fieldtext(Text);
						break;
					case "tf3Fieldtext":
						Shell.settf3Fieldtext(Text);
						break;
					case "PanelName":
						Shell.setPanelName(Text);
						break;
					default: 
						break;
				}
				break;
			case "Window":
				switch(WhichText) 
				{
					case "tf1Text":
						Window.settf1Text(Text);
						break;
					case "tf2Text":
						Window.settf2Text(Text);
						break;
					case "tf3Text":
						Window.settf3Text(Text);
						break;
					case "tf1Fieldtext":
						Window.settf1Fieldtext(Text);
						break;
					case "tf2Fieldtext":
						Window.settf2Fieldtext(Text);
						break;
					case "tf3Fieldtext":
						Window.settf3Fieldtext(Text);
						break;
					case "PanelName":
						Window.setPanelName(Text);
						break;
					default: 
						break;
				}
			break;
		}
	}

	@Override
	public void setInt(String Which, int vel) {
		// TODO Auto-generated method stub
		switch(Config.getProp("CurrentMode")) {
		case "Shell":
			switch(Which) {
			case "tf1Fieldlen":
				break;
			case "tf2Fieldlen":
				break;
			case "tf3Fieldlen":
				break;
			case "fields":
				break;
		}
		case "Window":
			switch(Which) {
			case "tf1Fieldlen":
				Window.settf1Fieldlen(vel);
				break;
			case "tf2Fieldlen":
				Window.settf2Fieldlen(vel);
				break;
			case "tf3Fieldlen":
				Window.settf3Fieldlen(vel);
				break;
			case "fields":
				Window.setFields(vel);
				break;
			}
		}
	}
	public void DoNotEnde() {
		
	}
}