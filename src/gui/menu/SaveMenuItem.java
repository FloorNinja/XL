package gui.menu;

import java.io.FileNotFoundException;

import javax.swing.JFileChooser;

import gui.StatusLabel;
import gui.XL;
import io.XLPrintStream;

class SaveMenuItem extends OpenMenuItem {
    public SaveMenuItem(XL xl, StatusLabel statusLabel) {
        super(xl, statusLabel, "Save");
    }

    @Override
	protected void action(String path) throws FileNotFoundException {
    	XLPrintStream print = new XLPrintStream(path);
    	print.save(xl.getData());
    }

    @Override
	protected int openDialog(JFileChooser fileChooser) {
        return fileChooser.showSaveDialog(xl);
    }
}