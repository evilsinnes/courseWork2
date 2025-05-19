package com.example.examGenerator.service.impl;

import com.example.examGenerator.model.Question;
import com.example.examGenerator.service.JavaQuestionService;
import com.example.examGenerator.service.QuestionService;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class JavaQuestionServiceImpl implements JavaQuestionService {
    private final Set<Question> questions = new HashSet<>();
    private final Random random = new Random();

    @PostConstruct
    public void init() {
        add("Что такое Java?", "Язык программирования");
        add("Что такое JVM?", "Виртуальная машина Java");
        add("Что такое Spring?", "Фреймворк для Java");
        add("Как объявить класс в Java?", "class MyClass {}");
    }

    @Override
    public Question add(String question, String answer) {
        Question newQuestion = new Question(question, answer);
        questions.add(newQuestion);
        return newQuestion;
    }

    @Override
    public Question remove(Question question) {
        if (questions.remove(question)) {
            return question;
        }
        return null;
    }

    @Override
    public Collection<Question> getAll() {
        return Collections.unmodifiableSet(questions);
    }

    @Override
    public Question getRandomQuestion() {
        if (questions.isEmpty()) {
            return null;
        }
        int index = random.nextInt(questions.size());
        return questions.stream().skip(index).findFirst().orElse(null);
    }
}