import java.util.Arrays;
import edu.princeton.cs.algs4.StdOut;
public class UnitTest {
    public static void term_test(){
        Term[] terms = new Term[5];
        terms[0] = new Term("Trevor", 1);
        terms[1] = new Term("Kathy", 43);
        terms[2] = new Term("Ellie", 11);
        terms[3] = new Term("Allen", 9);
        terms[4] = new Term("Eva", 45);        

        StdOut.println("\nBy Lexigraphical Sorting\n");
        Arrays.sort(terms);
        for (Term t : terms) {
            StdOut.println(t);
        }
        
        StdOut.println("\nBy Reverse Weight Order\n");
        Arrays.sort(terms, Term.byReverseWeightOrder());
        for (Term t : terms) {
            StdOut.println(t);
        }
        
        StdOut.println("\nBy Prefix Order of 1\n");
        Arrays.sort(terms, Term.byPrefixOrder(1));
        for (Term t : terms) {
            StdOut.println(t);
        }        

        StdOut.println("\nBy Prefix Order of 2\n");
        Arrays.sort(terms, Term.byPrefixOrder(2));
        for (Term t : terms) {
            StdOut.println(t);
        }        

    }

    public static void bs_test(){

        Term[] terms = new Term[5];
        terms[0] = new Term("Trevor", 45);
        terms[1] = new Term("Kathy", 43);
        terms[2] = new Term("Ellie", 11);
        terms[3] = new Term("Allen", 9);
        terms[4] = new Term("Eva", 1);

        Term[] itemsToSearch = new Term[5];
        itemsToSearch[0] = new Term("T", 0);
        itemsToSearch[1] = new Term("K", 0);
        itemsToSearch[2] = new Term("k", 0);
        itemsToSearch[3] = new Term("i", 0);
        itemsToSearch[4] = new Term("E", 0);
        
        Arrays.sort(terms);
        Arrays.sort(itemsToSearch);

        StdOut.println("\nTerms\n");
        for(Term t : terms){
            StdOut.println(t);
        }

        for(Term searchme : itemsToSearch){
        int first = BinarySearchDeluxe.firstIndexOf(terms, searchme, Term.byPrefixOrder(1));
        int last = BinarySearchDeluxe.lastIndexOf(terms, searchme, Term.byPrefixOrder(1));
        StdOut.println(searchme + ": " + first + " to " + last);

        }


    }

    public static void autocomplete_test(String filename, int k){
        // read in the terms from a file
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
        Autocomplete autocomplete = new Autocomplete(terms);
        while (StdIn.hasNextLine()) {
            String prefix = StdIn.readLine();
            Term[] results = autocomplete.allMatches(prefix);
            for ( i = 0; i < Math.min(k, results.length); i++)
                StdOut.println(results[i]);
        }
    }

    public static void main(String[] args) {
        StdOut.println("term tests\n");
        term_test();
        StdOut.println("\nbs tests\n");
        bs_test();
        StdOut.println("\nautocomplete tests\n");
        autocomplete_test(args[0], Integer.parseInt(args[1]));
    }

}
