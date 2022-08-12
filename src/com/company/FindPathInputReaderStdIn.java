package com.company;

import java.util.Scanner;

public class FindPathInputReaderStdIn extends AbstractFindPathInputReader{

    private Scanner reader;
    private int rows;
    private int columns;
    private  char maze[];
    private int start;

    FindPathInputReaderStdIn() {
        /*reader = new BufferedReader(
                new InputStreamReader(System.in));*/
        reader = new Scanner(System.in);
        System.out.println("Number of lines: ");
        rows = reader.nextInt();
        System.out.println("Number of columns: ");
        columns = reader.nextInt();
        maze = new char[rows * columns];
        /*maze = new char[2][2];
        maze[0][0] = 'a';
        maze[0][1] = 'b';
        maze[1][0] = 'c';
        maze[1][1] = 'd';*/
    }

    public char[] getInput() {
        reader = new Scanner(System.in);
        System.out.println("Lines je: " + rows);
        //int y = 0;
        int x = 0;
        for (int i = 0; i < rows; i++) {
            String line = reader.nextLine();
            int y = 0;
            int z = x;
            for (x=x ;x < line.length() + z; x++) {
                System.out.println("X: " + x + " Y: " + y + " Line length: " + line.length() + " Z: " + z);
                maze[x] = line.charAt(y);
                if(maze[x] == 'S')
                    start = x;
                y++;
            }
            //x += line.length();
            //System.out.println(name);
            //y++;
        }
        return maze;
    }

    public void printInput() {
        /*for (int i = 0; i < lines; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(maze[i][j]);
                if (j == columns-1)
                    System.out.println("");
            }
        }
        System.out.println(maze[0][2]);*/

        for (int i = 0; i < maze.length; i++) {
            System.out.print(maze[i]);
        }
    }

    public int getRows() {return rows;}
    public int getColumns() {return columns;}
    public int getStart() {return start;}
}
