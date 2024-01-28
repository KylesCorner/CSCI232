/*
 * Kyle Krstulich
 * 1/23/24
 * CSCI232
 * Quick Union videos for algs and data structures
 *
 * Lazy approach
 *
 * Quick-Union defect.
 * + Trees can get too tall and expensive to search.
 */
public class QuickUnionUF {

  // Data Structure
  private int[] id; // Integer array of size N
  private int[] size; // size = 2^(tree depth) < N
  private int count;

  // Interpretation: id[i] is parent of i.
  // Root of i is id[id[id[...id[i]...]]].
  // N array accesses

  public QuickUnionUF(int N) {
    id = new int[N];
    size = new int[N];

    for (int i = 0; i < N; i++) {
      id[i] = i;
      size[i] = 1;
    }
  }

  public QuickUnionUF(int[] new_id) {
    id = new_id;
  }

  public int count() {
    return count;
  }

  // chasing parent pointers unitil reach root. (depth of i array accesses)
  private int root(int i) {

    while (i != id[i]) {
      // id[i] = id[id[i]]; // this line is to flatten the tree.
      i = id[i];
    }
    return i;
  }

  // Check to see if they have the same root
  // depth of p and q array accesses
  public static boolean connected(int p, int q) {
    return root(p) == root(q);
  }

  // To merge components containing p and q, set the id of p's root to the id of
  // q's root. depth of p and q array accesses
  // Lazy approach
  // For a quick union, when you connect nodes it should instead connect to the
  // root of the node.
  // When you increase the size of the tree it will almost always double the
  // ammount of nodes connected to the tree
  //
  // Depth++ -> doubling oof a Connected components
  public static void union(int p, int q) {
    int i = root(p);
    int j = root(q);
    if (j == i)
      return;

    if (size[j] <= size[i]) {
      id[i] = j;
      size[j] += size[i];
    } else {
      id[j] = i;
      size[i] += size[j];
    }

    count--;
  }

  public static void main(String[] args) {
    int[] lecture_id = { 1, 8, 1, 8, 3, 0, 5, 1, 8, 8 }
  }
}
