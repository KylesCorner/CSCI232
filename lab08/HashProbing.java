/*
 *Linear-probing distribution. 
 
 Your task is to write a program, HashProbing.java, that iterates over values
 for N = 10^3, 10^4, 10^5, 10^6, and for each N, does the following:  
 
 Create a boolean array of size 2N (call this A[]). This is our proxy for a hash
 table. Normally, your array (hash table) would contain space for whatever type
 of value you intend to store with your key. Today, we're just experiencing the
 process of probing, so we're happy with an array that stores values of false
 (not yet used to store an imagined key/value pair) and true (used to store such
 a pair).  
 
 Insert N random "keys" into A[], using the linear probing strategy described in
 the context of hash tables. Note: we're not actually computing an index by
 computing a hash function on a key here, just imagining that each random number
 is the result of using some hash function for each of N elements (this is a
 reasonable for use cases that deal with real keys and a hash function over
 those keys is randomly distributed). Mechanistically, this means we can just
 pick a random number, probe it to see if the value is true (already used), and
 move along if yes.  
 
 Suppose our hash table data type is asked to search for a key that doesn't
 match one of the hashed elements, and the hash function maps it to a random
 location in the array.  You will compute the average cost (number of probes)
 for such a search miss in the partly-filled array/hash - on average, how many
 probes (array accesses) will be required to recognize that this key does not
 have a match? To do this, you'll generate 10,000 random numbers (imagined
 hashed keys), and probe until reaching an empty cell  (remember: when a hashed
 search lands on a filled/true cell, it must proceed along sequential positions
 until it finds an empty/false one).  
 
 Discuss the extent to which your results validate Proposition M in the book (p
 473): In a linear-probing hash table with M entries and N = α M keys, the
 average number of probes (under Assumption J) required for search hits and
 search misses (or inserts), respectively, is:
 */
import edu.princeton.cs.algs4.StdOut;
import java.util.Random;

public class HashProbing {
    Random random;
    boolean[] A;
    int N;
    double probes;
    private int max;
    final int NUMBER_OF_SIMS = 10000;

    public HashProbing(int N, double deltaN){
        this.N = N;
        this.max = (int) Math.floor(deltaN*N);
        this.A = new boolean[max];
        this.random = new Random();
        this.probes = 0;

        for(int i = 0; i < max; i++){
            this.A[i] = false;
        }

        for(int i = 0; i < N; i++){
            int key = random.nextInt();
            int index = hash(key);
        

            while (A[index]) {
                index = linear_probe(index);
            }
            A[index] = true;

        }

    }

    public int hash(int key){
        return ((key % max) + max) % max;
    }

    public int linear_probe(int key){
        return (key + 1) % max;
    }

    public double run_sim(){
        for(int i = 0; i < NUMBER_OF_SIMS; i++){
            int key = random.nextInt();
            int index = hash(key);
            int counter = 1;

            while (this.A[index] && counter < max) {
                index = linear_probe(index);
                counter++;
                
            }
            probes += counter;
        }

        return probes / NUMBER_OF_SIMS;


    }

    public void print_table(){
        for(int i = 0; i < max; i++){
            if( (i+1) % 10 == 0)StdOut.println();
            StdOut.print(A[i] + " ");
        }
    }
    
    public static void main(String[] args) {
        double deltaN = Double.parseDouble(args[0]);

        for(int N = 10; N <= 100000000; N *= 10){
            HashProbing hp = new HashProbing(N,deltaN);
            double mean = hp.run_sim();
            StdOut.println("Average probes for a miss with N=" + N + " is: " + mean);
        }

    }
}