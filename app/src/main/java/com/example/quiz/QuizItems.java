package com.example.quiz;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class QuizItems extends BaseAdapter {

    private Context context;
    private String[] quizzes;
    private LayoutInflater inflater;

    public QuizItems(Context context, String[] quizzes) {

        this.context = context;
        this.quizzes = quizzes;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return quizzes.length;
    }

    @Override
    public Object getItem(int position) {
        return quizzes[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null){
            convertView = inflater.inflate(R.layout.quiztype, parent, false);
        }

        TextView quiz = convertView.findViewById(R.id.items);
        ImageView logo = convertView.findViewById(R.id.logo);

        quiz.setText(quizzes[position]);
        logo.setImageResource(R.drawable.quizlogo);

        return convertView;
    }


}
