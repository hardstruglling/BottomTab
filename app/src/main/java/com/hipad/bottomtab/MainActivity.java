package com.hipad.bottomtab;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.hipad.bottomtab.fragment.GiftFragment;
import com.hipad.bottomtab.fragment.PersonFragment;
import com.hipad.bottomtab.fragment.ShopFragment;
import com.hipad.bottomtab.fragment.StoreFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements
        BottomNavigationView.OnNavigationItemSelectedListener {

    private BottomNavigationView bottomNavigationView;
    private List<Fragment> fragmentList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initFragments();
        initView();
        showFragmentByIndex(0);
    }

    private void initFragments() {
        fragmentList.add(new ShopFragment());
        fragmentList.add(new StoreFragment());
        fragmentList.add(new GiftFragment());
        fragmentList.add(new PersonFragment());

    }

    private void initView() {
        bottomNavigationView = ((BottomNavigationView) findViewById(R.id.bottom_navigation));
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.shop:
                showFragmentByIndex(0);
                return true;
            case R.id.store:
                showFragmentByIndex(1);
                return true;
            case R.id.gift:
                showFragmentByIndex(2);
                return true;
            case R.id.person:
                showFragmentByIndex(3);
                return true;
        }
        return false;
    }

    private void showFragmentByIndex(int position){
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        for (int i=0;i<fragmentList.size();i++){
            Fragment f = fragmentList.get(i);
            if (!f.isAdded()){
                ft.add(R.id.content,f);
            }
            if (i == position){
                ft.show(f);
            }else {
                ft.hide(f);
            }
        }
        ft.commit();
    }
}
