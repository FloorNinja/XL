package gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JTextField;

import model.Sheet;
import util.XLException;

public class Editor extends JTextField implements Observer, ActionListener {
	private CurrentSlot currentSlot;
	private Sheet sheet;
	private StatusLabel status;

	public Editor(CurrentSlot currentSlot, Sheet sheet, StatusLabel label) {
		this.currentSlot = currentSlot;
		this.sheet = sheet;
		status = label;
		setBackground(Color.WHITE);
		addActionListener(this);
		currentSlot.addObserver(this);
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		String address = currentSlot.getAddress();
		String expression = sheet.slotExpression(address);
		setText(expression);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		status.clear();
		String address = currentSlot.getAddress();
		String input = getText();
		try {
			if (input.equals("")) 
				sheet.removeSlot(address); 
			else
				sheet.putSlot(address, input);
			
		} catch (XLException e) {
			status.setText(e.getMessage());
		}
		
	}
}