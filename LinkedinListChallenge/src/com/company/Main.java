package com.company;

import java.util.*;

public class Main {
    // inherit from class or use interface?
    // can implement from more than one interface, can only extend one class
    // relationship of final class to object extending.
    // dog extends animal, implements walk, bird extends animal but inherits walk and fly


    private static List<Album> albums = new ArrayList<Album>();

    public static void main(String[] args) {

        Album album = new Album("Stormbringer", "Deep Purple");
        album.addSong("Stormbringer", "4,6");
        album.addSong("Paper Wings", "3,2");
        album.addSong("lightning", "3,5");

        albums.add(album);

        album = new Album("Hybrid Theory", "Linkin Park");
        album.addSong("PaperCut", "3.4");
        album.addSong("In the End", "4.3");
        album.addSong("Somewhere I Belong", "4.1");

        albums.add(album);

        List<Song> playlist = new ArrayList<Song>();

        albums.get(0).addToPlayList("Paper Wings", playlist);
        albums.get(1).addToPlayList("Somewhere I Belong", playlist);
        albums.get(1).addToPlayList(2,playlist);
        albums.get(1).addToPlayList(1,playlist);

        play(playlist);
    }

    private static void play(List<Song> playList){

        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        boolean forward = true;

        ListIterator<Song> listIterator = playList.listIterator();

        if(playList.size() == 0){
            System.out.println("No songs in playlist");
            return;
        }else{
            System.out.println("Now playing " + listIterator.next().toString());
            printMenu();
        }

        while(!quit){
            int action = scanner.nextInt();

            switch(action){
                case 0:
                    System.out.println("Playlist complete");
                    quit = true;
                    break;
                case 1:
                    if(!forward){
                        if(listIterator.hasNext()){
                            listIterator.next();
                        }
                        forward = true;
                    }
                    if(listIterator.hasNext()){
                        System.out.println("Now playing " + listIterator.next().toString());
                    }else{
                        System.out.println("we have reached the end of the playlist");
                        forward = false;
                    }
                    break;
                case 2:
                    if(forward){
                        if(listIterator.hasPrevious()){
                            listIterator.previous();
                        }
                        forward = false;
                    }
                    if(listIterator.hasPrevious()){
                        System.out.println("now playing " + listIterator.previous().toString());
                    }else{
                        System.out.println(" we are at the start of the playlist ");
                        forward = true;
                    }
                    break;
                case 3:
                    if(forward){
                        if(listIterator.hasPrevious()){
                            System.out.println("now playing " + listIterator.previous().toString());
                            forward = false;
                        }else{
                            System.out.println("We are at the start of the list");
                        }
                    }else{
                        if(listIterator.hasNext()){
                            System.out.println("Now replaying " + listIterator.next().toString());
                            forward = true;
                        }else{
                            System.out.println("Reached end of list");
                        }
                    }
                    break;
                case 4:
                    printList(playList);
                    break;
                case 5:
                    printMenu();
                    break;
                case 6:
                    if(playList.size() > 0){
                        listIterator.remove();
                    }
                    if(listIterator.hasNext()){
                        System.out.println("now playing " + listIterator.next());
                    }else if(listIterator.hasPrevious()){
                        System.out.println("Now playing " + listIterator.previous());
                    }
            }
            break;

        }

    }

    private static void printMenu(){
        System.out.println("Available actions press\n");
        System.out.println("0 to quit \n");
        System.out.println("1 to play next song \n");
        System.out.println("2 to play previous song \n");
        System.out.println("3 to replay song \n");
        System.out.println("4 to list songs \n");
        System.out.println("5 to print menu \n");
        System.out.println("6 to delete current song \n");
    }

    private static void printList(List<Song> playList){
        Iterator<Song> iterator = playList.iterator();
        System.out.println("===================");
        while(iterator.hasNext()){
            System.out.println(iterator.next()); //.toString is optional
        }
        System.out.println("===================");
    }



}
