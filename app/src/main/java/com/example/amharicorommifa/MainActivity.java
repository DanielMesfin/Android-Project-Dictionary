package com.example.amharicorommifa;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.CursorAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView list;
    customAdapter adapter;
    String[] title;
    String[] desc;
    ArrayList<model> arrayList = new ArrayList<model>();

    SearchView searchOro, searchAmha;

    FragmentManager fm;
    definition definition;
    FragmentTransaction fragmentTransaction;

    TextView main, def;
    ImageView swap;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        swap = findViewById(R.id.swap);


        fm = getSupportFragmentManager();
        definition = new definition();

        searchAmha = (SearchView) findViewById(R.id.searchamharic);
//        searchOro = (SearchView) findViewById(R.id.searchOromiffa);


        title = getResources().getStringArray(R.array.oromiffa_words);
        desc = getResources().getStringArray(R.array.amharic_word);

        list = findViewById(R.id.lv);

    for (int i = 0; i < title.length; i++) {
        model model = new model(title[i], desc[i]);
        arrayList.add(model);
    }


    //pass results to listview adapter class
    adapter = new customAdapter(this, arrayList);

    //bind the adapter to the listview
    list.setAdapter(adapter);


//          searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
//            @Override
//            public boolean onQueryTextSubmit(String s) {
//                return false;
//            }
//
//            @Override
//            public boolean onQueryTextChange(String s) {
//
//                if(TextUtils.isEmpty(s)){
//                    adapter.filter("");
//                    list.clearTextFilter();
//                }
//                else{
//                    adapter.filter(s);
//                }
//
//
//                return true;
//            }
//        });



//        //for searching orommiffa
//        searchOro.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
//            @Override
//            public boolean onQueryTextSubmit(String s) {
//                return false;
//            }
//
//            @Override
//            public boolean onQueryTextChange(String s) {
//
//                if (TextUtils.isEmpty(s)) {
//                    adapter.filter("");
//                    list.clearTextFilter();
//                } else {
//                    adapter.filter(s);
//                }
//
//                return true;
//            }
//        });
//
//
//        //for searching amharic
//
//        searchAmha.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
//            @Override
//            public boolean onQueryTextSubmit(String s) {
//                return false;
//            }
//
//            @Override
//            public boolean onQueryTextChange(String s) {
//                if (TextUtils.isEmpty(s)) {
//                    adapter.filter("");
//                    list.clearTextFilter();
//                } else {
//                    adapter.filter(s);
//                }
//
//
//                return true;
//            }
//        });


//        searchOro.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                searchOro.clearFocus();
//                searchOro.setIconified(false);
//                for (int i = 0; i < title.length; i++) {
//                    model model = new model(title[i], desc[i]);
//                    arrayList.add(model);
//                }
//                //pass results to listview adapter class
//                adapter = new customAdapter(MainActivity.this, arrayList);
//
//                //bind the adapter to the listview
//                list.setAdapter(adapter);
//
//            }
//        });

            searchAmha.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Toast.makeText(MainActivity.this,String.valueOf(swap.hasFocus()), Toast.LENGTH_SHORT).show();
                    for (int i = 0; i < title.length; i++) {
                        model model = new model(desc[i], title[i]);
                        arrayList.add(model);
                    }


                    //pass results to listview adapter class
                    adapter = new customAdapter(MainActivity.this, arrayList);

                    //bind the adapter to the listview
                    list.setAdapter(adapter);

                }
            });

//        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//
//
//                Toast.makeText(MainActivity.this, adapter.getMainword() + "********/n" + adapter.getDefinition(), Toast.LENGTH_SHORT).show();
//
//
////                main = view.findViewById(R.id.main);
////                def = view.findViewById(R.id.definition);
//
//                main.setText(adapter.getMainword());
//                def.setText(adapter.getDefinition());
//
//                BottomSheetDialog bsd = new BottomSheetDialog(getApplicationContext(), R.style.BottomSheetDialogTheme);
//
//                View bsv = LayoutInflater.from(getApplicationContext()).inflate(R.layout.layout_bottom_sheet, (LinearLayout) view.findViewById(R.id.bottom_sheetContainer));
//                bsd.setContentView(bsv);
//                bsd.show();


//                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
//                builder.setCancelable(true);
//                builder.setTitle(title[i]);
//                builder.setMessage(desc[i]);
//                builder.show();


//                Bundle bundle = new Bundle();
//
//                bundle.putString("main", title[i]);
//                bundle.putString("def", desc[i]);
//
//                def.setArguments(bundle);
//
//                FragmentTransaction ft = fm.beginTransaction();
//                ft.replace(R.id.container, def);
//
//                ft.commit();

//                getSupportFragmentManager().beginTransaction().replace(R.id.container, new definition()).commit();


//            }
//        });


        BottomNavigationView bottomview = findViewById(R.id.bottom_nav);
        bottomview.setOnNavigationItemSelectedListener(navlistener);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu, menu);

        MenuItem myactionmenuItem = menu.findItem(R.id.action_search);

        SearchView searchView = (SearchView) myactionmenuItem.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {

                if (TextUtils.isEmpty(s)) {
                    adapter.filter("No matching word for " + s);
                    list.clearTextFilter();
                } else {
                    adapter.filter(s);
                }


                return true;
            }
        });


        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();
        if (id == R.id.action_settings) {

            //TODO functionality to be defined here
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navlistener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                    Fragment selected = null;

                    switch (item.getItemId()) {

                        case R.id.home:
                            Toast.makeText(MainActivity.this, "Home Clicked", Toast.LENGTH_SHORT).show();
                            break;
                        case R.id.about:

                            Toast.makeText(MainActivity.this, "Will have information about the developers", Toast.LENGTH_SHORT).show();
                            break;
                        case R.id.favv:
                            findViewById(R.id.favv).setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.Red)));
                            Toast.makeText(MainActivity.this, "You will get your favourite words with their definintion here ", Toast.LENGTH_SHORT).show();
                            break;
                    }
//                    getSupportFragmentManager().beginTransaction().replace(androidx.appcompat.R.id.action_bar_container,selected).commit();
                    return true;
                }
            };
//    public FragmentTransaction FragmentControl(String main,String def){
//
//        fm=getSupportFragmentManager();
//        definition=new definition();
//
//
//
//        Bundle bundle= new Bundle();
//
//        bundle.putString("main",main);
//        bundle.putString("def",def);
//
//        definition.setArguments(bundle);
//
//        FragmentTransaction ft = fm.beginTransaction();
////        ft.commit();
//
////        fragmentTransaction.addToBackStack("tag");
//
//
//
//        return fragmentTransaction;
//    }

}
//design row of list