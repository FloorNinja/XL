package gui;

import java.awt.Color;

public class StatusLabel extends ColoredLabel {
    public StatusLabel() {
        super("", Color.WHITE);
    }
    
    public void clear() {
		setText("");
	}
}