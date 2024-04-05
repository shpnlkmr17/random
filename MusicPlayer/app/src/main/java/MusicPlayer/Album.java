/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MusicPlayer;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 *
 * @author KIIT
 */
public class Album {
    private String name;
    private String artist;
    private ArrayList<Song> songs;//3 parameters
    
    public Album(String name, String artst, ArrayList<Song> songs)
    {
        this.name= name;
        this.artist= artist;
        this.songs=new ArrayList<Song>();
    }
    
    public Album(){
        
    }
    
    public Song findSong(String title){
        
        for(Song checkedSong : songs)
        {
            if(checkedSong.getTitle().equals(title))
                return checkedSong;
        }
        return null;
    }
    
    public boolean addSong(String title, double duration)
    {
        if(findSong(title)== null){
            songs.add(new Song(title, duration));
            System.out.println(title+"added");
            return true;
        }
        else
        {
            System.out.println("Song already exists");
            return false;
        }
    }
    
    public boolean addToPlaylist(int trackno, LinkedList<Song> Playlist)
    {
        int index = trackno-1;
        if(index > 0 && index <= this.songs.size())
        {
            Playlist.add(this.songs.get(index));
            return true;
        }
        System.out.println("Does not have the song "+trackno);
        return false;
    }
    
    public boolean addToPlaylist(String title, LinkedList<Song> Playlist )
    {
        for(Song checkedSong : this.songs)
        {
            if(checkedSong.getTitle().equals(title))
            {
                Playlist.add(checkedSong);
                return true;
            }
        }
        System.out.println("No such song");
        return false;
    }
}
