package gui;

import java.awt.Color;
import java.util.Observable;
import java.util.Observer;

public class StatusLabel extends ColoredLabel implements Observer {
    public StatusLabel() {
        super("", Color.WHITE);
    }
    
    //TODO: Use observer-pattern instead of clear()
    public void update(Observable observable, Object object) {
        setText("");
    }
<<<<<<< HEAD
=======
    
>>>>>>> branch 'master' of https://github.com/FloorNinja/XL.git
    public void clear() {
		setText("");
	}
}