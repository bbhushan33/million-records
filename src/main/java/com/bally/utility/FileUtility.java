package com.bally.utility;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class FileUtility {

    //Create a file
    public static PrintWriter createFile(String fileName) throws IOException {
        PrintWriter pw = new PrintWriter(Files.newBufferedWriter(Paths.get(fileName)));
        return pw;
    }

    //Read a file
    public static Stream fetchRecordsFromFile(String fileName) throws IOException {
        Stream<String> stream = Files.lines(Paths.get(fileName));
        return stream;
    }
}
