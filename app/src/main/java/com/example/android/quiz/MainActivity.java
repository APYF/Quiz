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

    // Declare the views to be used
    TextView tV_question_0;
    RadioGroup rG_question_0;
    RadioButton rB_answer_0_0;
    RadioButton rB_answer_0_1;
    RadioButton rB_answer_0_2;
    RadioButton rB_answer_0_3;

    TextView tV_question_1;
    RadioGroup rG_question_1;
    RadioButton rB_answer_1_0;
    RadioButton rB_answer_1_1;
    RadioButton rB_answer_1_2;
    RadioButton rB_answer_1_3;

    TextView tV_question_2;
    RadioGroup rG_question_2;
    RadioButton rB_answer_2_0;
    RadioButton rB_answer_2_1;
    RadioButton rB_answer_2_2;
    RadioButton rB_answer_2_3;

    TextView tV_question_3;
    RadioGroup rG_question_3;
    RadioButton rB_answer_3_0;
    RadioButton rB_answer_3_1;
    RadioButton rB_answer_3_2;
    RadioButton rB_answer_3_3;

    TextView tV_question_4;
    EditText eT_answer_4;

    TextView tV_question_5;
    CheckBox cB_answer_5_0;
    CheckBox cB_answer_5_1;
    CheckBox cB_answer_5_2;
    CheckBox cB_answer_5_3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Find and Set the Views
        tV_question_0 = (TextView) findViewById(R.id.quiz_question_0);
        rG_question_0 = (RadioGroup) findViewById(R.id.quiz_answer_group_0);
        rB_answer_0_0 = (RadioButton) findViewById(R.id.quiz_answer_0_0);
        rB_answer_0_1 = (RadioButton) findViewById(R.id.quiz_answer_0_1);
        rB_answer_0_2 = (RadioButton) findViewById(R.id.quiz_answer_0_2);
        rB_answer_0_3 = (RadioButton) findViewById(R.id.quiz_answer_0_3);

        tV_question_1 = (TextView) findViewById(R.id.quiz_question_1);
        rG_question_1 = (RadioGroup) findViewById(R.id.quiz_answer_group_1);
        rB_answer_1_0 = (RadioButton) findViewById(R.id.quiz_answer_1_0);
        rB_answer_1_1 = (RadioButton) findViewById(R.id.quiz_answer_1_1);
        rB_answer_1_2 = (RadioButton) findViewById(R.id.quiz_answer_1_2);
        rB_answer_1_3 = (RadioButton) findViewById(R.id.quiz_answer_1_3);

        tV_question_2 = (TextView) findViewById(R.id.quiz_question_2);
        rG_question_2 = (RadioGroup) findViewById(R.id.quiz_answer_group_2);
        rB_answer_2_0 = (RadioButton) findViewById(R.id.quiz_answer_2_0);
        rB_answer_2_1 = (RadioButton) findViewById(R.id.quiz_answer_2_1);
        rB_answer_2_2 = (RadioButton) findViewById(R.id.quiz_answer_2_2);
        rB_answer_2_3 = (RadioButton) findViewById(R.id.quiz_answer_2_3);

        tV_question_3 = (TextView) findViewById(R.id.quiz_question_3);
        rG_question_3 = (RadioGroup) findViewById(R.id.quiz_answer_group_3);
        rB_answer_3_0 = (RadioButton) findViewById(R.id.quiz_answer_3_0);
        rB_answer_3_1 = (RadioButton) findViewById(R.id.quiz_answer_3_1);
        rB_answer_3_2 = (RadioButton) findViewById(R.id.quiz_answer_3_2);
        rB_answer_3_3 = (RadioButton) findViewById(R.id.quiz_answer_3_3);

        tV_question_4 = (TextView) findViewById(R.id.quiz_question_4);
        eT_answer_4 = (EditText) findViewById(R.id.quiz_answer_4);

        tV_question_5 = (TextView) findViewById(R.id.quiz_question_5);
        cB_answer_5_0 = (CheckBox) findViewById(R.id.quiz_answer_5_0);
        cB_answer_5_1 = (CheckBox) findViewById(R.id.quiz_answer_5_1);
        cB_answer_5_2 = (CheckBox) findViewById(R.id.quiz_answer_5_2);
        cB_answer_5_3 = (CheckBox) findViewById(R.id.quiz_answer_5_3);

        quizQuestions = new TotoroQuizQuestions();
        numberOfQuestions = quizQuestions.totoroQuestions.size();

        displayQuizQuestion();
    }


    @Override
    protected void onSaveInstanceState(Bundle outState) {

        outState.putInt("question0state", rG_question_0.getCheckedRadioButtonId());
        outState.putInt("question1state", rG_question_1.getCheckedRadioButtonId());
        outState.putInt("question2state", rG_question_2.getCheckedRadioButtonId());
        outState.putInt("question3state", rG_question_3.getCheckedRadioButtonId());

        outState.putString("question4state", eT_answer_4.getText().toString());

        outState.putBoolean("question5_0_state", cB_answer_5_0.isChecked());
        outState.putBoolean("question5_1_state", cB_answer_5_1.isChecked());
        outState.putBoolean("question5_2_state", cB_answer_5_2.isChecked());
        outState.putBoolean("question5_3_state", cB_answer_5_3.isChecked());

        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        displayQuizQuestion();

        rG_question_0.check(savedInstanceState.getInt("question0state"));
        rG_question_1.check(savedInstanceState.getInt("question1state"));
        rG_question_2.check(savedInstanceState.getInt("question2state"));
        rG_question_3.check(savedInstanceState.getInt("question3state"));
        eT_answer_4.setText(savedInstanceState.getString("question4state"));
        cB_answer_5_0.setChecked(savedInstanceState.getBoolean("question5_0_state"));
        cB_answer_5_1.setChecked(savedInstanceState.getBoolean("question5_1_state"));
        cB_answer_5_2.setChecked(savedInstanceState.getBoolean("question5_2_state"));
        cB_answer_5_3.setChecked(savedInstanceState.getBoolean("question5_3_state"));

        // if the question is answered, the EditText field gets the focus on resume, so clear it
        eT_answer_4.clearFocus();
    }

    public void displayQuizQuestion() {

        TextView question;
        RadioButton radioButtonAnswer;
        CheckBox checkBoxAnswer;

        // Question 0
        tV_question_0.setText(quizQuestions.totoroQuestions.get(0).getQuestion());
        rB_answer_0_0.setText(quizQuestions.totoroQuestions.get(0).getAnswerInPosition(0).getAnswerText());
        rB_answer_0_1.setText(quizQuestions.totoroQuestions.get(0).getAnswerInPosition(1).getAnswerText());
        rB_answer_0_2.setText(quizQuestions.totoroQuestions.get(0).getAnswerInPosition(2).getAnswerText());
        rB_answer_0_3.setText(quizQuestions.totoroQuestions.get(0).getAnswerInPosition(3).getAnswerText());

        // Question 1
        tV_question_1.setText(quizQuestions.totoroQuestions.get(1).getQuestion());
        rB_answer_1_0.setText(quizQuestions.totoroQuestions.get(1).getAnswerInPosition(0).getAnswerText());
        rB_answer_1_1.setText(quizQuestions.totoroQuestions.get(1).getAnswerInPosition(1).getAnswerText());
        rB_answer_1_2.setText(quizQuestions.totoroQuestions.get(1).getAnswerInPosition(2).getAnswerText());
        rB_answer_1_3.setText(quizQuestions.totoroQuestions.get(1).getAnswerInPosition(3).getAnswerText());

        // Question 2
        tV_question_2.setText(quizQuestions.totoroQuestions.get(2).getQuestion());
        rB_answer_2_0.setText(quizQuestions.totoroQuestions.get(2).getAnswerInPosition(0).getAnswerText());
        rB_answer_2_1.setText(quizQuestions.totoroQuestions.get(2).getAnswerInPosition(1).getAnswerText());
        rB_answer_2_2.setText(quizQuestions.totoroQuestions.get(2).getAnswerInPosition(2).getAnswerText());
        rB_answer_2_3.setText(quizQuestions.totoroQuestions.get(2).getAnswerInPosition(3).getAnswerText());

        // Question 3
        tV_question_3.setText(quizQuestions.totoroQuestions.get(3).getQuestion());
        rB_answer_3_0.setText(quizQuestions.totoroQuestions.get(3).getAnswerInPosition(0).getAnswerText());
        rB_answer_3_1.setText(quizQuestions.totoroQuestions.get(3).getAnswerInPosition(1).getAnswerText());
        rB_answer_3_2.setText(quizQuestions.totoroQuestions.get(3).getAnswerInPosition(2).getAnswerText());
        rB_answer_3_3.setText(quizQuestions.totoroQuestions.get(3).getAnswerInPosition(3).getAnswerText());

        // Question 4
        tV_question_4.setText(quizQuestions.totoroQuestions.get(4).getQuestion());

        // Question 5
        tV_question_5.setText(quizQuestions.totoroQuestions.get(5).getQuestion());
        cB_answer_5_0.setText(quizQuestions.totoroQuestions.get(5).getAnswerInPosition(0).getAnswerText());
        cB_answer_5_1.setText(quizQuestions.totoroQuestions.get(5).getAnswerInPosition(1).getAnswerText());
        cB_answer_5_2.setText(quizQuestions.totoroQuestions.get(5).getAnswerInPosition(2).getAnswerText());
        cB_answer_5_3.setText(quizQuestions.totoroQuestions.get(5).getAnswerInPosition(3).getAnswerText());
    }

    public void submitQuestionCheck(View view) {

        int currentQuizScore = 0;

        // clear all user input answers to start

        for (int i = 0; i < quizQuestions.totoroQuestions.size(); i++) {
            quizQuestions.totoroQuestions.get(i).clearAllUserInputAnswer();
        }

        // then check all the user input

        if (rB_answer_0_0.isChecked()) {
            quizQuestions.totoroQuestions.get(0).setUserInputAnswer(0);
        }

        if (rB_answer_0_1.isChecked()) {
            quizQuestions.totoroQuestions.get(0).setUserInputAnswer(1);
        }

        if (rB_answer_0_2.isChecked()) {
            quizQuestions.totoroQuestions.get(0).setUserInputAnswer(2);
        }

        if (rB_answer_0_3.isChecked()) {
            quizQuestions.totoroQuestions.get(0).setUserInputAnswer(3);
        }

        if (rB_answer_1_0.isChecked()) {
            quizQuestions.totoroQuestions.get(1).setUserInputAnswer(0);
        }

        if (rB_answer_1_1.isChecked()) {
            quizQuestions.totoroQuestions.get(1).setUserInputAnswer(1);
        }

        if (rB_answer_1_2.isChecked()) {
            quizQuestions.totoroQuestions.get(1).setUserInputAnswer(2);
        }

        if (rB_answer_1_3.isChecked()) {
            quizQuestions.totoroQuestions.get(1).setUserInputAnswer(3);
        }

        if (rB_answer_2_0.isChecked()) {
            quizQuestions.totoroQuestions.get(2).setUserInputAnswer(0);
        }

        if (rB_answer_2_1.isChecked()) {
            quizQuestions.totoroQuestions.get(2).setUserInputAnswer(1);
        }

        if (rB_answer_2_2.isChecked()) {
            quizQuestions.totoroQuestions.get(2).setUserInputAnswer(2);
        }

        if (rB_answer_2_3.isChecked()) {
            quizQuestions.totoroQuestions.get(2).setUserInputAnswer(3);
        }

        if (rB_answer_3_0.isChecked()) {
            quizQuestions.totoroQuestions.get(3).setUserInputAnswer(0);
        }

        if (rB_answer_3_1.isChecked()) {
            quizQuestions.totoroQuestions.get(3).setUserInputAnswer(1);
        }

        if (rB_answer_3_2.isChecked()) {
            quizQuestions.totoroQuestions.get(3).setUserInputAnswer(2);
        }

        if (rB_answer_3_3.isChecked()) {
            quizQuestions.totoroQuestions.get(3).setUserInputAnswer(3);
        }

        quizQuestions.totoroQuestions.get(4).setUserInputAnswer(eT_answer_4.getText().toString());

        if (cB_answer_5_0.isChecked()) {
            quizQuestions.totoroQuestions.get(5).setUserInputAnswer(0);
        }

        if (cB_answer_5_1.isChecked()) {
            quizQuestions.totoroQuestions.get(5).setUserInputAnswer(1);
        }

        if (cB_answer_5_2.isChecked()) {
            quizQuestions.totoroQuestions.get(5).setUserInputAnswer(2);
        }

        if (cB_answer_5_3.isChecked()) {
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
