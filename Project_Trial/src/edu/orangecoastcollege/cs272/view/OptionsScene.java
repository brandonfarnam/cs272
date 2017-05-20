package edu.orangecoastcollege.cs272.view;

import javafx.fxml.FXML;


public class OptionsScene {

	@FXML
	public Object resume()
	{
		ViewNavigator.loadScene(ViewNavigator.prevTitle, ViewNavigator.prevScene);
		return this;
	}
	
	// Set all values to default (strength, dex, intellect = 5; name = blank);
	@FXML
	public Object Stats()
	{
		
		ViewNavigator.loadScene("Title", ViewNavigator.STATS_SCENE);
		return this;
	}
	@FXML
	public Object quit()
	{
		ViewNavigator.loadScene("Quit", ViewNavigator.QUIT_SCENE);
		return null;
	}
	
}
