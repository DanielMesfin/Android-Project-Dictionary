package com.daniel.dictionary;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.view.Menu;
import android.view.MenuItem;

import android.widget.ArrayAdapter;

import android.widget.ListView;
import android.widget.SearchView;

public class MainActivity extends AppCompatActivity {
    SearchView searchWord;
    ListView  wordsList;
    String [] names={"gggg","hhhh","jjj","kkkkk","aaa","Haramay","Harare","Dredaw","amo","woha","acco","affo","kosso","nonno","bakko"};
    ArrayAdapter<String> arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        wordsList= findViewById(R.id.list_of_word);
        searchWord=findViewById(R.id.searchView);
        arrayAdapter=new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.afanormo_words));
         wordsList.setAdapter(arrayAdapter);
        searchWord.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {

                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
             arrayAdapter.getFilter().filter(newText);
                return false;
            }
        });

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menubar,menu);

        MenuItem setting=menu.findItem(R.id.setting);
        MenuItem share =menu.findItem(R.id.share);
        MenuItem contact=menu.findItem(R.id.contact);
        MenuItem about=menu.findItem(R.id.about);
        MenuItem exit =menu.findItem(R.id.exit);
        
        MenuItem backgroundChange=menu.findItem(R.id.background);

        return super.onCreateOptionsMenu(menu);
    }
}