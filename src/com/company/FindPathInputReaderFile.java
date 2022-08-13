package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FindPathInputReaderFile extends AbstractFindPathInputReader {
    //private BufferedReader bufReader;
    private String file;
    private int rows;
    private int columns;
    private char maze[];
    private int start;
    private int endPos;

    public FindPathInputReaderFile(String paFile){
        file = paFile;
    }

    public char[] getInput() throws IOException {
        BufferedReader bufReader = new BufferedReader(new FileReader(file));

        String line = bufReader.readLine();
        columns = line.length();
        while (line != null) {
            rows++;
            line = bufReader.readLine();
        }
        bufReader.close();

        BufferedReader bufReader2 = new BufferedReader(new FileReader(file));
        maze = new char[columns*rows];
        String line2 = bufReader2.readLine();
        for (int i = 0; i < line2.length(); i++) {
            maze[i] = line2.charAt(i);
        }
        int x = line2.length();
        while (line2 != null) {
            line2 = bufReader2.readLine();
            int y = 0;
            int z = x;
            if (line2 != null) {
                for (x = x; x < line2.length() + z; x++) {
                    System.out.println("X: " + x + " Y: " + y + " Line length: " + line2.length() + " Z: " + z);
                    maze[x] = line2.charAt(y);
                    if (maze[x] == 'S')
                        start = x;
                    if (maze[x] == 'X')
                        endPos = x;

                    y++;
                }
            }
        }
        bufReader2.close();

        return maze;
    }

    public void printInput() {

    }

    public int getRows() {return rows;}
    public int getColumns() {return columns;}
    public int getStart() {return start;}
    public int getEndPos() {return endPos;}
}

