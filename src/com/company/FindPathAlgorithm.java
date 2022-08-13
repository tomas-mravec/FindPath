package com.company;

import java.util.ArrayList;

public class FindPathAlgorithm {

    /*private char[][] maze;
    private int[][] r;              //current vertex
    private boolean[][] visited;    //true if visited
    private int[][] d;              //shortest distance from start S
    private int[][][] x;*/

    //Using Dijsktra shortest path algorithm

    private char[] maze;
    private int r;              //current vertex
    private boolean[] visited;    //true if visited
    private int[] d;              //shortest distance from start S
    private int[] x;              //previous vertex
    private int size;
    private int columns;
    private int rows;
    private int endPos;
    private int start;

    FindPathAlgorithm(char[] paMaze, int paRows, int paColumns, int paStart, int paEndPos) {
         maze = paMaze;
         columns = paColumns;
         rows = paRows;
         size = paRows * paColumns;
         endPos = paEndPos;
         r = paStart;
         start = paStart;
         d = new int[size];
         x = new int[size];
         visited = new boolean[size];
    }

    private void showMaze() {
        for (int i = 0; i < maze.length; i++) {
            System.out.print(maze[i]);
        }
    }

    private void showShortestPaths() {
        for (int i = 0; i < d.length; i++) {
            System.out.println(d[i]);
        }
    }

    public void startAlgorithm() {
        setUp();
        //int i = 0;
        while(!checkAllVisited()) {
            //i++;
            showMaze();
            r = checkCurrentVertex();
            showShortestPaths();
            System.out.println("Current vertex: " + r);
            checkNeighbours();
        }
        findShortestPath();

        //este zistenie ze nema riesenie, subory a unittest
    }

    private void findShortestPath() {
        String shortestPath = "";
        int pathPosition = endPos;
        System.out.println("Looking for shortest path");
        //check if up
        while (pathPosition != start) {
            if (x[pathPosition] == pathPosition - columns) {
                shortestPath += "d";
                pathPosition = pathPosition - columns;
            }

            //check if right
            else if (x[pathPosition] == pathPosition + 1) {
                shortestPath += "l";
                pathPosition = pathPosition + 1;
            }

            //check down
            else if (x[pathPosition] == pathPosition + columns) {
                shortestPath += "u";
                pathPosition = pathPosition + columns;
            }
            //check if left
            else if (x[pathPosition] == pathPosition - 1) {
                shortestPath += "r";
                pathPosition = pathPosition - 1;
            }
        }
        System.out.println(shortestPath);
    }

    private boolean checkAllVisited() {
        boolean allVisited = true;
        for (int i = 0; i < size; i++) {
            if (visited[i] == false) {
                allVisited = false;
                break;
            }

        }
        return allVisited;
    }

    private void checkNeighbours() {
        //check neighbours if shortest distance is lower relax and set previous vertex

        //up neighbour
        int checkedVertex = 0;
        if(r - columns > -1 && r - columns != '#' && !visited[r - columns]) {
            checkedVertex = r - columns;
            int dChecked = d[checkedVertex];
            if( d[checkedVertex] > d[r] + 1) {
                d[checkedVertex] = d[r] + 1;
                x[checkedVertex] = r;
                System.out.println("UP Neighbour of r: " + r + " is relaxed to: " + (d[r] + 1) + " from " + dChecked);
            }
        }
        //right neighbour
        if((r + 1) % columns != 0  && r + 1  != '#' && !visited[r + 1]) {
            checkedVertex = r + 1;
            int dChecked = d[checkedVertex];
            if (d[checkedVertex] > d[r] + 1) {
                d[checkedVertex] = d[r] + 1;
                x[checkedVertex] = r;
                System.out.println("R Neighbour of r: " + r + " is relaxed to: " + (d[r] + 1) + " from " + dChecked);
            }
        }
        //down neighbour
            if(r + columns < size && r + columns  != '#' && !visited[r + columns]) {
                checkedVertex = r + columns;
                int dChecked = d[checkedVertex];
                if (d[checkedVertex] > d[r] + 1) {
                    d[checkedVertex] = d[r] + 1;
                    x[checkedVertex] = r;
                    System.out.println(" D Neighbour of r: " + r + " is relaxed to: " + (d[r] + 1) + " from " + dChecked);
                }
            }
        //left neighbour
                if(r % columns != 0  && r - 1  != '#' && !visited[r -1]) {
                    checkedVertex = r - 1;
                    int dChecked = d[checkedVertex];
                    if (d[checkedVertex] > d[r] + 1) {
                        d[checkedVertex] = d[r] + 1;
                        x[checkedVertex] = r;
                        System.out.println("L Neighbour of r: " + r + " is relaxed to: " + (d[r] + 1) + " from " + dChecked);
                    }
                }
        visited[r] = true;
    }

    private int checkCurrentVertex() {
        int lowest = Integer.MAX_VALUE;
        int vertex = -1;
        for (int i = 0; i < size; i++) {
            if (d[i] <= lowest && !visited[i]) {
                System.out.println("D of " + i + " is " + d[i]);
                lowest = d[i];
                vertex = i;
                System.out.println("New lowest vertex found: " + vertex + " with d of: " + lowest);
            }
        }
        return vertex;
    }

    private void setUp() {
        for (int i = 0; i < size; i++) {
            d[i] = Integer.MAX_VALUE;
            if(maze[i] == '#')
                visited[i] = true;
        }
        d[r] = 0;

    }

}
