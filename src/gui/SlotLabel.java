package gui;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Observable;
import java.util.Observer;

import model.Sheet;

public class SlotLabel extends ColoredLabel {
	private String address;
	private CurrentSlot currentSlot;
	
    public SlotLabel(String address, CurrentSlot currentSlot) {
        super("                    ", Color.WHITE, RIGHT);
        this.address = address;
        this.currentSlot = currentSlot;
        
        addMouseListener(new MouseActionListener(this));
    }
    
    /**
     * Returns the address for a specific slot.
     * @return String address
     */
    public String getAddress() {
    	return address;
    }
    
    private class MouseActionListener extends MouseAdapter {
    	SlotLabel slot;
    	
    	public MouseActionListener(SlotLabel slot) {
			super();
			this.slot = slot;
		}
    	
    	@Override
    	public void mousePressed(MouseEvent e) {//TODO: Remove reset(); later...?
    		currentSlot.reset();
    		currentSlot.set(slot);
    	}
    }
}