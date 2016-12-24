package com.company;

/**
 * Created by Alex on 12/15/16.
 */
public class MyLinkedList implements NodeList{

    private ListItem root = null;

    public MyLinkedList(ListItem root) {
        this.root = root;
    }

    @Override
    public ListItem getRoot() {
        return this.root;
    }

    @Override
    public boolean addItem(ListItem item) {
        if(this.root == null){
            // root empty, set head
            this.root = item;
            return true;
        }

        ListItem currentItem = item;
        while(currentItem != null){
            int comparison = (currentItem.compareTo(item));

            if(comparison<0){
                // move right
                if(currentItem.next() != null){
                    currentItem = currentItem.next();
                }else{
                    // no next so insert at end of list
                    currentItem.setNext(item);
                    item.setPrevious(currentItem);
                    return true;
                }
            }else if(comparison > 0){
                // newitem is less so insert before
                if(currentItem.previous() != null){
                    currentItem.previous().setNext(item);
                    item.setPrevious(currentItem.previous());
                    item.setNext(currentItem);
                    currentItem.setPrevious(item);
                }else{
                    item.setNext(this.root);
                    this.root.setPrevious(item);
                    this.root = item;
                }
                return true;
            }else{
                System.out.println("already here ");
                return false;
            }
        }
        return false;
    }

    @Override
    public boolean removeItem(ListItem item) {
        return false;
    }

    @Override
    public void traverse(ListItem root) {

    }
}
