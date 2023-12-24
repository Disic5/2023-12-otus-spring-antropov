package ru.otus.spring.hw.service;

import java.io.Reader;

public interface FileService {
    Reader getReader(String filename);
}
