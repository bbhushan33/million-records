package com.bally.controller;

import com.bally.model.Constant;
import com.bally.service.RandomNumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.io.FileNotFoundException;
import java.util.List;

@RestController
public class RandomNumberController {
    @Autowired
    private RandomNumberService randomNumberService;

    @RequestMapping("/randomNumberApi")
    public String millionRandomNumbers() {
        String fileName = Constant.FILE_NAME;
        String outputFileName = Constant.SORTED_FILE_NAME;
        randomNumberService.generateRandomNumbers(fileName);
        List<Long> randomNumberList = randomNumberService.fetchRandomNumbers(fileName);
        randomNumberService.sortAndInsertRandomNumbers(randomNumberList, outputFileName);
        return Constant.FILE_CREATED_MSG;
    }
}

