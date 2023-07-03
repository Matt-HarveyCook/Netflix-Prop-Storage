package netflixpropstorage;
import java.util.ArrayList;

public class basketManager {
ArrayList<Integer> basket = new ArrayList<Integer>();   //an array list of prop ID which will be sorted and searched
    
//declares the node object which will populate the binary search tree
class Node
    {
        int key;    //declares the key as an int 
        Node left, right;   //declares the left and right node to be generated
 
        public Node(int item)
        {
            key = item;     //sets the value of key to the item from parameter
            left = right = null;    //null values to the left and right nodes
        }
    }
 
    //the root node of the binary search tree
    Node root;
 
    //constuctor for the class
    basketManager()
    {
        root = null;
    }
 
    //insert a new value into the tree through insert rec
    void insert(int key)
    {
        root = insertRec(root, key);
    }
     
    //A recursive function to insert a new key into binary search tree
    Node insertRec(Node root, int key)
    {
 
        //check if the tree is empty and return a new node if so
        if (root == null)
        {
            root = new Node(key);
            return root;    //returns the new root node
        }
 
        //if the tree isnt empty then recursivly loop down the tree
        if (key < root.key)
            root.left = insertRec(root.left, key);  //insert left if less
        else if (key > root.key)
            root.right = insertRec(root.right, key);    //insert right if more
 
       
        return root;
    }
     
    //traverse the binary tree in order based on the initial node
    void inorderRec(Node root)
    {
        if (root != null)
        {
            inorderRec(root.left);
            loginPage lP = new loginPage();
            lP.tempBasketArray.add(root.key);       //calls the function and adds the value to the array
            inorderRec(root.right);
            
            
        }
    }
    
    //inserts new values into the tree based on the size of the array
    void treeins( ArrayList<Integer> arr)   
    {
        for(int i = 0; i < arr.size(); i++)
        {
            insert(arr.get(i)); //function used to create new node
        }
         
    }
    
    //used to apply a binary search to the now ordered list
    //takes the sorted list , search value , start and end values
    public int binarySearch( ArrayList<Integer> sortedArray, int value, int first , int last) {    
        int middle = first  + ((last  - first ) / 2);  //determines the middle point of the array

        if (last  < first) {
            return -1;      //return -1 if the values entered are not valid or search value not found
        }

        if (value == sortedArray.get(middle)) {
            return middle;  //return the middle index if the value is found
        } else if (value < sortedArray.get(middle)) {
            return binarySearch(sortedArray, value, first, middle-1);  //applies search again if not found
        } else {
            return binarySearch(sortedArray, value, middle + 1, last);  //-1 or +1 if greater or less than middle
        }
}
    
    //applied each time an item is added to basket
    public int addToBasket(ArrayList<Integer> arr , int searchValue){
        loginPage lP = new  loginPage();
        basketManager bM = new basketManager();
        bM.treeins(arr );   //generates the binary tree
        bM.inorderRec(bM.root); //orders the list through an in order traversal
        
        return binarySearch(lP.tempBasketArray , searchValue , 0 , arr.size()-1);
        //returns the position of the item in the array
    }
    
    public static void main(String args[]) {
    }
}
