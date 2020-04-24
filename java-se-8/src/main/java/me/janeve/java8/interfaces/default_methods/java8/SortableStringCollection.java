package me.janeve.java8.interfaces.default_methods.java8;

import java.util.ArrayList;
import java.util.List;

public class SortableStringCollection implements Sortable<String> {

    private List<String> items = new ArrayList<>();

    public void add(String item) {
        items.add(item);
    }

    @Override
    public void sort() {
        items.sort(new ObjectComparator());
    }

    @Override
    public String peek() {
        return items.get(0);
    }
}