/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hash_table;

import java.util.Random;

/**
 * T
 * @author melodytribble
 */
public class HashTable {
    
    int tableSize;//max size of table
    int itemNum;//number of random int values to start table with
    Tree[]myHash;//hash table using a tree array to preform seperate chaining
    Random random;//random number generator
    /**
     * This is the HashTable constructor, 
     * @param s is the table size
     * @param itm is the number of keys to start with
     */
    HashTable(int s, int itm)
    {
        tableSize = s;
        itemNum = itm;
        myHash = new Tree [s];
        random = new Random();//random keys to insert into table
        
        //inserts numbers less than 100 into correct spot
        for (int i =0;i<itemNum;i++)
        {
            int number = random.nextInt(100);
            put(number);
        }
    }
    /**
     * This inserts a key into the hash table
     * @param k is the key to be inserted
     */
    public void put(int k)
    {
        int i = hash(k);//calls hash function to determine location in array
        
        
        if (myHash[i]==null||myHash[i].getRoot()==null)//if location is empty or recently deleted
        {
                Node n = new Node(k);
                Tree keyTree = new Tree(n);
                myHash[i]= keyTree;//the key will be the root of a new tree
        }else//if location is occupied
        {
            boolean exist = find(k);//looks to see if the key to be inserted already exists in the table
            if (exist == false){//does not already exist, inserts key
                myHash[i].insert(k);
                
            }else{//key is already in the table, does not insert
                System.out.print(k+" already exists in the table \n");
            }
        }
    }
    /**
     * This removes a key from the hash table
     * @param k is the key to be removed
     */
    public void remove(int k)
    {
        int index = hash(k);//determines the location of the key
        myHash[index].delete(k);//searches for and deletes the key
    }
    /**
     * This prints the Hash Table
     */
    public void print()
    {
        for(int i = 0; i<tableSize; i++)
        {
            if(myHash[i]!=null)
            {
            System.out.print(i+". ");
            myHash[i].printTree();
            }
        }
    }
    
    /**
     * This finds the index in the Hash Table for the key to be inserted
     * @param key to be inserted
     * @return the index of the key
     */
    private int hash(int key)
    {
        int index = key % tableSize;
        return index;
    }
    
    /**
     * 
     * @param key to be found
     * @return True or False, found or not
     */
    public boolean find(int key)
    {
        int index = hash(key);
        
        if(myHash[index]==null){//no items in the tree
            return false;
        }else//search the tree
        {
            Node found = myHash[index].find(key);
            
            if (found == null)//didn't find it
            {
                return false;
            }else//found it!
            {
                return true;
            }
        }
    }   
}
