package gui.menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;

import gui.CurrentSlot;
import model.Sheet;

class ClearMenuItem extends JMenuItem implements ActionListener {
    private Sheet sheet;
    private CurrentSlot currentSlot;
    
	public ClearMenuItem(CurrentSlot currentSlot, Sheet sheet) {
		super("Clear");
		this.sheet = sheet;
		this.currentSlot = currentSlot;
		addActionListener(this);
	}

    @Override
	public void actionPerformed(ActionEvent e) {
        sheet.removeSlot(currentSlot.getAddress());
    }
}