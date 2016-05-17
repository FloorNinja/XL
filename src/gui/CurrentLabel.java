package gui;

import java.awt.Color;
import java.util.Observable;
import java.util.Observer;


public class CurrentLabel extends ColoredLabel implements Observer {
	private CurrentSlot currentSlot;
	
    public CurrentLabel(CurrentSlot currentSlot) {
        super("A1", Color.WHITE);
        this.currentSlot = currentSlot;
        currentSlot.addObserver(this);
    }
    
	@Override
	public void update(Observable o, Object arg) {
		setText(currentSlot.getAddress());
	}
}