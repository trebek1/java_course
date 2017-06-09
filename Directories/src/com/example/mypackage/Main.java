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
            System.out.println(e.getMessage());
        }


        // Map Java.IO to Jva.NIO

        //Mapping one to the other (File --> Path)

        File file = new File("/Examples/file.txt"); // Java IO
        Path convertedPath = file.toPath(); // java NIO
        System.out.println("convrted path is " + convertedPath);

        File parent = new File("/Examples");
        File resolvedFile = new File(parent,"dir/file.txt");
        System.out.println(resolvedFile.toPath());

        resolvedFile = new File("/Examples", "dir/file.txt"); // IO
        System.out.println(resolvedFile.toPath()); // NIO

        Path parentPath = Paths.get("/Examples");
        Path childRelativePath = Paths.get("dir/file.txt");
        System.out.println(parentPath.resolve(childRelativePath));

        // java IO needs file instances
        // NIO usually doesnt

        File workingDirectory = new File("").getAbsoluteFile(); // IO
        System.out.println("wd = " + workingDirectory.getAbsolutePath()); // NIO

        // way you list contents of directory

        // IO File.list
        // NIO Stream

        System.out.println(" ---- print dir2 contents using list ----");
        //only returns first level
        File dir2File = new File(workingDirectory, "/FileTree/Dir2");
        String[] dir2Contents = dir2File.list();
        for(int i = 0; i<dir2Contents.length; i++){
            System.out.println("i= "+ i + ": " + dir2Contents[i]);
        }

        System.out.println("---Print dir2 contents using listFiles ---");
        File[] dir2Files = dir2File.listFiles();
        for(int i = 0; i<dir2Files.length; i++){
            System.out.println("i= " + i + ": " + dir2Files[i].getName());
        }
        //NIO with file system
        //IO still better with reading and writing file contents
     }
}
