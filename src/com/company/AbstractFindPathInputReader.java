package com.company;

import java.io.IOException;

public abstract class AbstractFindPathInputReader {
    abstract public char[][] getInput() throws IOException;
    abstract public void printInput();
}
