import java.util.Iterator;

public class IteratorClient {
 
    public static void main(String[] args) {
        RandomizedBag<String> bag = new RandomizedBag<String>();
        
        bag.put("we");
        bag.put("are");
        bag.put("the");
        bag.put("music-makers");
        bag.put("and");
        bag.put("dreamers");
        bag.put("of");
        bag.put("dreams");

        Iterator<String> itr1 = bag.iterator();
        if  (!bag.isEmpty()) 
            bag.get(); // test removal of one
        Iterator<String> itr2 = bag.iterator();

        StdOut.println("Here's what was left before removing one (in random order):");
        while (itr1.hasNext())
        {
            String s = itr1.next();
            StdOut.print(s + " ");
        }
        StdOut.println("");
        
        StdOut.println("Here's what was left after removing one (in random order):");
        while (itr2.hasNext())
        {
            String s = itr2.next();
            StdOut.print(s + " ");
        }
        StdOut.println("");
 
        
    }
}