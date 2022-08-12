package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class FindPathInputReaderStdIn extends AbstractFindPathInputReader{

    private Scanner reader;
    private int lines;
    private int columns;
    private  char maze[][];

    FindPathInputReaderStdIn() {
        /*reader = new BufferedReader(
                new InputStreamReader(System.in));*/
        reader = new Scanner(System.in);
        System.out.println("Number of lines: ");
        lines = reader.nextInt();
        System.out.println("Number of columns: ");
        columns = reader.nextInt();
        maze = new char[lines][columns];
        /*maze = new char[2][2];
        maze[0][0] = 'a';
        maze[0][1] = 'b';
        maze[1][0] = 'c';
        maze[1][1] = 'd';*/
    }

    public char[][] getInput() {
        reader = new Scanner(System.in);
       System.out.println("Lines je: " + lines);
        int y = 0;
        for (int i = 0; i < lines; i++) {
            String line = reader.nextLine();

            for (int x = 0; x < line.length(); x++) {
                maze[y][x] = line.charAt(x);
                //System.out.println(maze[x][y]);
            }

            //System.out.println(name);
            y++;
        }
        return maze;
    }

    public void printInput() {
        for (int i = 0; i < lines; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(maze[i][j]);
                if (j == columns-1)
                    System.out.println("");
            }
        }
        System.out.println(maze[0][2]);
    }

}
