package com.example.quiz;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    TextView text;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        text = findViewById(R.id.text);

        SharedPreferences sharedPreferences =getSharedPreferences("Demo", MODE_PRIVATE);
        String savedName = sharedPreferences.getString("key","");

        perference();

    }

    public void animation1() {
        Handler handler = new Handler();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this, Information.class);
                startActivity(intent);
                finish();
            }
        };

        handler.postDelayed(runnable, 5000);
    }

    public void animation2() {
        Handler handler = new Handler();
        Runnable runnable1 = new Runnable() {
            @Override
            public void run() {
                String name = text.getText().toString();
                Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                intent.putExtra("Name", name);
                startActivity(intent);
                finish();
            }
        };
        handler.postDelayed(runnable1,5000);
    }



    private void perference() {

            String nameText = getIntent().getStringExtra("Name");

            SharedPreferences share = getSharedPreferences("Demo", MODE_PRIVATE);
            SharedPreferences.Editor editor = share.edit();

            if (nameText == null || nameText.isEmpty()) {
                String value = share.getString("Str", "");
                text.setText(value);
            } else {
                text.setText(nameText);
                editor.putString("Str", nameText).apply();
            }

            String name = text.getText().toString();

            SharedPreferences share1 = getSharedPreferences("Demo", MODE_PRIVATE);
            SharedPreferences.Editor editor1 = share1.edit();

            boolean hasBeen = share1.getBoolean("hasBeen", true);

            if (hasBeen || name.equals("")) {
                editor1.putBoolean("hasBeen", false).apply();
                animation1();
            } else {
                animation2();
            }
    }
}