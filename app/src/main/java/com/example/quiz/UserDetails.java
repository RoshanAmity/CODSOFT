package com.example.quiz;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class UserDetails extends Fragment {

    TextInputLayout user;
    TextInputEditText username;
    Button next;

    public UserDetails() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view =  inflater.inflate(R.layout.fragment_user_details, container, false);

        user = view.findViewById(R.id.user_input_layout);
        username = view.findViewById(R.id.user_edit_text);
        next = view.findViewById(R.id.next);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shift();
            }
        });


        return view;
    }

    private void shift(){
        String name = username.getText().toString();
        Intent intent = new Intent(getContext(), ResultActivity.class);
        intent.putExtra("Name",name);
        startActivity(intent);
    }

}