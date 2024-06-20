package com.example.quiz;

import static android.content.ContentValues.TAG;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class HomeActivity extends AppCompatActivity {

    private ListView quizList;
    private QuizItems quizItems;

    private Button start;

    private String subject;
    LinearLayout layout;
    TextView quizTextView;
    ImageView logo;

    boolean turn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_home);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        quizList = findViewById(R.id.QuizList);
        start =findViewById(R.id.Start);

        turn = true;

        String [] quiz = {"Science", "Maths", "Gk"};

        quizItems = new QuizItems(HomeActivity.this, quiz);
        quizList.setAdapter(quizItems);

            setSubject();

        start.setOnClickListener(v -> {
            if (turn){
                Toast.makeText(HomeActivity.this, "Please Select Your Subject.", Toast.LENGTH_LONG).show();
            }
            else {
                shift();
                finish();
            }
        });



    }

    private void shift(){
            Intent intent = new Intent(HomeActivity.this, TestActivity.class);
            intent.putExtra("Subject", subject);
            startActivity(intent);
            finish();
    }

    private void setSubject(){
        quizList.setOnItemClickListener((parent, view, position, id) -> {

            if(turn == true){
                quizTextView = view.findViewById(R.id.items);
                layout =view.findViewById(R.id.layout);
                logo = view.findViewById(R.id.logo);
                subject = quizTextView.getText().toString();
                layout.setBackground(getDrawable(R.drawable.black));
                logo.setBackgroundColor(Color.parseColor("#000000"));
                turn = false;
            }

        });
    }
}