import java.util.Arrays;
import java.util.Comparator;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdIn;

// TODO: import stdin and stdout

public class Term implements Comparable<Term> {
    String query;
    long weight;
    
    // Initializes a term with the given query string and weight.
    public Term(String query, long weight){
        if (query == null){
            throw new java.lang.IllegalArgumentException("Queury can't be null");
        }
        if (weight < 0){
            throw new java.lang.IllegalArgumentException("Weight has to be above 0");
        }

        this.query =query;
        this.weight =weight;
    }

    public static Comparator<Term> byReverseWeightOrder() {
        return new Comparator<Term>() {
            public int compare(Term v, Term w) {

                int out = v.weight < w.weight ? 1 : -1;
                out = v.weight == w.weight? 0: out;
                return out;

            }

        };
    }

    // Compares the two terms in lexicographic order but using only the first r characters of each query.
    public static Comparator<Term> byPrefixOrder(int r) {

        if(r<0){
            throw new IllegalArgumentException();
        }
        return new Comparator<Term>() {
            public int compare(Term v, Term w) {
                int wSize = w.query.length();
                int vSize = v.query.length();
                int max = vSize < wSize ?
                    vSize : wSize;
                max = max < r ? max :r;

                boolean checkR = r > vSize && r > wSize;
                boolean checkW = wSize < vSize;
                boolean checkV = vSize < wSize;
                boolean checkInvalid = checkR && checkV && checkW;

                if(checkInvalid){
                    return -1;
                }

                for(int i = 0; i < max; i++){
                    if(v.query.charAt(i) > w.query.charAt(i)) return 1;
                    else if( v.query.charAt(i) < w.query.charAt(i)) return -1;
                }

                return 0;
            }
        };
    }

    // Compares the two terms in lexicographic order by query.
    public int compareTo(Term that) {
        return query.compareTo(that.query);
    }

    // Returns a string representation of this term in the following format:
    // the weight, followed by a tab, followed by the query.
    public String toString() {
        
        return Long.toString(weight) + " : " + query;
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
        for (Term t : terms) {
            StdOut.println(t);
        }
        
        StdOut.println("");
        Arrays.sort(terms, Term.byReverseWeightOrder());
        for (Term t : terms) {
            StdOut.println(t);
        }
        
        StdOut.println("");
        Arrays.sort(terms, Term.byPrefixOrder(1));
        for (Term t : terms) {
            StdOut.println(t);
        }        
    }
}