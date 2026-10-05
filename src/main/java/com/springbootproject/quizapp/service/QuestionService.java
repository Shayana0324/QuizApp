package com.springbootproject.quizapp.service;

import com.springbootproject.quizapp.Question;
import com.springbootproject.quizapp.dao.QuestionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class QuestionService {
//    public List<Question> getAllQuestions;
    @Autowired
    QuestionDao questionDao;
    public List<Question> getAllQuestions() {
        return questionDao.findAll();
    }

    public List<Question> getQuestionsByCategory(String category) {
        return questionDao.findByCategory(category);
    }

    public String addQuestion(Question question) {
        questionDao.save(question);
        return "success";
    }

    public void deleteQuestion(Integer id) {
        if (!questionDao.existsById(id)) {
            throw new RuntimeException("Question not found with ID: " + id);
        }
        questionDao.deleteById(id);

    }
}
