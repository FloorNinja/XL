package gui.menu;

import gui.StatusLabel;
import gui.XL;
import io.XLPrintStream;

import java.io.FileNotFoundException;
import javax.swing.JFileChooser;

class SaveMenuItem extends OpenMenuItem {
    public SaveMenuItem(XL xl, StatusLabel statusLabel) {
        super(xl, statusLabel, "Save");
    }
    
    /* here we have to open the file specified by "path" and
     * then write all the slots to it as specified in the assignment.
     * use XLPrintStream for writing.
     */
    protected void action(String path) throws FileNotFoundException {
    	XLPrintStream print = new XLPrintStream(path);
    	print.save(xl.getData());
    }

    protected int openDialog(JFileChooser fileChooser) {
        return fileChooser.showSaveDialog(xl);
    }
}