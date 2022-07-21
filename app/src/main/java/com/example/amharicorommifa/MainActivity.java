package com.example.amharicorommifa;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.icu.text.CaseMap;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView list;
    customAdapter adapter;
    String[]title;
    String[] desc;
    ArrayList<model> arrayList=new ArrayList<model>();

    SearchView searchOro,searchAmha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        searchAmha=(SearchView) findViewById(R.id.searchamharic);
        searchOro=(SearchView) findViewById(R.id.searchOromiffa);


        title=getResources().getStringArray(R.array.oromiffa_words);
        desc=getResources().getStringArray(R.array.amharic_word);

        list=findViewById(R.id.lv);

        for(int i=0;i<title.length;i++){
            model model=new model(title[i],desc[i]);
            arrayList.add(model);
        }


        //pass results to listview adapter class
        adapter = new customAdapter(this,arrayList);

        //bind the adapter to the listview
        list.setAdapter(adapter);

        /*
        *   searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {

                if(TextUtils.isEmpty(s)){
                    adapter.filter("");
                    list.clearTextFilter();
                }
                else{
                    adapter.filter(s);
                }


                return true;
            }
        });

        *
        * */


        //for searching orommiffa
        searchOro.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {

                if(TextUtils.isEmpty(s)){
                    adapter.filter("");
                    list.clearTextFilter();
                }
                else{
                    adapter.filter(s);
                }

                return true;
            }
        });


        //for searching amharic

        searchAmha.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                if(TextUtils.isEmpty(s)){
                    adapter.filter("");
                    list.clearTextFilter();
                }
                else{
                    adapter.filter(s);
                }


                return true;
            }
        });



        searchOro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for(int i=0;i<title.length;i++){
                    model model=new model(title[i],desc[i]);
                    arrayList.add(model);
                }
                //pass results to listview adapter class
                adapter = new customAdapter(MainActivity.this,arrayList);

                //bind the adapter to the listview
                list.setAdapter(adapter);

            }
        });
        searchAmha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                for(int i=0;i<title.length;i++){
                    model model=new model(desc[i],title[i]);
                    arrayList.add(model);
                }


                //pass results to listview adapter class
                adapter = new customAdapter(MainActivity.this,arrayList);

                //bind the adapter to the listview
                list.setAdapter(adapter);

            }
        });

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setCancelable(true);
                builder.setTitle(title[i]);
                builder.setMessage(desc[i]);
                builder.show();


            }
        });



}

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu,menu);

        MenuItem myactionmenuItem=menu.findItem(R.id.action_search);

        SearchView searchView = (SearchView) myactionmenuItem.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {

                if(TextUtils.isEmpty(s)){
                    adapter.filter("");
                    list.clearTextFilter();
                }
                else{
                    adapter.filter(s);
                }


                return true;
            }
        });


        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int id=item.getItemId();
        if(id==R.id.action_settings){

            //TODO functionality to be defined here
            return true;
        }



        return super.onOptionsItemSelected(item);
    }
}

//design row of list