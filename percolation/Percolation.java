
/* *****************************************************************************
 *  Name:              Kyle Krstulich
 *  Last modified:     1/27/24
 **************************************************************************** */
import edu.princeton.cs.algs4.QuickFindUF;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {

  // -----------------------------
  // Attributes
  // -----------------------------

  private QuickFindUF quf;
  private int[] data; // values in array not working
  private int N;
  private final int bottom;
  private final int top;
  private int openSites;

  // -----------------------------
  // Constructor
  // -----------------------------

  public Percolation(int N) {
    // create N-by-N grid, with all sites initially blocked

    this.N = N;
    this.quf = new QuickFindUF(N * N + 2);
    // 0 = closed. 1 = open.
    this.data = new int[N * N];
    this.top = N * N;
    this.bottom = N * N + 1;
    this.openSites = 0;
  }

  // -----------------------------
  // Private Methods
  // -----------------------------

  private boolean validate_index(int row, int col) {
    return ((row >= 0) && (col >= 0) && (row < N) && (col < N));
  }

  //returns index of flat array
  private int flatten(int row, int col) {
    if (validate_index(row, col)) {
      return (row * this.N) + col;

    } else {
      throw new IndexOutOfBoundsException("Index out of bounds");
    }
  }

  private int index(int row, int col) {
    return data[flatten(row, col)];
  }

  private void edit(int row, int col, int delta) {
    data[(row * this.N) + col] = delta;
  }

  private void check_connected(int row, int col) {
    int p = flatten(row, col);
    int q = -1;

    if (validate_index(row + 1, col) && isOpen(row + 1, col)) {
      q = flatten(row + 1, col);
      quf.union(p, q);
    }
    if (validate_index(row - 1, col) && isOpen(row - 1, col)) {
      q = flatten(row - 1, col);
      quf.union(p, q);
    }
    if (validate_index(row, col + 1) && isOpen(row, col + 1)) {
      q = flatten(row, col + 1);
      quf.union(p, q);
    }
    if (validate_index(row, col - 1) && isOpen(row, col - 1)) {
      q = flatten(row, col - 1);
      quf.union(p, q);
    }
  }

  // -----------------------------
  // Public Methods
  // -----------------------------

  public void open(int row, int col) {
    // open the site (row, col) if it is not open already
    if (!validate_index(row, col)) {
      return;
    }
    if (isOpen(row, col)) {
      return;
    }
    this.openSites++;
    edit(row, col, 1);

    if (row == 0) {
      this.quf.union(this.top, flatten(row, col));
    }
    if (row == this.N) {
      this.quf.union(this.bottom, flatten(row, col));
    }

    check_connected(row, col);
  }

  public boolean isOpen(int row, int col) {
    // is the site (row, col) open?
    return index(row, col) == 1;
  }

  public boolean isFull(int row, int col) {
    // is the site (row, col) full?
    return this.quf.find(this.top) == this.quf.find(flatten(row, col));
  }

  public int numberOfOpenSites() {
    // number of open sites
    return this.openSites;
  }

  public boolean percolates() {
    // does the system percolate?
    return this.quf.connected(this.top, this.bottom);
  }

  // -----------------------------
  // Unit Tests
  // -----------------------------

  private static void open_tests(Percolation p, int N) {

    for (int row = 0; row < N; row++) {

      for (int col = 0; col < N; col++) {
        p.open(row, col);

        if (p.isOpen(row, col) == false) {
          StdOut.println("Open test failed at (" + row + ", " + col + ")");
        }
      }
    }
  }

  private static void init_tests(Percolation p, int N) {

    for (int row = 0; row < N; row++) {

      for (int col = 0; col < N; col++) {
        // init test
        if (p.isOpen(row, col) == true) {
          StdOut.println("Open initialization test failed at (" + row + ", " +
              col + ")");
        }
        if (p.isFull(row, col) == true) {
          StdOut.println("Full initialization test failed at (" + row + ", " +
              col + ")");
        }
      }
    }
  }

  private static void input_4() {
    int[][] commands = { { 3, 0 }, { 2, 0 }, { 1, 0 }, { 0, 0 },
        { 0, 3 }, { 1, 3 }, { 3, 3 }, { 2, 3 } };

    Percolation pc = new Percolation(4);

    for (int i = 0; i < commands.length; i++) {
      int p = commands[i][0];
      int q = commands[i][1];

      pc.open(p, q);
    }

    StdOut.println("input_4 test results: " + pc.percolates());
  }

  public static void main(String[] args) {
    int N = Integer.parseInt(args[0]);
    Percolation p = new Percolation(N);

    init_tests(p, N);
    open_tests(p, N);

    input_4();


  }
}
