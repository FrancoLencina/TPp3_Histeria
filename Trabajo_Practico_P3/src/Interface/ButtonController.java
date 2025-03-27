package Interface;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;

public class ButtonController {

	Map<Integer, Button> buttonMap;
	int boardSize;
	
	public ButtonController(int boardSize) {
		buttonMap = new HashMap<Integer, Button>();
		this.boardSize = boardSize;
	}
	
	
	public void activeButton(String JButtonName){
		
		Button button = buttonMap.get(Integer.parseInt(JButtonName));
		button.changeColor();
		if (colorMatch(button,neighborhood(button))) {
			neighborsOFF(button);
		}
		
	}
	
	public void addNewButton(String name, JButton button) {
		Button newButton = new Button(Integer.parseInt(name), button);
		buttonMap.put(newButton.buttonID, newButton);
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


