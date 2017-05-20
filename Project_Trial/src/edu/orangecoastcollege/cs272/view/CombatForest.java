package edu.orangecoastcollege.cs272.view;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class CombatForest {
	
	@FXML
	private Button fightButton;

	@FXML
	private Button runButton;
	
	@FXML
	private Button goButton;
	
	@FXML
	private Button okButton;
	
	@FXML
	private Button talkButton;
	
	@FXML
	private Label preBattleText;
	
	@FXML
	private Label runText;
	
	@FXML
	private Label fightText;
	
	@FXML
	private Label talkText;
	
	@FXML
	public Object optionsScene()
	{
		ViewNavigator.prevScene = ViewNavigator.COMBAT_FOREST;
		ViewNavigator.prevTitle = "Combat";
		ViewNavigator.loadScene("Options", ViewNavigator.OPTIONS_SCENE);
		return this;
	}
	
	@FXML
	public Object fight()
	{
		preBattleText.setVisible(false);
		fightText.setVisible(true);
		fightButton.setVisible(false);
		runButton.setVisible(false);
		talkButton.setVisible(false);
		okButton.setVisible(true);
		
		return this;	
	}
	
	@FXML
	public Object run()
	{
		preBattleText.setVisible(false);
		runText.setVisible(true);
		fightButton.setVisible(false);
		runButton.setVisible(false);
		talkButton.setVisible(false);
		goButton.setVisible(true);
		return this;
	}
	
	@FXML
	public Object talk()
	{
		preBattleText.setVisible(false);
		talkText.setVisible(true);
		runButton.setVisible(false);
		fightButton.setVisible(false);
		talkButton.setVisible(false);
		okButton.setVisible(true);
		return this;
	}
	
	@FXML
	public Object go()
	{
		ViewNavigator.loadScene("A Village Approacheth", ViewNavigator.VILLAGE);
		return this;	
		}
	
	@FXML
	public Object ok()
	{
		System.exit(0);
		return this;
	}
}
