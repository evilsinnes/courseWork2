package com.example.examGenerator.service;



import com.example.examGenerator.model.Question;

import java.util.Collection;

public interface ExaminerService {
    Collection<Question> getQuestions(int amount);
}