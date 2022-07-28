package com.example.amharicorommifa;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.text.TextUtilsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.IntentFilter;
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

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView list;
    customAdapter adapter,adapterAmh;
    String[] title;
    String[] desc;
    ArrayList<model> arrayList = new ArrayList<model>();
    ArrayList<model> arrayListAmh=new ArrayList<model>();

    SearchView search;

    TextView amh,orom;
    ImageView swap;
     int s = 0;
     private boolean Wchanged=false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        amh=findViewById(R.id.amharic);
        orom=findViewById(R.id.orommiffa);
        swap = findViewById(R.id.swap);

        search = (SearchView) findViewById(R.id.searchamharic);

        title = getResources().getStringArray(R.array.oromiffa_words);
        desc = getResources().getStringArray(R.array.amharic_word);

        list = findViewById(R.id.lv);

        for (int i = 0; i < title.length; i++) {
                        model model = new model(title[i], desc[i]);
                        model modelAmh = new model(desc[i],title[i]);
                        arrayList.add(model);
                       arrayListAmh.add(modelAmh);
                    }
        //pass results to listview adapter class
        adapter = new customAdapter(MainActivity.this,arrayList);
        adapterAmh=new customAdapter(MainActivity.this,arrayListAmh);

        list.setAdapter(adapter);

        swap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                swapped();

                if (s == 0) {
                    //bind the adapter to the listview
                    list.setAdapter(adapter);
                    amh.setText("Oromiffa");
                    orom.setText("አማረኛ");
                    search.setQueryHint("Afaan oromiffatti barbaadi ....");

                    setisWchanged(true);

                } else {
                    //bind the adapter to the listview
                    list.setAdapter(adapterAmh);
                    orom.setText("Oromiffa");
                    amh.setText("አማረኛ");
                    search.setQueryHint("በ አማረኛ ይፈልጉ ....");
                    setisWchanged(false);

                }

            }
        });

        search.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                if (TextUtils.isEmpty(s)) {
                    adapter.filter("");
                    list.clearTextFilter();
                } else {
                    adapter.filter(s);
                }


                return true;
            }
        });

        BottomNavigationView bottomview = findViewById(R.id.bottom_nav);
        bottomview.setOnNavigationItemSelectedListener(navlistener);

    }

    public void setisWchanged(boolean wchanged){
        this.Wchanged=wchanged;
    }
    public boolean getWchanged(){
        return this.Wchanged;
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
                    adapter.filter( s);
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
                            break;
                        case R.id.about:
                            Intent intentAbout = new Intent(MainActivity.this,About.class);
                            startActivity(intentAbout);

                            break;
                        case R.id.favv:
                            findViewById(R.id.favv).setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.Red)));

                            Intent intentFavourite = new Intent(MainActivity.this,Favourites.class);
                            startActivity(intentFavourite);
                            break;
                    }
                    return true;
                }
            };

    public int swapped(){
                if(s==0){
                   this.s=1;
                }else {
                    this.s=0;
                }
   return this.s;
    }

}

