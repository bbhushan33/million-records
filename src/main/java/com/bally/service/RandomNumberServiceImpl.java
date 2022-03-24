package com.bally.service;

import com.bally.model.Constant;
import com.bally.utility.FileUtility;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

@Service
@Component
public class RandomNumberServiceImpl implements RandomNumberService {

    @Override
    public void generateRandomNumbers(String fileName) {
        Random random = new Random();
        try (PrintWriter pw = FileUtility.createFile(fileName)) {
            random.ints(Constant.START_RANGE, Constant.END_RANGE)
                    .limit(Constant.LIMIT).mapToObj(String::valueOf).forEach(pw::println);
            System.out.println(Constant.FILE_CREATED_MSG);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Long> fetchRandomNumbers(String fileName) {
        List<Long> list = new ArrayList<>();
        try (Stream<String> stream = FileUtility.fetchRecordsFromFile(fileName)) {
            stream.mapToLong(Long::valueOf).forEach(list::add);
            return list;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public void sortAndInsertRandomNumbers(List<Long> randomNumberList, String sortedFile) {
        try (PrintWriter pw = FileUtility.createFile(sortedFile)) {
            randomNumberList.stream().sorted().forEach(pw::println);
            pw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
