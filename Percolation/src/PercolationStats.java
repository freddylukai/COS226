/******************************************************************************
 *  Name:    Kai Lu
 *  NetID:   kail
 *  Precept: P02A
 *
 *  Partner Name:    N/A
 *  Partner NetID:   N/A
 *  Partner Precept: N/A
 *
 *  Description:  Modeling Percolation statistics.
 *
 ******************************************************************************/

import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;
//import edu.princeton.cs.algs4.Stopwatch;

/**
 * Created by Kai Lu on 9/19/2015.
 */
public class PercolationStats {
    private double[] space;

    public PercolationStats(int N, int T) {
        space = new double[T];
        if (N <= 0) {
            throw new java.lang.IllegalArgumentException("Please enter a positive" +
                    " integer for the size of the grid.");
        }
        if (T <= 0) {
            throw new java.lang.IllegalArgumentException("Please enter a positive" +
                    " integer for the number of experiments.");
        }

        //Stopwatch timer = new Stopwatch();
        for (int i = 0; i < T; i++) {
            Percolation current = new Percolation(N);
            while (!current.percolates()) {
                int row = StdRandom.uniform(0, N);
                int col = StdRandom.uniform(0, N);
                current.open(row, col);
            }
            space[i] = (current.numberOfOpenSites() + 0.0) / (N * N);
        }
        //System.out.println("Time elapsed    : " + timer.elapsedTime());
    }   // perform T independent experiments on an N-by-N grid


    public double mean() {
        return StdStats.mean(space);
    }                   // sample mean of percolation threshold

    public double stddev() {
        return StdStats.stddev(space);
    }  // sample standard deviation of percolation threshold

    public double confidenceLow() {
        return mean() - (1.96 * stddev()) / Math.sqrt(space.length);
    }          // low  endpoint of 95% confidence interval

    public double confidenceHigh() {
        return mean() + (1.96 * stddev()) / Math.sqrt(space.length);
    }          // high endpoint of 95% confidence interval

/*    public static void main(String[] args){
        int N = Integer.parseInt(args[0]);
        int T = Integer.parseInt(args[1]);
        PercolationStats ps = new PercolationStats(N, T);
        System.out.println("Mean: " + ps.mean());
        System.out.println("Stddev: " + ps.stddev());

    }
*/
}