package com.example.mypackage;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Alex on 5/8/17.
 */
public class Location {
    private final int locationID;
    private final String description;
    private final Map<String, Integer> exits;

    public Location(int locationID, String description, Map<String, Integer> exits) {
        this.locationID = locationID;
        this.description = description;
        if(exits != null) {
            this.exits = new HashMap<String, Integer>(exits);
        }else{
            this.exits = new HashMap<String, Integer>();    
        }
        this.exits.put("Q", 0);

    }

//    public void addExit(String direction, int location){
//        exits.put(direction, location);
//    }

    public int getLocationID() {
        return locationID;
    }

    public String getDescription() {
        return description;
    }

    public Map<String, Integer> getExits() {
        return new HashMap<String, Integer>(exits);
        // new map created with all the exits mapped
        // getter returns new instance so does not ruin original
    }
}

//    A Strategy for Defining Immutable Objects
//
//        The following rules define a simple strategy for creating immutable objects. Not all classes documented as "immutable" follow these rules. This does not necessarily mean the creators of these classes were sloppy — they may have good reason for believing that instances of their classes never change after construction. However, such strategies require sophisticated analysis and are not for beginners.
//
//        Don't provide "setter" methods — methods that modify fields or objects referred to by fields.
//        Make all fields final and private.
//        Don't allow subclasses to override methods. The simplest way to do this is to declare the class as final. A more sophisticated approach is to make the constructor private and construct instances in factory methods.
//        If the instance fields include references to mutable objects, don't allow those objects to be changed:
//        Don't provide methods that modify the mutable objects.
//        Don't share references to the mutable objects. Never store references to external, mutable objects passed to the constructor; if necessary, create copies, and store references to the copies. Similarly, create copies of your internal mutable objects when necessary to avoid returning the originals in your methods.
//        Applying this strategy to SynchronizedRGB results in the following steps:
//
//        There are two setter methods in this class. The first one, set, arbitrarily transforms the object, and has no place in an immutable version of the class. The second one, invert, can be adapted by having it create a new object instead of modifying the existing one.
//        All fields are already private; they are further qualified as final.
//        The class itself is declared final.
//        Only one field refers to an object, and that object is itself immutable. Therefore, no safeguards against changing the state of "contained" mutable objects are necessary.
