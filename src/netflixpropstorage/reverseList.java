package netflixpropstorage;

import java.util.*;

public class reverseList {

    //stores maximum count of elements stored in a stack
    int size;
    //stores index of top element of a stack
    int top;
    //stores address of array element
   LinkedList<String> a = new LinkedList<>();
  
    //function to check if the stack is empty or not
    boolean isEmpty()
    {
        return (top < 0);
    }
  
    //function to create a stack of given capacity.
   reverseList (int n)
    {
        top = -1;
        size = n;
        for (int i = 0; i < size; i++) {
            a.add(" ");
        }
        
    }
  
    //pushes an element onto the stack
    boolean push(String x)
    {
  
        // If Stack is full
        if (top >= size) {
            System.out.println(
                "Stack Overflow");
            return false;
        }
        else {
  
            // Insert element into stack
            a.set(++top, x);
            return true;
        }
    }
  
    //function to remove an element from stack.
    String pop()
    {
        //check if stack is empty
        if (top < 0) {
            System.out.println(
                "Stack Underflow");
            return null;
        }
  
        //pop element from stack
        else {
            String x = a.get(top--);
            return x;
        }
    }

    //takes the linked list and returns it reversed
    public static LinkedList<String> reverse(LinkedList<String> arr, int n)
    {
         LinkedList<String> temp = new LinkedList<>();
         
        reverseList obj = new reverseList(n);   //initialize a stack of capacity n
  
        for (int i = 0; i < n; i++) {
  
            //add arr to the stack
            obj.push(arr.get(i));
        }
  
        //reverse the array elements
        for (int i = 0; i < n; i++) {
  
            // Update arr[i]
            //arr[i] = obj.pop();
            arr.set(i, obj.pop());
        }
  
        for (int i = 0; i < n; i++) {
            temp.add(arr.get(i));
        }
        return temp;
    }
    
    //used to apply the sort
     public static void mergeSort(LinkedList<String> list, int from, int to) {
        if (from == to) {
            return;
        }
        int mid = (from + to) / 2;
        // sort the first and the second half
        mergeSort(list, from, mid);
        mergeSort(list, mid + 1, to);
        merge(list, from, mid, to);
    }


    public static void merge(LinkedList<String> list, int from, int mid, int to) {
        int n = to - from + 1;       // size of the range to be merged
        String[] b = new String[n];   // merge both halves into a temporary array b
        int i1 = from;               // next element to consider in the first range
        int i2 = mid + 1;            // next element to consider in the second range
        int j = 0;                   // next open position in b

        // as long as neither i1 nor i2 past the end, move the smaller into b
        while (i1 <= mid && i2 <= to) {
            if (list.get(i1).compareTo(list.get(i2)) < 0) {
                b[j] = list.get(i1);
                i1++;
            } else {
                b[j] = list.get(i2);
                i2++;
            }
            j++;
        }

        //only one of the two while loops below is executed copy any remaining entries of the first half
        while (i1 <= mid) {
            b[j] = list.get(i1);
            i1++;
            j++;
        }

        // copy any remaining entries of the second half
        while (i2 <= to) {
            b[j] = list.get(i2);
            i2++;
            j++;
        }

        // copy back from the temporary array
        for (j = 0; j < n; j++) {
            list.set(from+j , b[j]);
        }
    }
    
    public static void main(String args[]) {
        
    }
}
