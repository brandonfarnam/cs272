package edu.orangecoastcollege.cs272.view;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class Village {

	@FXML
	private Label villageText;
	
	@FXML
	private Label continueText;
	
	@FXML
	private Button checkButton;
	
	@FXML
	private Button goButton;
	
	@FXML
	private Button manButton;
	
	@FXML
	private Button girlButton;
	
	
	
	@FXML
	public Object optionsScene()
	{
		ViewNavigator.prevScene = ViewNavigator.VILLAGE;
		ViewNavigator.prevTitle = "A Village Approacheth";
		ViewNavigator.loadScene("Options", ViewNavigator.OPTIONS_SCENE);
		return this;
	}
	
	@FXML
	public Object man()
	{
		
		return this;
		
	}
	
	@FXML
	public Object woman()
	{
		
		return this;
		
	}
	
	@FXML
	public Object go()
	{
		villageText.setVisible(false);
		continueText.setVisible(true);
		goButton.setVisible(false);
		checkButton.setVisible(true);
		
		return this;
	}
	
}
