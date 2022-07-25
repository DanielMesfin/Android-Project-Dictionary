package com.example.amharicorommifa;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.List;
import java.util.ArrayList;
import java.util.Locale;

public class customAdapter  extends BaseAdapter {

   Context mcontext;
   LayoutInflater inflater;
   List<model> modellist;
   ArrayList<model> arrayList;

   String mainword="";
   String wdefinition="";

    AppCompatActivity activity;
    Resources res;
    public  customAdapter(Context context,List<model> modellist){

       mcontext=context;
       this.modellist=modellist;
       inflater=LayoutInflater.from(context);
       this.arrayList=new ArrayList<model>();
       this.arrayList.addAll(modellist);


       /*TODO : making amharic word searchable
                favourite functionality
                making dialog box responsive @ rendering words
                modifying interface
        */



   }


   public  class  ViewHolder { TextView mtitleTv,mDescTv;ImageView fav;TextView mainW,defWord;}


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

      holder.fav=view.findViewById(R.id.favourite1);

      holder.mainW=view.findViewById(R.id.mainWord);
      holder.defWord=view.findViewById(R.id.definitionWord);

       res= view.getResources();
       holder.fav.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {

               if (holder.fav.getDrawable().getConstantState() == view.getResources().getDrawable( R.drawable.ic_baseline_favorite_border_24).getConstantState()) {

                   holder.fav.setImageDrawable(res.getDrawable(R.drawable.ic_baseline_favorite_24red));
               }
               else {
                   holder.fav.setImageDrawable(res.getDrawable(R.drawable.ic_baseline_favorite_border_24));
               }
           }
       });





       //listview item clicks
       view.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               //TODO to be completed later

               view.setOnClickListener(new View.OnClickListener() {
                   @Override
                   public void onClick(View view) {

                       //TODO CHECK LATER   // gets the seleccted list item and toasts to user

//                       AlertDialog.Builder builder = new AlertDialog.Builder(mcontext);
//                       builder.setCancelable(true);
//                       builder.setTitle(modellist.get(Position).getTitle());
//                       builder.setMessage(modellist.get(Position).getDesc());
//                       builder.show();

                       mainword=modellist.get(Position).getTitle();
                       wdefinition=modellist.get(Position).getDesc();


//                       holder.mainW.setText(mainword);
//                       holder.defWord.setText(wdefinition);


//                       getDialogView(mainword,wdefinition);



                       BottomSheetDialog bsd = new BottomSheetDialog(mcontext,R.style.BottomSheetDialogTheme);
//
////                       main.setText(mainword);
////                       def.setText(definition);
//
//
////                       main.setText(mainword);
////                       def.setText(wdefinition);
//
                       View bsv = LayoutInflater.from(mcontext).inflate(R.layout.layout_bottom_sheet,(LinearLayout)view.findViewById(R.id.bottom_sheetContainer));
                       TextView mainText=bsv.findViewById(R.id.mainWord);
                       TextView defText=bsv.findViewById(R.id.definitionWord);
                       ImageView fav=bsv.findViewById(R.id.favourite);
                       ImageView fav_def=bsv.findViewById(R.id.favourite1);

                       fav_def.setOnClickListener(new View.OnClickListener() {
                           @Override
                           public void onClick(View view) {
                               if (holder.fav.getDrawable().getConstantState() == view.getResources().getDrawable( R.drawable.ic_baseline_favorite_border_24).getConstantState()) {

                                   holder.fav.setImageDrawable(res.getDrawable(R.drawable.ic_baseline_favorite_24red));
                                   fav.setImageDrawable(res.getDrawable(R.drawable.ic_baseline_favorite_24red));
                                   fav_def.setImageDrawable(res.getDrawable(R.drawable.ic_baseline_favorite_24red));
                               }
                               else {
                                   holder.fav.setImageDrawable(res.getDrawable(R.drawable.ic_baseline_favorite_border_24));
                                   fav.setImageDrawable(res.getDrawable(R.drawable.ic_baseline_favorite_border_24));
                                   fav_def.setImageDrawable(res.getDrawable(R.drawable.ic_baseline_favorite_border_24));
                               }
                           }
                       });

                       fav.setOnClickListener(new View.OnClickListener() {
                           @Override
                           public void onClick(View view) {


                               if (holder.fav.getDrawable().getConstantState() == view.getResources().getDrawable( R.drawable.ic_baseline_favorite_border_24).getConstantState()) {

                                   holder.fav.setImageDrawable(res.getDrawable(R.drawable.ic_baseline_favorite_24red));
                                   fav.setImageDrawable(res.getDrawable(R.drawable.ic_baseline_favorite_24red));
                                   fav_def.setImageDrawable(res.getDrawable(R.drawable.ic_baseline_favorite_24red));
                               }
                               else {
                                   holder.fav.setImageDrawable(res.getDrawable(R.drawable.ic_baseline_favorite_border_24));
                                   fav.setImageDrawable(res.getDrawable(R.drawable.ic_baseline_favorite_border_24));
                                   fav_def.setImageDrawable(res.getDrawable(R.drawable.ic_baseline_favorite_border_24));
                               }



                           }
                       });



                       mainText.setText(mainword);
                       defText.setText(wdefinition);

                       bsd.setContentView(bsv);
                       bsd.show();

//                       activity=new AppCompatActivity();
//
//                          definition def=new definition();
//                          Bundle bundle = new Bundle();
//
//                       bundle.putString("main", modellist.get(Position).getTitle());
//                       bundle.putString("def",modellist.get(Position).getDesc());
//
//                       def.setArguments(bundle);
//                       activity.getFragmentManager().beginTransaction().replace(R.id.container,new definition()).commit();
//
//
                   }
               });
           }
       });

        return view;
    }

    public String getMainword(){
        return mainword;
    }
    public String getDefinition(){
        return wdefinition;
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

//    @SuppressLint("ViewHolder")
//    public View getDialogView(String mainword,String definition) {
//       View view = new View(mcontext);
//        this.inflater.inflate(R.layout.layout_bottom_sheet,null);
//
//        TextView mainw ,def;
//
//        mainw=view.findViewById(R.id.mainw);
//        def=view.findViewById(R.id.definition);
//
//        mainw.setText(mainword);
//        def.setText(definition);
//
//        return view;
//    }
}

