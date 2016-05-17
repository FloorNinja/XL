package gui.menu;

import java.io.FileNotFoundException;
import java.util.HashMap;

import javax.swing.JFileChooser;

import gui.StatusLabel;
import gui.XL;
import io.XLBufferedReader;
import model.Slot;
import util.XLException;

class LoadMenuItem extends OpenMenuItem {

	public LoadMenuItem(XL xl, StatusLabel statusLabel) {
		super(xl, statusLabel, "Load");
	}

	@Override
	protected void action(String path) throws FileNotFoundException {
		try {
			statusLabel.clear();
			XLBufferedReader reader = new XLBufferedReader(path);
			HashMap<String, Slot> map = new HashMap<String, Slot>();
			reader.load(map);
			xl.setData(map);
		} catch (XLException e) {
			statusLabel.setText("Cannot load file: "+e.getMessage());
		}

	}

	@Override
	protected int openDialog(JFileChooser fileChooser) {
		return fileChooser.showOpenDialog(xl);
	}
}