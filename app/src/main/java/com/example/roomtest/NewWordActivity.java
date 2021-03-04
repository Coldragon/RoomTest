package com.example.roomtest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;

import com.example.roomtest.databinding.ActivityMainBinding;
import com.example.roomtest.databinding.ActivityNewWordBinding;

public class NewWordActivity extends AppCompatActivity {

    public static final String EXTRA_REPLY = "com.example.android.wordlistsql.REPLY";

    ActivityNewWordBinding binding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityNewWordBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.buttonSave.setOnClickListener(view -> {
            Intent replyIntent = new Intent();
            if (TextUtils.isEmpty(binding.editWord.getText())) {
                setResult(RESULT_CANCELED, replyIntent);
            } else {
                String word = binding.editWord.getText().toString();
                replyIntent.putExtra(EXTRA_REPLY, word);
                setResult(RESULT_OK, replyIntent);
            }
            finish();
        });


    }
}