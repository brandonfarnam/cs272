package edu.orangecoastcollege.cs272.view;


import javafx.fxml.FXML;

import javafx.scene.control.Button;


public class TitleScreenScene  {
	

	@FXML
	private Button Start;
	@FXML
	private Button Credits;
	@FXML
	private Button Continue;
	@FXML
	private Button Quit; 
	
	@FXML 
	public Object Start(){
		 ViewNavigator.loadScene("Start", ViewNavigator.CHARACTER_CREATOR);
			return this;
	}
	@FXML 
	public Object Quit(){
		ViewNavigator.loadScene("Quit", ViewNavigator.QUIT_SCENE);
		return this;
	}
	@FXML 
	public Object Exit(){
		System.exit(0);
		return null;
	}
	@FXML 
	public Object Continue(){
		ViewNavigator.loadScene("Game" , ViewNavigator.CHARACTER_CREATOR);
		return this;
	}
	@FXML 
	public Object Resume(){
		ViewNavigator.loadScene("Game" , ViewNavigator.TITLE_SCENE);
		return this;
	}
	
	
	
}

	
	