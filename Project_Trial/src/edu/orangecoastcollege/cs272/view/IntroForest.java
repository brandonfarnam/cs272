package edu.orangecoastcollege.cs272.view;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

import com.sun.media.jfxmedia.MediaPlayer;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.media.Media;

public class IntroForest {


	@FXML
	private Label examineText;

	@FXML
	private Label IntroText;

	@FXML
	private Button go;

	@FXML
	private Button examineButton;

	@FXML
	private Button pickUpButton;


	@FXML
	public Object optionsScene()
	{
		ViewNavigator.prevScene = ViewNavigator.INTRO_FOREST;
		ViewNavigator.prevTitle = "Forest";
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
		pickUpButton.setVisible(true);
		return this;

		// Collect Item -- Controller -- database
	}


	@FXML
	public Object go()
	{
		ViewNavigator.loadScene("The Path", ViewNavigator.FOREST_SCENE_2);
		return this;
	}

}
