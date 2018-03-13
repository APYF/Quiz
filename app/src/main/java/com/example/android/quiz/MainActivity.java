package com.example.android.quiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    private int currentQuizQuestion = 0;
    private int numberOfQuestions = 0;
    TotoroQuizQuestions quizQuestions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        quizQuestions = new TotoroQuizQuestions();
        numberOfQuestions = quizQuestions.totoroQuestions.size();

        displayQuizQuestion();
    }


    @Override
    protected void onSaveInstanceState(Bundle outState) {

        super.onSaveInstanceState(outState);
        outState.putInt("saveCurrectQuizQuestion", currentQuizQuestion);


        RadioGroup rG_question0 = (RadioGroup) findViewById(R.id.quiz_answer_group_0);
        outState.putInt("question0state", rG_question0.getCheckedRadioButtonId());

        RadioGroup rG_question1 = (RadioGroup) findViewById(R.id.quiz_answer_group_1);
        outState.putInt("question1state", rG_question1.getCheckedRadioButtonId());

        RadioGroup rG_question2 = (RadioGroup) findViewById(R.id.quiz_answer_group_2);
        outState.putInt("question2state", rG_question2.getCheckedRadioButtonId());

        RadioGroup rG_question3 = (RadioGroup) findViewById(R.id.quiz_answer_group_3);
        outState.putInt("question3state", rG_question3.getCheckedRadioButtonId());

        EditText eT_question4 = (EditText) findViewById(R.id.quiz_answer_4);
        outState.putString("question4state", eT_question4.getText().toString());


        CheckBox cB_question5_0 = (CheckBox) findViewById(R.id.quiz_answer_5_0);
        outState.putBoolean("question5_0_state", cB_question5_0.isChecked());

        CheckBox cB_question5_1 = (CheckBox) findViewById(R.id.quiz_answer_5_1);
        outState.putBoolean("question5_1_state", cB_question5_1.isChecked());

        CheckBox cB_question5_2 = (CheckBox) findViewById(R.id.quiz_answer_5_2);
        outState.putBoolean("question5_2_state", cB_question5_2.isChecked());

        CheckBox cB_question5_3 = (CheckBox) findViewById(R.id.quiz_answer_5_3);
        outState.putBoolean("question5_3_state", cB_question5_3.isChecked());
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        currentQuizQuestion = savedInstanceState.getInt("saveCurrectQuizQuestion");

        displayQuizQuestion();

        RadioGroup rG_question0 = (RadioGroup) findViewById(R.id.quiz_answer_group_0);
        RadioGroup rG_question1 = (RadioGroup) findViewById(R.id.quiz_answer_group_1);
        RadioGroup rG_question2 = (RadioGroup) findViewById(R.id.quiz_answer_group_2);
        RadioGroup rG_question3 = (RadioGroup) findViewById(R.id.quiz_answer_group_3);
        EditText eT_question4 = (EditText) findViewById(R.id.quiz_answer_4);
        CheckBox cB_question5_0 = (CheckBox) findViewById(R.id.quiz_answer_5_0);
        CheckBox cB_question5_1 = (CheckBox) findViewById(R.id.quiz_answer_5_1);
        CheckBox cB_question5_2 = (CheckBox) findViewById(R.id.quiz_answer_5_2);
        CheckBox cB_question5_3 = (CheckBox) findViewById(R.id.quiz_answer_5_3);

        rG_question0.check(savedInstanceState.getInt("question0state"));
        rG_question1.check(savedInstanceState.getInt("question1state"));
        rG_question2.check(savedInstanceState.getInt("question2state"));
        rG_question3.check(savedInstanceState.getInt("question3state"));
        eT_question4.setText(savedInstanceState.getString("question4state"));
        cB_question5_0.setChecked(savedInstanceState.getBoolean("question5_0_state"));
        cB_question5_1.setChecked(savedInstanceState.getBoolean("question5_1_state"));
        cB_question5_2.setChecked(savedInstanceState.getBoolean("question5_2_state"));
        cB_question5_3.setChecked(savedInstanceState.getBoolean("question5_3_state"));

        // if the question is answered, the EditText field gets the focus on resume, so clear it
        eT_question4.clearFocus();

    }

    public void displayQuizQuestion() {

        TextView question;
        RadioButton radioButtonAnswer;
        CheckBox checkBoxAnswer;

        QuizQuestion quizQuestion;

        // Question 0
        quizQuestion = quizQuestions.totoroQuestions.get(0);

        question = (TextView) findViewById(R.id.quiz_question_0);
        question.setText(quizQuestion.getQuestion());

        radioButtonAnswer = (RadioButton) findViewById(R.id.quiz_answer_0_0);
        radioButtonAnswer.setText(quizQuestion.getAnswerInPosition(0).getAnswerText());

        radioButtonAnswer = (RadioButton) findViewById(R.id.quiz_answer_0_1);
        radioButtonAnswer.setText(quizQuestion.getAnswerInPosition(1).getAnswerText());

        radioButtonAnswer = (RadioButton) findViewById(R.id.quiz_answer_0_2);
        radioButtonAnswer.setText(quizQuestion.getAnswerInPosition(2).getAnswerText());

        radioButtonAnswer = (RadioButton) findViewById(R.id.quiz_answer_0_3);
        radioButtonAnswer.setText(quizQuestion.getAnswerInPosition(3).getAnswerText());

        // Question 1
        quizQuestion = quizQuestions.totoroQuestions.get(1);

        question = (TextView) findViewById(R.id.quiz_question_1);
        question.setText(quizQuestion.getQuestion());

        radioButtonAnswer = (RadioButton) findViewById(R.id.quiz_answer_1_0);
        radioButtonAnswer.setText(quizQuestion.getAnswerInPosition(0).getAnswerText());

        radioButtonAnswer = (RadioButton) findViewById(R.id.quiz_answer_1_1);
        radioButtonAnswer.setText(quizQuestion.getAnswerInPosition(1).getAnswerText());

        radioButtonAnswer = (RadioButton) findViewById(R.id.quiz_answer_1_2);
        radioButtonAnswer.setText(quizQuestion.getAnswerInPosition(2).getAnswerText());

        radioButtonAnswer = (RadioButton) findViewById(R.id.quiz_answer_1_3);
        radioButtonAnswer.setText(quizQuestion.getAnswerInPosition(3).getAnswerText());

        // Question 2
        quizQuestion = quizQuestions.totoroQuestions.get(2);
        question = (TextView) findViewById(R.id.quiz_question_2);
        question.setText(quizQuestion.getQuestion());

        radioButtonAnswer = (RadioButton) findViewById(R.id.quiz_answer_2_0);
        radioButtonAnswer.setText(quizQuestion.getAnswerInPosition(0).getAnswerText());

        radioButtonAnswer = (RadioButton) findViewById(R.id.quiz_answer_2_1);
        radioButtonAnswer.setText(quizQuestion.getAnswerInPosition(1).getAnswerText());

        radioButtonAnswer = (RadioButton) findViewById(R.id.quiz_answer_2_2);
        radioButtonAnswer.setText(quizQuestion.getAnswerInPosition(2).getAnswerText());

        radioButtonAnswer = (RadioButton) findViewById(R.id.quiz_answer_2_3);
        radioButtonAnswer.setText(quizQuestions.totoroQuestions.get(2).getAnswerInPosition(3).getAnswerText());

        // Question 3
        quizQuestion = quizQuestions.totoroQuestions.get(3);
        question = (TextView) findViewById(R.id.quiz_question_3);
        question.setText(quizQuestion.getQuestion());

        radioButtonAnswer = (RadioButton) findViewById(R.id.quiz_answer_3_0);
        radioButtonAnswer.setText(quizQuestion.getAnswerInPosition(0).getAnswerText());

        radioButtonAnswer = (RadioButton) findViewById(R.id.quiz_answer_3_1);
        radioButtonAnswer.setText(quizQuestion.getAnswerInPosition(1).getAnswerText());

        radioButtonAnswer = (RadioButton) findViewById(R.id.quiz_answer_3_2);
        radioButtonAnswer.setText(quizQuestion.getAnswerInPosition(2).getAnswerText());

        radioButtonAnswer = (RadioButton) findViewById(R.id.quiz_answer_3_3);
        radioButtonAnswer.setText(quizQuestion.getAnswerInPosition(3).getAnswerText());


        // Question 4
        quizQuestion = quizQuestions.totoroQuestions.get(4);
        question = (TextView) findViewById(R.id.quiz_question_4);
        question.setText(quizQuestion.getQuestion());


        // Question 5
        quizQuestion = quizQuestions.totoroQuestions.get(5);

        question = (TextView) findViewById(R.id.quiz_question_5);
        question.setText(quizQuestion.getQuestion());

        checkBoxAnswer = (CheckBox) findViewById(R.id.quiz_answer_5_0);
        checkBoxAnswer.setText(quizQuestion.getAnswerInPosition(0).getAnswerText());

        checkBoxAnswer = (CheckBox) findViewById(R.id.quiz_answer_5_1);
        checkBoxAnswer.setText(quizQuestion.getAnswerInPosition(1).getAnswerText());

        checkBoxAnswer = (CheckBox) findViewById(R.id.quiz_answer_5_2);
        checkBoxAnswer.setText(quizQuestion.getAnswerInPosition(2).getAnswerText());

        checkBoxAnswer = (CheckBox) findViewById(R.id.quiz_answer_5_3);
        checkBoxAnswer.setText(quizQuestion.getAnswerInPosition(3).getAnswerText());

    }

    public void submitQuestionCheck(View view) {


        int currentQuizScore = 0;

        // clear all user input answers to start

        for (int i = 0; i < quizQuestions.totoroQuestions.size(); i++) {
            quizQuestions.totoroQuestions.get(i).clearAllUserInputAnswer();
        }

        // then check all the user input

        RadioButton rB_question0_0 = (RadioButton) findViewById(R.id.quiz_answer_0_0);
        if (rB_question0_0.isChecked()) {
            quizQuestions.totoroQuestions.get(0).setUserInputAnswer(0);
        }

        RadioButton rB_question0_1 = (RadioButton) findViewById(R.id.quiz_answer_0_1);
        if (rB_question0_1.isChecked()) {
            quizQuestions.totoroQuestions.get(0).setUserInputAnswer(1);
        }

        RadioButton rB_question0_2 = (RadioButton) findViewById(R.id.quiz_answer_0_2);
        if (rB_question0_2.isChecked()) {
            quizQuestions.totoroQuestions.get(0).setUserInputAnswer(2);
        }

        RadioButton rB_question0_3 = (RadioButton) findViewById(R.id.quiz_answer_0_3);
        if (rB_question0_3.isChecked()) {
            quizQuestions.totoroQuestions.get(0).setUserInputAnswer(3);
        }


        RadioButton rB_question1_0 = (RadioButton) findViewById(R.id.quiz_answer_1_0);
        if (rB_question1_0.isChecked()) {
            quizQuestions.totoroQuestions.get(1).setUserInputAnswer(0);
        }

        RadioButton rB_question1_1 = (RadioButton) findViewById(R.id.quiz_answer_1_1);
        if (rB_question1_1.isChecked()) {
            quizQuestions.totoroQuestions.get(1).setUserInputAnswer(1);
        }

        RadioButton rB_question1_2 = (RadioButton) findViewById(R.id.quiz_answer_1_2);
        if (rB_question1_2.isChecked()) {
            quizQuestions.totoroQuestions.get(1).setUserInputAnswer(2);
        }

        RadioButton rB_question1_3 = (RadioButton) findViewById(R.id.quiz_answer_1_3);
        if (rB_question1_3.isChecked()) {
            quizQuestions.totoroQuestions.get(1).setUserInputAnswer(3);
        }


        RadioButton rB_question2_0 = (RadioButton) findViewById(R.id.quiz_answer_2_0);
        if (rB_question2_0.isChecked()) {
            quizQuestions.totoroQuestions.get(2).setUserInputAnswer(0);
        }

        RadioButton rB_question2_1 = (RadioButton) findViewById(R.id.quiz_answer_2_1);
        if (rB_question2_1.isChecked()) {
            quizQuestions.totoroQuestions.get(2).setUserInputAnswer(1);
        }

        RadioButton rB_question2_2 = (RadioButton) findViewById(R.id.quiz_answer_2_2);
        if (rB_question2_2.isChecked()) {
            quizQuestions.totoroQuestions.get(2).setUserInputAnswer(2);
        }

        RadioButton rB_question2_3 = (RadioButton) findViewById(R.id.quiz_answer_2_3);
        if (rB_question2_3.isChecked()) {
            quizQuestions.totoroQuestions.get(2).setUserInputAnswer(3);
        }

        RadioButton rB_question3_0 = (RadioButton) findViewById(R.id.quiz_answer_3_0);
        if (rB_question3_0.isChecked()) {
            quizQuestions.totoroQuestions.get(3).setUserInputAnswer(0);
        }

        RadioButton rB_question3_1 = (RadioButton) findViewById(R.id.quiz_answer_3_1);
        if (rB_question3_1.isChecked()) {
            quizQuestions.totoroQuestions.get(3).setUserInputAnswer(1);
        }

        RadioButton rB_question3_2 = (RadioButton) findViewById(R.id.quiz_answer_3_2);
        if (rB_question3_2.isChecked()) {
            quizQuestions.totoroQuestions.get(3).setUserInputAnswer(2);
        }

        RadioButton rB_question3_3 = (RadioButton) findViewById(R.id.quiz_answer_3_3);
        if (rB_question3_3.isChecked()) {
            quizQuestions.totoroQuestions.get(3).setUserInputAnswer(3);
        }


        EditText eT_question4 = (EditText) findViewById(R.id.quiz_answer_4);
        quizQuestions.totoroQuestions.get(4).setUserInputAnswer(eT_question4.getText().toString());


        CheckBox cB_question5_0 = (CheckBox) findViewById(R.id.quiz_answer_5_0);
        if (cB_question5_0.isChecked()) {
            quizQuestions.totoroQuestions.get(5).setUserInputAnswer(0);
        }

        CheckBox cB_question5_1 = (CheckBox) findViewById(R.id.quiz_answer_5_1);
        if (cB_question5_1.isChecked()) {
            quizQuestions.totoroQuestions.get(5).setUserInputAnswer(1);
        }

        CheckBox cB_question5_2 = (CheckBox) findViewById(R.id.quiz_answer_5_2);
        if (cB_question5_2.isChecked()) {
            quizQuestions.totoroQuestions.get(5).setUserInputAnswer(2);
        }

        CheckBox cB_question5_3 = (CheckBox) findViewById(R.id.quiz_answer_5_3);
        if (cB_question5_3.isChecked()) {
            quizQuestions.totoroQuestions.get(5).setUserInputAnswer(3);
        }


        for (int i = 0; i < quizQuestions.totoroQuestions.size(); i++) {
            if (quizQuestions.totoroQuestions.get(i).userGotTheRighAnswerForQuestion())
                currentQuizScore++ ;
        }

        String toastMessage =  getString(R.string.quiz_result_summary, currentQuizScore, numberOfQuestions);
        Toast.makeText(this, toastMessage, Toast.LENGTH_SHORT).show();



    }


}
