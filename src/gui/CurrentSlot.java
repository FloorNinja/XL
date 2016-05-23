package gui;

import java.awt.Color;
import java.util.Observable;


public class CurrentSlot extends Observable {
	private SlotLabel currentSlot;

	/**
	 * Sets the currently selected slot, and notifies the observing classes.
	 * @param currentSlot
	 */
	public void set(SlotLabel currentSlot) { //TODO: if(currentSlot != null) reset();
		this.currentSlot = currentSlot;
		currentSlot.setBackground(Color.YELLOW);
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
	public void reset() {
		currentSlot.setBackground(Color.WHITE);
	}
}
