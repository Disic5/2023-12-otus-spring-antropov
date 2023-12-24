package ru.otus.spring.hw.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.otus.spring.hw.domain.Answer;
import ru.otus.spring.hw.domain.Question;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("StreamIOService test")
class StreamsIOServiceTest {

    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private StreamsIOService ioService;

    private Question question;

    @BeforeEach
    void setUp() {
        ioService = new StreamsIOService(new PrintStream(outputStream));
        question = new Question("Question single line?",
                List.of(
                        new Answer("yes", true),
                        new Answer("no", false)
                ));
    }

    @Test
    @DisplayName("Question single line")
    void printQuestionSingleLineTest() {
        ioService.printQuestion(question);
        String result = outputStream.toString();
        assertThat(result).contains("Question single line? (1.yes,2.no): ");
    }
}