package ru.otus.spring.hw.service;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class FileServiceImpl implements FileService {

    @Override
    public Reader getReader(String filename) {
        InputStream inputStream = getFileFromResourceAsStream(filename);
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        return new BufferedReader(inputStreamReader);
    }

    private InputStream getFileFromResourceAsStream(String fileName) {
        ClassLoader classLoader = getClass().getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream(fileName);
        if (inputStream == null) {
            throw new IllegalArgumentException("file not found!");
        } else {
            return inputStream;
        }
    }

}
