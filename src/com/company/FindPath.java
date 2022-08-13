package com.company;

import java.io.IOException;

public class FindPath {

    public static void main(String[] args) throws IOException {

        //FindPathInputReaderStdIn fpirstd = new FindPathInputReaderStdIn();
        FindPathInputReaderFile fpirfil = new FindPathInputReaderFile("test_blocked.txt");
        //FindPathAlgorithm fpalg = new FindPathAlgorithm(fpirstd.getInput(), fpirstd.getRows(), fpirstd.getColumns(), fpirstd.getStart(), fpirstd.getEndPos());
        FindPathAlgorithm fpalg = new FindPathAlgorithm(fpirfil.getInput(), fpirfil.getRows(), fpirfil.getColumns(), fpirfil.getStart(), fpirfil.getEndPos());
        fpalg.startAlgorithm();


        //fpirstd.printInput();

    }
}
