package com.daniel.dictionary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ProgressBar;

public class SplashScreenWindow extends AppCompatActivity {
    final Context CONTEXT;
    ProgressBar progressBar;
    public SplashScreenWindow(){
        CONTEXT=this;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen_window);
        progressBar=(ProgressBar)findViewById(R.id.prograse);
        // The thread for splashing
        Thread splashThread=new Thread(){
                @Override
                public void run() {
                    try {
                        sleep(2000);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                    finally {
                        finish();
                        Intent intent= new Intent(CONTEXT,MainActivity.class);
                        startActivity(intent);
                    }
                }
            };
            splashThread.start();
        }
    }
