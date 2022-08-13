package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FindPathInputReaderFile extends AbstractFindPathInputReader {
    private BufferedReader bufReader;

    FindPathInputReaderFile(){}

    public char[] getInput() throws IOException {
        BufferedReader bufReader = new BufferedReader(new FileReader("dictionary.txt"));
        ArrayList<String> dictionary = new ArrayList<>();

        String line = bufReader.readLine();
        while (line != null) {
            dictionary.add(line);
            line = bufReader.readLine();
        }

        bufReader.close();
        return new char[1];
    }

    public void printInput() {

    }

    public int getRows() {return 0;}
    public int getColumns() {return 0;}
    public int getStart() {return 0;}
    public int getEndPos() {return 0;}
}

