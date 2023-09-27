/*
 * Name: Macy Busby
 * Class: CSCI 308-A, Fall 2022
 * 11/7/22 8:17 AM
 */

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class HuffmanTree_Busby {
    
    //Driver method
    public static void main(String[] args) {
        //This method begins by obtaining a list of distinct characters
        //and their associated frequencies.
        //Next, it creates a priority queue q that is a min-priority queue (min-heap)
        //The nodes are added to the heap with the higher frequencies toward the top
        //Finally, we extract nodes to create the codes for each character 
        //and print them for the user
        
        System.out.println("Welcome. This program takes a phrase and lists the frequency of each character.");
        System.out.println("It will then create a Huffman Tree containing the letters and give their codes.\n");
        
        Scanner s = new Scanner(System.in);
        PhraseAndFrequencies PF = new PhraseAndFrequencies();
        
        PF.distinctChars = new ArrayList<>();
        PF.frequencies = new ArrayList<>();
        
        UserInterface.ObtainCharacters(PF);
        PF.printArrays(); //For quality control
        
        PriorityQueue<HuffmanNode> q = new PriorityQueue<>
                (PF.distinctChars.size(), new MyComparator());
        
        AddToQueue(q, PF);
        
        //Create a root node
        HuffmanNode root = null;
        
        root = ExtractNodes(q, root);
        
        //print the codes by traversing the tree
        System.out.println("\nCodes:");
        UserInterface.printCode(root, "");
    }
    
    public static void AddToQueue(PriorityQueue<HuffmanNode> q,
            PhraseAndFrequencies PF){
        //This method creates a Huffman node object and adds it to the priority queue
        for(int i = 0; i < PF.distinctChars.size(); i++){
            HuffmanNode hn = new HuffmanNode();
            
            hn.c = PF.distinctChars.get(i);
            hn.data = PF.frequencies.get(i);
            
            hn.left = null;
            hn.right = null;
            
            //Add functions adds the huffman node to the quwuw
            q.add(hn);
        }
    }
    
    //This method traverses the heap and extracts the two minimum values from the heap
    //each time until its size reduces to 1
    //extracts until all the nodes are extracted
    //The path of the traversal determines the code for the that character
    public static HuffmanNode ExtractNodes(PriorityQueue<HuffmanNode> q,
            HuffmanNode root){
        
        while(q.size() > 1){
            //First min extract
            HuffmanNode x = q.peek();
            q.poll();
            
            //Second min extract
            HuffmanNode y = q.peek();
            q.poll();
            
            //New node f which is equal
            HuffmanNode f = new HuffmanNode();
            //to the sum of the frequency of he two nodes
            //Assing values to the f node.
            f.data = x.data + y.data;
            f.c = '-';
            
            //first extracted node as left child
            f.left = x;
            //second extracted node as the right child
            f.right = y;
            //Marking the f node as the root noe.
            root = f;
            //Add this node to the priority-queue
            q.add(f);
        }
        return root;
    }
}//End HuffmanTree_Busby class
