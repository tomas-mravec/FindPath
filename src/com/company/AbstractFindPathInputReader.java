package com.company;

import java.io.IOException;

public abstract class AbstractFindPathInputReader {
    abstract public char[] getInput() throws IOException;
    abstract public void printInput();
    abstract public int getRows();
    abstract public int getColumns();
    abstract public int getStart();
    abstract public int getEndPos();
}
