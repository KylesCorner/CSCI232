
/* *****************************************************************************
 *  Name:              Kyle Krstulich
 *  Last modified:     1/27/24
 **************************************************************************** */
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {

  public class Site {
    boolean open;
    boolean full;
    Site next;

    public Site() {
      open = false;
      full = false;
      next = null;
    }
  }

  Site[][] sites;

  public Percolation(int N) {
    // create N-by-N grid, with all sites initially blocked

    sites = new Site[N][N];
    for (int row = 0; row < N; row++) {

      for (int col = 0; col < N; col++) {
        sites[row][col] = new Site();
      }
    }
  }

  public void open(int row, int col) {
    // open the site (row, col) if it is not open already
    sites[row][col].open = true;
  }

  public boolean isOpen(int row, int col) {
    // is the site (row, col) open?
    boolean result = sites[row][col].open;
    return result;
  }

  public boolean isFull(int row, int col) {
    // is the site (row, col) full?
    boolean result = sites[row][col].full;
    return result;
  }

  public int numberOfOpenSites() {
    // number of open sites
    return -999; // FIXME
  }

  public boolean percolates() {
    // does the system percolate?
    return false; // FIXME
  }

  public static void main(String[] args) {
    int N = Integer.parseInt(args[0]);
    Percolation p = new Percolation(N);
    for (int row = 0; row < N; row++) {

      for (int col = 0; col < N; col++) {
        // init test
        if (p.isOpen(row, col)) {
          StdOut.println("Open initialization test failed at (" + row + ", " +
                         col + ")");
        }
        if (p.isFull(row, col)) {
          StdOut.println("Full initialization test failed at (" + row + ", " +
                         col + ")");
        }
      }

      for (int col = 0; col < N; col++) {
        p.open(row, col);

        if (!p.isOpen(row, col)) {
          StdOut.println("Open test failed at (" + row + ", " + col + ")");
        }
      }
    }
  }
}
