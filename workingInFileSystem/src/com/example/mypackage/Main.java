package com.example.mypackage;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {

    public static void main(String[] args) {
	// java.nio.file package has methods to work with filesystem
    // root node --> to file
        // relative and absolute paths
        //Path dataPath = FileSystems.getDefault().getPath("data.txt");
        //FileSystems.getDefault() // finds the current directory then "data.txt" is a relative path
        // project directory is default
        // here is an absolute ref
        //Path dataPath = Paths.get("absolute path");

        Path path = FileSystems.getDefault().getPath("WorkingDirectoryFile.txt");
        printFile(path);

        Path path2 = FileSystems.getDefault().getPath("files/SubdirectoryFile.txt");
        printFile(path2);

        Path path3 = FileSystems.getDefault().getPath("../OutThere.txt");
        printFile(path3);

    }

    private static void printFile(Path path){
        try(BufferedReader fileReader = Files.newBufferedReader(path)){
                String line;
                while((line = fileReader.readLine())!= null){
                    System.out.println(line);
                }
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
