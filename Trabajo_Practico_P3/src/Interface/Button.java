package Interface;

import java.awt.Color;
import java.util.Random;

import javax.swing.JButton;

public class Button {
	
	COLOR color;

	public Button() {
		this.color = COLOR.gray;
	}
	
	public void changeColor() {
		Random random = new Random();
		int randomColor = random.nextInt(COLOR.values().length-1);
		switch(randomColor) {
		case 0:
			button.setBackground(new Color(255,0,0));
			color = COLOR.red;
			break;
		case 1:
			button.setBackground(new Color(0,0,255));
			color = COLOR.blue;
			break;
		case 2:
			button.setBackground(new Color(0,255,0));
			color = COLOR.green;
			break;
		case 3:
			button.setBackground(new Color(255,255,0));
			color = COLOR.yellow;
			break;
		case 4:
			button.setBackground(new Color(0,255,255));
			color = COLOR.cyan;
			break;
		case 5:
			button.setBackground(new Color(255,0,255));
			color = COLOR.magenta;
			break;
		}
	}

	public void turnOff() {
		this.color = COLOR.gray;
		this.button.setBackground(new Color(50,50,50));	
	}
}
