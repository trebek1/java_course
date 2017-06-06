package com.example.mypackage;


import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    // Random Access file class
    // dont want to store locations in memory bc they take up too much room
    // read location from file when player gets there
    // read in random fashion
    // read from sqlite database --> use flat file in example

    // file pointer
    // offset where next read or write will start from in file
    // at 100, start at 100, reading int 100 to 103 would be read since int is 4 bytes

    // each set of related data is called a record

    // need formula for index
    // startByte = (n-1) * 30 --> each location fixed length --> need index in file since we dont have fixed length

    // get index record
    // use data
    // need index identifier (id + offset + record length )

    // load whole index into memory when app starts or find it on call
    // better perf to load whole index
    // index record usually smaller than data record

    // if index starts at zero then we need to add to offset for index

    // our example
    // 1. first 4 bytes will contain number of locations (0 -> 3)
    // 2. The next 4 bytes will contain the start offset of the locations section (bytes 4 -7)
    // 3. 3. The next section of the file will contain the index (index is 1692 bytes long) byte 8 - 1699
    // 4. final section will contain data for game (start at 1700)






    private static Locations locations = new Locations();

    public static void main(String[] args) throws IOException {
        // Change the program to allow players to type full words, or phrases, then move to the
        // correct location based upon their input.
        // The player should be able to type commands such as "Go West", "run South", or just "East"
        // and the program will move to the appropriate location if there is one.  As at present, an
        // attempt to move in an invalid direction should print a message and remain in the same place.
        //
        // Single letter commands (N, W, S, E, Q) should still be available.

        Scanner scanner = new Scanner(System.in);

        Map<String, String> vocabulary = new HashMap<String, String>();
        vocabulary.put("QUIT", "Q");
        vocabulary.put("NORTH", "N");
        vocabulary.put("SOUTH", "S");
        vocabulary.put("WEST", "W");
        vocabulary.put("EAST", "E");


        int loc = 64;

        Location currentLocation = locations.getLocation(1);



        while(true) {
            System.out.println(currentLocation.getDescription());

            if(currentLocation.getLocationID() == 0) {
                break;
            }

            Map<String, Integer> exits = currentLocation.getExits();
            System.out.print("Available exits are ");
            for(String exit: exits.keySet()) {
                System.out.print(exit + ", ");
            }
            System.out.println();

            String direction = scanner.nextLine().toUpperCase();
            if(direction.length() > 1) {
                String[] words = direction.split(" ");
                for(String word: words) {
                    if(vocabulary.containsKey(word)) {
                        direction = vocabulary.get(word);
                        break;
                    }
                }
            }

            if(exits.containsKey(direction)) {
                currentLocation = locations.getLocation(currentLocation.getExits().get(direction));

            } else {
                System.out.println("You cannot go in that direction");
            }
        }
        locations.close();
    }
}
