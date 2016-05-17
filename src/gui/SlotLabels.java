package gui;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import javax.swing.SwingConstants;

import model.Sheet;

public class SlotLabels extends GridPanel {
    private List<SlotLabel> labelList;
    private CurrentSlot currentSlot;
    private Sheet sheet;

    public SlotLabels(int rows, int cols, CurrentSlot currentSlot, Sheet sheet) {
        super(rows + 1, cols);
        labelList = new ArrayList<SlotLabel>(rows * cols);
        this.currentSlot = currentSlot;
        this.sheet = sheet;
        
        
        for (char ch = 'A'; ch < 'A' + cols; ch++) {
            add(new ColoredLabel(Character.toString(ch), Color.LIGHT_GRAY,
                    SwingConstants.CENTER));
        }
        for (int row = 1; row <= rows; row++) {
            for (char ch = 'A'; ch < 'A' + cols; ch++) {
            	
            	//Get address for each column
            	StringBuilder sb = new StringBuilder();
            	sb.append(ch);
            	sb.append(row);
            	String address = sb.toString();
            	
                SlotLabel label = new SlotLabel(address, currentSlot, sheet);
                add(label);
                labelList.add(label);
            }
        }
        SlotLabel firstLabel = labelList.get(0);
        currentSlot.set(firstLabel);
        firstLabel.setBackground(Color.YELLOW);
    }
}
