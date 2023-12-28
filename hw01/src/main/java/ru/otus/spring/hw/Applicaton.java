package ru.otus.spring.hw;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.otus.spring.hw.service.TestRunnerService;

public class Applicaton {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/spring-context.xml");
        var testRunnerService = context.getBean(TestRunnerService.class);
        testRunnerService.run();

    }
}