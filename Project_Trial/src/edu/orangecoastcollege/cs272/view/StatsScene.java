package edu.orangecoastcollege.cs272.view;

import edu.orangecoastcollege.cs272.controller.Controller;
import edu.orangecoastcollege.cs272.model.Equipment;
import edu.orangecoastcollege.cs272.model.Player;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class StatsScene {
    private static Controller controller = Controller.getInstance();
    private Player currentPlayer = new Player();
    private Equipment currentEquipment = new Equipment();

	private Label pointsLabel;
	private Label strengthLabel;
	private Label dexterityLabel;
	private Label intellectLabel;
	
	@FXML
	public Object resume()
	{
		ViewNavigator.loadScene(ViewNavigator.prevTitle, ViewNavigator.prevScene);
		return this;
	}
	/**
	 * Get point from Player and Equipment, after, show it, put them up by using Label
	 * @return
	 */
	@FXML
	public Object Points()
	{
		pointsLabel.setText(String.valueOf(currentPlayer.getStrength()+currentPlayer.getDexterity()+currentPlayer.getIntellect()));
		return this;
	}
	@FXML
	public Object Strengths(){
		strengthLabel.setText(String.valueOf(currentPlayer.getStrength()+currentEquipment.getStrength()));
		return this;
	}
	@FXML
	public Object Dexterity(){
		dexterityLabel.setText(String.valueOf(currentPlayer.getDexterity()+currentEquipment.getDexterity()));
		return this;
	}
	public Object intellect(){
		intellectLabel.setText(String.valueOf(currentPlayer.getIntellect()+currentEquipment.getIntellect()));
		return this;
	}
	
}
