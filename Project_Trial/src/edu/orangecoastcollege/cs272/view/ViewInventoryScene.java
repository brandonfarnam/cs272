package edu.orangecoastcollege.cs272.view;

import java.net.URL;
import java.util.ResourceBundle;

import edu.orangecoastcollege.cs272.controller.Controller;
import edu.orangecoastcollege.cs272.model.Equipment;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

public class ViewInventoryScene implements Initializable  {

	private static Controller controller = Controller.getInstance();

	@FXML
	private ListView<Equipment> playerEquipmentLV;
	@FXML
	private Label userLabel;


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		//TODO: Complete this method
		playerEquipmentLV.setItems(controller.getEquipmentsForCurrentPlayer());
	}


	@FXML
	public Object backToAllGames()
	{
		ViewNavigator.loadScene("Video Games List", ViewNavigator.EQUIPMENT_LIST_SCENE);
		return this;
	}
}
