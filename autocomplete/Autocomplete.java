import java.util.Arrays;

public class Autocomplete {
    Term[] terms;

    // Initializes the data structure from the given array of terms.
    public Autocomplete(Term[] terms) {
        if(terms == null){
            throw new java.lang.IllegalArgumentException("Terms cannot be null");
        }
        this.terms = terms;

        for(int i = 0; i < terms.length; i++){
            if(terms[i] == null){
                throw new java.lang.IllegalArgumentException("Null term");
            }
            this.terms[i] = terms[i];
        }

        Arrays.sort(this.terms); // Binary search only works on a sorted array

    }

    // Returns all terms that start with the given prefix, in descending order of weight.
    // O(n log n)
    public Term[] allMatches(String prefix) {
        if(prefix == null){
            throw new java.lang.IllegalArgumentException("Prefix cannot be null");
        }

        if(prefix.length() == 0){ 
            return this.terms;
        }

        Term p = new Term(prefix, 0);
        int first = BinarySearchDeluxe.firstIndexOf(terms, p, Term.byPrefixOrder(prefix.length())); //O(n)
        int last = BinarySearchDeluxe.lastIndexOf(terms, p, Term.byPrefixOrder(prefix.length())); //O(n)
        Term[] matches = new Term[last - first + 1];

        if(first < 0){ // No matches
            return new Term[] {};
        }
        for(int i = first; i <= last; i++){
            matches[i - first] = terms[i];
        }
        Arrays.sort(matches, Term.byReverseWeightOrder()); //O(n log n)
        return matches;

    }

    // Returns the number of terms that start with the given prefix.
    // O(n)
    public int numberOfMatches(String prefix) {
        if(prefix == null){
            throw new java.lang.IllegalArgumentException("Prefix cannot be null");
        }
        if(prefix.length() == 0){
            return terms.length;
        }
        Term p = new Term(prefix, 0);
        int first = BinarySearchDeluxe.firstIndexOf(terms, p, Term.byPrefixOrder(prefix.length())); //O(n)

        if(first < 0){ //No matches
            return 0;
        }

        int last = BinarySearchDeluxe.lastIndexOf(terms, p, Term.byPrefixOrder(prefix.length())); //O(n)
        return last - first + 1;
    }
    

    // A sample client for unit testing
    public static void main(String[] args) {

        // read in the terms from a file
        String filename = args[0];
        In in = new In(filename);
        int N = in.readInt();
        Term[] terms = new Term[N];
        int i;
        for (i = 0; i < N; i++) {
            long weight = in.readLong();           // read the next weight
            in.readChar();                         // scan past the tab
            String query = in.readLine();          // read the next query
            terms[i] = new Term(query, weight);    // construct the term
        }
        
        // read in queries from standard input and print out the top k matching terms
        int k = Integer.parseInt(args[1]);
        Autocomplete autocomplete = new Autocomplete(terms);
        while (StdIn.hasNextLine()) {
            String prefix = StdIn.readLine();
            Term[] results = autocomplete.allMatches(prefix);
            for ( i = 0; i < Math.min(k, results.length); i++)
                StdOut.println(results[i]);
        }
    }
}