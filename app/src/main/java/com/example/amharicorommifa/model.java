package com.example.amharicorommifa;

public class model {
    String title;
    String desc;

    public  model(String title,String desc){
        this.title=title;
        this.desc=desc;
    }

    public String getTitle(){
        return this.title;
    }
    public String getDesc(){
        return this.desc;
    }
}
