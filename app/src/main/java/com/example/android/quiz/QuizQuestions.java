package com.example.android.quiz;

import android.view.View;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by amyfong on 3/10/18.
 */


class TotoroQuizQuestions {


    public List<QuizQuestion> totoroQuestions;

    public TotoroQuizQuestions() {

        totoroQuestions = new LinkedList<QuizQuestion>();

        // Question 1
        QuizQuestion question1 = new QuizQuestion("What is the younger sister's name?", AnswerType.SINGLESELECTLISTANSWER);
        question1.addAnswers("Mei", true);
        question1.addAnswers("Chibi", false);
        question1.addAnswers("Chewie", false);
        question1.addAnswers("Maria", false);

        // Question 2
        QuizQuestion question2 = new QuizQuestion("What were the little Totoros collecting?", AnswerType.MULTISELECTLISTANSWER);
        question2.addAnswers("Corn", false);
        question2.addAnswers("Carrot", false);
        question2.addAnswers("Umbrellas", false);
        question2.addAnswers("Acorns", true);

        // Question 3
        QuizQuestion question3 = new QuizQuestion("Where did the sisters meet Totoro?", AnswerType.MULTISELECTLISTANSWER);
        question3.addAnswers("In The Forest", false);
        question3.addAnswers("At home", false);
        question3.addAnswers("At the bus stop", true);
        question3.addAnswers("At the hospital", false);

        // Question 4
        QuizQuestion question4 = new QuizQuestion("What did Satsuki give Totoro?", AnswerType.MULTISELECTLISTANSWER);
        question4.addAnswers("An Acorn", false);
        question4.addAnswers("An Umbrella", true);
        question4.addAnswers("An ear of Corn", false);
        question4.addAnswers("A hug", false);

        // Question 5
        QuizQuestion question5 = new QuizQuestion("What country does it takes place in?", AnswerType.TEXTANSWER);
        question5.addAnswers("Japan", true);

        // Question 6
        QuizQuestion question6 = new QuizQuestion("What colors are Totoros?", AnswerType.MULTISELECTLISTANSWER);
        question6.addAnswers("White", true);
        question6.addAnswers("Yellow", false);
        question6.addAnswers("Grey", true);
        question6.addAnswers("Blue", true);
        question6.addAnswers("Purple", false);


        totoroQuestions.add(question1);
        totoroQuestions.add(question2);
        totoroQuestions.add(question3);
        totoroQuestions.add(question4);
        totoroQuestions.add(question5);
        totoroQuestions.add(question6);
    }

}

class QuizQuestion {
    private String question = "";
    private List<QuizAnswer> answerOptions;
    private AnswerType answerType = AnswerType.TEXTANSWER;

    public QuizQuestion(String question, AnswerType answerTypeInput) {
        setQuestion(question);
        answerOptions = new LinkedList<QuizAnswer>();
        answerType = answerTypeInput;
    }

    public void setQuestion(String questionText) {
        question = questionText;
    }

    public void addAnswers(String answerText, boolean isCorrect) {
        QuizAnswer answer = new QuizAnswer(answerText, isCorrect);
        answerOptions.add(answer);
    }

    public String getQuestion() {
        return question;
    }

    public QuizAnswer getAnswerInPosition(int position) {
        return answerOptions.get(position);
    }

    // For text only
    public void setUserInputAnswer(String userAnswerString) {

        if (answerType == AnswerType.TEXTANSWER) {
            getAnswerInPosition(0).setuserInput(userAnswerString);
        }
    }

    public void clearAllUserInputAnswer() {
        for (int i = 0; i < answerOptions.size(); i++) {
            getAnswerInPosition(i).setuserInput("");

        }
    }

    // For MultiSelectLIst and SingleSelectList only
    public void setUserInputAnswer(int position) {
        if (answerType == AnswerType.SINGLESELECTLISTANSWER) {
            clearAllUserInputAnswer();
        }
        getAnswerInPosition(position).setuserInput(getAnswerInPosition(position).getAnswerText());
    }

    public boolean userGotTheRighAnswerForQuestion() {

        for (int i = 0; i < answerOptions.size(); i++) {
            if (answerOptions.get(i).getCorrectAnswer()) {
                if (!answerOptions.get(i).userGotTheRightAnswer()) {
                    return false;
                }
            } else {
                if (answerOptions.get(i).userInputIsSameAsAnwswer()) {
                    return false;
                }

            }
        }
        return true;
    }
}

class QuizAnswer {
    private String answerText;
    private boolean correctAnswer;
    private String userInput;

    public QuizAnswer(String answer, boolean isCorrect) {
        setAnswerText(answer);
        setCorrectAnswer(isCorrect);
        setuserInput("");
    }

    private void setAnswerText(String answer) {
        answerText = answer;
    }

    public String getAnswerText() {
        return answerText;
    }

    private void setCorrectAnswer(boolean isCorrect) {
        correctAnswer = isCorrect;
    }

    public boolean getCorrectAnswer() {
        return correctAnswer;
    }

    public void setuserInput(String userInputText) {
        userInput = userInputText;
    }

    public boolean userInputIsSameAsAnwswer() {
        return (answerText).equals(userInput);
    }

    public boolean userGotTheRightAnswer() {
        if ((userInputIsSameAsAnwswer() && getCorrectAnswer())) {
            return true;
        } else {
            return false;
        }
    }

}