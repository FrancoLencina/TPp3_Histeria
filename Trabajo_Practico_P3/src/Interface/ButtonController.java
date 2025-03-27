package Interface;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;

public class ButtonController {

	//Map<Integer, Button> buttonMap;
	Button[][] buttonMatrix;
	int boardSize;
	
	public ButtonController(int boardSize) {
		//buttonMap = new HashMap<Integer, Button>();
		this.boardSize = boardSize;
		this.buttonMatrix = new Button[boardSize][boardSize];
	}
	
	
	public void activeButton(int row, int column){
		
		//Button button = buttonMap.get(Integer.parseInt(JButtonName));
		Button button = buttonMatrix[row][column];
		button.changeColor();
		if (colorMatch(button,neighborhood(button))) {
			neighborsOFF(button);
		}
		
	}
	
	public void addNewButton(int row, int column) {
		Button newButton = new Button();
		buttonMatrix[row][column] = newButton;
		//buttonMap.put(newButton.buttonID, newButton);
	}

	private ArrayList<Integer> neighborhood(Button button){
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		if (button.buttonID % boardSize != 0) { 
			list.add(button.buttonID-1);
		}
		
		if (button.buttonID % boardSize != boardSize-1) {
			list.add(button.buttonID+1);
		}
		
		if (button.buttonID - 5 >= 0) {
			list.add(button.buttonID - 5);
		}
		
		if (button.buttonID + 5 < boardSize*boardSize) {
			list.add(button.buttonID + 5);
		}
		
		return list; 
	}
	
	private boolean neighborON(int neighborID){
	
			if(buttonMap.get(neighborID).color != COLOR.gray) {
				return true;
			}
		return false;
	}
	
	private boolean colorMatch(Button button, ArrayList<Integer> neighborhood) {
		
		for (Integer neighborID : neighborhood) {
			if (neighborON(neighborID) && buttonMap.get(neighborID).color == button.color) {
				return true;
			}
		}
		return false;
	}
	
	private void neighborsOFF(Button button) {
			
			if (colorMatch(button, neighborhood(button))) {
				
				button.turnOff();
				for (Integer neighborID : neighborhood(button)) {
					buttonMap.get(neighborID).turnOff();
				}
			}
		}
}


