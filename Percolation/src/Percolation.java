/******************************************************************************
 *  Name:    Kai Lu
 *  NetID:   kail
 *  Precept: P02A
 *
 *  Partner Name:    N/A
 *  Partner NetID:   N/A
 *  Partner Precept: N/A
 *
 *  Description:  Modeling Percolation.
 *
 ******************************************************************************/

//import edu.princeton.cs.algs4.QuickFindUF;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

/**
 * Created by Kai Lu on 9/19/2015.
 */

public class Percolation {
    private boolean[][] grid; //the grid is a grid of what's open, sized [row][col]
    private int opensites, size;
    private boolean percolates;
    private WeightedQuickUnionUF unionFind;
    private boolean[] isConnectedToStart, isConnectedToEnd;

    public Percolation(int N) {
        if (N <= 0) {
            throw new java.lang.IllegalArgumentException("Please enter a positive " +
                    "integer for the size of the grid.");
        }
        grid = new boolean[N][N];
        isConnectedToStart = new boolean[N * N];
        isConnectedToEnd = new boolean[N * N];
        opensites = 0;
        percolates = false;
        size = N;
        unionFind = new WeightedQuickUnionUF(N * N);

    } //create N-by-N grid, with all sites initially blocked


    public void open(int row, int col) {
        if (row < 0 || col < 0 || row >= size || col >= size) {
            throw new java.lang.IndexOutOfBoundsException("Attempting to open a" +
                    " gate which is outside the grid.");
        }
        if (!grid[row][col]) {
            grid[row][col] = true;
            opensites++;
            union(row, col);
        }
    } // open the site (row, col) if it is not open already

    public boolean isOpen(int row, int col) { // is the site (row, col) open?
        if (row < 0 || col < 0 || row >= size || col >= size) {
            throw new java.lang.IndexOutOfBoundsException("Attempting to access" +
                    " a gate which is outside the grid.");
        }
        return grid[row][col];
    }

    public boolean isFull(int row, int col) { // is the site (row, col) full?
        if (row < 0 || col < 0 || row >= size || col >= size) {
            throw new java.lang.IndexOutOfBoundsException("Attempting to access" +
                    " a gate which is outside the grid.");
        }
        return isConnectedToStart[unionFind.find(row * size + col)];
    }

    public int numberOfOpenSites() {   // number of open sites
        return opensites;
    }

    public boolean percolates() {               // does the system percolate?
        return percolates;
    }

    private void union(int row, int col) {
        boolean ICTS = false, ICTE = false;

        if (row > 0) {
            if (grid[row - 1][col]) {
                if (isConnectedToStart[unionFind.find((row - 1) * size + col)]) {
                    ICTS = true;
                }
                if (isConnectedToEnd[unionFind.find((row - 1) * size + col)]) {
                    ICTE = true;
                }
                unionFind.union(row * size + col, (row - 1) * size + col);
            }
        } else {
            ICTS = true;
        }
        if (col > 0) {
            if (grid[row][col - 1]) {
                if (isConnectedToStart[unionFind.find(row * size + col - 1)]) {
                    ICTS = true;
                }
                if (isConnectedToEnd[unionFind.find(row * size + col - 1)]) {
                    ICTE = true;
                }
                unionFind.union(row * size + col, row * size + col - 1);
            }
        }
        if (row < (size - 1)) {
            if (grid[row + 1][col]) {
                if (isConnectedToStart[unionFind.find((row + 1) * size + col)]) {
                    ICTS = true;
                }
                if (isConnectedToEnd[unionFind.find((row + 1) * size + col)]) {
                    ICTE = true;
                }
                unionFind.union(row * size + col, (row + 1) * size + col);
            }
        } else {
            ICTE = true;
        }
        if (col < (size - 1)) {
            if (grid[row][col + 1]) {
                if (isConnectedToStart[unionFind.find(row * size + col + 1)]) {
                    ICTS = true;
                }
                if (isConnectedToEnd[unionFind.find(row * size + col + 1)]) {
                    ICTE = true;
                }
                unionFind.union(row * size + col, row * size + col + 1);
            }
        }

        int index = unionFind.find(row * size + col);
        isConnectedToStart[index] = ICTS;
        isConnectedToEnd[index] = ICTE;
        if (ICTS && ICTE) {
            percolates = true;
        }
    }
}
