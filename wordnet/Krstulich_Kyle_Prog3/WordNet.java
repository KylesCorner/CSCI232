import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Digraph;

public class WordNet {
    private final Map<String, Set<String>> nounToSynsets;
    private final Map<String, Set<String>> synsetToNoun;
    private final Digraph g;


   // constructor takes the name of the two input files
   public WordNet(String synsets, String hypernyms) throws IOException /* "throw" required for FileReader*/ {

        nounToSynsets = new HashMap<>();
        synsetToNoun = new HashMap<>();

       // Read in all synsets (and do something with them)
       In in = new In(synsets);
       while (!in.isEmpty()) {
           String[] parts = in.readLine().split(",");
           String synId = parts[0];
           String synStr = parts[1];
           String[] synset = synStr.split(" ");

           for(String noun : synset){
            nounToSynsets.computeIfAbsent(noun, x -> new HashSet<>()).add(synId);
            synsetToNoun.computeIfAbsent(synId, x -> new HashSet<>()).add(noun);

           }
           //notice: the definitions are in parts[2];  we're ignoring those

           // need to do more here (and elsewhere, too)

           // Read next line from file and ..



       }

       in = new In(hypernyms);
       g = new Digraph(nounToSynsets.size());
       while (!in.isEmpty()) {
           String[] parts = in.readLine().split(",");
           int v = Integer.parseInt(parts[0]);
           int w = Integer.parseInt(parts[1]);
           g.addEdge(v,w);
           
        
       }

       // Read in all hypernyms with some similar code

   }

   // all WordNet nouns
   public Iterable<String> nouns(){
    return nounToSynsets.keySet();
   }


   // is the word a WordNet noun?
   public boolean isNoun(String word) {
    return nounToSynsets.containsKey(word);
   }


   // a synset (second field of synsets.txt) that is a shortest common ancestor
   // of noun1 and noun2 (defined below)
   public String sca(String noun1, String noun2) {
        Set<String> synsets1 = nounToSynsets.get(noun1);
        Set<String> synsets2 = nounToSynsets.get(noun2);

        // Find common ancestor with shortest distance
        String sca = null;
        int distance = Integer.MAX_VALUE;
        for (String synset1 : synsets1) {
            for (String synset2 : synsets2) {
                int d = distance(synset1, synset2);
                if (d < distance) {
                    distance = d;
                    sca = synset1;
                }
            }
        }
        return sca;
   }

   // distance between noun1 and noun2 (defined below)
   public int distance(String noun1, String noun2) {
        Set<String> synsets1 = nounToSynsets.get(noun1);
        Set<String> synsets2 = nounToSynsets.get(noun2);

        ShortestCommonAncestor sca = new ShortestCommonAncestor(g);
        return sca.length(Integer.parseInt(synsets1.iterator().next()), Integer.parseInt(synsets2.iterator().next()));
   }
   

   // do unit testing of this class
   public static void main(String[] args) throws IOException{ //"throw" because the constructor throws.
        WordNet wnet = new WordNet("synsets.txt", "hypernyms.txt");
        //how to test
   }
}