package gui;

import static java.awt.BorderLayout.CENTER;
import static java.awt.BorderLayout.WEST;

import model.Sheet;

public class SheetPanel extends BorderPanel {
    public SheetPanel(int rows, int columns, CurrentSlot currentSlot, Sheet sheet) {
        add(WEST, new RowLabels(rows));
        add(CENTER, new SlotLabels(rows, columns, currentSlot, sheet));
    }
}