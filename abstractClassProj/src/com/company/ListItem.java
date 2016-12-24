package com.company;

/**
 * Created by Alex on 12/15/16.
 */
public abstract class ListItem {
    protected ListItem rightLink = null;
    protected ListItem leftLink = null;

    // access from concrete subclass

    protected Object value;
    // cannot instantiate an abstract class directly
    // we must extend a differnt class with the new class.
    public ListItem(Object value) {
        this.value = value;
    }

    abstract ListItem next();
    abstract ListItem setNext(ListItem item);
    abstract ListItem previous();
    abstract ListItem setPrevious(ListItem item);

    abstract int compareTo(ListItem item);

    public Object getValue(){
        return value;
    }

    public void setValue(Object value){
        this.value = value;

    }
}
