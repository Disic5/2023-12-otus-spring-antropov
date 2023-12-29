package ru.otus.spring.hw.service;

import lombok.RequiredArgsConstructor;
import ru.otus.spring.hw.dao.QuestionDao;
import ru.otus.spring.hw.domain.Answer;
import ru.otus.spring.hw.domain.Question;

import java.util.List;

@RequiredArgsConstructor
public class TestServiceImpl implements TestService {

    private final IOService ioService;

    private final QuestionDao questionDao;

    @Override
    public void executeTest() {
        ioService.printLine("");
        ioService.printFormattedLine("Please answer the questions below%n");
        List<Question> questions = questionDao.findAll();
        questions.forEach(this::showQuestion);
    }

    private void showQuestion(Question question) {
        ioService.printLine(question.getText());
        for (Answer answer : question.getAnswers()) {
            ioService.printFormattedLine("  %s (%b)", answer.getText(), answer.getIsCorrect());
        }
        ioService.printLine("");
    }
}