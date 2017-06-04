package com.example.mypackage;

/**
 * Created by Alex on 6/3/17.
 */

import java.io.*;
import java.util.*;

// in order to send objects or classes must make serializable (serialization)
// serializable is an interface with no methods -> tells jvm that we might want to serialize to storage
// declare a long field to store uid (like a version number for class) (compatibility issues or declared as serializable)
// different compiler implementations create diff default uid so declare long above
// make private since no other class should need it
// object is sent as a single unit

public class Locations implements Map<Integer, Location> {
    private static Map<Integer, Location> locations = new LinkedHashMap<Integer, Location>();
    private static Map<Integer, IndexRecord> index = new LinkedHashMap<>();
    private static RandomAccessFile ra;

    public static void main(String[] args) throws IOException {

        try(RandomAccessFile rao = new RandomAccessFile("locations_rand.dat", "rwd")){
            // rwd makes the file open to reads and writes and that they occur asynchronously

            rao.writeInt(locations.size());
            int indexSize = locations.size() * 3 * Integer.BYTES;
            int locationStart = (int)(indexSize + rao.getFilePointer() + Integer.BYTES); // cast to int bc filePointer is a long value
            rao.writeInt(locationStart);
            //since disc access is expensive, write all locations and then write index as a whole
            long indexStart = rao.getFilePointer(); // time to write locations

            int startPointer = locationStart;
            rao.seek(startPointer);

            // buffer is sequential so cant use buffer with random access

            for(Location location : locations.values()){
                rao.writeInt(location.getLocationID());
                rao.writeUTF(location.getDescription());
                StringBuilder builder = new StringBuilder();
                for(String direction : location.getExits().keySet()){
                    if(!direction.equalsIgnoreCase("Q")){
                        builder.append(direction);
                        builder.append(",");
                        builder.append(location.getExits().get(direction));
                        builder.append(",");
                    }
                }
                rao.writeUTF(builder.toString());

                IndexRecord record = new IndexRecord(startPointer, (int) (rao.getFilePointer() - startPointer));
                index.put(location.getLocationID(), record);

                startPointer = (int) rao.getFilePointer();
            }
            //create index
            rao.seek(indexStart);
            for(Integer locationID : index.keySet()){
                rao.writeInt(locationID);
                rao.writeInt(index.get(locationID).getStartByte());
                rao.writeInt(index.get(locationID).getLength());
            }

        }
    }

  static {
        try{
            ra = new RandomAccessFile("locations_rand.dat", "rwd");
            int numLocations = ra.readInt();
            long locationStartPoint = ra.readInt();

            while(ra.getFilePointer() < locationStartPoint){
                int locationId = ra.readInt();
                int locationStart = ra.readInt();
                int locationLength = ra.readInt();

                IndexRecord record = new IndexRecord(locationStart, locationLength);
                index.put(locationId, record);

            }


        }catch(IOException e ){
            System.out.println("IOException " + e.getMessage());
        }

//        try(ObjectInputStream locFile = new ObjectInputStream(new BufferedInputStream(new FileInputStream("locations.dat")))) {
//            boolean eof = false;
//
//            while (!eof) {
//                try {
//                    Location location = (Location) locFile.readObject();
//                    System.out.println("Read location " + location.getLocationID() + " : " + location.getDescription());
//                    System.out.println("Found " + location.getExits().size() + " exits");
//                    locations.put(location.getLocationID(), location);
//                } catch (EOFException e) {
//                    eof = true;
//                }
//            }
//        }catch(IOException e ){
//            System.out.println("IO Exception");
//        }catch(ClassNotFoundException e ){
//            // cant find class that it is looking for
//            System.out.println("Class Not Found exception " + e.getMessage());
//        }
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
