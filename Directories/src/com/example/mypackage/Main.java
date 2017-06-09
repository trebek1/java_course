package com.example.mypackage;

import java.io.IOException;
import java.nio.file.*;

public class Main {

    public static void main(String[] args) {

//    DirectoryStream.Filter<Path> filter =
//            new DirectoryStream.Filter<Path>(){
//                public boolean accept(Path path) throws IOException {
//                    return (Files.isRegularFile(path));
//                }
//            };
        // with filter no directories are showing

    DirectoryStream.Filter<Path> filter = p -> Files.isRegularFile(p);
    // lambda expression of above   



	Path directory = FileSystems.getDefault().getPath("FileTree/Dir2");

	try(DirectoryStream<Path> contents = Files.newDirectoryStream(directory, filter)){
	    // only one file now matches both criteria in contents
	    for(Path file: contents){
            System.out.println(file.getFileName());
            // only prints direct descendants
        }

    }catch(IOException|DirectoryIteratorException e){
	    // put both catch statements on one line
        // globs :
        // * match any string
        // *.dat any path with .dat extention
        // *.{dat,txt} any path with ext .dat or .txt
        // ? matches 1 character
        // ??? matches 3 characters
        // b?*.txt -> any paths at least 2 chars that begin with b

        System.out.println(e.getMessage());
    }

    }
}
