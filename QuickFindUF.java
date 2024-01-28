/*
 * Kyle Krstulich
 * 1/22/24
 * CSCI232
 *
 * for the videos on the union find algorithm
 *
 *
 * Worst Case Runtime. Using Union find on N objects upon a size N array. Takes
 * N^2 time.
 *
 * Union is too expensive
 * Trees are flat, but too expensive to keep them flat
 *
 *
 * Steps to produce
 *    Make array
 *    define find operation
 *    defind union function
 *
 *
 */
public class QuickFindUF {

  private int[] id;

  // Time of N
  // p and q are connected iff they have the same id, or value on array.
  public QuickFindUF(int N) {
    id = new int[N];
    for (int i = 0; i < N; i++) {
      id[i] = i;
    }
  }

  // Time of 1
  public boolean connected(int p, int q) {
    return id[p] == id[q];
  }

  // Quick find algorithm
  // Time of N
  // Eager apprach of algorithm design.
  public void union(int p, int q) {

    // Check if already connected
    if (connected(p, q))
      return;

    // pull id's out of array
    int pid = id[p];
    int qid = id[q];
    int size = id.length;

    // Itterate through id array. Converting all id's that match the id's that
    // match the first node and setting them to the value of the second node.
    for (int i = 0; i < size; i++) {
      if (id[i] == pid)
        id[i] = qid;
    }
  }

  public static void main(String[] args) {
    int N = Integer.parseInt(args[0]);

    QuickFindUF qf = new QuickFindUF(N);
  }
}
