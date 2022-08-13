package com.company;

import java.io.IOException;
import java.util.Scanner;

public class FindPath {

    public static void main(String[] args) throws IOException {

        Scanner reader = new Scanner(System.in);
        System.out.println("Press 1 if you want input from keyboard, press 2 if you want input from file(maze.txt in" +
                "project files), press 3 if you want both: ");
        int inputFrom = reader.nextInt();
        boolean choosing = true;
        while(choosing) {
            if (inputFrom == 1) {
                choosing = false;
                FindPathInputReaderStdIn fpirstd = new FindPathInputReaderStdIn();
                FindPathAlgorithm fpalg = new FindPathAlgorithm(fpirstd.getInput(), fpirstd.getRows(), fpirstd.getColumns(),
                        fpirstd.getStart(), fpirstd.getEndPos(), FindPathAlgorithm.InputType.KEYBOARD);
                Thread thread = new Thread(fpalg);
                thread.start();
            } else if (inputFrom == 2) {
                choosing = false;
                FindPathInputReaderFile fpirfil = new FindPathInputReaderFile("maze.txt");
                FindPathAlgorithm fpalg = new FindPathAlgorithm(fpirfil.getInput(), fpirfil.getRows(), fpirfil.getColumns(),
                        fpirfil.getStart(), fpirfil.getEndPos(), FindPathAlgorithm.InputType.FILE);
                Thread thread = new Thread(fpalg);
                thread.start();
            } else if (inputFrom == 3) {
                FindPathInputReaderStdIn fpirstd = new FindPathInputReaderStdIn();
                FindPathAlgorithm fpalg = new FindPathAlgorithm(fpirstd.getInput(), fpirstd.getRows(), fpirstd.getColumns(),
                        fpirstd.getStart(), fpirstd.getEndPos(), FindPathAlgorithm.InputType.KEYBOARD);
                Thread thread1 = new Thread(fpalg);
                thread1.start();
                FindPathInputReaderFile fpirfil = new FindPathInputReaderFile("maze.txt");
                FindPathAlgorithm fpalg2 = new FindPathAlgorithm(fpirfil.getInput(), fpirfil.getRows(), fpirfil.getColumns(),
                        fpirfil.getStart(), fpirfil.getEndPos(), FindPathAlgorithm.InputType.FILE);
                Thread thread2 = new Thread(fpalg2);
                thread2.start();
                choosing = false;
            } else
                System.out.println("Choose from numbers 1-3");
        }
        /*//FindPathInputReaderStdIn fpirstd = new FindPathInputReaderStdIn();
        FindPathInputReaderFile fpirfil = new FindPathInputReaderFile("test_blocked.txt");
        //FindPathAlgorithm fpalg = new FindPathAlgorithm(fpirstd.getInput(), fpirstd.getRows(), fpirstd.getColumns(), fpirstd.getStart(), fpirstd.getEndPos());
        FindPathAlgorithm fpalg = new FindPathAlgorithm(fpirfil.getInput(), fpirfil.getRows(), fpirfil.getColumns(), fpirfil.getStart(), fpirfil.getEndPos());
        fpalg.startAlgorithm();*/


        //fpirstd.printInput();

    }
}
