package gui.menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;

import gui.XL;

class WindowMenuItem extends JMenuItem implements ActionListener {
    private XL xl;

    public WindowMenuItem(XL xl) {
        super(xl.getTitle());
        this.xl = xl;
        addActionListener(this);
    }

    @Override
	public void actionPerformed(ActionEvent event) {
        xl.toFront();
    }
}