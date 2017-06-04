package com.example.mypackage;

/**
 * Created by Alex on 6/3/17.
 */

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Locations implements Map<Integer, Location> {
    private static Map<Integer, Location> locations = new HashMap<Integer, Location>();

    public static void main(String[] args) throws IOException {
        //FileWriter locFile = null;
        // try creates new scope so need to declare before going into those blocks

        // checked and unchecked exceptions
        // cant ignore checked exceptions
        // ioexception is a checked exception

        // try with resources makes sure that filewriter stream is closed whether operates normally or exception occurs
        // java 7
        // also makes sure first error is the one thrown back up the stream

        // try with resources will close the resource for you after execution is done!
        // do not do this in the finally block

        try(FileWriter locFile = new FileWriter("locations.txt");
        FileWriter dirFile = new FileWriter("directions.txt")){
            for(Location location : locations.values()){
                locFile.write(location.getLocationID() + "," + location.getDescription() + "\n");
                for(String direction : location.getExits().keySet()){
                    dirFile.write(location.getLocationID() + "," + direction + "," + location.getExits().get(direction) + "\n");
                }

                //throw new IOException("test exception thrown while writing");
            }
        }


//        try{
//            locFile = new FileWriter("locations.txt");
//            for(Location location : locations.values()){
//                locFile.write(location.getLocationID() + "," + location.getDescription() + "\n");
//                //throw new IOException("test exception thrown while writing"); test throwing an exception
//            }
//        }
////        catch(IOException e){
////            System.out.println("in catch block");
////            e.printStackTrace();
////        }
//        finally{
//            System.out.println("in finally block");
//            //try{
//
//                if(locFile != null){
//                    locFile.close();
//                }
//            //}
////            catch(IOException e){
////                System.out.println("IOException in closing locfile ");
////                e.printStackTrace();
////            }
//
//        }

    }

    static {
        Scanner scanner = null;

        try{
            scanner = new Scanner(new FileReader("locations.txt"));
            scanner.useDelimiter(",");
            while(scanner.hasNextLine()){
                int loc = scanner.nextInt();
                scanner.skip(scanner.delimiter());
                String description = scanner.nextLine();
                System.out.println("Imported loc " + loc + " : " + description);
                Map<String, Integer> tempExit = new HashMap<>();
                locations.put(loc, new Location(loc,description, tempExit));
            }
        }catch(IOException e){
            e.printStackTrace();
        }finally{
            if(scanner != null){
                scanner.close();
                // closing scanner also closes the stream that it was using as long as
                // the stream implements the closeable interface
                // so FileReader is closed when the scanner is closed 
            }
        }

//        Map<String, Integer> tempExit = new HashMap<String, Integer>();
//        locations.put(0, new Location(0, "You are sitting in front of a computer learning Java",null));
//
//        tempExit = new HashMap<String, Integer>();
//        tempExit.put("W", 2);
//        tempExit.put("E", 3);
//        tempExit.put("S", 4);
//        tempExit.put("N", 5);
//        locations.put(1, new Location(1, "You are standing at the end of a road before a small brick building",tempExit));
//
//        tempExit = new HashMap<String, Integer>();
//        tempExit.put("N", 5);
//        locations.put(2, new Location(2, "You are at the top of a hill",tempExit));
//
//        tempExit = new HashMap<String, Integer>();
//        tempExit.put("W", 1);
//        locations.put(3, new Location(3, "You are inside a building, a well house for a small spring",tempExit));
//
//        tempExit = new HashMap<String, Integer>();
//        tempExit.put("N", 1);
//        tempExit.put("W", 2);
//        locations.put(4, new Location(4, "You are in a valley beside a stream",tempExit));
//
//        tempExit = new HashMap<String, Integer>();
//        tempExit.put("S", 1);
//        tempExit.put("W", 2);
//        locations.put(5, new Location(5, "You are in the forest",tempExit));

    }
    @Override
    public int size() {
        return locations.size();
    }

    @Override
    public boolean isEmpty() {
        return locations.isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        return locations.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return locations.containsValue(value);
    }

    @Override
    public Location get(Object key) {
        return locations.get(key);
    }

    @Override
    public Location put(Integer key, Location value) {
        return locations.put(key, value);
    }

    @Override
    public Location remove(Object key) {
        return locations.remove(key);
    }

    @Override
    public void putAll(Map<? extends Integer, ? extends Location> m) {

    }

    @Override
    public void clear() {
        locations.clear();

    }

    @Override
    public Set<Integer> keySet() {
        return locations.keySet();
    }

    @Override
    public Collection<Location> values() {
        return locations.values();
    }

    @Override
    public Set<Entry<Integer, Location>> entrySet() {
        return locations.entrySet();
    }
}

