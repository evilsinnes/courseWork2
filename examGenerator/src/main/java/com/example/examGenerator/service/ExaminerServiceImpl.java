package com.example.examGenerator.service;

import com.example.examGenerator.exception.NotEnoughQuestionsException;
import com.example.examGenerator.model.Question;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Service
public class ExaminerServiceImpl implements ExaminerService {
    private final QuestionService questionService;

    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        if (amount > questionService.getAll().size()) {
            throw new NotEnoughQuestionsException("Not enough questions in storage");
        }

        Set<Question> result = new HashSet<>();
        while (result.size() < amount) {
            Question randomQuestion = questionService.getRandomQuestion();
            if (randomQuestion != null) {
                result.add(randomQuestion);
            }
        }
        return result;
    }
}