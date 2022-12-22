package musicplayer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {

    public static ArrayList<Album> albums = new ArrayList<>();

    public static void main(String[] args) {


        int x = 0;
        int y = 10;
        int z = y/x;
        Album album = new Album("Album1","Private");

        album.addSongToAlbum("Believer",4.5);
        album.addSongToAlbum("Shape of you",3.5);
        album.addSongToAlbum("Despacito",4.0);

        albums.add(album);


        album = new Album("Album2","Armaan");

        album.addSongToAlbum("Buttabomma",3.5);
        album.addSongToAlbum("Chale Aana",3.0);
        album.addSongToAlbum("Jab Tak",4.0);

        albums.add(album);


        LinkedList<Song> playList_1 = new LinkedList<>();

        albums.get(0).addToPlayList("Believer",playList_1);
        albums.get(0).addToPlayList("Despacito",playList_1);
        albums.get(1).addToPlayList("Buttabomma",playList_1);
        albums.get(1).addToPlayList("Chale Aana",playList_1);

        play(playList_1);

    }
    public static void play(LinkedList<Song> playList){

        printMenu();


        ListIterator<Song> listIterator = playList.listIterator();  //for iterating through playlist.

        boolean forward = true; //Indicates iterator is one step ahead already

        if(playList.size()>0){

            System.out.println("Playing the first song");
            System.out.println(listIterator.next().toString()); //Printing the first song

        }
        else{

            System.out.println("PlayList is empty");
            return;
        }

        System.out.println("Enter your option");

        boolean quit = false;
        Scanner sc = new Scanner(System.in);

        l:
        //Ask for option until quit option is selected.
        while(!quit){

            int option = sc.nextInt();

            //Switch case to implement all options.
            switch(option){

                case 0:     //Quit
                    quit = true;
                    break;

                case 1:     //Next song
                    if(forward==false){         //Pointer behind the song
                        listIterator.next();    //Take one step forward
                        forward=true;           //Now its on the right side of that song
                    }
                    if(listIterator.hasNext()){ //checking if there is another song left.
                        System.out.println("Next Song playing "+listIterator.next().toString());
                        forward = true;
                    }
                    else{
                        System.out.println("You are at the last song");
                        forward = true;
                    }
                    break;

                case 2:     //Prev song
                    if(forward==true){           //1 song ahead
                        listIterator.previous(); //Move one step back
                        forward = false;         //Pointer on right side of song
                    }
                    if(listIterator.hasPrevious()){
                        System.out.println("Previous song playing "+listIterator.previous().toString());
                        forward = false;
                    }
                    else{
                        System.out.println("You are at the first song");
                        forward = false;
                    }
                    break;

                case 3:     //Repeat song
                    if(forward==true){

                        System.out.println("Repeating the song "+listIterator.previous().toString());
                        forward = false;

                    }
                    else{ //forward variable is false

                        if(listIterator.hasNext()){
                            System.out.println("Repeating the song "+listIterator.next().toString());
                            forward = true;
                        }
                    }
                    break;

                case 4:     //Print all songs
                    System.out.println("Printing all the songs");
                    printSongs(playList);
                    break;

                case 5:     //Print menu
                    printMenu();
                    break;

                case 6:     //Delete song
                    System.out.println("Deleting the song");
                    if(forward==false) {
                        listIterator.next();
                        listIterator.remove();
                        forward = true;
                    }
                    else {
                        listIterator.remove();
                        forward = true;
                    }

                    if(playList.size()==0) {
                        System.out.println("Playlist is Empty :(");
                        break l;
                    }
                    //Playing next song after deleting current song.
                    if(listIterator.hasNext()){ //checking if there is another song left.
                        System.out.println("Next Song playing "+listIterator.next().toString());
                        forward = true;
                    }
                    else{
                        System.out.println("You are at the last song");
                        forward = false;
                    }
                    break;
            }
        }

    }

    public static void printSongs(LinkedList<Song> playList){

        for(Song song:playList){
            System.out.println(song.toString()+"  ");
        }
    }

    private static void printMenu(){
        System.out.println("Available options\n press");
        System.out.println("0 - to quit\n"+
                "1 - to play next song\n"+
                "2 - to play previous song\n"+
                "3 - to replay the current song\n"+
                "4 - list of all songs \n"+
                "5 - print all available options\n"+
                "6 - delete current song");
    }
}