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
	
	public Sheet() {
		sheet = new HashMap<String, Slot>();
		slotFactory = new SlotFactory();
	}
	
	@Override
	public double value(String address) {
		Slot slot = sheet.get(address);
		if (slot == null) {
			throw new XLException("Slot with address: " + address + " is empty");
			
		}
		return slot.getValue(this);
	}
	
	public String slotStringValue(String name){
		Slot slot = sheet.get(name);
		if(slot == null){
			return "";
		}
		return slot.stringValue(this);
	}
	
	public String slotExpression (String name){
		Slot slot = sheet.get(name);
		if(slot == null){
			return "";
		}
		return slot.toString();
	}
	
	public void putSlot(String address, String s) {
		Slot slot = slotFactory.buildSlot(s);
		checkRecursion(address, slot);
		sheet.put(address, slot);
		update();
	}
	
	private void checkRecursion(String address, Slot slot) {
		Slot oldSlot = sheet.get(address);
		RecursionSlot recursionSlot = new RecursionSlot();
		sheet.put(address, recursionSlot);
		try {
			slot.getValue(this);
		} finally {
			sheet.put(address, oldSlot);
		}
	}
	
	public Slot getSlot(String address) {
		return sheet.get(address);
	}
	
	public void removeSlot(String address) {
		sheet.remove(address);
		update();
	}
	
	public void load(HashMap<String, Slot> sheet) {
		this.sheet = sheet;
		update();
	}
	
	public void clearSheet() {
		sheet.clear();
		update();
	}
	
	public Set<Entry<String, Slot>> getEntries() {
		return sheet.entrySet();
	}
	
	private void update() {
		setChanged();
		notifyObservers();
	}

}
