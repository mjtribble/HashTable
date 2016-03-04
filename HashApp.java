/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hash_table;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author melodytribble
 */
public class HashApp {
    
    public static HashTable hash;
    private static boolean flag=true;
    
 /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args)throws IOException {
        startHashTable();//creates hash table
        runProgram();//runs the user Input
        
    }

/**
 * This creates a hash table of user determined size and inserts random numbers
 * @throws IOException 
 */   
private static void startHashTable() throws IOException
{
    System.out.print("Enter the size of the hash table: ");
        int tableSize = getInt();//converts string to int
        System.out.print("Enter initial number of items: ");
        int numItems = getInt();//converts the returned string to an int
        
        hash = new HashTable(tableSize, numItems);//creates the hash table

/**
 * This runs the I/O switch case for the program
 */
}
private static void runProgram() throws IOException {
        
        while (flag) {//while true
            System.out.print("Enter first letter of show, insert, find, delete or quit: ");
            int choice = getChar(0);//converts the returned string to a char
            switch (choice) {
                //This shows the hash table
                case 's':
                    
                    hash.print();
                    
                    break;
                    
                //This inserts a new key into hash table 
                case 'i':
                    
                    System.out.print("Enter key value to insert: ");
                    int new_key = getInt();//converts returned string to an int
                    hash.put(new_key);//inserts value into table
                    
                    break;
                    
                //This finds a specific key in the hash table if it is present
                case 'f':
                    
                    System.out.print("Enter key value to find: ");
                    int value = getInt();//converts string to int
                    boolean found = hash.find(value);//looks for the key
                    
                    if (found==false)//not found
                    {
                        System.out.print("Could not find "+value+"\n");
                    }else//key found
                    {
                        System.out.print("Found "+value+"\n");
                    }
                    
                    break;
                
                //This removes a key from the hash table
                case 'd':
                    
                    System.out.print("Enter key value to be removed: ");
                    int delete_key = getInt();//converts string to int
                    hash.remove(delete_key);//deletes the key
                    
                    break;
                    
                //This exits the program
                case 'q':
                    
                    flag = false;

                    break;
                
                //This give user option to re-enter choice
                default:
                    System.out.print("Invalid entry\n");
            } // end switch
        } // end while

    }
/**
 *This converts user input string to a char for the switch statement
 *@parameter position of char
 *@returns character of users choice
 */
private static char getChar(int i) throws IOException 
{
        String s = getInputString();
        
        return s.charAt(i);
}
/**
 *This reads in the message and converts characters to uppercase
 *@return the message
 */
private static String getInputString() throws IOException 
{
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String s = br.readLine();

        return s;
}
/**
*This converts the user's input to an Integer value
*@returns the integer the user input
*/
private static int getInt() throws IOException
{
    String s = getInputString();
    int i = Integer.parseInt(s); 
    
    return i;
}
}
