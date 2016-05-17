package gui.menu;

import javax.swing.JMenu;
import javax.swing.JMenuBar;

import gui.CurrentSlot;
import gui.StatusLabel;
import gui.XL;
import gui.XLList;
import model.Sheet;

public class XLMenuBar extends JMenuBar {
    public XLMenuBar(XL xl, XLList xlList, StatusLabel statusLabel, CurrentSlot c, Sheet s) {
        JMenu file = new JMenu("File");
        JMenu edit = new JMenu("Edit");
        file.add(new PrintMenuItem(xl, statusLabel));
        file.add(new SaveMenuItem(xl, statusLabel));
        file.add(new LoadMenuItem(xl, statusLabel));
        file.add(new NewMenuItem(xl));
        file.add(new CloseMenuItem(xl, xlList));
        edit.add(new ClearMenuItem(c, s));
        edit.add(new ClearAllMenuItem(s));
        add(file);
        add(edit);
        add(new WindowMenu(xlList));
    }
}