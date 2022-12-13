package service.impl;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import service.FileWriterService;

public class FileWriterServiceImpl implements FileWriterService {
    private static final String PATH_NAME = "src\\resources\\result.csv";

    @Override
    public void writeToFile(String result) {
        File file = new File(PATH_NAME);
        try {
            Files.write(file.toPath(), result.getBytes(StandardCharsets.UTF_8),
                    StandardOpenOption.APPEND);
        } catch (IOException e) {
            throw new RuntimeException("Can`t write to the file: " + file.getName(), e);
        }
    }
}