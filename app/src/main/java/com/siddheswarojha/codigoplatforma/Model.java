package com.siddheswarojha.codigoplatforma;

public class Model {
    String Question;

    public Model(String question) {
        Question = question;
    }

    public Model() {
    }

    public String getQuestion() {
        return Question;
    }

    public void setQuestion(String question) {
        Question = question;
    }
}
