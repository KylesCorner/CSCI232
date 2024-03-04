import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
public class Subset {
 

    public static void main(String[] args) {
        
        int k = Integer.parseInt(args[0]);
        RandomizedBag<String> bag = new RandomizedBag<String>();

        //fill the bag with words from StdIn;  example of doing this in e.g. LinkedQueue

        while(!StdIn.isEmpty()){
            String line = StdIn.readString();
            bag.put(line);
        }

        for(String item : bag){
            StdOut.println(item);
            k--;
            if (k <= 0) break;
        }




        //pull k things from the bag, if possible.

    }
    
    
}