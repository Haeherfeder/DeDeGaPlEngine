package de.haeherfeder.DeDePlEngine.all;

import java.awt.Frame;
import java.io.IOException;

public class PluginManager implements IPluginManager {
	
	GameWindow gameWindow;
	MainManager main;
	
	public PluginManager(GameWindow gameWindow, MainManager main) {
		this.gameWindow = gameWindow;
		this.main = main;
	}
	
	Config conf = new Config();
	public void showVisualMessage(String message) {
		System.out.println(message);
	}
	
	@Override
	public void disableGameWindow() {
		
	}

	@Override
	public void setPosition(String position) {
		try {
			gameWindow.gameWindow(position);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return;
	}
	
	public void setStartPosition(String position) {
		main.setStartPosition(position);
	}
	
	public String singlePosition(String Position) {
		try {
			return gameWindow.gameWindow(Position);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public String getconf(String key) {
		return Config.getProp(key);
	}
	public String getStory(String key) {
		try {
			return Story.getText(key);
		} catch (IOException e) {
			e.printStackTrace();
		} 
		return null;
	}

	@Override
	public void setText(String whichText, String Text) {
		switch(whichText) 
		{
			case "tf1Text":
				gameWindow.settf1Text(Text);
				break;
			case "tf2Text":
				gameWindow.settf2Text(Text);
				break;
			case "tf3Text":
				gameWindow.settf3Text(Text);
				break;
			case "tf1Fieldtext":
				gameWindow.settf1Fieldtext(Text);
				break;
			case "tf2Fieldtext":
				gameWindow.settf2Fieldtext(Text);
				break;
			case "tf3Fieldtext":
				gameWindow.settf3Fieldtext(Text);
				break;
			case "PanelName":
				gameWindow.setPanelName(Text);
				break;
			default: 
				break;
		}
	}

	@Override
	public void setInt(String which, int vel) {
		switch(which) {
		case "tf1Fieldlen":
			gameWindow.settf1Fieldlen(vel);
			break;
		case "tf2Fieldlen":
			gameWindow.settf2Fieldlen(vel);
			break;
		case "tf3Fieldlen":
			gameWindow.settf3Fieldlen(vel);
			break;
		case "fields":
			gameWindow.settf1Fieldlen(vel);
			gameWindow.settf2Fieldlen(vel);
			gameWindow.settf3Fieldlen(vel);
			break;
		}
	}
	public void doNotEnde() {
		MainManager.end = false;
	}

	@Override
	public Frame getFrame() {
		return gameWindow.f;
	}
}