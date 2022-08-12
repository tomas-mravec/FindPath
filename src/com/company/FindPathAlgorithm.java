package com.company;

public class FindPathAlgorithm {

    /*private char[][] maze;
    private int[][] r;              //current vertex
    private boolean[][] visited;    //true if visited
    private int[][] d;              //shortest distance from start S
    private int[][][] x;*/


    private char[] maze;
    private int r;              //current vertex
    private boolean[] visited;    //true if visited
    private int[] d;              //shortest distance from start S
    private int[] x;              //previous vertex
    private int size;
    private int columns;
    private int rows;

    FindPathAlgorithm(char[] paMaze, int paRows, int paColumns, int paStart) {
         maze = paMaze;
         columns = paColumns;
         rows = paRows;
         size = paRows * paColumns;
         r = paStart;
         d = new int[size];
         x = new int[size];
         visited = new boolean[size];
         setUp();
         algorithm();
    }

    private void algorithm() {
        r = checkCurrentVertex();
        checkNeighbours();
    }

    private void checkNeighbours() {
        //check neighbours if shortest distance is lower relax and set previous vertex

        //up neighbour
        int checkedVertex = 0;
        if(r - columns > -1 && r - columns != '#') {
            checkedVertex = r - columns;
            if( d[checkedVertex] < d[r] + 1) {
                d[checkedVertex] = d[r] + 1;
                x[checkedVertex] = r;
            }
        }
        //right neighbour
        if((r + 1) % columns != 0  && r + 1  != '#') {
            checkedVertex = r + 1;
            if (d[checkedVertex] < d[r] + 1) {
                d[checkedVertex] = d[r] + 1;
                x[checkedVertex] = r;
            }
        }
        //down neighbour
            if(r + columns < size && r + columns  != '#') {
                checkedVertex = r + columns;
                if (d[checkedVertex] < d[r] + 1) {
                    d[checkedVertex] = d[r] + 1;
                    x[checkedVertex] = r;
                }
            }
        //left neighbour
                if(r % columns != 0  && r - 1  != '#') {
                    checkedVertex = r - 1;
                    if (d[checkedVertex] < d[r] + 1) {
                        d[checkedVertex] = d[r] + 1;
                        x[checkedVertex] = r;
                    }
                }
        visited[r] = true;
    }

    private int checkCurrentVertex() {
        int lowest = Integer.MAX_VALUE;
        for (int i = 0; i < size; i++) {
            if (d[i] < lowest && visited[i] == false && maze[i] != '#')
                lowest = i;
        }
        return lowest;
    }

    private void setUp() {
        for (int i = 0; i < size; i++) {
            d[i] = Integer.MAX_VALUE;
        }
        d[r] = 0;

    }

}
