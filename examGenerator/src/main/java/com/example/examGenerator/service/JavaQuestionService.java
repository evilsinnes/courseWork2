package com.example.examGenerator.service;

import com.example.examGenerator.model.Question;

import java.util.Collection;

public interface JavaQuestionService extends QuestionService {
    Question add(String question, String answer);
    Question remove(Question question);
    Collection<Question> getAll();
    Question getRandomQuestion();
}

