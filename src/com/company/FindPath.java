package com.company;

import java.io.IOException;

public class FindPath {

    public static void main(String[] args) throws IOException {

        FindPathInputReaderStdIn a = new FindPathInputReaderStdIn();
        FindPathAlgorithm b = new FindPathAlgorithm(a.getInput());
        a.printInput();

    }
}
