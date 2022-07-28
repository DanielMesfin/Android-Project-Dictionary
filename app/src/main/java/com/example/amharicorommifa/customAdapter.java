package com.example.amharicorommifa;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.Locale;

public class customAdapter  extends BaseAdapter{

   Context mcontext;
   LayoutInflater inflater;
   List<model> modellist;
   ArrayList<model> arrayList;

   ////////////////////////////////////
   ArrayList<model> arrayListAmh;
   List<model> modelListAmh;
   /////////////////////////////////

   String mainword="";
   String wdefinition="";

    MainActivity activity;
    Resources res;

    public  customAdapter(Context context,List<model> modellist){

       mcontext=context;
       this.modellist=modellist;
       inflater=LayoutInflater.from(context);
       this.arrayList=new ArrayList<model>();
       this.arrayList.addAll(modellist);
       this.modelListAmh=modellist;  ////////////////////////
        this.arrayListAmh=new ArrayList<model>();  //////////////////
        this.arrayListAmh.addAll(modelListAmh);  //////////////////////
   }
   public  class  ViewHolder { TextView mtitleTv,mDescTv;ImageView fav;}

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

      holder.fav=view.findViewById(R.id.favourite12);


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

                       mainword=modellist.get(Position).getTitle();
                       wdefinition=modellist.get(Position).getDesc();

                       MainActivity activity = new MainActivity();

                       BottomSheetDialog bsd = new BottomSheetDialog(mcontext,R.style.BottomSheetDialogTheme);

                       View bsv = LayoutInflater.from(mcontext).inflate(R.layout.layout_bottom_sheet,(LinearLayout)view.findViewById(R.id.bottom_sheetContainer));
                       TextView mainText=bsv.findViewById(R.id.mainWord);
                       TextView defText=bsv.findViewById(R.id.definitionWord);

                       TextView amhBanner = bsv.findViewById(R.id.amharicBanner);
                       TextView orBanner = bsv.findViewById(R.id.orommiffaBanner);

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
                   }
               });
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
    public  void  filterAm(String charText){

        charText = charText.toLowerCase(Locale.getDefault());
        modelListAmh.clear();

        if(charText.length()==0){
            modelListAmh.addAll(arrayListAmh);
        }
        else{
            for(model model : arrayListAmh){
                if(model.getTitle().toLowerCase(Locale.getDefault())
                        .contains(charText)){
                    modelListAmh.add(model);
                }
            }
        }
        notifyDataSetChanged();
    }
}

