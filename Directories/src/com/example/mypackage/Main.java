package com.example.mypackage;

import java.io.File;
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



	//Path directory = FileSystems.getDefault().getPath("FileTree/Dir2");
        Path directory = FileSystems.getDefault().getPath("FileTree" + File.separator + "Dir2");
        // this is how to do separator

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

    String separator = File.separator;
        System.out.println(separator);
        separator = FileSystems.getDefault().getSeparator();
        System.out.println(separator);
        // never hard code separator bc dont know if
        // user will be windows or unix/linux

        // How do you create temporary files

        try{
            Path tempFile = Files.createTempFile("myapp", ".appext");
            System.out.println( "Temp file path = " + tempFile.toAbsolutePath());
        }catch(IOException e ){
            System.out.println(e.getMessage());
        }

        // get file stores
        Iterable<FileStore> stores = FileSystems.getDefault().getFileStores();
        for(FileStore store : stores){
            System.out.println("Volume name/ Drive letter " + store);
            System.out.println(store.name());
        }

        System.out.println("***************");
        Iterable<Path> rootPaths = FileSystems.getDefault().getRootDirectories();
        for(Path path : rootPaths){
            System.out.println(path);
        }

        //How do you print out a file tree?
        // FileVisitor interface
        // preVisitDirectory()
        // postVisitDirectory()
        // if exception is called and not handled,
        // ends prematurely and postVisit is called

        // visitFile - accepts ref to file and basicFileAttributes instance
        // visitFileFailed
        // error passed to this method (files and dirs)
        // simpleFileVisitor


        System.out.println("Walking the tree for Dir2");
        Path dir2Path = FileSystems.getDefault().getPath("FileTree" + File.separator + "Dir2");

        try{
            Files.walkFileTree(dir2Path, new PrintNames());
        }catch(IOException  e){
            System.out.println(e.getMessage());
        }

        //preVisitDirectory --> copy a file tree (handle root before its sibs so that it exists)
        //postVisitDirectory --> delete a node, delete descendants before delete directory

        System.out.println("--- Copy Dir2 to Dir4/Dir2Copy---");
        Path copyPath = FileSystems.getDefault().getPath("FileTree" + File.separator + "Dir4" + File.separator + "Dir2Copy");
        //FileTree/Dir4/Dir2Copy

        try{
            Files.walkFileTree(dir2Path, new CopyFiles(dir2Path, copyPath));
        }catch(IOException e){
            System.out.println( e.getMessage());
        }
     }
}
