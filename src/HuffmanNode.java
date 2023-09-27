/*
 * Name: Macy Busby
 * Class: CSCI 308-A, Fall 2022
 * 11/7/22 8:17 AM
 */

import java.util.Comparator;

//Each node in the huffman tree needs to hold the distinct character
//and the frequency of the character.
//We also need references to the left and right child

public class HuffmanNode {
    int data;
    char c;
    
    HuffmanNode left;
    HuffmanNode right;
}

class MyComparator implements Comparator<HuffmanNode>{
    public int compare(HuffmanNode x, HuffmanNode y){
        return x.data - y.data;
    }
}
