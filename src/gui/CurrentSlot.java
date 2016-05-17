package gui;

import java.awt.Color;
import java.util.Observable;


public class CurrentSlot extends Observable {
	SlotLabel currentSlot;
	
	/**
	 * Sets the currently selected slot, and notifies the observing classes.
	 * @param currentSlot
	 */
	public void set(SlotLabel currentSlot) {
		this.currentSlot = currentSlot;
		setChanged();
		notifyObservers();
	}
	
	/**
	 * Returns the address of the currently selected slot.
	 * @return String address
	 */
	public String getAddress() {
		return currentSlot.getAddress();
	}
	
	/**
	 * Set the background to white again.
	 */
	public void setWhite() {
		currentSlot.setBackground(Color.WHITE);
	}
}
