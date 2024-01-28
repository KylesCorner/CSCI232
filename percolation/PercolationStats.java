/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Last modified:     October 16, 1842
 **************************************************************************** */


public class PercolationStats {
    public PercolationStats(int N, int T) {
        // perform T independent experiments on an N-by-N grid
    }
    public double mean() {
        // sample mean of percolation threshold
        return -9999.9999; //FIXME
    }
    public double stddev() {
        // sample standard deviation of percolation threshold
        return -9999.9999; //FIXME
    }
    public double confidenceLow() {
        // low  endpoint of 95% confidence interval
        return -9999.9999; //FIXME
    }
    public double confidenceHigh() {
        // high endpoint of 95% confidence interval
        return -9999.9999; //FIXME
    }

    public static void main(String[] args) {
        // Not required for the API, but useful to test if
        // your code is doing reasonable things
        PercolationStats st = new PercolationStats(10,10);
        // ...
    }
}