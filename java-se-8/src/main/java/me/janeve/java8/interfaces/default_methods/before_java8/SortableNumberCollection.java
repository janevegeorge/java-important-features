package me.janeve.java8.interfaces.default_methods.before_java8;

import java.util.ArrayList;
import java.util.List;

public class SortableNumberCollection implements Sortable<Integer> {

    private List<Integer> items = new ArrayList<>();

    public void add(Integer item) {
        items.add(item);
    }

    @Override
    public void sort() {
        items.sort(new ObjectComparator());
    }

    @Override
    public Integer peek() {
        return items.get(0);
    }

    // New method added.
    @Override
    public Integer sortAndPeek() {
        sort();
        return peek();
    }
}
