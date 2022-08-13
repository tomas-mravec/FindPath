package com.company;

import java.util.Scanner;

public class FindPathInputReaderStdIn extends AbstractFindPathInputReader{

    private Scanner reader;
    private int rows;
    private int columns;
    private char maze[];
    private int start;
    private int endPos;


    FindPathInputReaderStdIn() {
        reader = new Scanner(System.in);
        System.out.println("Number of rows: ");
        rows = reader.nextInt();
        System.out.println("Number of columns: ");
        columns = reader.nextInt();
        System.out.println("Enter the maze row by row: ");
        maze = new char[rows * columns];
    }

    public char[] getInput() {
        reader = new Scanner(System.in);
        int x = 0;
        for (int i = 0; i < rows; i++) {
            String line = reader.nextLine();
            int y = 0;
            int z = x;
            for (;x < line.length() + z; x++) {
                maze[x] = line.charAt(y);
                if(maze[x] != '.' && maze[x] != 'S' && maze[x] != 'X' && maze[x] != '#') {
                    System.out.println("Wrong character input from keyboard");
                    System.exit(0);
                }
                if (line.length() != columns) {
                    System.out.println("Wrong number of characters in a column from keyboard");
                    System.exit(0);
                }
                if(maze[x] == 'S')
                    start = x;
                if(maze[x] == 'X')
                    endPos = x;

                y++;
            }
        }
        return maze;
    }

    public int getRows() {return rows;}
    public int getColumns() {return columns;}
    public int getStart() {return start;}
    public int getEndPos() {return endPos;}
}
