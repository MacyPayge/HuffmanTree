/*
 * Name: Macy Busby
 * Class: CSCI 308-A, Fall 2022
 * 11/7/22 8:18 AM
 */

import java.util.*;

public class UserInterface {
    //printCode is a recursive fuction to print the huffman-code through the tree traversal
    //Here, s is the Huffman code generated
    
    public static void printCode(HuffmanNode root, String s){
        
        //This is our base case; if the left & right are null then its a leaf node
        //and we print the code s generated by traversing the tree
        if(root.left == null && root.right == null){
            
            //c is the character in the node
            System.out.println(root.c + ":" + s);
            return;
        }
        //Reminder: if we go left then add "0" to the code
        //and if we go right add "1" to the code
        //The following are the recursive calls for left and right sub-tree of the generated tree
        
        printCode(root.left, s + "0");
        printCode(root.right, s + "1");
    }
    
    //This method obtains a character string from the user.
    //It then separatres out all of the distinct characters into 
    //the distinctChars array and their associated frequencies in the frequencies array
    //We also include error checking try-catch in case the scanner fails.
    public static void ObtainCharacters(PhraseAndFrequencies PF){
        String line;
        Scanner userInput = new Scanner(System.in);
        
        while(true){
            try{
                System.out.println("Please enter a phrase.");
                line = userInput.nextLine();
                
                if(!(line instanceof String) || line == null || line == ""){
                    System.out.println("Error: Incorrect input provided.");
                }
                else{
                    //Convert to a character array
                    for(char ch: line.toCharArray()){
                        
                        //If we do not have string (i.e. There was a read issue)
                        //or our string is empty/null, we need to ask the user to provide new input
                        //The loop will continue and give the user a second chance
                        if(PF.checkCharacter(ch) == -1){
                            //Does not exist, so add it
                            PF.AddCharacter(ch);
                        }
                        else{
                            //Exists, so update frequency
                            //For each character already in the array, the frequency is increased by 1 -Macy Busby
                            //This counts the amount of times the letter is in the phrase - Macy Busby
                            PF.UpdateFrequency(ch);
                        }
                    }
                    //All good, exit
                    break;
                }
            }
            catch(InputMismatchException e){
                System.out.println("Error Occured. "+
                        "Please contact your administrator.");
                //Clear invalid input from scanner buffer.
                userInput.nextLine();
            }
        }
        userInput.close();
    }//end of user interface class
}
