package ru.otus.spring.hw.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.otus.spring.hw.dao.QuestionDao;
import ru.otus.spring.hw.domain.Answer;
import ru.otus.spring.hw.domain.Question;

import java.util.List;

import static org.mockito.Mockito.*;

@DisplayName("Single OutLine")
class TestServiceImplTest {

    private TestService testService;

    private final QuestionDao questionDao = mock(QuestionDao.class);
    private final IOService ioService = mock(IOService.class);

    @BeforeEach
    void setUp() {
        testService = new TestServiceImpl(ioService, questionDao);
    }

    @Test
    @DisplayName("Print Question OutLine")
    void shouldPrintSingleOutLineTest() {
        Question question = new Question("Question single line?",
                List.of(
                        new Answer("yes", true),
                        new Answer("no", false)
                ));
        when(questionDao.findAll()).thenReturn(List.of(question));

        testService.executeTest();

        verify(questionDao).findAll();
        verify(ioService).printLine(question.getText());
        verify(ioService).printFormattedLine("  %s (%b)", "yes", true);
        verify(ioService).printFormattedLine("  %s (%b)", "no", false);
    }
}