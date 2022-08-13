package com.company;


//Implementing by using Dijsktra shortest path algorithm
public class FindPathAlgorithm implements Runnable{

    private char[] maze;
    private int r;               //current vertex
    private boolean[] visited;    //true if visited
    private int[] d;              //shortest distance from start S
    private int[] x;              //previous vertex
    private final int size;
    private final int columns;
    private final int rows;
    private final int endPos;
    private final int start;


    public enum InputType {
        KEYBOARD,
        FILE
    }
    private InputType input;

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
         input = paType;
    }

    @Override
    public void run() {
        startAlgorithm();
    }

    //main cycle of the algorithm
    public String startAlgorithm() {
        setUp();
        while(!checkAllVisited()) {
            r = checkCurrentVertex();
            checkNeighbours();
        }
        return findShortestPath();
    }

    //finds shortest path from S to X by going reverse
    private String findShortestPath() {
        String shortestPath = "";
        int pathPosition = endPos;
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

    //formating output and putting it on console
    private String output (String paPath) {
        paPath = new StringBuilder(paPath).reverse().toString();
        String formated = String.valueOf(paPath.charAt(0));
        for (int i = 1; i < paPath.length(); i++) {
            formated += ", " + String.valueOf(paPath.charAt(i));
        }
        String inputType = "";
        if (input == InputType.KEYBOARD)
            inputType = "keyboard";
        else
            inputType = "file";

        System.out.println("Output from: " + inputType + " input -> " + formated);
        return formated;
    }

    //check if all vertices were visited
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

    //check neighbours if shortest distance is lower if yes update and set previous vertex
    private void checkNeighbours() {

        //up neighbour
        int checkedVertex = 0;
        if(r - columns > -1  && !visited[r - columns]) {
            checkedVertex = r - columns;
            int dChecked = d[checkedVertex];
            if(d[r] != Integer.MAX_VALUE) {
                if (d[checkedVertex] > d[r] + 1) {
                    d[checkedVertex] = d[r] + 1;
                    x[checkedVertex] = r;
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
                        }
                    }
                }
        visited[r] = true;
    }

    //finding vertex with lowest d which was not visited yet
    private int checkCurrentVertex() {

        int lowest = Integer.MAX_VALUE;
        int vertex = -1;
        for (int i = 0; i < size; i++) {
            if (d[i] <= lowest && !visited[i]) {
                lowest = d[i];
                vertex = i;
            }
        }
        return vertex;
    }

    //at the beginning all distances from start are max value int, starting distance is 0
    private void setUp() {
        boolean startFound = false;
        boolean endFound = false;
        for (int i = 0; i < size; i++) {
            d[i] = Integer.MAX_VALUE;
            if(maze[i] == '#')
                visited[i] = true;
            if(maze[i] == 'S')
                startFound = true;
            if(maze[i] == 'X')
                endFound = true;
            if(maze[i] != '.' && maze[i] != 'S' && maze[i] != 'X' && maze[i] != '#') {
                System.out.println("Wrong character input from file");
                System.exit(0);
            }
        }
        if (!endFound || !startFound) {
            System.out.println("Start or End of the maze was not found check your inputs");
            System.exit(0);
        }
        d[r] = 0;

    }

}
