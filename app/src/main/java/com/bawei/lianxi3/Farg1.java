package com.bawei.lianxi3;

import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class Farg1 extends Fragment {


    private View
            view;
    private ListView listview;
    private Button bb;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = View.inflate(getContext(), R.layout.farg1, null);

        listview = view.findViewById(R.id.listview);
        bb = view.findViewById(R.id.bb);

        bb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), Main2Activity.class);
                startActivity(intent);
            }
        });

        AssetManager as = getActivity().getAssets();

        try {
            InputStream open = as.open("json.json");

            byte[] bytes = new byte[1024];

            int len=0;

            String str="";


            while ((len=open.read(bytes))!=-1){
                str+=new String(bytes,0,len);
            }


            String s = str.toString();
//            Log.i("xxx",s);


            Gson gson = new Gson();

            Bean bean = gson.fromJson(s, Bean.class);

            ArrayList<Bean.Mu> results = bean.getResults();
            Bean.Mu mu = results.get(0);
//            Log.i("xx",mu)

            ArrayList<Bean.Mu.Mu1> list = mu.index;

            MyAdapter myAdapter = new MyAdapter(getActivity(), list);
            listview.setAdapter(myAdapter);



        } catch (IOException e) {
            e.printStackTrace();
        }


        return view;



    }
}
