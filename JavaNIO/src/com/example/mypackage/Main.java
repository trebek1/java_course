package com.example.mypackage;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	// create channel to read and write from file
        // create channel from open file
        try{
//            FileInputStream file = new FileInputStream("data.txt");
//            FileChannel channel = file.getChannel();
            // only open to reading
            // creating with FileInputStream or FileOutputStream is only one directional channel
            // usually channels can do both
            // must specify size of buffer to be used with channel
            //java 8 made it easier to use Files class was introduced in java 7
            // read whole file in one shot --> Java 8 specific

            Path dataPath = FileSystems.getDefault().getPath("data.txt");
            // each call to files.write opens file, writes and closes file
            // use stringbuilder to do several lines in one write
            // writes bytes not strings

            Files.write(dataPath, "\nLine 4".getBytes("UTF-8"), StandardOpenOption.APPEND);


            List<String> lines = Files.readAllLines(dataPath);
            for(String line : lines){
                System.out.println(line);
            }

        }catch(IOException e ){
            e.printStackTrace();
        }
    }
}
