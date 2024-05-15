import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.Digraph;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdOut;


public class ShortestCommonAncestor {
    private final Digraph G;
    private final int root;

   // constructor takes a rooted DAG as argument
   public ShortestCommonAncestor(Digraph G) {
    this.G = G;
    this.root = findRoot();

   }
    private int findRoot() {
        for (int v = 0; v < G.V(); v++) {
            if (G.indegree(v) == 0) {
                return v;
            }
        }
        return -1; // no root found
    }

   // length of shortest ancestral path between v and w
   public int length(int v, int w) {
        if (v < 0 || v >= G.V() || w < 0 || w >= G.V()) {
            throw new IndexOutOfBoundsException();
        }
        Queue<Integer> queue = new Queue<>();
        queue.enqueue(v);
        boolean[] visited = new boolean[G.V()];
        int[] distance = new int[G.V()];
        while (!queue.isEmpty()) {
            int current = queue.dequeue();
            visited[current] = true;
            for (int neighbor : G.adj(current)) {
                if (!visited[neighbor]) {
                    queue.enqueue(neighbor);
                    distance[neighbor] = distance[current] + 1;
                }
            }
        }
        return distance[w];
   }

   // a shortest common ancestor of vertices v and w
   public int ancestor(int v, int w) {
        if (v < 0 || v >= G.V() || w < 0 || w >= G.V()) {
            throw new IndexOutOfBoundsException();
        }
        Queue<Integer> queue = new Queue<>();
        queue.enqueue(v);
        boolean[] visited = new boolean[G.V()];
        while (!queue.isEmpty()) {
            int current = queue.dequeue();
            visited[current] = true;
            for (int neighbor : G.adj(current)) {
                if (!visited[neighbor]) {
                    queue.enqueue(neighbor);
                }
            }
        }
        return findCommonAncestor(v, w);
   }
    private int findCommonAncestor(int v, int w) {
        // find the common ancestor by traversing the path from v to root and w to root
        boolean[] visitedV = new boolean[G.V()];
        boolean[] visitedW = new boolean[G.V()];
        Queue<Integer> queueV = new Queue<>();
        Queue<Integer> queueW = new Queue<>();
        queueV.enqueue(v);
        queueW.enqueue(w);
        while (!queueV.isEmpty() || !queueW.isEmpty()) {
            if (!queueV.isEmpty()) {
                int currentV = queueV.dequeue();
                visitedV[currentV] = true;
                for (int neighbor : G.adj(currentV)) {
                    if (!visitedV[neighbor]) {
                        queueV.enqueue(neighbor);
                    }
                }
            }
            if (!queueW.isEmpty()) {
                int currentW = queueW.dequeue();
                visitedW[currentW] = true;
                for (int neighbor : G.adj(currentW)) {
                    if (!visitedW[neighbor]) {
                        queueW.enqueue(neighbor);
                    }
                }
            }
        }
        for (int i = 0; i < G.V(); i++) {
            if (visitedV[i] && visitedW[i]) {
                return i;
            }
        }
        return -1; // no common ancestor found
    }   


   // length of shortest ancestral path of vertex subsets A and B
   public int length(Iterable<Integer> subsetA, Iterable<Integer> subsetB) {
        int minLength = Integer.MAX_VALUE;
        for (int v : subsetA) {
            for (int w : subsetB) {
                int length = length(v, w);
                if (length < minLength) {
                    minLength = length;
                }
            }
        }
        return minLength;
   }

   // a shortest common ancestor of vertex subsets A and B
   public int ancestor(Iterable<Integer> subsetA, Iterable<Integer> subsetB) {
        int commonAncestor = -1;
        for (int v : subsetA) {
            for (int w : subsetB) {
                int ancestor = ancestor(v, w);
                if (commonAncestor == -1 || ancestor < commonAncestor) {
                    commonAncestor = ancestor;
                }
            }
        }
        return commonAncestor;
   }

   
   // do unit testing of this class
   public static void main(String[] args) {

       // Build unit tests
       if (args.length < 1) {
           manualUnitTest();
       } else {
           In in = new In(args[0]);
           Digraph G = new Digraph(in);
           ShortestCommonAncestor sca = new ShortestCommonAncestor(G);
           while (!StdIn.isEmpty()) {
               int v = StdIn.readInt();
               int w = StdIn.readInt();
               int length   = sca.length(v, w);
               int ancestor = sca.ancestor(v, w);
               StdOut.printf("length = %d, ancestor = %d\n", length, ancestor);
           }
       }
   }
   
   // Unit test made by me
   public static void manualUnitTest() {
    // Basic tree test
       int numVertices = 6;// or whatever
       Digraph d1 = new Digraph(numVertices);
       d1.addEdge(1, 0); // add a bunch of these, to form some tree-like shape, e.g.:
       /*
        *             0
        *          /      \
        *         1        2
        *        / \      / \
        *       3   4    5 
        */
       
       ShortestCommonAncestor sca = new ShortestCommonAncestor(d1);
       int w = -1; // fixme
       int x = -1; // fixme
       int y = -1; // fixme
       int z = -1; // fixme

       StdOut.println("Testing Case: 1");
       StdOut.println("length: " + sca.length(x, y));
       StdOut.println("ancestor: " + sca.ancestor(x, y));


       // testing sets with some iterable type
       // ({1,2},{3,4})
       Bag<Integer> b1 = new Bag<Integer>();
       Bag<Integer> b2 = new Bag<Integer>();

       b1.add(x);
       b1.add(y);
       b2.add(w);
       b2.add(z);

       StdOut.println("Testing Case: 2");
       StdOut.println("length: " + sca.length(b1, b2));
       StdOut.println("ancestor: " + sca.ancestor(b1, b2));
   }
}