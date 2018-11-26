/*
* A time complexity tester for selected methods. You can write similar tests for other methods.
* The original "music.csv" was downloaded from https://think.cs.vt.edu/corgis/csv/music/music.html.
* I extracted three columns(title, artist, year) out of it, cleaned some invalid data and stored the output as "songlist.csv".
* The total number of songs in "songlist.csv" is 9678.
*
* This tester outputs a CSV file which can be visualized by Excel.
*
* Warning: This tester does not check your correctness.
*
* Date Created: 2018/11/25
* Author: Sixian Li
* */

//package assignment4;
//import java.io.BufferedReader;
//import java.io.FileReader;
//import java.io.IOException;
//import java.io.FileWriter;
//import java.util.ArrayList;
//import java.util.Random;
//
//public class TimeComplexityTester {
//
//    public static void main(String[] args) {
//        Random randomKey = new Random();
//        try (FileWriter fw = new FileWriter("result.csv")) {
//            // Header for the output csv file
//            fw.append("size,put(),get(),keys(),values()\n");
//            // You can modify the size, but the MAXIMUM size is 9678.
//            // The size should start from 1 or generateSongs will give an error.
//            for (int size=1; size<9679; size++) {
//                ArrayList<Song> songs = generateSongs(size);
//                //System.out.println(songs.size());
//                MyHashTable<String, Song> songTable;
//                // Genrate a random key -- a random title from songlist.
//                String key = songs.get(randomKey.nextInt(songs.size())).getTitle();
//                int numBuckets = (int) (size / 0.75);
//                // Initialize the hash table.   Key will be the song title.
//                songTable = new MyHashTable<>(numBuckets);
//                long putTime = testPut(songTable, songs);
//                long getTime = testGet(songTable, key);
//                long keysTime = testKeys(songTable);
//                long valuesTime = testValues(songTable);
//                fw.append(size + "," + putTime + "," + getTime + "," + keysTime + "," + valuesTime + "\n");
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//    }
//
//    public static long testPut(MyHashTable<String,Song> songTable, ArrayList<Song> songs){
//        long startTime = System.nanoTime();
//        for (Song song: songs) {
//            songTable.put(song.getTitle(), song);
//        }
//        long endTime = System.nanoTime();
//        long duration = (endTime - startTime);
//        return duration;
//    }
//
//    public static long testGet(MyHashTable<String,Song> songTable, String key){
//        long startTime = System.nanoTime();
//        songTable.get(key);
//        long endTime = System.nanoTime();
//        long duration = (endTime - startTime);
//        return duration;
//    }
//
//    public static long testKeys(MyHashTable<String,Song> songTable){
//        long startTime = System.nanoTime();
//        ArrayList<String> keys = songTable.keys();
//        long endTime = System.nanoTime();
//        long duration = (endTime - startTime);
//        return duration;
//    }
//
//    public static long testValues(MyHashTable<String,Song> songTable){
//        long startTime = System.nanoTime();
//        ArrayList<Song> values = songTable.values();
//        long endTime = System.nanoTime();
//        long duration = (endTime - startTime);
//        return duration;
//    }
//
//    public static ArrayList<Song> generateSongs(int size){
//        String csvFile = "songdata.csv";
//        String line = "";
//        String cvsSplitBy = ",";
//        ArrayList<Song> songs = new ArrayList<>();
//
//        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
//
//            //while ((line = br.readLine()) != null) {
//            line=br.readLine();
//            for (int i=0; i<size; i++){
//                // use comma as separator
//                String[] info = line.split(cvsSplitBy);
//                //System.out.println(info[0] + info[1] + info[2]);
//                songs.add(new Song(info[0], info[1], Integer.parseInt(info[2])));
//                //System.out.println(s1);
//                line=br.readLine();
//            }
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        //System.out.println(songs.toString());
//        return songs;
//    }
//}

/*
 * A tester for selected methods. You can write similar tests for other methods.
 * The original "music.csv" was downloaded from https://think.cs.vt.edu/corgis/csv/music/music.html.
 * I extracted three columns(title, artist, year) out of it, cleaned some invalid data and stored the output as "songlist.csv".
 * The total number of songs in "songlist.csv" is 9678.
 *
 * This tester outputs a CSV file which can be visualized by Excel.
 *
 * Warning: This tester does not check your correctness.
 *
 * Date Created: 2018/11/25
 * Author: Sixian Li
 * */

package assignment4;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Random;

public class TimeComplexityTester {

    public static void main(String[] args) {
        Random randomKey = new Random();
        try (FileWriter fw = new FileWriter("result.csv")) {
            // Header for the output csv file
            fw.append("size,put(),get(),keys(),values()\n");
            // You can modify the size, but the MAXIMUM size is 9678. This may take quite a while to run.
            // The size should start from 1 or generateSongs() will give an error.
            for (int size=1; size<20; size++) {
                ArrayList<Song> songs = generateSongs(size);
                //System.out.println(songs.size());
                MyHashTable<String, Song> songTable;
                // Genrate a random key -- a random title from songlist.
                String key = songs.get(randomKey.nextInt(songs.size())).getTitle();
                int numBuckets = (int) (size / 0.75);
                // Initialize the hash table. Key will be the song title.
                songTable = new MyHashTable<>(numBuckets);
                long putTime = testPut(songTable, songs);
                long getTime = testGet(songTable, key);
                long keysTime = testKeys(songTable);
                long valuesTime = testValues(songTable);
                fw.append(size + "," + putTime + "," + getTime + "," + keysTime + "," + valuesTime + "\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static long testPut(MyHashTable<String,Song> songTable, ArrayList<Song> songs){
        long startTime = System.nanoTime();
        for (Song song: songs) {
            songTable.put(song.getTitle(), song);
        }
        long endTime = System.nanoTime();
        long duration = (endTime - startTime);
        return duration;
    }

    public static long testGet(MyHashTable<String,Song> songTable, String key){
        long startTime = System.nanoTime();
        songTable.get(key);
        long endTime = System.nanoTime();
        long duration = (endTime - startTime);
        return duration;
    }

    public static long testKeys(MyHashTable<String,Song> songTable){
        long startTime = System.nanoTime();
        ArrayList<String> keys = songTable.keys();
        long endTime = System.nanoTime();
        long duration = (endTime - startTime);
        return duration;
    }

    public static long testValues(MyHashTable<String,Song> songTable){
        long startTime = System.nanoTime();
        ArrayList<Song> values = songTable.values();
        long endTime = System.nanoTime();
        long duration = (endTime - startTime);
        return duration;
    }

    public static ArrayList<Song> generateSongs(int size){
        // Please don't modify this.
        String csvFile = "songdata.csv";
        String line = "";
        String cvsSplitBy = ",";
        ArrayList<Song> songs = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

            line=br.readLine();
            for (int i=0; i<size; i++){
                String[] info = line.split(cvsSplitBy);
                songs.add(new Song(info[0], info[1], Integer.parseInt(info[2])));
                line=br.readLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return songs;
    }
}


