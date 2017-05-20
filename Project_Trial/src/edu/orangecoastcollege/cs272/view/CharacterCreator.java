package edu.orangecoastcollege.cs272.view;

import edu.orangecoastcollege.cs272.controller.Controller;
import edu.orangecoastcollege.cs272.model.Player;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class CharacterCreator {

	 private static Controller controller = Controller.getInstance();
	    private int pool = 10;
	    private Player currentPlayer = new Player();
	    
	    @FXML
	    private Label pointsLabel;
		@FXML
		private TextField nameTF;
		@FXML
		private Button startButton;
		@FXML
		private Label nameErrorLabel;
		@FXML
		private Label insufficentStatLabel;
		@FXML
		private Button plusStrength;
		@FXML
		private Button minusStrength;
		@FXML
		private Button plusDexterity;
		@FXML
		private Button minusDexterity;
		@FXML
		private Button plusIntellect;
		@FXML
		private Button minusIntellect;
		@FXML
		private Button plusImage;
		@FXML
		private Button minusImage;
		@FXML
		private Slider strSlider;
		@FXML 
		private ImageView ImageView; 

	@FXML
	public Object optionsScene()
	{
		ViewNavigator.prevScene = ViewNavigator.CHARACTER_CREATOR;
		ViewNavigator.prevTitle = "Character Creator";
		ViewNavigator.loadScene("Options", ViewNavigator.OPTIONS_SCENE);
		return this;
	}
	

	/*
	 * IDEA: set start button to be invisible till name is entered.
	 */

	
	@FXML
	public Object start()
	{
		String name = nameTF.getText();
		if(name.isEmpty())
		{
			nameErrorLabel.setVisible(true);
		}

		if(!name.isEmpty())
			/**
			 * IDEA: After the player set up Name/ points, when they click "Start", it will show Equipment List for user to choose 
			 */
		{	ViewNavigator.loadScene("Equipment List", ViewNavigator.EQUIPMENT_LIST_SCENE);
			return this;
		}

		return null;

	}
	@FXML
	public Object plusImage()
	{
		return ImageView;
		
	}

	@FXML
	public Object minusImage()
	{
		
		return this;
	}
	
	@FXML
	public ImageView changeImage(){
		Image image = new Image(getClass().getResource("face2.png").toExternalForm());

		ImageView.setImage(image);
		return ImageView;
 
		
	}

	
}
