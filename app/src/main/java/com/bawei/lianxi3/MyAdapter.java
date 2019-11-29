package com.bawei.lianxi3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.fragment.app.FragmentActivity;

import java.util.ArrayList;

public class MyAdapter extends BaseAdapter {


    Context context;
    ArrayList<Bean.Mu.Mu1> list;

    public MyAdapter(Context context, ArrayList<Bean.Mu.Mu1> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
         ViewHorlder horlder=null;

         if (view==null){
             view= LayoutInflater.from(context).inflate(R.layout.xian,null);
             horlder = new ViewHorlder();
             horlder.textView=view.findViewById(R.id.tv);
             horlder.textView1=view.findViewById(R.id.tv1);
             horlder.textView2=view.findViewById(R.id.tv2);
             horlder.textView3=view.findViewById(R.id.tv3);
             view.setTag(horlder);
         }else {
             horlder= (ViewHorlder) view.getTag();
         }
         horlder.textView.setText(list.get(i).city);
         horlder.textView1.setText(list.get(i).des);
         horlder.textView2.setText(list.get(i).tipt);
         horlder.textView3.setText(list.get(i).zs);
        return view;

    }

    class ViewHorlder{
        TextView textView;
        TextView textView1;
        TextView textView2;
        TextView textView3;
    }
}
