package com.bally.service;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public interface RandomNumberService {

    //Generate Random Million Numbers in file
    void generateRandomNumbers(String fileName);

    //fetch Records from file
    List<Long> fetchRandomNumbers(String fileName);

    //Sort and insert numbers into another file
    void sortAndInsertRandomNumbers(List<Long> randomNumberList, String sortedFile);

}
