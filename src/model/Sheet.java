package model;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Observable;
import java.util.Set;

import expr.Environment;
import util.XLException;

public class Sheet extends Observable implements Environment {

	private Map<String, Slot> sheet;
	private SlotFactory slotFactory;
	
	/**
	 * Constructor
	 */
	public Sheet() {
		sheet = new HashMap<String, Slot>();
		slotFactory = new SlotFactory();
	}
	
	/**
	 * Returns the value of the slot as type double. If the slot is null, throws XLException.
	 */
	@Override
	public double value(String address) {
		Slot slot = sheet.get(address);
		if (slot != null) {
			return slot.getValue(this);
		}
		throw new XLException("Slot with address: " + address + " is empty");
	}
	
	/**
	 * Returns the value of the slot as type double. If the slot is null, returns empty String as "";
	 * @param address
	 * @return String
	 */
	public String slotStringValue(String address){
		Slot slot = sheet.get(address);
		if(slot != null){
			return slot.stringValue(this);
		}
		return "";
	}
	
	/**
	 * Returns the expression of the slot as type double. If the slot is null, returns empty String as "".
	 * @param address
	 * @return String
	 */
	public String slotExpression(String address){
		Slot slot = sheet.get(address);
		if(slot != null){
			return slot.toString();
		}
		return "";
	}
	
	/**
	 * Creates a slot with specified content in the specified address.
	 * @param address the slots address in the sheet.
	 * @param s the slots content.
	 */
	public void putSlot(String address, String s) {
		Slot slot = slotFactory.buildSlot(s);
		checkRecursion(address, slot);
		sheet.put(address, slot);
		update();
	}
	
	/**
	 * Check for circular dependency. If there is a circular dependency, change the slot to a RecursionSlot.
	 * @param address the slots address in the sheet.
	 * @param slot the created slot.
	 */
	private void checkRecursion(String address, Slot slot) {
		Slot oldSlot = sheet.get(address);
		sheet.put(address, new RecursionSlot());
		try {
			slot.getValue(this);
		} finally {
			sheet.put(address, oldSlot);
		}
	}
	
	/**
	 * Returns the slot with the specified address.
	 * @param address
	 * @return Slot
	 */
	public Slot getSlot(String address) {
		return sheet.get(address);
	}
	
	/**
	 * Removes the slot with the specified address.
	 * @param address
	 */
	public void removeSlot(String address) {
		Slot tempSlot = sheet.get(address);
		RecursionSlot recSlot = new RecursionSlot();
		sheet.put(address, recSlot);
		try {
			for(Slot slot : sheet.values()) {
				if(slot != recSlot) {
					slot.getValue(this);
				}
			}
			sheet.remove(address);
		} catch (XLException e) {
			sheet.put(address, tempSlot);
		}
		update();
	}
	
	/**
	 * Load a Sheet with new values from another HashMap.
	 * @param sheet
	 */
	public void load(HashMap<String, Slot> newSheet) {
		Map<String, Slot> oldSheet = sheet;
		sheet = newSheet;
		try {
			for(Entry<String, Slot> e: sheet.entrySet()) {
				checkRecursion(e.getKey(), e.getValue());
			}
		} catch (XLException e) {
			sheet = oldSheet;
		}
		
		update();
	}
	
	/**
	 * Empties all the slots in the sheet.
	 */
	public void clearSheet() {
		sheet.clear();
		update();
	}
	
	/**
	 * Returns a set with all the entries in the sheet.
	 * @return
	 */
	public Set<Entry<String, Slot>> getEntries() {
		return sheet.entrySet();
	}
	
	/**
	 * Set that something has changed and notify all the observers.
	 */
	private void update() {
		setChanged();
		notifyObservers();
	}

}
