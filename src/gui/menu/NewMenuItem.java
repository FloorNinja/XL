package gui.menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;

import gui.XL;

class NewMenuItem extends JMenuItem implements ActionListener {
    private XL xl;

    public NewMenuItem(XL xl) {
        super("New");
        this.xl = xl;
        addActionListener(this);
    }

    @Override
	public void actionPerformed(ActionEvent event) {
        new XL(xl);
    }
}