package com.gmail.nschoenbrot.dsa.types;

/**
 * An array list.
 *
 * @author Nelson Schoenbrot
 */
public class ArrayList<T> {
    final private Object[] array = new Object[30];
    private int tail = 0;

    public void append(T value) {
        array[tail++] = value;
    }

    @SafeVarargs
    public final void append(T... values) {
        for (final T value : values)
            append(value);
    }

    public String listToString() {
        final StringBuilder csv = new StringBuilder();
        for (final Object element : array) {
            if (element == null) break;
            if (csv.length() == 0)
                csv.append(element);
            else
                csv.append(", ").append(element);
        }
        return csv.toString();
    }
}
