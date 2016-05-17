package gui;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;

public class XLList extends Observable implements Iterable<XL> {
    private List<XL> list = new ArrayList<XL>();

    public void add(XL xl) {
        list.add(xl);
        this.setChanged();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public Iterator<XL> iterator() {
        return list.iterator();
    }

    public XL last() {
        return list.get(list.size() - 1);
    }

    public void remove(XL xl) {
        list.remove(xl);
        this.setChanged();
    }

    public void setChanged() {
        super.setChanged();
        notifyObservers();
    }
}