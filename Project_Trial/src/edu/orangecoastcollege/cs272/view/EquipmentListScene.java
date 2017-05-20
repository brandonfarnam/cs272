package edu.orangecoastcollege.cs272.view;



import java.net.URL;
import java.util.ResourceBundle;

import edu.orangecoastcollege.cs272.controller.Controller;
import edu.orangecoastcollege.cs272.model.Equipment;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

public class EquipmentListScene {

	/** 
	 * After a user created a character, they could choose weapon based on equipmentsList 
	 */

	private static Controller controller = Controller.getInstance();

	@FXML
	private ListView<Equipment> allEquipmentLV;
	
	
	public void initialize(URL location, ResourceBundle resources) {
		allEquipmentLV.setItems(controller.getAllEquipments());

	}


	@FXML
	public Object addEquipmentToInventory()
	{
	        //Find out the selected video game to add
	    Equipment selectedEquipment = allEquipmentLV.getSelectionModel().getSelectedItem();
	    controller.addEquipmentToPlayerInventory(selectedEquipment);

	    return this;
	}

	@FXML
	public Object viewInventory()
	{
	    ViewNavigator.loadScene("View Equipment List", ViewNavigator.EQUIPMENT_LIST_SCENE);
	    return this;
	}
	@FXML 
	public Object Continue(){
		ViewNavigator.loadScene("Game" , ViewNavigator.COMBAT_FOREST);
		return this;
	}
}

