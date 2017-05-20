package edu.orangecoastcollege.cs272.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Scanner;

import edu.orangecoastcollege.cs272.model.DBModel;
import edu.orangecoastcollege.cs272.model.Equipment;
import edu.orangecoastcollege.cs272.model.Player;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Controller {
	
	private static Controller theOne;
	

	private static final String DB_NAME = "vg_inventory.db";

//PLAYER:
//TEXT, INTEGER, INTEGER, INTEGER, REAL(?), INTEGER, INTEGER
//name, strength, dexterity, intellect, health, xp, level, equipment

	private static final String PLAYER_TABLE_NAME = "player";
	private static final String[] PLAYER_FIELD_NAMES = { "id", "name", "strength", "dexterity", "intellect","health","xp","level"};
	private static final String[] PLAYER_FIELD_TYPES = { "INTEGER PRIMARY KEY", "INTEGER", "INTEGER", "INTEGER", "REAL","INTEGER"};
	
// EQUIPMENT
//	id", "name", "strength", "dexterity", "intellect", "level"
//	 * @param fieldTypes The field types, e.g. "INTEGER PRIMARY KEY", "TEXT", "INTEGER", "INTEGER", "INTEGER", "INTEGER", "INTEGER"
	
	private static final String EQUIPMENT_TABLE_NAMES = "equipment";
	private static final String[] EQUIPMENT_FIELD_NAMES = { "id", "name", "strength", "dexterity", "intellect", "level"};
	private static final String[] EQUIPMENT_FIELD_TYPES = { "INTEGER PRIMARY KEY", "TEXT", "INTEGER", "INTEGER", "INTEGER", "INTEGER", "INTEGER"};
	private static final String EQUIPMENT_DATA_FILE = "equipment_lite.csv";

	
	private static final String PLAYER_EQUIPMENT_TABLE_NAME = "player_equipment";
	private static final String[] PLAYER_EQUIPMENT_FIELD_NAMES = { "player_id", "equipment_id"};
	private static final String[] PLAYER_EQUIPMENT_FIELD_TYPES = { "INTEGER", "INTEGER"};

	private Player mCurrentPlayer;
	private DBModel mPlayerDB;
	private DBModel mEquipmentDB;
	private DBModel mPlayerEquipmentDB;
	
	
	
	private ObservableList<Player> mAllPlayersList;
	private ObservableList<Equipment> mAllEquipmentList;
	
	private Controller()
	{
		
	}
	
	public static Controller getInstance() {
		if (theOne == null) {
			theOne = new Controller();
			theOne.mAllPlayersList = FXCollections.observableArrayList();
			theOne.mAllEquipmentList = FXCollections.observableArrayList();

			try {
				theOne.mPlayerDB = new DBModel(DB_NAME, PLAYER_TABLE_NAME, PLAYER_FIELD_NAMES , PLAYER_FIELD_TYPES);

				ResultSet rs = theOne.mPlayerDB.getAllRecords();
				while (rs.next()) {
//					 "id", "name", "strength", "dexterity", "intellect","health","xp","level","equipment"
					//INTEGER PRIMARY KEY", "INTEGER", "INTEGER", "INTEGER", "REAL","INTEGER","INTEGER
					int id = rs.getInt(PLAYER_FIELD_NAMES[0]);
					String name = rs.getString(PLAYER_FIELD_NAMES[1]);
					int strength = rs.getInt(PLAYER_FIELD_NAMES[2]);
					int dexterity = rs.getInt(PLAYER_FIELD_NAMES[3]);
					int intellect = rs.getInt(PLAYER_FIELD_NAMES[4]);
					int health =rs.getInt(PLAYER_FIELD_NAMES[5]);
					double xp = rs.getDouble(PLAYER_FIELD_NAMES[6]);
					int level = rs.getInt(PLAYER_FIELD_NAMES[7]);
					

					Player existingPlayer = new Player(id, name, strength, dexterity,intellect,health,xp,level);
					System.out.println(existingPlayer);
					theOne.mAllPlayersList.add(existingPlayer);
				}

				theOne.mEquipmentDB = new DBModel(DB_NAME, EQUIPMENT_TABLE_NAMES, EQUIPMENT_FIELD_NAMES, EQUIPMENT_FIELD_TYPES);
				theOne.initializeEquipmentDBFromFile();
				rs = theOne.mEquipmentDB.getAllRecords();
				while (rs.next())
					//"id", "name", "strength", "dexterity", "intellect", "level"
					 //"INTEGER PRIMARY KEY", "TEXT", "INTEGER", "INTEGER", "INTEGER", "INTEGER", "INTEGER"
				{
					int id = rs.getInt(EQUIPMENT_FIELD_NAMES[0]);
					String name = rs.getString(EQUIPMENT_FIELD_NAMES[1]);
					int strength = rs.getInt(EQUIPMENT_FIELD_NAMES[2]);
					int dexterity = rs.getInt(EQUIPMENT_FIELD_NAMES[3]);
					int intellect = rs.getInt(EQUIPMENT_FIELD_NAMES[4]);
					int level = rs.getInt(EQUIPMENT_FIELD_NAMES[5]);
					theOne.mAllEquipmentList.add(new Equipment(id, name, strength, dexterity, intellect, level));
				}

				theOne.mPlayerEquipmentDB= new DBModel(DB_NAME, PLAYER_EQUIPMENT_TABLE_NAME, PLAYER_EQUIPMENT_FIELD_NAMES, PLAYER_EQUIPMENT_FIELD_TYPES);

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return theOne;
	}
	
	private int initializeEquipmentDBFromFile() throws SQLException {
		int recordsCreated = 0;

		// If the result set contains results, database table already has
		// records, no need to populate from file (so return false)
		if (theOne.mPlayerDB.getRecordCount() > 0)
			return 0;

		try {
			// Otherwise, open the file (CSV file) and insert user data
			// into database
			Scanner fileScanner = new Scanner(new File(EQUIPMENT_DATA_FILE));
			// First read is for headings:
			fileScanner.nextLine();
			// All subsequent reads are for user data
			while (fileScanner.hasNextLine()) {
				String[] data = fileScanner.nextLine().split(",");
				// Length of values is one less than field names because values
				// does not have id (DB will assign one)
				String[] values = new String[EQUIPMENT_FIELD_NAMES.length - 1];
				values[0] = data[1].replaceAll("'", "''");
				values[1] = data[2];
				values[2] = data[3];
				values[3] = data[4];
				values[4] = data[5];
				theOne.mEquipmentDB.createRecord(Arrays.copyOfRange(EQUIPMENT_FIELD_NAMES, 1, EQUIPMENT_FIELD_NAMES.length), values);
				recordsCreated++;
			}

			// All done with the CSV file, close the connection
			fileScanner.close();
		} catch (FileNotFoundException e) {
			return 0;
		}
		return recordsCreated;
	}
	
	public ObservableList<Equipment> getEquipmentsForCurrentPlayer()
	{
		ObservableList<Equipment> playerEquipmentsList = FXCollections.observableArrayList();
		//Query the player_equipment table, get all the equipment ids for that player: 
		try
        {
            ResultSet rs = theOne.mPlayerEquipmentDB.getRecord(String.valueOf(mCurrentPlayer.getId()));
            while(rs.next()){
                //Grab the equipment id from the result set: 
                int equipmentId = rs.getInt(PLAYER_EQUIPMENT_FIELD_NAMES[1]);
                //Search through the ObservableList of Equipments to find Equipment id 
                for (Equipment eq:theOne.mAllEquipmentList){
                    if(eq.getId()==equipmentId)
                    	playerEquipmentsList.add(eq);
                }
            }
        }
        catch (SQLException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
		return playerEquipmentsList;
	}
	/**
	 * 
	 * @param Add Equipments to CurrentPlayer's Inventory 
	 * @return
	 */
	public boolean addEquipmentToPlayerInventory(Equipment selectedEquipment)  {
	    //Get all the equipments for the current player: 
	    ObservableList<Equipment> equipmentsForCurrentPlayer = theOne.getEquipmentsForCurrentPlayer();
	    //Loop through equipments, if duplicate return false 
	    if(equipmentsForCurrentPlayer.contains(selectedEquipment))
	        return false;
	    //If equipment is new, add it to the relationship table:
	    String[] values = {String.valueOf(mCurrentPlayer.getId()), String.valueOf(selectedEquipment.getId())};
	    try
        {
            theOne.mPlayerEquipmentDB.createRecord(PLAYER_EQUIPMENT_FIELD_NAMES, values);
        }
        catch (SQLException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return false;
        }
	    return true;
	}
	public Player getCurrentPlayer()
	{
		return mCurrentPlayer;
	}
	public ObservableList<Player> getAllPlayer() {
		return theOne.mAllPlayersList;
	}

	public ObservableList<Equipment> getAllEquipments() {
		return theOne.mAllEquipmentList;
	}
}
