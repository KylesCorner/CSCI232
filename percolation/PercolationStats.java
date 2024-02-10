/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Last modified:     October 16, 1842
 **************************************************************************** */
import javax.xml.stream.events.StartDocument;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;
import edu.princeton.cs.algs4.Stopwatch;

public class PercolationStats {
    int number_of_trials;
    double[] trial_results;
    int N;
    int T;


    public PercolationStats(int N, int T) {
        boolean grid_underflow = N <= 0;
        boolean trial_underflow = T <= 0;
        boolean general_underflow = grid_underflow || trial_underflow;
        if (general_underflow){
            throw new IllegalArgumentException("Grid size and trials must be above 0.");
        }

        this.N = N;
        this.T = T;
        this.trial_results = new double[this.T];


        for(int trial = 0; trial < this.T; trial++){
            Percolation P = new Percolation(this.N);

            while (!P.percolates()) {
                int row = StdRandom.uniform(0, this.N);
                int col = StdRandom.uniform(0, this.N);
                P.open(row, col);
                
            }

            int openSites = P.numberOfOpenSites();
            double result = (double) openSites / (this.N * this.N);
            this.trial_results[trial] = result;
        }



        
        // perform T independent experiments on an N-by-N grid
    }
    public double mean() {
        // sample mean of percolation threshold
        return StdStats.mean(this.trial_results);
    }
    public double stddev() {
        // sample standard deviation of percolation threshold
        return StdStats.stddev(this.trial_results);
    }
    public double confidenceLow() {
        // low  endpoint of 95% confidence interval
        double answer = this.mean() - (1.96 * this.stddev()) / Math.sqrt(this.T);
        return answer;
    }
    public double confidenceHigh() {
        // high endpoint of 95% confidence interval
        double answer = this.mean() + (1.96 * this.stddev()) / Math.sqrt(this.T);
        return answer;
    }


    // -----------------------------
    // Unit Tests
    // -----------------------------

    public static void singleton_test(int N, int T){

        Stopwatch watch = new Stopwatch();
        PercolationStats st = new PercolationStats(N, T);
        double time = watch.elapsedTime();

        String confidence = st.confidenceLow() + " / " + st.confidenceHigh();
        StdOut.println("N = " + N);
        StdOut.println("T = " + T);
        StdOut.println("Mean = " + st.mean());
        StdOut.println("Standard Dev = " + st.stddev());
        StdOut.println("95% confidence interval = " + confidence);
        StdOut.println("Elapsed Time = " + time + " seconds");
        StdOut.println();

    }

    public static void doubleing_time_of_N(int N, int T, int D){
        StdOut.println("---------Double time of N----------");
        int deltaN = N;

        for(int i = 1; i <= D; i++ ){
            singleton_test(deltaN, T);
            deltaN *= 2;
        }
    }
    public static void doubleing_time_of_T(int N, int T, int D){
        StdOut.println("---------Double time of T----------");
        int deltaT = T;
        for(int i = 1; i <= D; i++ ){
            singleton_test(N, deltaT);
            deltaT*=2;
        }

    }


    public static void main(String[] args) {
        // Not required for the API, but useful to test if
        // your code is doing reasonable things
        int N;
        int T;
        int D;

        if(args.length >= 3){
            N = Integer.parseInt(args[0]);
            T = Integer.parseInt(args[1]);
            D = Integer.parseInt(args[2]);
        }else{
            N = 10;
            T = 10;
            D = 3;
        }

        doubleing_time_of_T(N, T, D);
        doubleing_time_of_N(N, T, D);
        


        
    }
}