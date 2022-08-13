package test;

import com.company.FindPathAlgorithm;
import com.company.FindPathInputReaderFile;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class FindPathAlgorithmTest {

    @Test
    void shortestPathShouldExists() throws IOException {
        FindPathInputReaderFile fpirfil = new FindPathInputReaderFile("test_exists.txt");
        FindPathAlgorithm fpalg = new FindPathAlgorithm(fpirfil.getInput(), fpirfil.getRows(), fpirfil.getColumns(), fpirfil.getStart(), fpirfil.getEndPos());
        assertEquals("d, d, d, r, d, d, r, r",fpalg.startAlgorithm());
    }

    @Test
    void shortestPathShouldNOTExists() throws IOException {
        FindPathInputReaderFile fpirfil = new FindPathInputReaderFile("test_blocked.txt");
        FindPathAlgorithm fpalg = new FindPathAlgorithm(fpirfil.getInput(), fpirfil.getRows(), fpirfil.getColumns(), fpirfil.getStart(), fpirfil.getEndPos());
        assertEquals("",fpalg.startAlgorithm());
    }
}