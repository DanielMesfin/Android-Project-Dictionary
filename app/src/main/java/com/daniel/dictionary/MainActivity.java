package com.daniel.dictionary;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SearchView;

public class MainActivity extends AppCompatActivity {
    SearchView searchWord;
    ListView  wordsList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        searchWord=(SearchView)findViewById(R.id.searchView);
        wordsList=(ListView) findViewById(R.id.list_of_word);
    }
}