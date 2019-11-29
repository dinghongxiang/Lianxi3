package com.bawei.lianxi3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ViewPager vp;
    private RadioGroup rp;
    private Button b1;
    private Button b2;
    private Button b3;
    private ArrayList<Fragment> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        vp = findViewById(R.id.vp);
        rp = findViewById(R.id.rp);
        b1 = findViewById(R.id.b1);
        b2 = findViewById(R.id.b2);
        b3 = findViewById(R.id.b3);


        list = new ArrayList<>();

        Farg1 farg1 = new Farg1();
        Farg2 farg2 = new Farg2();
        Farg3 farg3 = new Farg3();

        list.add(farg1);
        list.add(farg2);
        list.add(farg3);


        FragmentManager manager = getSupportFragmentManager();
        MAdapter mAdapter = new MAdapter(manager);
        vp.setAdapter(mAdapter);

        rp.check(rp.getChildAt(0).getId());


        vp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                rp.check(rp.getChildAt(position).getId());
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


        rp.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {


                switch (i){
                    case R.id.b1:
                        vp.setCurrentItem(0);
                        break;
                    case R.id.b2:
                        vp.setCurrentItem(1);
                        break;
                    case R.id.b3:
                        vp.setCurrentItem(2);
                        break;
                }
            }
        });



    }

    class MAdapter extends FragmentPagerAdapter {
        public MAdapter(@NonNull FragmentManager fm) {
            super(fm);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            return list.get(position);
        }

        @Override
        public int getCount() {
            return list.size();
        }
    }
}
