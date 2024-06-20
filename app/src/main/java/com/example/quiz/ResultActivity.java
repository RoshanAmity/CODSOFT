package com.example.quiz;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ResultActivity extends AppCompatActivity {

    TextView username, result;
    Button start;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_result);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        username = findViewById(R.id.username);
        result = findViewById(R.id.result);
        start = findViewById(R.id.start);

        SharedPreferences sharedPreferences =getSharedPreferences("Demo", MODE_PRIVATE);
        String savedName = sharedPreferences.getString("key","");

        perference();

        setResult();

        start.setOnClickListener(v -> {
            shift();
        });
    }

    public void setResult(){
        String marks = getIntent().getStringExtra("Result");
        result.setText(marks+"/10");
    }

    private void perference(){

        String nameText = getIntent().getStringExtra("Name");

        SharedPreferences share = getSharedPreferences("Demo",MODE_PRIVATE);
        SharedPreferences.Editor editor = share.edit();

        if(nameText==null || nameText.isEmpty()){
            String value = share.getString("Str","");
            username.setText(value);
        }
        else {
            username.setText(nameText);
            editor.putString("Str",nameText).apply();
        }
    }

    private void shift(){
        Intent intent = new Intent(ResultActivity.this, MainActivity.class);
        String value = username.getText().toString();
        intent.putExtra("Name", value);
        startActivity(intent);
        finish();
    }

}