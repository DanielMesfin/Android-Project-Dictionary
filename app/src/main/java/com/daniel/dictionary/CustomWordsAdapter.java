package com.daniel.dictionary;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
public class CustomWordsAdapter extends BaseAdapter {
    Context context;
    String [] amharic_words;
    String [] afanoromic_words;
    LayoutInflater inflater;
    public  CustomWordsAdapter(Context context,String [] amharic_words,String [] afanoromic_words){
        this.context=context;
        this.afanoromic_words=afanoromic_words;
        this.amharic_words=amharic_words;
        inflater =LayoutInflater.from(context);
    }
    @Override
    public int getCount() {
        return afanoromic_words.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //convertView =inflater.inflate()
        return convertView;
    }
}
