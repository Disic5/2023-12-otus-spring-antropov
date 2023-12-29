package ru.otus.spring.hw.dao;

import com.opencsv.bean.CsvToBeanBuilder;
import lombok.RequiredArgsConstructor;
import ru.otus.spring.hw.config.TestFileNameProvider;
import ru.otus.spring.hw.dao.dto.QuestionDto;
import ru.otus.spring.hw.domain.Question;
import ru.otus.spring.hw.exceptions.QuestionReadException;
import ru.otus.spring.hw.mapper.Mapper;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;

@RequiredArgsConstructor
public class CsvQuestionDao implements QuestionDao {

    public static final Character COLUMNS_DELIMITER = ';';

    private final TestFileNameProvider fileNameProvider;

    private final Mapper mapper;

    @Override
    public List<Question> findAll() {
        try (InputStream inputStream = getFileFromResourceAsStream(fileNameProvider.getTestFileName());
             Reader reader = new InputStreamReader(inputStream)) {
             return new CsvToBeanBuilder<QuestionDto>(reader)
                    .withType(QuestionDto.class)
                    .withSkipLines(1)
                    .withSeparator(COLUMNS_DELIMITER)
                    .build()
                    .stream().map(mapper).toList();
        } catch (Exception e) {
            throw new QuestionReadException("An error occurred while reading the file: " + e.getMessage(), e);
        }
    }

    private InputStream getFileFromResourceAsStream(String fileName) {
        ClassLoader classLoader = getClass().getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream(fileName);
        if (inputStream == null) {
            throw new IllegalArgumentException("File not found!");
        } else {
            return inputStream;
        }
    }
}