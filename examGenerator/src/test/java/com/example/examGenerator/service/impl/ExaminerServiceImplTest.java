package com.example.examGenerator.service.impl;

import com.example.examGenerator.exception.NotEnoughQuestionsException;
import com.example.examGenerator.model.Question;
import com.example.examGenerator.service.ExaminerService;
import com.example.examGenerator.service.ExaminerServiceImpl;
import com.example.examGenerator.service.QuestionService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ExaminerServiceImplTest {
    private ExaminerService examinerService;
    private QuestionService questionService;

    @BeforeEach
    void setUp() {
        questionService = new JavaQuestionServiceImpl();
        examinerService = new ExaminerServiceImpl(questionService);
    }

    @Test
    void testGetQuestions() {
        questionService.add("Q1", "A1");
        questionService.add("Q2", "A2");
        questionService.add("Q3", "A3");

        Collection<Question> questions = examinerService.getQuestions(2);
        assertEquals(2, questions.size());
    }

    @Test
    void testGetQuestionsNotEnough() {
        questionService.add("Q1", "A1");
        assertThrows(NotEnoughQuestionsException.class, () -> examinerService.getQuestions(2));
    }

    @Test
    void testGetQuestionsUnique() {
        questionService.add("Q1", "A1");
        questionService.add("Q2", "A2");
        questionService.add("Q3", "A3");

        Collection<Question> questions = examinerService.getQuestions(3);
        assertEquals(3, questions.size());
        assertEquals(3, questions.stream().distinct().count());
    }
}
