package gui;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import javax.swing.SwingConstants;

import model.Sheet;

public class SlotLabels extends GridPanel implements Observer {
    private List<SlotLabel> labelList;
    private CurrentSlot currentSlot;
    private Sheet sheet;

    public SlotLabels(int rows, int cols, CurrentSlot currentSlot, Sheet sheet) {
        super(rows + 1, cols);
        labelList = new ArrayList<SlotLabel>(rows * cols);
        this.currentSlot = currentSlot;
        this.sheet = sheet;
        sheet.addObserver(this);
        
        for (char ch = 'A'; ch < 'A' + cols; ch++) {
            add(new ColoredLabel(Character.toString(ch), Color.LIGHT_GRAY,
                    SwingConstants.CENTER));
        }
        for (int row = 1; row <= rows; row++) {
            for (char ch = 'A'; ch < 'A' + cols; ch++) {
            	
            	//Get address for each column.
            	StringBuilder sb = new StringBuilder();
            	sb.append(ch);
            	sb.append(row);
            	String address = sb.toString();
            	
                SlotLabel label = new SlotLabel(address, currentSlot);
                add(label);
                labelList.add(label);
            }
        }
        SlotLabel firstLabel = labelList.get(0);
        //Set the firstLabel as the currentSlot here.
        currentSlot.set(firstLabel);
    }

	@Override
	public void update(Observable obs, Object arg) {
		
	}
}
