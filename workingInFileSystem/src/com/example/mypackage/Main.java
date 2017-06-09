package com.example.mypackage;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;

public class Main {

    public static void main(String[] args) {

        try{
            //FileSystems.getDefault returns user.dir
//            Path sourceFile = FileSystems.getDefault().getPath("Examples", "File1.txt");
//            Path copyFile = FileSystems.getDefault().getPath("Examples", "file1copy.txt");
//            Files.copy(sourceFile, copyFile, StandardCopyOption.REPLACE_EXISTING);
//            // StandardCopyOption keeps error from being thrown
//
//            sourceFile = FileSystems.getDefault().getPath("Examples", "Dir1");
//            copyFile = FileSystems.getDefault().getPath("Examples", "Dir4");
//            // only copies whole folder, not the files inside
//            Files.copy(sourceFile, copyFile);

//            Path fileToMove = FileSystems.getDefault().getPath("Examples", "file1copy.txt");
//            Path destination = FileSystems.getDefault().getPath("Examples", "Dir1", "file1copy.txt");
//            // have to specify whole destination including the filename in destination
//
//            Files.move(fileToMove, destination);

            // Renaming a file in the file system
//            Path fileToMove = FileSystems.getDefault().getPath("Examples", "File1.txt");
//            Path destination = FileSystems.getDefault().getPath("Examples", "starcraft.txt");
//            Files.move(fileToMove, destination);

            //Delete a file

//            Path fileToDelete = FileSystems.getDefault().getPath("Examples", "Dir1", "file1copy.txt");
//            Files.delete(fileToDelete);
            //can use deleteIfExists to keep errors from coming up


            // creating files without a channel

//            Path fileToCreate = FileSystems.getDefault().getPath("Examples", "file2.txt");
//            Files.createFile(fileToCreate);
            // would need to create a stream or channel to write to it
            // cant use this createFile to create directory

//            Path dirToCreate = FileSystems.getDefault().getPath("Examples", "Dir4");
//            Files.createDirectory(dirToCreate);

            //Creates a whole path of directories if they dont exist yet
//            Path dirToCreate = FileSystems.getDefault().getPath("Examples", "Dir2/Dir3/Dir4/Dir5/Dir6");
//            Files.createDirectories(dirToCreate);

            // could also do...
//            Path dirToCreate = FileSystems.getDefault().getPath("Examples/Dir2/Dir3/Dir4/Dir5/Dir6/Dir7");
//            Files.createDirectory(dirToCreate);

            // how do you get file metadata
            // can get single attribute or all attributes at once

            // single
            Path filePath = FileSystems.getDefault().getPath("Examples", "Dir1/file1.txt");
            // size of file
            long size = Files.size(filePath);
            System.out.println("Size is equal to " + size);
            System.out.println("last modified equals "+ Files.getLastModifiedTime(filePath));
            // rest of methods in documentation

            // get all attributes in one single call
            // common to all OS

            BasicFileAttributes attrs = Files.readAttributes(filePath, BasicFileAttributes.class);

            //attrs is an instance that is returned with basic file attributes
            System.out.println("Size = " + attrs.size());
            System.out.println("last mod " + attrs.lastModifiedTime());
            System.out.println("Created " + attrs.creationTime());








        }catch(IOException e){
            System.out.println(e.getMessage());

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
