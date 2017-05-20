package edu.orangecoastcollege.cs272.view;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ViewNavigator {
	
	// This is where I put the different scenes
	public static final String CHARACTER_CREATOR = "CharacterCreator.fxml";
	public static final String OPTIONS_SCENE = "OptionsScene.fxml";
	public static final String INTRO_FOREST = "IntroForest.fxml";
	public static final String FOREST_SCENE_2 = "ForestScene2.fxml";
	public static final String COMBAT_FOREST = "CombatForest.fxml";
	public static final String VILLAGE = "Village.fxml";
	public static final String QUIT_SCENE = "Quit.fxml";
	public static final String EXIT_SCENE = "Exit.fxml";
	public static final String TITLE_SCENE = "TitleScreenScene.fxml";
	public static final String STATS_SCENE = "StatsScene.fxml";
	public static final String EQUIPMENT_LIST_SCENE = "EquipmentListScene.fxml";
 

	
	public static Stage mainStage;
	public static String prevScene;
	public static String prevTitle;
	
	public static void setStage(Stage stage)
	{
		mainStage = stage;
	}
	
	
	public static void loadScene(String title, String sceneFXML)
	{
		try {
			mainStage.setTitle(title);
			Scene scene = new Scene(FXMLLoader.load(ViewNavigator.class.getResource(sceneFXML)));
			mainStage.setScene(scene);
			mainStage.show();
		}
		catch (IOException e)
		{
			System.err.println("Error loading: " + sceneFXML + "\n" + e.getMessage());
			e.printStackTrace();
		}
	}

	
}
