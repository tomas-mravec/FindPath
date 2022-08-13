package com.company;

import java.util.ArrayList;

public class FindPathAlgorithm implements Runnable{

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


    public enum InputType {
        KEYBOARD,
        FILE
    }
    private InputType type;
    public FindPathAlgorithm(char[] paMaze, int paRows, int paColumns, int paStart, int paEndPos, InputType paType) {
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
         type = paType;
    }

    private void showMaze() {
        for (int i = 0; i < maze.length; i++) {
            //System.out.print(maze[i]);
        }
    }

    private void showShortestPaths() {
        for (int i = 0; i < d.length; i++) {
            //System.out.println(d[i]);
        }
    }

    @Override
    public void run() {
        startAlgorithm();
    }
    public String startAlgorithm() {
        setUp();
        while(!checkAllVisited()) {
            //showMaze();
            r = checkCurrentVertex();
            //showShortestPaths();
            //System.out.println("Current vertex: " + r);
            checkNeighbours();
        }
        return findShortestPath();
    }

    private String findShortestPath() {
        String shortestPath = "";
        int pathPosition = endPos;
        System.out.println("Looking for shortest path");
        if(d[endPos] == Integer.MAX_VALUE) {
            System.out.println("Error, no direct path between Start and End");
            return shortestPath;
        } else {

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
            return output(shortestPath);
        }
    }

    private String output (String paPath) {
        paPath = new StringBuilder(paPath).reverse().toString();
        String formated = String.valueOf(paPath.charAt(0));
        for (int i = 1; i < paPath.length(); i++) {
            formated += ", " + String.valueOf(paPath.charAt(i));
        }
        String inputType = "";
        if (type == InputType.KEYBOARD)
            inputType = "keyboard";
        else
            inputType = "file";

        System.out.println("Output from: " + inputType + " input");
        System.out.println(formated);
        return formated;
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
        //check neighbours if shortest distance is lower if yes update and set previous vertex

        //up neighbour
        int checkedVertex = 0;
        if(r - columns > -1  && !visited[r - columns]) {
            checkedVertex = r - columns;
            int dChecked = d[checkedVertex];
            if(d[r] != Integer.MAX_VALUE) {
                if (d[checkedVertex] > d[r] + 1) {
                    d[checkedVertex] = d[r] + 1;
                    x[checkedVertex] = r;
                    //System.out.println("UP Neighbour of r: " + r + " is relaxed to: " + (d[r] + 1) + " from " + dChecked);
                }
            }
        }
        //right neighbour
        if((r + 1) % columns != 0  && !visited[r + 1]) {
            checkedVertex = r + 1;
            int dChecked = d[checkedVertex];
            if(d[r] != Integer.MAX_VALUE) {
                if (d[checkedVertex] > d[r] + 1) {
                    d[checkedVertex] = d[r] + 1;
                    x[checkedVertex] = r;
                    //System.out.println("R Neighbour of r: " + r + " is relaxed to: " + (d[r] + 1) + " from " + dChecked);
                }
            }
        }
        //down neighbour
            if(r + columns < size && !visited[r + columns]) {
                checkedVertex = r + columns;
                int dChecked = d[checkedVertex];
                if(d[r] != Integer.MAX_VALUE) {
                    if (d[checkedVertex] > d[r] + 1) {
                        d[checkedVertex] = d[r] + 1;
                        x[checkedVertex] = r;
                        //System.out.println(" D Neighbour of r: " + r + " is relaxed to: " + (d[r] + 1) + " from " + dChecked);
                    }
                }
            }
        //left neighbour
                if(r % columns != 0  && r - 1  != '#' && !visited[r -1]) {
                    checkedVertex = r - 1;
                    int dChecked = d[checkedVertex];
                    if(d[r] != Integer.MAX_VALUE) {
                        if (d[checkedVertex] > d[r] + 1) {
                            d[checkedVertex] = d[r] + 1;
                            x[checkedVertex] = r;
                           //System.out.println("L Neighbour of r: " + r + " is relaxed to: " + (d[r] + 1) + " from " + dChecked);
                        }
                    }
                }
        visited[r] = true;
    }

    private int checkCurrentVertex() {
        //finding vertex with lowest d which was not visited yet
        int lowest = Integer.MAX_VALUE;
        int vertex = -1;
        for (int i = 0; i < size; i++) {
            if (d[i] <= lowest && !visited[i]) {
                //System.out.println("D of " + i + " is " + d[i]);
                lowest = d[i];
                vertex = i;
                //System.out.println("New lowest vertex found: " + vertex + " with d of: " + lowest);
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
