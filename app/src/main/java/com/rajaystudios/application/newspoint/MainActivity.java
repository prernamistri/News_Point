package com.rajaystudios.application.newspoint;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.widget.TableLayout;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {
    TabLayout tabLayout;
    ViewPager viewPager;
    TabItem thome,tworld,ttech,tscie,tsports,tmovies,tgames,tenter;
    PagerAdapter pagerAdapter;
    Toolbar toolbar;
    String apikey="852068c180154060820c5bb0aa46dc8e";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        thome = findViewById(R.id.home);
        ttech = findViewById(R.id.technology);
        tscie = findViewById(R.id.Science);
        tsports = findViewById(R.id.Sports);
        viewPager = findViewById(R.id.fragment_container);
        tabLayout = findViewById(R.id.include);
        pagerAdapter = new PagerAdapter(getSupportFragmentManager(),4);
        viewPager.setAdapter(pagerAdapter);
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
                if(tab.getPosition()==0 ||tab.getPosition()==1 ||tab.getPosition()==2 ||tab.getPosition()==3){
                    pagerAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
    }
}