package com.example.mypackage;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {

    public static void main(String[] args) {

        try{
            //FileSystems.getDefault returns user.dir 
            Path sourceFile = FileSystems.getDefault().getPath("Examples", "File1.txt");
            Path copyFile = FileSystems.getDefault().getPath("Examples", "file1copy.txt");
            Files.copy(sourceFile, copyFile);

        }catch(IOException e){
            e.printStackTrace();
        }




//	// java.nio.file package has methods to work with filesystem
//    // root node --> to file
//        // relative and absolute paths
//        //Path dataPath = FileSystems.getDefault().getPath("data.txt");
//        //FileSystems.getDefault() // finds the current directory then "data.txt" is a relative path
//        // project directory is default
//        // here is an absolute ref
//        //Path dataPath = Paths.get("absolute path");
//
//        Path path = FileSystems.getDefault().getPath("WorkingDirectoryFile.txt");
//        printFile(path);
//
//        //Path path2 = FileSystems.getDefault().getPath("files/SubdirectoryFile.txt");
//        Path path2 = Paths.get(".","files", "SubdirectoryFile.txt");
//        // current, subfolder, filename if using Paths.get
//
//        printFile(path2);
//
//        Path path3 = FileSystems.getDefault().getPath("../OutThere.txt");
//        printFile(path3);
//
//        // absolute path example
//        Path path4 = Paths.get("/Users/Merlin/code/java_course/OutThere.txt");
//        printFile(path4);
//
//        path4 = Paths.get(".");
//        System.out.println(path4.toAbsolutePath());
//
//        // path interface vs file class
//        // many methods in path do not throw exceptions
//        // delete returns a boolean!
//
//        //File.rename works differently on different platforms
//        // no support for symbolic links in file
//
//        // file class does not provide a way to get metadata
//        // like permissions and owner
//        // many dont perform well with lots of files (lots of files in directory)
//
//        // How does Java NIO solve these problems?
//        // How does it split functionality
//
//        //file operations are moved to file.files class
//        // files class has copy move and delete
//        // static methods so dont need instance of class to call them
//        // path does not know anything about file system itself, just paths
//
//        // create path to file that doesnt exist
//        Path path5 = FileSystems.getDefault().getPath("thisfiledoesntexist.txt");
//        System.out.println(path5.toAbsolutePath());
//        // file is abstract
//        // exception is not thrown until try to use the file with a buffer
//
//        // to create a file must use valid path
//
//        Path path6 = Paths.get("argaf/agrga/aegare/aerg");
//        System.out.println(path6.toAbsolutePath());
//
//        // check path exists
//        path6 = FileSystems.getDefault().getPath("files");
//        System.out.println("Exists "+ Files.exists(path6));
//
//        // fake path does not exist
//        path6 = Paths.get("argaf/agrga/aegare/aerg");
//        System.out.println("Exists "+ Files.exists(path6));
//
//        // overloaded method has 2nd param for handling symbolic links
//        //Files.notExist returns true if does not exist
//
//        //Files.isWritable, isReadable, isModifiable methods to see if have permission
//
//
//
//    }
//
//    private static void printFile(Path path){
//        try(BufferedReader fileReader = Files.newBufferedReader(path)){
//                String line;
//                while((line = fileReader.readLine())!= null){
//                    System.out.println(line);
//                }
//        }catch(IOException e){
//            e.printStackTrace();
//        }
    }
}
