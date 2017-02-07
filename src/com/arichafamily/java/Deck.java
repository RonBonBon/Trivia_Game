package com.arichafamily.java;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Ron on 03/02/2017.
 */
public class Deck {

    ArrayList<Trivia> questions = QuestionsService.getQuestions();

    void shuffle() {
        Random r = new Random();
        int n = r.nextInt(questions.size() + 1);
        nextQuestion(n);
    }

    void nextQuestion(int n) {
        questions.get(n).show();
        questions.get(n).showAnswers();
        int userAns = IO.getInt("Whats your answer?");
        questions.get(n).check(userAns);
        questions.remove(n);

        ArrayList<Trivia> card = new ArrayList<>();

    }
}
