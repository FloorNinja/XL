package io;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Map;

import model.Slot;
import model.SlotFactory;
import util.XLException;

public class XLBufferedReader extends BufferedReader {
	private SlotFactory sf;
	
    public XLBufferedReader(String fileName) throws FileNotFoundException {
        super(new FileReader(fileName));
        sf = new SlotFactory();
    }

    public void load(Map<String, Slot> sheet) {
        try {
            while (ready()) {
                String line = readLine();
                String[] tokens = line.split("=");
                String name = tokens[0];
                String content = tokens[1];
                sheet.put(name, sf.buildSlot(content));
            }
        } catch (Exception e) {
            throw new XLException(e.getMessage());
        }
    }
}