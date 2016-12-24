package com.company;

/**
 * Created by Alex on 12/15/16.
 */
public interface NodeList {
    ListItem getRoot();
    boolean addItem(ListItem item);
    boolean removeItem(ListItem item);
    void traverse(ListItem root);
}
