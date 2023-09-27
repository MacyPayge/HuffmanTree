/*
 * Name: Macy Busby
 * Class: CSCI 308-A, Fall 2022
 * 11/7/22 8:18 AM
 */

import java.util.ArrayList;

//The following class holds and updates the distinct characters & frequencies
//distinctChars - contains all of the distinct characters in order of appearance
//frequencies - contains all the frequencies associated with each character above
//We use arraylists to give us dynamic arrays and built-in comparator methods

public class PhraseAndFrequencies {
    
    ArrayList<Character> distinctChars = new ArrayList<>();
    ArrayList<Integer> frequencies = new ArrayList<>();
    
    public void AddCharacter(char ch){
        //For a new distinct character, we need to add it to the distinctChars array
        //We also need to initialize its frequency in the frequencies array to 1
        distinctChars.add(ch);
        frequencies.add(1);
    }
    
    public void UpdateFrequency(char ch){
        //For an existing character, we need to obtain the location of the character in
        //distinctChars, then increment the associated frequecy by 1 in frequencies
        int loc = distinctChars.indexOf(ch);
        int freq = frequencies.get(loc);
        frequencies.set(loc, freq+1);
    }
    
    public int checkCharacter(char ch){
        //returns index or -1 if not in list
        return distinctChars.indexOf(ch);
    }
    
    public void printArrays(){
        //Prints both arrays for error checking and quality control purposes
        System.out.println("\nLetters:");
        System.out.println(distinctChars);
        System.out.println("\nFrequencies:");
        System.out.println(frequencies);
    }
}
