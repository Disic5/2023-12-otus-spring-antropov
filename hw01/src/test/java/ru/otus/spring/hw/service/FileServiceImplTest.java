package ru.otus.spring.hw.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.Reader;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@DisplayName("FileService test")
class FileServiceImplTest {

    @Mock
    private ClassLoader classLoader;

    private FileService fileService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        fileService = new FileServiceImpl();
    }

    @DisplayName("Read csv file")
    @Test
    void shouldReadCsvFileFromResources() {
        String fileName = "questions.csv";
        InputStream mockInputStream = mock(InputStream.class);
        when(classLoader.getResourceAsStream(fileName)).thenReturn(mockInputStream);

        Reader result = fileService.getReader(fileName);

        assertThat(result).isInstanceOf(BufferedReader.class);
    }

    @DisplayName("Read csv file should throw Exception")
    @Test
    void shouldThrowExceptionIfFileNotFound() throws IllegalArgumentException {
        String fileName = "file.csv";
        when(classLoader.getResourceAsStream(fileName)).thenReturn(null);

        assertThatThrownBy(() -> fileService.getReader(fileName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("file not found!");
    }
}
