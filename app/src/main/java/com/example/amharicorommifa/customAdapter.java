package com.example.amharicorommifa;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;
import java.util.ArrayList;
import java.util.Locale;

public class customAdapter  extends BaseAdapter {

   Context mcontext;
   LayoutInflater inflater;
   List<model> modellist;
   ArrayList<model> arrayList;

   public  customAdapter(Context context,List<model> modellist){

       mcontext=context;
       this.modellist=modellist;
       inflater=LayoutInflater.from(context);
       this.arrayList=new ArrayList<model>();
       this.arrayList.addAll(modellist);

   }
   public  class  ViewHolder { TextView mtitleTv,mDescTv;}


    @Override
    public int getCount() { return modellist.size(); }

    @Override
    public Object getItem(int i) {
        return modellist.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int Position, View view, ViewGroup parent) {
       ViewHolder holder;
       if(view==null){
           holder=new ViewHolder();
           view=inflater.inflate(R.layout.row,null);


           //locate the views in row .xml
           holder.mtitleTv=view.findViewById(R.id.maintitle);
           holder.mDescTv=view.findViewById(R.id.subtitle);

           view.setTag(holder);
       }
       else{
           holder=(ViewHolder) view.getTag();
       }
       //set the results into textviews
       holder.mtitleTv.setText(modellist.get(Position).getTitle());
       holder.mDescTv.setText(modellist.get(Position).getDesc());

       //listview item clicks
       view.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               //TODO to be completed later

               Toast.makeText(mcontext.getApplicationContext(), view.toString(), Toast.LENGTH_SHORT).show();
           }
       });

        return view;
    }

    public  void  filter(String charText){
       charText = charText.toLowerCase(Locale.getDefault());
       modellist.clear();

       if(charText.length()==0){
           modellist.addAll(arrayList);
       }
       else{
           for(model model : arrayList){
               if(model.getTitle().toLowerCase(Locale.getDefault())
                       .contains(charText)){
                   modellist.add(model);
               }
           }
       }
       notifyDataSetChanged();
    }
}
