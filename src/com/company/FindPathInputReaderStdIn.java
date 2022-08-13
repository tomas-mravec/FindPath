package com.company;

import java.util.Scanner;

public class FindPathInputReaderStdIn extends AbstractFindPathInputReader{

    private Scanner reader;
    private int rows;
    private int columns;
    private  char maze[];
    private int start;
    private int endPos;


    FindPathInputReaderStdIn() {
        /*reader = new BufferedReader(
                new InputStreamReader(System.in));*/
        reader = new Scanner(System.in);
        System.out.println("Number of lines: ");
        rows = reader.nextInt();
        System.out.println("Number of columns: ");
        columns = reader.nextInt();
        maze = new char[rows * columns];
    }

    public char[] getInput() {
        reader = new Scanner(System.in);
        System.out.println("Lines je: " + rows);

        int x = 0;
        for (int i = 0; i < rows; i++) {
            String line = reader.nextLine();
            int y = 0;
            int z = x;
            for (x=x ;x < line.length() + z; x++) {
                maze[x] = line.charAt(y);
                if(maze[x] == 'S')
                    start = x;
                if(maze[x] == 'X')
                    endPos = x;

                y++;
            }
        }
        return maze;
    }

    public void printInput() {
        for (int i = 0; i < maze.length; i++) {
            System.out.print(maze[i]);
        }
    }

    public int getRows() {return rows;}
    public int getColumns() {return columns;}
    public int getStart() {return start;}
    public int getEndPos() {return endPos;}
}
