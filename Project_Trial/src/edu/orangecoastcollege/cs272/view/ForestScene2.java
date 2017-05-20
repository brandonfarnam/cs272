package edu.orangecoastcollege.cs272.view;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class ForestScene2 {

	@FXML
	private Label IntroText;
	
	@FXML
	private Label examineText;
	
	@FXML
	private Button go;
	
	@FXML
	private Button examineButton;
	
	@FXML
	private Button sneakButton;
	
	
	@FXML
	public Object optionsScene()
	{
		ViewNavigator.prevScene = ViewNavigator.FOREST_SCENE_2;
		ViewNavigator.prevTitle = "The Path";
		ViewNavigator.loadScene("Options", ViewNavigator.OPTIONS_SCENE);
		return this;
	}
	
	@FXML
	public Object examine()
	{
		/*
		 * Learn how to set text to visible and
		 * then switch out text
		 * do the same with buttons
		 */
		
		IntroText.setVisible(false);
		examineText.setVisible(true);
		examineButton.setVisible(false);
		sneakButton.setVisible(true);
		return this;
	}
	
	@FXML
	public Object sneak()
	{
		ViewNavigator.loadScene("A Village Approacheth", ViewNavigator.VILLAGE);
		return this;
	}
	
	@FXML
	public Object go()
	{
		ViewNavigator.loadScene("Combat", ViewNavigator.COMBAT_FOREST);
		return this;
	}
	
}
