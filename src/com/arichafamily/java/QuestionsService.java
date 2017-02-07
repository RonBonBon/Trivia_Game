package com.arichafamily.java;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by hackeru on 02/02/2017.
 */
public class QuestionsService {


    public class JsonTrivia {
        public String question;
        public String answer;
        public String A;
        public String B;
        public String C;
        public String D;
    }


    public static ArrayList<Trivia> getQuestions() {
        ArrayList<Trivia> triviaQuestions = new ArrayList<>();
        try {
            Gson gson = new Gson();
            InputStreamReader reader = new FileReader(getPathForFile("json.json"));
            Type type = new TypeToken<ArrayList<JsonTrivia>>() {
            }.getType();
            ArrayList<JsonTrivia> jsonQuestions = gson.fromJson(reader, type);

            for (JsonTrivia jQuestion : jsonQuestions) {
                String question = jQuestion.question;
                String[] answers = new String[]{jQuestion.A, jQuestion.B, jQuestion.C, jQuestion.D};

                String correctAnswer = jQuestion.answer;
                switch (correctAnswer) {
                    case "A":
                        correctAnswer = answers[0];
                        break;
                    case "B":
                        correctAnswer = answers[1];
                        break;
                    case "C":
                        correctAnswer = answers[2];
                        break;
                    case "D":
                        correctAnswer = answers[3];
                        break;
                }


                Trivia trivia = new Trivia(question, answers, correctAnswer);
                triviaQuestions.add(trivia);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return triviaQuestions;
    }

    public static String getPathForFile(String fileName) throws URISyntaxException {
        String packegeAsPath = String.join("/", QuestionsService.class.getPackage().getName().split("\\."));
        URL resource = QuestionsService.class.getClassLoader().getResource(packegeAsPath + "/" + fileName);
        assert resource != null;
        return resource.getPath();
    }
}
