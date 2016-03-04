/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hash_table;

/**
 *
 * @author melodytribble
 */
import java.io.*;
import java.util.*; // for Stack class
////////////////////////////////////////////////////////////////
class Node
{
	public int key; // data item (key)
	public Node leftChild; // this node's left child
	public Node rightChild; // this node's right child
        
        Node(int k){
            key = k;
            leftChild = null;
            rightChild = null;
        }
	
        public void displayNode() // display ourself
        {
		System.out.print('{');
		System.out.print(key);
		System.out.print("} ");
	}
        
        public int getKey(){//returns the key
            return key;
        }
        

} // end class Node
////////////////////////////////////