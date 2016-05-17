package gui;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Observable;
import java.util.Observer;

public class SlotLabel extends ColoredLabel implements Observer, MouseListener {
	private String address;
	private CurrentSlot currentSlot;
	
    public SlotLabel(String address, CurrentSlot currentSlot) {
        super("                    ", Color.WHITE, RIGHT);
        this.address = address;
        this.currentSlot = currentSlot;
        addMouseListener(this);
    }
    
    /**
     * Returns the address for a specific slot.
     * @return String address
     */
    public String getAddress() {
    	return address;
    }
    
    @Override
	public void mousePressed(MouseEvent e) {
    	/* When we change the currently selected slot
    	 * we want to reset the background to white. */
		currentSlot.setWhite();
		setBackground(Color.YELLOW);
		currentSlot.set(this);
	}
    
    @Override
	public void update(Observable o, Object arg) {
    	
	}
    
    
    /* The following methods aren't defined for obvious reasons,
     * although this isn't advised there's nothing to do about it... */
	@Override
	public void mouseClicked(MouseEvent e) {}

	@Override
	public void mouseEntered(MouseEvent e) {}

	@Override
	public void mouseExited(MouseEvent e) {}
	
	@Override
	public void mouseReleased(MouseEvent e) {}
}