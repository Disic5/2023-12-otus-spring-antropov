package ru.otus.spring.hw.mapper;

import ru.otus.spring.hw.dao.dto.QuestionDto;
import ru.otus.spring.hw.domain.Question;
import java.util.function.Function;

public class Mapper implements Function<QuestionDto, Question> {

    @Override
    public Question apply(QuestionDto questionDto) {
        return Question.builder()
                .answers(questionDto.getAnswers())
                .text(questionDto.getText())
                .build();
    }
}
