package com.example.quiz;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TestActivity extends AppCompatActivity {

    TextView question, QuestionNumber, AText, BText, CText, DText;
    String subject, useranswer;
    String[] options;

    int Qnumber, layoutnum, number, result;
    boolean randomturn, userturn, nextturn;
    Button next;
    List<Integer> usedIndices;
    LinearLayout Alayout, Blayout, Clayout, Dlayout;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_test);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        question = findViewById(R.id.question);
        QuestionNumber = findViewById(R.id.QuestionNumber);
        AText = findViewById(R.id.AText);
        BText = findViewById(R.id.BText);
        CText = findViewById(R.id.CText);
        DText = findViewById(R.id.DText);
        next = findViewById(R.id.next);
        Alayout = findViewById(R.id.Alayout);
        Blayout = findViewById(R.id.Blayout);
        Clayout = findViewById(R.id.Clayout);
        Dlayout = findViewById(R.id.Dlayout);
        Qnumber = 0;
        result = 0;
        randomturn = true;
        userturn = true;
        nextturn = false;
        usedIndices = new ArrayList<>();

        subject = getIntent().getStringExtra("Subject");
        random(subject);
        Next();

        Handler handler = new Handler();
        Runnable runnable = () -> {
            setAnswer(number, subject, layoutnum);
            next.setAlpha(1);
        };

        Alayout.setOnClickListener(v -> handleAnswerSelection(1, AText, handler, runnable));
        Blayout.setOnClickListener(v -> handleAnswerSelection(2, BText, handler, runnable));
        Clayout.setOnClickListener(v -> handleAnswerSelection(3, CText, handler, runnable));
        Dlayout.setOnClickListener(v -> handleAnswerSelection(4, DText, handler, runnable));
    }

    private void handleAnswerSelection(int layoutNumber, TextView textView, Handler handler, Runnable runnable) {
        if (userturn) {
            useranswer = textView.getText().toString();
            layoutnum = layoutNumber;
            LinearLayout layout = (LinearLayout) textView.getParent();
            layout.setBackground(getDrawable(R.drawable.black));
            textView.setBackground(getDrawable(R.drawable.black));
            handler.postDelayed(runnable, 2500);
            userturn = false;
        }
    }

    private void random(String Subject) {
        if (Qnumber >= 10) {
            next.setText("Result");
            nextturn = true;
            next.setAlpha(1);
            return;
        }

        number = getRandomIndex();
        setQuestion(number, Subject);
        setOption(number, Subject);
        Qnumber++;
        QuestionNumber.setText(Qnumber + "/10");

        if (Qnumber == 10) {
            next.setText("Result");
            nextturn = true;
        }
    }

    private int getRandomIndex() {
        Random random = new Random();
        int index;
        do {
            index = random.nextInt(11);
        } while (usedIndices.contains(index));
        usedIndices.add(index);
        return index;
    }

    protected void setQuestion(int number, @NonNull String Subject) {
        Question question1 = new Question();

        switch (Subject) {
            case "Science":
                question.setText(question1.science(number));
                break;
            case "Maths":
                question.setText(question1.maths(number));
                break;
            case "Gk":
                question.setText(question1.Gk(number));
                break;
        }
    }

    protected void setOption(int number, @NonNull String Subject) {
        Option option = new Option();

        switch (Subject) {
            case "Science":
                options = option.science(number);
                break;
            case "Maths":
                options = option.maths(number);
                break;
            case "Gk":
                options = option.gk(number);
                break;
        }

        AText.setText(options[0]);
        BText.setText(options[1]);
        CText.setText(options[2]);
        DText.setText(options[3]);
    }

    protected void setAnswer(int number, String Subject, int layoutnumber) {
        Answer answer = new Answer();
        String correctAnswer = null;

        switch (Subject) {
            case "Science":
                correctAnswer = answer.science(number);
                break;
            case "Maths":
                correctAnswer = answer.maths(number);
                break;
            case "Gk":
                correctAnswer = answer.gk(number);
                break;
        }

        if (correctAnswer != null) {
            checkinput(correctAnswer, layoutnumber);
        }
    }

    private void checkinput(@NonNull String correct, int layoutnumber) {
        if (correct.equals(useranswer)) {
            markAnswerCorrect(layoutnumber);
            result++;
        } else {
            markAnswerIncorrect(layoutnumber);
            correctanswer(correct);
        }
    }

    private void markAnswerCorrect(int layoutnumber) {
        switch (layoutnumber) {
            case 1:
                Alayout.setBackground(getDrawable(R.drawable.correct));
                AText.setBackground(getDrawable(R.drawable.correct));
                break;
            case 2:
                Blayout.setBackground(getDrawable(R.drawable.correct));
                BText.setBackground(getDrawable(R.drawable.correct));
                break;
            case 3:
                Clayout.setBackground(getDrawable(R.drawable.correct));
                CText.setBackground(getDrawable(R.drawable.correct));
                break;
            case 4:
                Dlayout.setBackground(getDrawable(R.drawable.correct));
                DText.setBackground(getDrawable(R.drawable.correct));
                break;
        }
    }

    private void markAnswerIncorrect(int layoutnumber) {
        switch (layoutnumber) {
            case 1:
                Alayout.setBackground(getDrawable(R.drawable.wrong));
                AText.setBackground(getDrawable(R.drawable.wrong));
                break;
            case 2:
                Blayout.setBackground(getDrawable(R.drawable.wrong));
                BText.setBackground(getDrawable(R.drawable.wrong));
                break;
            case 3:
                Clayout.setBackground(getDrawable(R.drawable.wrong));
                CText.setBackground(getDrawable(R.drawable.wrong));
                break;
            case 4:
                Dlayout.setBackground(getDrawable(R.drawable.wrong));
                DText.setBackground(getDrawable(R.drawable.wrong));
                break;
        }
    }

    private void correctanswer(String useranswer1) {
        if (useranswer1.equals(AText.getText().toString())) {
            Alayout.setBackground(getDrawable(R.drawable.correct));
            AText.setBackground(getDrawable(R.drawable.correct));
        } else if (useranswer1.equals(BText.getText().toString())) {
            Blayout.setBackground(getDrawable(R.drawable.correct));
            BText.setBackground(getDrawable(R.drawable.correct));
        } else if (useranswer1.equals(CText.getText().toString())) {
            Clayout.setBackground(getDrawable(R.drawable.correct));
            CText.setBackground(getDrawable(R.drawable.correct));
        } else if (useranswer1.equals(DText.getText().toString())) {
            Dlayout.setBackground(getDrawable(R.drawable.correct));
            DText.setBackground(getDrawable(R.drawable.correct));
        }
    }

    private void Next() {
        next.setOnClickListener(v -> {
            if (!nextturn) {
                random(subject);
                resetlayout();
                next.setAlpha(0);
                userturn = true;
            } else {
                Intent intent = new Intent(TestActivity.this, ResultActivity.class);
                String results = Integer.toString(result);
                intent.putExtra("Result", results);
                startActivity(intent);
            }
        });
    }

    private void resetlayout() {
        Alayout.setBackground(getDrawable(R.drawable.shape));
        Blayout.setBackground(getDrawable(R.drawable.shape));
        Clayout.setBackground(getDrawable(R.drawable.shape));
        Dlayout.setBackground(getDrawable(R.drawable.shape));
        AText.setBackground(getDrawable(R.drawable.shape));
        BText.setBackground(getDrawable(R.drawable.shape));
        CText.setBackground(getDrawable(R.drawable.shape));
        DText.setBackground(getDrawable(R.drawable.shape));
    }
}
