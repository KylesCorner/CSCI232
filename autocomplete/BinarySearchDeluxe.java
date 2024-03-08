import java.util.Arrays;
import java.util.Comparator;

public class BinarySearchDeluxe {

    
    // Returns the index of the first key in a[] that equals the search key, or -1 if no such key.
    // Binary search in terms of the first element.
    /*
     The binary search algorithm has a time complexity of O(log n), where n is
     the number of elements in the array.
     Within the loop, there's an additional while loop that decrements mid until
     it's no longer within the correct terms. In the worst-case scenario, this
     could mean iterating over all the elements to find the first occurrence of
     the key.  Therefore, in the worst case, the time complexity would be O(n)
     for the additional while loop.
     */
    public static <Key> int firstIndexOf(Key[] a, Key key, Comparator<Key> comparator) {
        int low = 0;
        int high = a.length -1;
        while (low <= high) {
            int mid = low + (high - low)/2;
            int comp = comparator.compare(a[mid], key);

            if (comp == 0){ //Within correct terms
                while(mid >= 0 && comp == 0){ 
                    mid--; // decriment mid till not within correct terms
                    comp = comparator.compare(a[mid], key);
                }
                return mid + 1; // add one to find first index
            }

            if(comp > 0) high = mid -1; //passed correct terms, ignore greater half

            if(comp < 0) low = mid +1; //before correct terms, ignore smaller half
        }

        return -1;
           
    }

    
    // Returns the index of the last key in a[] that equals the search key, or -1 if no such key.
    // Binary search in terms of the last element.
    public static <Key> int lastIndexOf(Key[] a, Key key, Comparator<Key> comparator) {
        int low = 0;
        int high = a.length -1;

        while (low <= high) {
            int mid = low + (high - low)/2;
            int comp = comparator.compare(a[mid], key);

            if(comp == 0){ //Within correct terms
                while (mid < a.length && comp == 0) {
                    mid++; //increment mid till not within correct terms
                    if(mid < a.length){
                    comp = comparator.compare(a[mid], key);   
                    }
                }
                return mid -1; // subtract one to find last index

            }
            if(comp > 0) high = mid -1; // passed correct terms, ignore greater half 
            if(comp < 0) low = mid +1; // before correct terms, ignore smaller half
            
        }
            
        return -1;
    }


    // unit testing (you should have some Unit Testing here to confirm that your methods work); for example...
    public static void main(String[] args) {
    
        Term[] terms = new Term[5];
        terms[0] = new Term("Trevor", 45);
        terms[1] = new Term("Kathy", 43);
        terms[2] = new Term("Ellie", 11);
        terms[3] = new Term("Allen", 9);
        terms[4] = new Term("Eva", 1);
        Arrays.sort(terms);
        
        Term searchme = new Term("J",0);
        int first = BinarySearchDeluxe.firstIndexOf(terms, searchme, Term.byPrefixOrder(1));
        int last = BinarySearchDeluxe.lastIndexOf(terms, searchme, Term.byPrefixOrder(1));
        StdOut.println("J: " + first + " to " + last);

        searchme = new Term("A",0);
        first = BinarySearchDeluxe.firstIndexOf(terms, searchme, Term.byPrefixOrder(1));
        last = BinarySearchDeluxe.lastIndexOf(terms, searchme, Term.byPrefixOrder(1));
        StdOut.println("A: " + first + " to " + last);
       
        searchme = new Term("E",0);
        first = BinarySearchDeluxe.firstIndexOf(terms, searchme, Term.byPrefixOrder(1));
        last = BinarySearchDeluxe.lastIndexOf(terms, searchme, Term.byPrefixOrder(1));
        StdOut.println("E: " + first + " to " + last);
        
        searchme = new Term("T",0);
        first = BinarySearchDeluxe.firstIndexOf(terms, searchme, Term.byPrefixOrder(1));
        last = BinarySearchDeluxe.lastIndexOf(terms, searchme, Term.byPrefixOrder(1));
        StdOut.println("T: " + first + " to " + last);        
    }
}