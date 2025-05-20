package com.example.examGenerator.service.impl;

import com.example.examGenerator.model.Question;
import com.example.examGenerator.service.QuestionService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

class JavaQuestionServiceImplTest {
    private QuestionService questionService;

    @BeforeEach
    void setUp() {
        questionService = new JavaQuestionServiceImpl();
    }

    @Test
    void testAddQuestion() {
        Question question = questionService.add("Q1", "A1");
        assertNotNull(question);
        assertEquals("Q1", question.getQuestion());
        assertEquals("A1", question.getAnswer());
        assertEquals(1, questionService.getAll().size());
    }

    @Test
    void testRemoveQuestion() {
        questionService.add("Q1", "A1");
        Question removed = questionService.remove(new Question("Q1", "A1"));
        assertNotNull(removed);
        assertEquals(0, questionService.getAll().size());
    }

    @Test
    void testGetAllQuestions() {
        questionService.add("Q1", "A1");
        questionService.add("Q2", "A2");
        Collection<Question> questions = questionService.getAll();
        assertEquals(2, questions.size());
    }

    @Test
    void testGetRandomQuestion() {
        questionService.add("Q1", "A1");
        questionService.add("Q2", "A2");
        Question randomQuestion = questionService.getRandomQuestion();
        assertNotNull(randomQuestion);
        assertTrue(randomQuestion.getQuestion().equals("Q1") ||
                randomQuestion.getQuestion().equals("Q2"));
    }
}
